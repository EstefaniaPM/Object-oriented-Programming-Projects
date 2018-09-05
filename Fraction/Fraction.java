//Estefania Pitol Martinez A01551688
//Fernanda Montano Rios    A01730440

//Friday, August 18th, 2017
//This class is a template for instantiating Fractions
public class Fraction implements Comparable<Fraction>{
	
	private int num, den;
	
	//Parametrized constructor
    //Parameter num - Fraction numerator
	//Parameter den - Fraction dneominator
    //Creates a Fraction
	public Fraction(int num, int den){
		this.num = num;
		this.den = den;
	}

	//Parametrized constructor
    //Parameter num - number
    //Converts the number into a Fraction
	public Fraction(int num){
		this.num = num;
		this.den = 1;
	}
	
	//Empty Constructor
    //Creates a Fraction (0/1)
	public Fraction(){
		this.num = 0;
		this.den = 1;
	}
	
	//Numerator getter
	//Returns - Fraction numerator
	public int getNum(){
		return this.num;
	}
	
	//denominator getter
	//Returns - Fraction denominator
	public int getDen(){
		return this.den;
	}
	
	//Sums up a Fraction to the actual Fraction
    //Parameter other - the other Fraction
	//Returns Fraction - total sum
	public Fraction sum(Fraction other){
		int n = this.num * other.den + other.num * this.den;
		int d = this.den * other.den;
		Fraction s = new Fraction(n, d);
		s.simplify();
		return s;
	}
	
	//Multiply the actual Fraction and other Fraction
    //Parameter other - the other Fraction
	//Returns Fraction - multiplication result	
	public Fraction mul(Fraction other){
		int n = this.num * other.num;
		int d = this.den * other.den;
		Fraction m = new Fraction(n, d);
		m.simplify();
		return m;
	}
	
	//Simplifies the Fraction
	public void simplify(){
		int gcd = gcd(this.num, this.den);
		this.num /= gcd;
		this.den /= gcd;
	}
	
	//Gets the greatest common divisor
	//Parameter a - first number
	//Parameter b - second number
	//Returns - gcd
	public int gcd(int a, int b){
		if(b == 0)
           return a;
       	else
           return gcd(b, a%b);
	}
	
	//Stringifies Fraction
	//Returns - String representation of the Fraction
	public String toString(){
		return this.num + "/" + this.den;
	}
	
	//Stringifies Fraction using a format
	//Parameter n - spaces the number must embrace
	//Returns - String representation of the Fraction
	public String toString(int n){
		//this.simplify();
		String numStr = Integer.toString(this.num);
		String denStr = Integer.toString(this.den);
		int numSpaces = n-numStr.length();
		int denSpaces = n-denStr.length();
		numStr = "";
		denStr = "";
		for(int i = 0; i<numSpaces; i++)
			numStr += " ";
		for(int i = 0; i<denSpaces; i++)
			denStr += " ";
		numStr += Integer.toString(this.num);
		denStr += Integer.toString(this.den);
		return numStr + " / " + denStr;
	}
	
	@Override
	
	//Compares the actual Fraction to another
	//Parameter o - the other Fraction
	//Returns - 1 if the actual Fraction is bigger, -1 if is smaller and 0 if is the same
	public int compareTo(Fraction o){
		if(this.num * o.den > o.num * this.den)
			return 1;
		else 
			if(this.num * o.den == o.num * this.den)
				return 0;
			else
				return -1;
	}
}