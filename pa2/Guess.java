// Guess.java 
// Janson Chiu 
// jaachiu
// Programming Assignment 2
// This programming asks the user to guess a number between 1 and 10 in 3 guesses. If the user guesses the correct number in 3 guesse, they win. 

import java.util.Scanner; 

class Guess{ 
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in); 

        System.out.println("I'm thinking of an integer in the range 1 to 10. You have three guesses.");
        int randomNum =(int)Math.floor( Math.random()* 10+1);  // chooses a random number from 1 to 10. 
        System.out.println();

        System.out.print("Enter you first guess: ");
        int firstGuess = sc.nextInt(); 
        if (firstGuess > randomNum) { 
            System.out.println("Your guess is too high."); // shows the user that the number inputted is too high  
	}else if (firstGuess < randomNum) { 
            System.out.println("Your guess is too low."); // shows the user that the number inputted is too low
        }else { 
            System.out.println("You win!") ; 
            System.exit(0); // exits the program when you win 
        }
        System.out.println();

        System.out.print("Enter your second guess: "); 
        int secondGuess = sc.nextInt(); 
        if ( secondGuess > randomNum) { 
            System.out.println("Your guess is too high.");
        }else if (secondGuess< randomNum){
            System.out.println("Your guess is too low.");
        } else {
            System.out.println("You win!");
            System.exit(0); 
        }
        System.out.println();
  
        System.out.print("Enter your third guess: "); 
        int thirdGuess = sc.nextInt(); 
        if ( thirdGuess > randomNum){ 
            System.out.println("Your guess is too high.");
            System.out.println();
            System.out.println("You lose. The number was "+randomNum+".");  // You lose after 3 incorrect guesses
        }else if (thirdGuess< randomNum) {
            System.out.println("Your guess is too low."); // You lose after 3 incorrect guesses 
            System.out.println(); 
            System.out.println("You lose. The number was "+randomNum+"."); 
        } else { 
            System.out.println("You win!"); 
        } 
} 
}












