
/**
Team: Konnichiwa
Qianni Chen, Ari Hahalis, Ruoshan Wang, Yiyang Luo
If you have ever played Mafia before, you must know how important the role of the moderator is.
A bad moderator can significantly affect your game experience. Our program is designed for a
moderator (even for a newbie!) in Mafia to have a smooth facilitation throughout the whole game.
Even if you have never been a moderator before, just follow the script and instructions shown on
the screen and you will be good to go!
**/

import java.util.Random;
import java.util.Scanner;

public class MafiaEd4{
  public static String[] role;
  public static String[] roles = {"","","","","","",""};
  public static boolean[] alive = {true,true,true,true,true,true,true};
  public static void main(String[]args){
    //instructions to the game, *** to be read aloud
    System.out.println("MAFIA GAME");
    System.out.println("");
    System.out.println("Moderator: Any lines with stars will be your script. Please read exactly as shown on the screen.");
    System.out.println("All other lines will be your instructions.");
    System.out.println("");
    System.out.println("*** I'm the moderator. Let me explain the rules.***");
    System.out.println("*** There are 7 roles in Mafia. Three innocents, two mafias, one healer, and one detective.***");
    System.out.println("*** The innocents are only responsible for debating and voting out who they believe to be the mafia***");
    System.out.println("");
    System.out.println("*** When the game starts, I will ask everyone to close their eyes. ***");
    System.out.println("*** The first step is for the two mafias to choose to murder one non-mafia.*** ");
    System.out.println("*** The mafias use fingers to show the number of the person they want to kill.***");
    System.out.println("*** The second step is for the detective to suspect mafias.***");
    System.out.println("*** The detective uses fingers to show the number of the person they want to detect.***");
    System.out.println("*** I will show thumbs up or thumbs down. Thumb up means the suspect is the mafia. Thumb down means the suspect is not.***");
    System.out.println("");
    System.out.println("*** The third step is for the healer to save people.*** ");
    System.out.println("*** The healer uses fingers to show the number of the person they want to save.***");
    System.out.println("*** If the healer chooses the person to save correctly, nobody dies.***");
    System.out.println("");
    System.out.println("*** Then everyone wakes up, and surviving players debate the identities of the mafia and vote to eliminate a suspect.*** ");
    System.out.println("*** Make sure that everyone votes and that they all vote at the same time.***");
    System.out.println("*** The game continues until all of the mafia have been eliminated or until the mafia outnumbers the non-mafias.***");
    System.out.println("*** Make sure all moves are quiet when people are asleep.***");
    System.out.println("*** Once you have died, you may no longer speak, but you do not have to close your eyes anymore.***");
    System.out.println("*** Now, the roles will be selected randomly to play.***");
    System.out.println("");

    System.out.println("Ready to play? Yes or No?");
    Scanner scan = new Scanner(System.in);
    String yn = scan.nextLine();
    if(yn.equals("No")||yn.equals("no")){
      System.out.println("Take your time!");
      System.out.println("If you are ready, press Enter to start!");
      pause1();
    }
    else if(yn.equals("Yes")){
      System.out.println("Great, let's get started!");
    }

    //gameplay has started
    int[] players={0,1,2,3,4,5,6} ;
    playersRole(players);
    System.out.println("If you are the last player, please give the computer back to the moderator.");

    pause1();

    boolean gameContinues = true;
    while (gameContinues){
      System.out.println("*** All players, please close your eyes and put down your heads.***");
      //code for Mafia
      System.out.println("*** Mafia, open your eyes. Make sure you know the other mafia. Pick a victim by showing me the number.***");
      System.out.println("");
      System.out.println("Enter the player number of the victim");
      int victim1 = scan.nextInt();
      System.out.println("");
      System.out.println("*** Understood, close your eyes.***");
      System.out.println("");

      System.out.println("*** Detective, open your eyes. Who would you like to know about? Please show me the number.***");
      System.out.println("");
      // code for detective
      //If the Detective is correct, that Mafia member has a higher chance of being eliminated from the game.

      for (int i=0; i<7; i++){
        if (roles[i].equals( "Detective")){
          if (alive[i]==true){
            System.out.println("Enter the player number of the suspected Mafia.");
            int suspected1 = scan.nextInt();
            if (roles[suspected1].equals( "Mafia")){
              System.out.println("");
              System.out.println("Player "+suspected1+" is a mafia.");
            }
            else{
              System.out.println("");
              System.out.println("Player "+suspected1+" is not a mafia.");
            }
            System.out.println("Thumb up if the suspect is a mafia. Thumb down if the suspect is not.");
            System.out.println("");
            System.out.println("*** Detective, close your eyes.***");
          }
          else{
            System.out.println("The detective is already dead but please follow the script.");
            System.out.println("");
            System.out.println("*** Detective, close your eyes.***");
          }
        }
      }
      //code for Healer
      //if the healer is correct, nobody dies
      System.out.println("*** Healer, open your eyes, and tell me who do you want to save by showing me the number.***");
      System.out.println("");
      for (int j=0;j<7;j++){
        if(roles[j].equals("Healer")){
          if(alive[j]==true){
            System.out.println("Enter the player number of the person been saved.");
            int saved1 = scan.nextInt();
            System.out.println("");
            System.out.println("*** Healer, close your eyes.***");
            System.out.println("");
              if (victim1 == saved1){
                System.out.println("*** No one died last night.***");
                }
              else {
                  System.out.println("*** Player "+victim1+" was killed last night.***");
                  System.out.println("");
                  alive[victim1] = false;
                  }
          }
          else{
            System.out.println("The healer is already dead but please follow the script");
            System.out.println("");
            System.out.println("*** Healer, close your eyes.***");
            System.out.println("*** Player "+victim1+" was killed last night.***");
            alive[victim1] = false;
          }
        }
      }
      //discussion and vote code
      System.out.println("*** Everyone, open your eyes.***");
      System.out.println("Press enter to continue");
      pause1();

      System.out.println("*** Please discuss about recent events. Speak from number zero to number six.***");
      System.out.println("");
      System.out.println("When the discussion reaches a point where a player has a suspicion, the game moves on to the accusation.");
      System.out.println("");
      System.out.println("*** Raise hands for who you suspect most, and vote out the person suspected the most. ***");
      System.out.println("***3,2,1, VOTE!***");
      System.out.println("");
      System.out.println("Enter the number.");
      int vote1 = scan.nextInt();
      alive[vote1] = false;
      //determines if game continues or ends as well as who the winners are
      int mafiacounter=0;
      int nonmafiacounter=0;
      for (int i=0; i<7; i++){
        if (roles[i].equals( "Mafia")){
          if (alive[i]==true){
            mafiacounter++;
          }
        }
        else{if (alive[i]==true){
          nonmafiacounter++;
        }
      }
    }
    if (mafiacounter==0){
      System.out.println("*** The innocent party wins!***");
      System.out.println("*** Game over.***");
      gameContinues = false;

    }
    else if (mafiacounter==nonmafiacounter){
      System.out.println("*** The mafia party wins!***");
      System.out.println("*** Game over.***");
      gameContinues = false;
    }
    else {
      System.out.println("*** Game continues.***");
      gameContinues = true;
     }
    }
  }

