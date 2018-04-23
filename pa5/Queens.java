//Queens.java
//jaachiu
//Janson Chiu
//pa5
//This program finds the solutions to the eight queens problem 

public class Queens{ 
    public static void main(String[] args){
        int i, n = args.length;
        int size = 0;
        if(args[0].equals("-v")){
            try{
                size = Integer.parseInt(args[1]); 
            }catch(NumberFormatException e1){ // if -v was entered but a non-numerical string was entered after 
                System.out.println("Usage: Queens [-v] number");
                System.out.println("Option: -v   verbose output, print all solutions");
            
            }
            int[] arr1 = new int[size+1];
            for(i =0;i<arr1.length;i++){
                arr1[i] = i;
            }
            long numOfSol =0;
            long numOfPerm = Queens.factorial(size);  
            for(i =0; i<numOfPerm;i++){
                nextPermutation(arr1);
                if(isSolution(arr1)){
                    printArray(arr1);
                    numOfSol++;
                }
            }
            
            System.out.println(size+"-Queens has "+numOfSol+" solutions");
            
        }else if(isInt(args[0])==true){       
                size = Integer.parseInt(args[0]);
                int[] arr2 = new int[size+1];
                for(i=0;i<arr2.length;i++){
                    arr2[i] = i;
                }
                long k =0;
                long numOfPerm = Queens.factorial(size);
                for(i=0;i<numOfPerm;i++){
                    nextPermutation(arr2);
                    if(isSolution(arr2)){
                        k++;
                    }
                }
                System.out.println(size+"-Queens has "+k+" solutions");
                
        }else{ 
            System.out.println("Usage: Queens [-v] number");
            System.out.println("Option: -v   verbose output, print all solutions"); 
            System.exit(0);
        }    
         
    } 
    
    static boolean isInt(String n){
        try{
            Integer.parseInt(n);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    static void nextPermutation(int[] A) { 
        int pivot = -1;
        int pivotPos = -1; 
        int successor = -1;
        int successorPos = -1; 
        for(int i=A.length-2; i>=1;i--){ 
            if(A[i] < A[i+1]){
                pivot = A[i];
                pivotPos = i;
                break;
            }
        }
        if(pivot ==-1) {
            Queens.reverseArray(A,1);
            return; 
        }
        for(int i = A.length-1;i>=1;i--){
            if(A[i]>pivot){ 
                successor = A[i];
                successorPos = i;
                break;
            }
        } 
        Queens.swap(A,pivotPos,successorPos);
        reverseArray(A,pivotPos+1);
        return;
    }
     
    static boolean isSolution(int[] A){ 
        int n = A.length;
        
        for(int i = 1; i <A.length;i++){ 
            for(int j =i+1;j<A.length;j++){
               if(Math.abs(i-j)==Math.abs(A[j]-A[i])){
                   return false;// n(n-1)/2 comparisons 
               }
            }
        }
        return true; 
    }

    static void swap(int[] A, int start, int end){
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }

    static int[] reverseArray(int[] A,int start){ 
        int i = start;
        int j = A.length-1;
        while(i<j){
            swap(A, i, j);
            i++;
            j--;
        }
       return A;
    }
 
    static void printArray(int[] A) {
        System.out.print("("); 
        for(int i =1;i<A.length;i++){
            if(i<A.length-1){
                System.out.print(A[i]+", ");
            }else{
                System.out.print(A[i]);
            }
        }
        System.out.println(")");
    }

    static long factorial(int n) { 
        long result = 1;
        for(int i = 1; i<=n;i++){
            result = result*i;
        }
        return result;
    }
         
} 

