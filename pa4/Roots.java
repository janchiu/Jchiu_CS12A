//Roots.java
//Janson Chiu 
//jaachiu
//pa4
//This program finds the roots of the given polynomial 
import java.util.Scanner; 

class Roots{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double tolerance = Math.pow(10,-11); // raises 10 to the -11 power
        double threshold = Math.pow(10,-3); // raises 10 to the -3 power
 
        System.out.println("Enter the degree:");  //prompts the user for the degree
        int degree = sc.nextInt();
        int numOfCo = degree+1; //number of coefficients 
        System.out.println("Enter "+(numOfCo)+ " coefficients:");

        double[] C = new double[numOfCo];
        for(int i = 0; i<numOfCo; i++){//make loop to get input
            C[i] = sc.nextInt();
        } 
        double[] D = diff(C); // derivative array with one less value 
   
        while(true){
            System.out.println("Enter endpoints, or q to quit:");
            if(sc.hasNextDouble()){  
            double a = sc.nextDouble(); // gets the next two double values
            double b = sc.nextDouble();
            double answer =0.0;
            double diffAns = 0.0;
                if(poly(C,a)*poly(C,b)<=0){ // checks for odd roots
                    answer = findRoot(C, a, b, tolerance);
                    System.out.print("    Odd root in ["+a+", "+b+"] "+"found at: ");
                    System.out.printf("%.10f%n",answer);
                    
                }else if ((poly(D,a)*poly(D,b))<=0){ 
                    diffAns = findRoot(D,a,b,tolerance);
                  
                    if (Math.abs(poly(C,diffAns))<threshold){            // checks if it is an even root
                        System.out.print("    Even root in ["+a+", "+b+"] "+"found at: ");
                        System.out.printf("%.10f%n",diffAns);
                    }else {
                        System.out.println("No root found in ["+a+", "+b+"]");
                    }
                }else{
                    System.out.println("No root found in ["+a+", "+b+"]");// edit
                } 
            } else {
               System.out.println("bye!");
               break;

            }
        }
    }
   
    static double poly(double[] C, double x){ // converts it to polynomial and returns the sum of the values 
        double sum = 0.0;
        for (int i =0; i<C.length;i++){
            sum = sum +(C[i]*Math.pow(x,i));
        }
        return sum; 
    }

    static double[] diff(double[] C){ // finds the derivative of the function 
        double[] derivArr = new double[C.length-1];
        for(int i =0; i<C.length-1;i++){
            derivArr[i] = C[i+1]*(i+1);
        }
        return derivArr;
    }
    static double findRoot(double[] C, double a, double b, double tolerance){ // finds the root in the polynomial 
        double width = b-a;
        double mid = 0.0;
        while(width>tolerance){
            mid = (a+b)/2.0;
            if((poly(C,a)*poly(C,mid)<=0)){
                b = mid;
            } else {
                a = mid;
            }
            width = b-a;
        }
        return mid; 
    } 
}
