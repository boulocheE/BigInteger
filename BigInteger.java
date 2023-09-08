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

		res = this.isNegative ? "-" : "";

		for ( int cpt = 0; cpt < this.arrayInt.length; cpt ++ )
		{
			if ( this.arrayInt[cpt] < 0 ) return res;
			res += (this.arrayInt[cpt] + "");
		}

		return res;
	}


	public BigInteger addition ( BigInteger number )
	{
		int[] numArray1, numArray2, numResArray;

		String num1,     num2;
		int    sizeNumber;


		num1 = this  .returnNumber();
		num2 = number.returnNumber();

		sizeNumber = num1.length() >= num2.length() ? num1.length() : num2.length();

		numArray1   = new int[sizeNumber    ];
		numArray2   = new int[sizeNumber    ];
		numResArray = new int[sizeNumber + 1];

		for ( int cpt = num1.length(); cpt < sizeNumber; cpt ++ )
			num1 = "0" + num1;

		for ( int cpt = num2.length(); cpt < sizeNumber; cpt ++ )
			num2 = "0" + num2;

		for ( int cpt = 0; cpt < sizeNumber; cpt ++ )
		{
			numArray1  [cpt] = Integer.parseInt( num1.charAt(cpt) + "" );
			numArray2  [cpt] = Integer.parseInt( num2.charAt(cpt) + "" );
			numResArray[cpt] = 0;
		}

		numResArray[0] = 0;

		for ( int cpt = 0; cpt < sizeNumber; cpt ++ )
			numResArray[cpt] = numArray1[cpt] + numArray2[cpt];

		this.retainAddition(numResArray);

		String res = "";
		for ( int cpt = 0; cpt < numArray1.length; cpt ++ ) res += numResArray[cpt] + "";
		System.out.println( res + " " );

		return this;
	}

	private int[] retainAddition ( int[] array )
	{
		int   retain;

		retain = 0;

		// System.out.println( array.length );

		for ( int cpt = array.length - 1; cpt >= 0; cpt -- )
		{
			System.out.println( "cpt : " + cpt + " " + array[cpt] );
			array[cpt] += retain;

			retain = 0;

			if ( array[cpt] >= 10 ) { retain = 1; array[cpt] -= 10; }
		}

		array[0] = retain;

		return array;
	}


	public String toString () { return this.returnNumber() + ""; }


	public static void main (String[] a)
	{
		BigInteger a1 = new BigInteger(2,57);
		BigInteger a2 = new BigInteger(2, 50);

		a1.addition(a2);

		// System.out.println( test );
	}

}