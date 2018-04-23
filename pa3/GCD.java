//GCD.java 
//Janson Chiu
//jaachiu
//pa3 
//This program asks the user for two positive integer inputs and calculates the greatest common divisor between the two numbers. 

import java.util.Scanner; 

class GCD{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // creates a scanner called sc that will take in user input 
        int a = 0;
	int x = 0;
	int y = 0;
        int smallNum =0;
        int largeNum = 0; 
        int remainder = 1;
        System.out.print("Enter a positive integer: "); // prompts the user to enter a positive number 
        while(a<2){
            while(true){
                while(!sc.hasNextInt()){  // if the user does not enter an integer, it prompts the user again
                    System.out.print("Please enter a positive integer: ");
                    sc.next();
                }
                if (a <1){
                    x = sc.nextInt(); 
                    if (x > 0){ // checks if the integer is positive 
                        System.out.print("Enter another positive integer: ");
                        break;
                    }
                    if (x <= 0 ){ // Only allows the user to enter positive integers
                        System.out.print("Please enter a positive integer: ");
                        continue;
                    }
                }
                if (a <2){ 
                    y = sc.nextInt();
                    if (y>0){ 
                        break;
                    }
                    if ( y <= 0){ 
                        System.out.print("Please enter a positive integer: ");
                        continue;
                    }
                }
            }
            a += 1;
        }
     
        if(x>y){ // checks which of the inputs is the largest
            largeNum = x;
            smallNum = y;  
        } else { 
            largeNum = y;
            smallNum = x;
        }
        while(remainder !=0){
            remainder = largeNum % smallNum;
            largeNum = smallNum;
            smallNum = remainder; 
        }
        System.out.println("The GCD of "+x+" and "+y+" is "+largeNum); // prints out the result  
    }
}





