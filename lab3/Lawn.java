//Lawn.java
// Janson Chiu 
// jaachiu
// Programming Assignment 1
// This program is intended to take input and calculate the lawn area and mowing time.
import java.util.Scanner; 

class Lawn{
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        double i = scanner.nextDouble();
        double y = scanner.nextDouble(); 
        double x = scanner.nextDouble();
        double z = scanner.nextDouble();
        double squareFeet = ((i*y)-(x*z));
        System.out.println("The lawn area is "+squareFeet+" square feet.");
        double mowRate = scanner.nextDouble();
        System.out.print("The mowing time is ");
        double sec = squareFeet/mowRate;
        int s = (int) Math.round(sec);
        int m = s/60;
        s = s%60;
        int h = m/60;
        m = m%60; 
        System.out.println(h+" hour"+(h==1?" ":"s ")+m+" minute"+(m==1?" ":"s ")+s+" second"+(s==1?".":"s."));
}

}
