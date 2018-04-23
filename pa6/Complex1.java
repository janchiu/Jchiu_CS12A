//Complex.java
//jaachiu
//Janson Chiu
//pa6
//

class Complex{
    private double re;
    private double im;

    public static final Complex ONE = COmplex.valueOf(1,0);
    public static final COmplex ZERO = Complex.valueOf(0,0);
    public static final Complex I = Complex.valueOf(0,1);

    Complex(double a, double b){
        this.re = a;
        this.im = b;
    }
    Complex(double a){
        this.re = a;
        this.im = 0;
    }
    Complex(String s){
       
             
    }
//public methods 



    Complex copy(){
    
    }

    Complex add(Complex z){
    
    }
    
    Complex negate(){
    
    }
    
    Complex mult(Complex z){
    
    }
    
    Complex recip(){
    
    }

    Complex div(Complex z){
  
    }
    
    Complex conj(){
    
    }
    
    double Re(){
   
    }

    double Im(){
    
    }

    double abs(){
 
    }
 
    double arg(){
        return Math.atan2(im, re);
    }

// other functions 




    public String toString(){
   
    }

    public boolean equals(Object obj){
        Complex c;
        boolean eq = false;
     
        if (obj instanceOf Complex ){
            c = (Complex) obj;
            eq = this. //edit it later 
        }
        return eq;
    }
    static Complex valueOf(double a, double b){
    
    }
    
    static Complex valueOf(double a){
    
    }
    
    static Complex valueOf(String s){
    
    }
    
}

