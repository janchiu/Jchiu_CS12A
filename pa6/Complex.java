//Complex.java
//jaachiu
//Janson Chiu 
//pa6
//This program calculates Complex numbers and does different calculations to them. 

import java.lang.Math;
public class Complex{

    private double re;
    private double im;
    public static final Complex ONE = Complex.valueOf(1,0);
    public static final Complex ZERO = Complex.valueOf(0,0);
    public static final Complex I = Complex.valueOf(0,1);
    
    public static void main(String[] args){
        Complex a = new Complex("2+3i");
        Complex b = new Complex("1+1i");
        System.out.println(a.Re());
        System.out.println(b.Re());
        Complex c = a.add(b);
        System.out.println(c.re);
        System.out.println(c.im);
        System.out.println(c.toString());
    }
    Complex(double a, double b){
        this.re = a;
	this.im = b;
    }
    Complex(double a){
        this.re = a;
	this.im = 0;
    }

    Complex(String s){
        double[] C = parseComplex(s);
        System.out.println("Re("+s+") = "+C[0]);  // real part
        System.out.println("Im("+s+") = "+C[1]);  // imaginary part
        this.re = C[0];
        this.im = C[1];
	      // Fill in this constructor.
	      // It should accept expressions like "-2+3i", "2-3i", "3", "5i", etc..
	      // Throw a NumberFormatException if s cannot be parsed as Complex.
    }
    static double[] parseComplex(String str){
        double[] part = new double[2];
	String s = str.trim();
        String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
	String SGN = "[+-]?";
        String OP =  "\\s*[+-]\\s*";
        String I =   "i";
        String OR =  "|";
	String REAL = SGN+NUM;
	String IMAG = SGN+NUM+"?"+I;
	String COMP = REAL+OR+
        IMAG+OR+
        REAL+OP+NUM+"?"+I;
		      
	if( !s.matches(COMP) ){
            throw new NumberFormatException(
                "Cannot parse input string \""+s+"\" as Complex");
        }
        s = s.replaceAll("\\s","");     
	if( s.matches(REAL) ){
            part[0] = Double.parseDouble(s);
            part[1] = 0;
        }else if( s.matches(SGN+I) ){
	    part[0] = 0;
            part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
        }else if( s.matches(IMAG) ){
	    part[0] = 0;
	    part[1] = Double.parseDouble( s.replace( I , "" ) );
        }else if( s.matches(REAL+OP+I) ){
	    part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
            part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
        }else{   //  s.matches(REAL+OP+NUM+I) 
	    part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
            part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
        }
	return part;
    }
	   //---------------------------------------------------------------------------
	   // Public methods 
	   
	   // copy()
	   // Return a new Complex equal to this Complex
    Complex copy(){
        Complex newComp = new Complex(0.0, 0.0);
            newComp.re = this.re;
	    newComp.im = this.im;
	    return(newComp);
    }
	   
	   // add()
	   // Return a new Complex representing the sum this plus z.
    Complex add(Complex z){
        Complex sum = new Complex(1.0,2.0);
        sum.re = this.re +z.Re();
        sum.im = this.im +z.Im();
        return (sum);
         //       return new Complex(this.re+z.re,this.im+z.im);
    }
	   
 	   // negate()
	   // Return a new Complex representing the negative of this.
    Complex negate(){
        if(this.im!=0)
            return new Complex(-1*this.re, -1*this.im);
        else 
            return new Complex(-1*this.re);
    }

	   // sub()
	   // Return a new Complex representing the difference this minus z.
    Complex sub(Complex z){
        double n = this.re - z.Re();
        double d = this.im -z.Im();
	return( new Complex(n,d));
	      
    }

	   // mult()
	   // Return a new Complex representing the product this times z
    Complex mult(Complex z){
   
        if(this.im ==0. || z.Im() ==0.){
            return new Complex(this.re*z.Re());
        }
        return new Complex((this.re*z.Re())-(this.im*z.Im()),(this.re*z.Im())+(this.im*z.Re()));
        // Fill in
    }
    Complex mult(double z){
         return new Complex(z*this.re,z*this.im);
    }

