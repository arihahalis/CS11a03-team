import java.util.Random;
import java.util.Scanner;


public class Mafia{
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
    if(yn.equals("No")){
      System.out.println("Take your time!");
      pause();
    }
    else if(yn.equals("Yes")){
      System.out.println("Great, let's get started!");
    }

    int[] players={0,1,2,3,4,5,6} ;
    playersRole(players);
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
      System.out.println("Pass the laptop to the next player.");
      pause();
    }
  }
  public static void pause(){
    System.out.println("Press Enter to continue");
    System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
    try{System.in.read();}
    catch(Exception e){}
    
  }
}
