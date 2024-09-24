class Rational {
	
	private int numerator;
	private int denominator;
	
	Rational () {}
	
	Rational (int numerator, int denominator) throws UndefinedRational {
		this.numerator = numerator;
		if ( denominator != 0 ) {
			this.denominator = denominator;
		}else {
			throw new UndefinedRational("Failed to created from constructor: Denominator can not be 0");
		}
	}
	
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	
	public void setDenominator(int denominator) throws UndefinedRational {
		if ( denominator != 0 ) {
			this.denominator = denominator;
		}else {
			throw new UndefinedRational("Failed to set from set method: Denominator can not be 0.");
		}
	}
	
	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	public static Rational add (Rational r1, Rational r2) {
		Rational result = new Rational();
		int numerator = r1.getNumerator() * r2.getDenominator() + r1.getDenominator() * r2.getNumerator();
		int denominator = r1.getDenominator() * r2.getDenominator();
		try {
			result.setNumerator(numerator);
			result.setDenominator(denominator);
		}catch(UndefinedRational err) {
			System.out.println(err.getMessage());
		}
		return result;
	}
	
	private static int gcd(int a, int b) {
		for(int i = Math.min(a, b); i > 0; i--){
		if(a % i == 0 && b % i == 0) return i;
		}
		return 1;
	}
	
	public static Rational reduce (int numerator , int denominator) {
		int gcd = gcd(numerator, denominator);
		Rational result = new Rational();
		
		
		return result;
		
	}
	
	@Override
	public String toString() {
		return this.numerator + (this.denominator == 1 ? "" : "/" + this.denominator);
	}
	
	@Override
    public boolean equals(Object object){
        if ( (object == null) || !(object instanceof Rational)) return false;
        Rational r = (Rational) object;

        return this.numerator * this.denominator == r.numerator * r.denominator;
    }
	
	
	public static void main (String args[]) {
		
		try {
			Rational r = new Rational(3,2);
			Rational r1 = new Rational(4,1);
			
			System.out.println("r = " + r.toString());
			System.out.println("r1 = " + r1.toString());
			System.out.println("r is equal to r1 : " + r.equals(r1));
			
			Rational r4 = add(r, r1);
			System.out.println("r4 = " + r4.toString());
			
		}catch (UndefinedRational err) {
			System.out.println(err.getMessage());
		}
		
		Rational r3 = new Rational();
		try {
			r3.setNumerator(5);
			r3.setDenominator(0);
			System.out.println("r3 = " + r3.toString());
		}catch (UndefinedRational err) {
			System.out.println(err.getMessage());
		}
		
		
		
			
	}
}