	   // recip()
	   // Return a new Complex representing the reciprocal of this.
	   // Throw an ArithmeticException with appropriate message if 
	   // this.equals(Complex.ZERO).
    Complex recip(){
	      // Fill in
        double n = this.re;
	double d = this.im;
	if(this.equals(Complex.ZERO)) {
	    throw new ArithmeticException("Cannot creste reciprocal of zero");
	}else {
            double scale = this.re*this.re+this.im*this.im;
	    return(new Complex(this.re/scale,-this.im/scale));
        }
    }

	   // div()
	   // Return a new Complex representing the quotient of this by z.
	   // Throw an ArithmeticException with appropriate message if 
	   // z.equals(Complex.ZERO).
    Complex div(Complex z){
       // Complex divd = new Complex(0.0,0.0);
	//double r,den;
        Complex a = this;
	if(z.equals(Complex.ZERO)) {
	    throw new ArithmeticException("cannot divide by zero");
	}else{
            return a.mult(z.recip());
/*
	if(Math.abs(z.re)>= Math.abs(z.im)) {
	    r = z.im/z.re;
	    den = z.re+r*z.im;
	    divd.re = (r*this.re+this.im)/den;
	    divd.im = (r*this.im-this.re)/den;
 	} else {
	    r = z.re/z.im;
	    den = z.im + r*this.re;
	    divd.re = (r*this.re + this.im)/den;
	    divd.im = (r*this.im - this.re)/den;
	}
*/
	   }
	      // Fill in
    }

	   // conj()
	   // Return a new Complex representing the conjugate of this Complex.\
    Complex conj(){
        return new Complex(this.re,-this.im);
	      // Fill in
    }
    double Re(){
        return re;
    }

    double Im(){
        return im;
    }

	   // abs()
	   // Return the modulus of this Complex, i.e. the distance between 
	   // points (0, 0) and (re, im).
    double abs(){
        
        double x, y,temp, result;
        x = Math.abs(this.re);
        y = Math.abs(this.im);
        if(x ==0){
            result = y;
        }else if(y==0){
            result = x;
        }else if(x>y){
            temp = y/x;
            result = x*Math.sqrt((double)(1.0+temp*temp));
        }else{
            temp = x/y;
            result = y*Math.sqrt((double)(1.0+temp*temp));
        }
	return result;      // Fill in
    }

	   // arg()
	   // Return the argument of this Complex, i.e. the angle this Complex
	   // makes with positive real axis.
    double arg(){
        return Math.atan2(im, re);
    }

	   // Other functions ---------------------------------------------------------
	   
	   // toString()
	   // Return a String representation of this Complex.
	   // The String returned will be readable by the constructor Complex(String s)
    public String toString(){
        if(this.im > 0 && this.re!=0) {
	    return this.re+"+"+this.im+"i";
        } else if(this.im==0){
            return String.valueOf(this.re);
           // return this.re+" ";
        } else if (this.re!=0 && this.im<0){
            return this.re+"-"+(-this.im)+"i";
        }else if (this.re ==0){
            return this.im+"i";
        } else {
	    return this.re +"-"+-this.im+"i";
	}
	      // Fill in
    }

	   // equals()
	   // Return true iff this and obj have the same real and imaginary parts.
    public boolean equals(Object obj){
        boolean eq = false;
        Complex c;
        if( obj instanceof Complex){
            c = (Complex) obj;
            eq = (this.re==c.re &&this.im == c.im);
        }
        return eq;
	      // Fill in
    }

	   // valueOf()
	   // Return a new Complex with real part a and imaginary part b.
    static Complex valueOf(double a, double b){
	      // Fill in
        return(new Complex(a,b));
    }

	   // valueOf()
	   // Return a new Complex with real part a and imaginary part 0.
    static Complex valueOf(double a){
        return(new Complex(a));
	      // Fill in
    }

	   // valueOf()
	   // Return a new Complex constructed from s.
    static Complex valueOf(String s){
        return(new Complex(s));
	      // Fill in
    }

}
