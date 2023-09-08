public class BigInteger
{
	private final static int MIN_DIG = 10;

	private int[]   arrayInt;
	private boolean isNegative;


	public BigInteger ()
	{
		this.initArrayDigit(0);
		this.isNegative = false;
	}


	public BigInteger ( int size, long number )
	{
		this.initArrayDigit(size);
		this.initializeNumberArray(number);
	}


	public BigInteger ( long number )
	{
		this.initArrayDigit((number + "").length());
		this.initializeNumberArray(number);
	}


	private void initArrayDigit ( int size )
	{
		if ( size < BigInteger.MIN_DIG )
			this.arrayInt = new int[BigInteger.MIN_DIG];
		else
			this.arrayInt = new int[size];
	}


	public boolean updateNumber ( int number ) { return this.initializeNumberArray(number); }


	private boolean initializeNumberArray ( long number )
	{
		String numberString = number + "";

		this.isNegative = number < 0;

		if ( numberString.length() > this.arrayInt.length ) return false;

		for ( int cpt = 0; cpt < numberString.length(); cpt ++ )
			this.arrayInt[cpt] = Integer.parseInt( numberString.charAt(cpt) + "" );

		if ( this.arrayInt.length > numberString.length() ) this.arrayInt[numberString.length()] = -1;

		return true;
	}


	private String returnNumber ()
	{
		String res;

		res = this.isNegative ? "-0" : "0";

		for ( int cpt = 0; cpt < this.arrayInt.length; cpt ++ )
		{
			if ( this.arrayInt[cpt] < 0 ) return res;
			res += (this.arrayInt[cpt] + "");
		}

		return res;
	}


	public BigInteger addition ( BigInteger number )
	{
		int[] numArray1, numArray2;

		String num1, num2;
		int    sizeNumber;


		num1 = this  .returnNumber();
		num2 = number.returnNumber();

		sizeNumber = num1.length() >= num2.length() ? num1.length() : num2.length();

		numArray1 = new int[sizeNumber];
		numArray2 = new int[sizeNumber];

		for ( int cpt = sizeNumber - 1; cpt >= 0; cpt -- )
		{
			numArray1[cpt] = 
		}

		return ;
	}


	public String toString () { return this.returnNumber() + ""; }


	public static void main (String[] a)
	{
		BigInteger a1 = new BigInteger(2,50);
		BigInteger a2 = new BigInteger(2, 10);

		System.out.println( a1.addition(a2) );

		// System.out.println( test );
	}

}