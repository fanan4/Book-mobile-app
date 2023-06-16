package guessingGame.com;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static  Random rand=new Random();
    static  Scanner scanner=new Scanner(System.in);
    static int guesnumber= rand.nextInt(11);
    static  int usernumber;
    public static void main(String[] args) {
        int playagain;
           do{
               gussfunc();
               System.out.println("if want to to play again please enter 1");
               playagain=scanner.nextInt();
           }while(playagain==1);


    }
    static  void gussfunc(){
        int i=1;
        while(i>=0){
            do {
                System.out.println("Enter a number between 0 and 10");
                usernumber=scanner.nextInt();
               }while(usernumber<0 && usernumber>=11);
                  if(usernumber>guesnumber){
                      System.out.println("it's high");
                  }
                  else if(usernumber<guesnumber){
                      System.out.println("it's low");
                  }
                  else if(usernumber==guesnumber){
                      System.out.println("you win the game");
                      break;
                  }
            else if(i>=5){
                System.out.println(" You have exceeded 5 attempts");
                break;
            }
            i++;
        }
    }
}
