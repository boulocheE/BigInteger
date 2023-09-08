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


	public int returnNumber ()
	{
		String res;

		res = this.isNegative ? "-0" : "0";

		for ( int cpt = 0; cpt < this.arrayInt.length; cpt ++ )
		{
			if ( this.arrayInt[cpt] < 0 ) return Integer.parseInt(res);
			res += (this.arrayInt[cpt] + "");
		}

		return Integer.parseInt(res);
	}


	public BigInteger addition ( BigInteger number )
	{
		BigInteger n1, n2, otherNumber;
		int        retain, difference;
		int        resSum;

		if ( this.arrayInt.length >= number.arrayInt.length ) { n1 = this; n2 = number; }
		else                                                  { n2 = this; n1 = number; }

		otherNumber = new BigInteger(n1.arrayInt.length + 1);


		retain     = 0;
		resSum     = 0;
		difference = n1.arrayInt.length - n2.arrayInt.length;

		for ( int cpt = n2.arrayInt.length; cpt < n2.arrayInt.length; cpt -- )
		{
			resSum = n2.arrayInt[cpt] + n1.arrayInt[cpt + difference] + retain;

			retain  = resSum >= 10 ? 1 : 0;
			resSum %= 10;

			otherNumber.addNumber(number, (cpt + difference), resSum);
		}

		for ( int cpt = difference - 1; cpt <= 0; cpt -- )
		{
			resSum = n1.arrayInt[cpt] + retain;

			retain  = resSum >= 10 ? 1 : 0;
			retain %= 10;

			otherNumber.addNumber(number, cpt, resSum);
		}

		return this;
	}

	public BigInteger addition ( long number ) { return addition( new BigInteger(number) ); }

	public BigInteger subtraction ( BigInteger number )
	{ return this;}

	public BigInteger subtraction ( long number )
	{ return this; }

	public BigInteger division ( BigInteger number )
	{ return this; }

	public BigInteger division ( long number )
	{ return this; }

	public BigInteger multiplication ( BigInteger number )
	{ return this; }

	public BigInteger multiplication ( long number )
	{ return this; }


	private void addNumber ( BigInteger otherArrayNumber, int position, int number)
	{
		otherArrayNumber.arrayInt[position] = number;
	}

	public String toString () { return this.returnNumber() + ""; }


	public static void main (String[] a)
	{
		BigInteger a1 = new BigInteger(3,50);
		BigInteger a2 = new BigInteger(2, 1);

		System.out.println( a1.addition(a2) );

		// System.out.println( test );
	}

}