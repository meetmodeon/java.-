import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
class Team{
    private String teamName;
    private TreeMap<Integer,Player> roster;

    public Team(String teamName,TreeMap<Integer,Player> roster){
        this.teamName=teamName;
        this.roster=roster;
    }

    public String getTeamName(){
        return teamName;
    }

    public TreeMap<Integer,Player> getRoster(){
        return roster;
    }
}
class Player{
    protected int number;
    protected String name;
    protected String pos;
    protected boolean rightHanded;
    protected int plateAppearnaces;
    protected int walks;
    protected int strikeouts;
    protected int hits;

    public Player(int number,String name,String pos,boolean rightHanded,int plateAppearnaces,int walks,int strikeouts,int hits){
        this.number=number;
        this.name=name;
        this.pos=pos;
        this.rightHanded=rightHanded;
        this.plateAppearnaces=plateAppearnaces;
        this.walks=walks;
        this.strikeouts=strikeouts;
        this.hits=hits;
    }
}
class Pitcher extends Player{
    private int innings;
    private int earnedRuns;
     public Pitcher(int number,String name,String pos,boolean rightHanded,int plateAppearances,int walks,int strikeouts,int hits,int innings,int earnedRuns){
         super(number,name,pos,rightHanded,plateAppearances,walks,strikeouts,hits);
         this.innings=innings;
         this.earnedRuns=earnedRuns;

     }
}
class PostionPlayer extends Player{
    private int atBats;
    private int runsBattedIn;
    private int homeRuns;
    private int hitByPitch;

    public PostionPlayer(int number,String name,String pos,boolean rightHanded,int plateAppearances,int walks,int strikeouts,int hits,int atBats,int runsBattedIn,int homeRuns,int hitsByPitch){
        super(number,name,pos,rightHanded,plateAppearances,walks,strikeouts,hits);
        this.atBats=atBats;
        this.runsBattedIn=runsBattedIn;
        this.homeRuns=homeRuns;
        this.hitByPitch=hitsByPitch;
    }
}
public class BaseballDriver{
    private Map<String,Team> teams;
    public BaseballDriver(){
//        super( teams=new HashMap<String,Team>());
        teams=new HashMap<String,Team>();
    }
    public void readData(Scanner scn){
        while (scn.hasNext()){
            Team t=readTeamData(scn);
            teams.put(t.getTeamName().toLowerCase(),t);
        }
    }
    private Team readTeamData(Scanner scn){
        TreeMap<Integer,Player> roster=new TreeMap<Integer, Player>();
        String teamName=scn.next();
        int playerNumber =scn.nextInt();
        while(playerNumber != -1){
            Player p=readPlayerData(playerNumber,scn);
            roster.put(playerNumber,p);
            playerNumber=scn.nextInt();
        }
        return new Team(teamName,roster);
    }
    private Player readPlayerData(int playerNumber,Scanner scn){
        //Read common data fields
        int number=scn.nextInt();
        String name=scn.next();
        String pos=scn.next();
        boolean rightHanded=scn.next().charAt(0)=='t';
        int plateAppearances=scn.nextInt();
        int walks=scn.nextInt();
        int strikeouts=scn.nextInt();
        int hits=scn.nextInt();

        //Read variant data fields based on position
        int inningsOrAtBats= scn.nextInt();
        int earnedRunsOrRunsBattedIn=scn.nextInt();
        if(pos.equals("1")){
            return new Pitcher(number,name,pos,rightHanded,plateAppearances,walks,strikeouts,hits,inningsOrAtBats,earnedRunsOrRunsBattedIn);
        }
        else{
            int homeRuns=scn.nextInt();
            int hitByPitch=scn.nextInt();
            return new PostionPlayer(number,name,pos,rightHanded,plateAppearances,walks,strikeouts,hits,inningsOrAtBats,earnedRunsOrRunsBattedIn,homeRuns,hitByPitch);
        }
    }

    public static void main(String[] args) {
        // Assuming the file is provided as command line argument
        String filename=args[0];
        try(Scanner scn= new Scanner(new File(filename))){
            BaseballDriver driver=new BaseballDriver();
            driver.readData(scn);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+filename);
            throw new RuntimeException(e);
        }
    }
}
