package EmailApplication;

public class EmailApp {
    public static void main(String[] args) {
        Email email=new Email("John","Khan");
//        email.setMailboxCapacity(800);
//        email.changePassword("Meet&786");
//        email.setAlternateEmail("meetyadav@gmail.com");
        System.out.println(email.showInfo());
    }
}
