package edu.nyu.cs;

//import random
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A variation of the game of Blackjack.  
 * Complete this program according to the instructions in the README.md file as well as within the given comments below.
 */
public class Blackjack {
  
  /**
   * The main function is automatically called first in a Java program.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {

    // complete this function according to the instructions
    
    try (Scanner input = new Scanner(System.in)) {
    Random random = new Random();
    ArrayList<Integer> playerCards = new ArrayList<>();
    ArrayList<Integer> dealerCards = new ArrayList<>();

    System.out.println("Welcome to Blackjack!");
      
    //maximum - minimum +1 (this is inside the bracket) add minimum on the outside
    int card1= (int)random.nextInt(10)+2;
    int card2= (int)random.nextInt(10)+2;
      
    playerCards.add(card1);
    playerCards.add(card2);
    //System.out.println(playerCards);
      
    int playerScore = card1 + card2;
    boolean user_busts = false;
    boolean dealer_busts = false;
    boolean players_tie = false; 

    System.out.println("Your cards are: " + card1 +" and "+ card2);
    

 
      int dealer_card1 =random.nextInt(10)+2;
      int dealer_card2 = random.nextInt(10)+2;

      int dealerScore = dealer_card1 + dealer_card2;
  
      dealerCards.add(dealer_card1);
      dealerCards.add(dealer_card2);

      boolean boo = true;
    

      while (boo) {
        
      int newpcard = random.nextInt(10)+2;
        System.out.print("Would you like to hit or stand? ");
        String response = input.nextLine();
        if (response.equalsIgnoreCase("hit")){
          playerCards.add(newpcard);
          playerScore+= newpcard;
          
          System.out.print("Your cards are: ");
          for(int i=0; i< playerCards.size();i++){
            System.out.print(playerCards.get(i));
            if(i <= playerCards.size()-2){
              System.out.print(", ");
            }
            if(i==playerCards.size()-2){
              System.out.print("and ");
            }
          }
          System.out.println();
          //potential problem
          if (playerScore>21){
            System.out.print("Your cards are: ");
          for(int i=0; i< playerCards.size();i++){
          System.out.print(playerCards.get(i));
          if(i <= playerCards.size()-2){
            System.out.print(", ");
          }
          if(i==playerCards.size()-2){
            System.out.print("and ");
          }
         }
            System.out.println("\nYou have bust!");

            System.out.println("Dealer wins.");
            user_busts = true;
            break;
          }
        } else if (response.equalsIgnoreCase("stand") || response.equalsIgnoreCase("stop") || response.equalsIgnoreCase("pass")){
          
          break;
          
        } else {
          System.out.println("Invalid response. Please enter 'hit' or 'stand'.");
        }

      }
      System.out.println(); //ADDED THIS FOR TEST

      int choice;
      int newdcard;

      if (user_busts==false){
        choice = (int)random.nextInt(2);
        if(choice== 0){
          System.out.println("The dealer hits.");
          newdcard = random.nextInt(10)+2;
          dealerCards.add(newdcard);
          dealerScore += newdcard;
        }
        if (dealerScore>21){
          System.out.print("Your cards are: ");
      for(int i=0; i< playerCards.size();i++){
        System.out.print(playerCards.get(i));
        if(i <= playerCards.size()-2){
          System.out.print(", ");
        }
        if(i==playerCards.size()-2){
          System.out.print("and ");
        }
      }
        System.out.println();
        System.out.print("The dealer's cards are: ");
        for(int i=0; i< dealerCards.size();i++){
          System.out.print(dealerCards.get(i));
          if (i<= dealerCards.size()-2){
            System.out.print(", ");
          }
          if(i==dealerCards.size()-2){
            System.out.print("and ");
          }
        }
        System.out.println();
      
          System.out.println("The dealer has bust!");
          System.out.println("You win!");
        }else {
          System.out.println("The dealer stands.");
          System.out.print("Your cards are: ");
      for(int i=0; i< playerCards.size();i++){
        System.out.print(playerCards.get(i));
        if(i <= playerCards.size()-2){
          System.out.print(", ");
        }
        if(i==playerCards.size()-2){
          System.out.print("and ");
        }
      }
      System.out.println();

        }
      }
      if(user_busts != true){
        System.out.print("The dealer's cards are: ");
        for(int i=0; i< dealerCards.size();i++){
          System.out.print(dealerCards.get(i));
          if (i<= dealerCards.size()-2){
            System.out.print(", ");
          }
          if(i==dealerCards.size()-2){
            System.out.print("and ");
          }
          
        }
        System.out.println();
      }
      

     
      if (user_busts==false && playerScore> dealerScore) {
        System.out.println("You win!");
      }else if (dealer_busts == false && dealerScore>playerScore){
        System.out.println("Dealer wins!");
      } else if (dealerScore == playerScore && user_busts==false && dealer_busts==false){
        players_tie=true;
        if (players_tie == true){
          System.out.println("Tie!");
        }
      }

      
      
  } // main
  }
}
