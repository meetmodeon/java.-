package BankingManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class Accounts {
    private Connection con;
    private Scanner sc;
    public Accounts(Connection con,Scanner sc){
        this.con=con;
        this.sc=sc;
    }
    public long open_account(String email){
        if(!account_exist(email)){
            String open_account_query="insert into Accounts(account_number,full_name,email,balance,security_pin) values (?,?,?,?,?)";
            sc.nextLine();
            System.out.println("Enter Full Name:");
            String full_name=sc.nextLine();
            System.out.println("Enter Initial Amount: ");
            double balance=sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter Security Pin: ");
            String security_pin=sc.nextLine();
            try{
                long account_number=generateAccountNumber();
                PreparedStatement preparedStatement=con.prepareStatement(open_account_query);
                preparedStatement.setLong(1,account_number);
                preparedStatement.setString(2,full_name);
                preparedStatement.setString(3,email);
                preparedStatement.setDouble(4,balance);
                preparedStatement.setString(5,security_pin);
                int rowsAffecteced=preparedStatement.executeUpdate();
                if(rowsAffecteced>0){
                    return account_number;
                }
                else {
                    throw new RuntimeException("Account Creation failed!!!");
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        throw new RuntimeException("Account Number Doesn't Exist");
    }
    public long getAccount_number(String email){
        String query="select account_number from Accounts where email=?";

        try{
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(1,email);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getLong("account_number");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException("Account Number Doesn't Exist!");
    }
    private long generateAccountNumber(){
        try{
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("select account_number from Accounts order by account_number desc limit 1");
            if(resultSet.next()){
                long last_account_number=resultSet.getLong("account_number");
                return last_account_number+1;
            }else{
                return 10000100;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 10000100;
    }

    public  boolean account_exist(String email){
        String query="select account_number from Accounts where email=?";
        try{
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(1,email);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}