  public static void playersRole(int[] players){
    //method randomly assigns roles to players
    String role = " ";
    boolean[] arr = new boolean[7];
    int min = 0;
    int max = 6;
    for(int i = 0; i<players.length; i++){
      Random randomNum = new Random();
      int n = min + randomNum.nextInt(max+1);
      boolean numberTaken = false;
      if(arr[n] == true){
        numberTaken = true;
      }
      while(numberTaken){
        n = min + randomNum.nextInt(max+1);
        if(arr[n] == true){
          numberTaken = true;
        }
        if(arr[n] == false){
          numberTaken = false;
        }
      }
      arr[n]=true;
      if (n==0){
        role = "Healer";
      }
      else if (n==1){
        role = "Detective";
      }
      else if (n==2||n==3){
        role = "Mafia";
      }
      else if (n==4||n==5||n==6){
        role = "Innocent";
      }
      System.out.printf("player %d is %s%n",i,role);
      roles [i] = role;
      pause2();
    }
  }

  public static void pause1(){
    //allows moderator and players time, press enter to continue playing
    try{System.in.read();}
    catch(Exception e){}
  }

  public static void pause2(){
    //allows players to see their own role and no one else's
    System.out.println("Press ENTER to continue.");
    try{System.in.read();}
    catch(Exception e){}
    System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
    System.out.println("Pass the laptop to the next player.Next player please press Enter to continue.");
    
    try{System.in.read();}
    catch(Exception e){}
  }
}
