package simpleGame;

public class Main {
    public static void main(String[] args) {
        Player1 player=new Player1("Abhau","sword",100);
//        System.out.println(player.getName());
//        System.out.println(player.getHealth());
//        System.out.println(player.getWeapon());
        player.damageByGun1();
        player.damageByGun1();
        player.damegeByGun2();
        player.heal();
//        player.damegeByGun2();
//
//        Player2 betterPlayer=new Player2("Shyam","machineGun",78,true);
//        betterPlayer.damageByGun1();


    }
}
