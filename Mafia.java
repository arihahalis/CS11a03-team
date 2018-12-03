import java.util.Random;
import java.util.Scanner;


public class Mafia{
  public static String[] role;
  public static String[] roles = {"","","","","","",""};
  public static boolean[] alive = {true,true,true,true,true,true,true};
  public static void main(String[]args){
    System.out.println("MAFIA");
    System.out.println("Choose a group of 8. Select a moderator. They will operate the computer.");
    System.out.println("Moderator, assign the rest of the group numbers 0-6");
    System.out.println("They will be selected randomly to play:");
    System.out.println("An innocent (there are 3 in total),");
    System.out.println("A member of the mafia (there are 2 in total),");
    System.out.println("A healer (only 1 player),");
    System.out.println("Or a detective (only 1 player).");
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

    int[] players={0,1,2,3,4,5,6} ;
    playersRole(players);
    System.out.println("If you are the last player, please give the computer back to the moderator.");

    pause1();

    System.out.println("Please have all players close their eyes and put down their heads.");
    System.out.println("Say: Mafia, open your eyes. Make sure you know the other mafia. Pick a victim by showing me the number.");
    //code for Mafias
    System.out.println("Enter the player number of the victim");
    int victim1 = scan.nextInt();
    System.out.println("Say: Mafia, close your eyes.");
    System.out.println("Say: Detective, open your eyes. Who would you like to know about? Please show me the number.");
    // code for detective
    //If the Detective is correct, that Mafia member is eliminated from the game.

    System.out.println("Enter the player number of the suspected Mafia.");
    int suspected1 = scan.nextInt();
        if (roles[suspected1-1].equals( "Mafia")){
          System.out.println("Player "+suspected1+" is a mafia.");
        }else{
          System.out.println("Player "+suspected1+" is not a mafia.");
        }
        System.out.println("Say: Detective, close your eyes.");


       
        //code for healer
        //The Doctor can choose to save himself and thus survive the night.
        //If the Doctor chooses another player and that individual is chosen by the Mafia to be killed,

        //If the Doctor is chosen for death by the Mafia,
        //he is out of the game and the townspeople can no longer be saved.
        System.out.println("Say:Wake up the Healer and the person died tonight was(point to the victim).");
        //code for healer
        
        System.out.println("Say:Do you want to save ? (Enter yes or no)" );
        String healer=scan.next();
          if(healer.equals("yes"){
            System.out.println("Enter the player number of the person been saved.");
          int saved1 = scan.nextInt();
        }

       
        System.out.println("Say: Everyone, open your eyes.");
        System.out.println("Press enter to continue");

        pause1();

        if (victim1==saved1){
          System.out.println("Tell the players that no one died last night.");
        } else {
          System.out.println("Tell the players that player "+victim1+" was killed last night.");
        }

        pause1();

        System.out.println("Please hold a discussion about recent events. When the discussion reaches a point where a player has a suspicion, the game moves on to the accusation.");
        System.out.println("Who did they vote? Enter the number.");
        int vote1 = scan.nextInt();
        alive[vote1-1] = false;
        //System.out.println(victim1+" "+dec1+" "+saved1);
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
            System.out.println("The innocent party wins!");
            System.out.println("Game over.");
            }
          else if (mafiacounter==nonmafiacounter){
            System.out.println("The mafia party wins!");
            System.out.println("Game over.");
            }
          else {
            System.out.println("Game continues.");
            }
         }


      public static void playersRole(int[] players){
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
        try{System.in.read();}
        catch(Exception e){}

        }
        public static void pause2(){
          System.out.println("Press ENTER to continue.");
          try{System.in.read();}
          catch(Exception e){}
            System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
            System.out.println("Pass the laptop to the next player.Next player please press Enter to continue.");

            try{System.in.read();}
            catch(Exception e){}

            }

          }
