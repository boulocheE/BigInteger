public class BigInteger
{
	private final static int MIN_DIG = 10;

	private int[] arrayInt;

	private int     nbDigit;
	private boolean isNegative;


	public BigInteger ()
	{
		this.initArrayDigit(0);

		this.nbDigit    = 0;
		this.isNegative = false;
	}

	public BigInteger ( int size )
	{
		this.initArrayDigit(size);

		this.nbDigit    = 0;
		this.isNegative = false;
	}

	public BigInteger ( int size, long number )
	{
		this.initArrayDigit(size);
		this.isNegative = number < 0;

		this.nbDigit    = (number + "").length();
		this.fillArrayDigit(number + "");
	}

	public BigInteger ( int size, int number )
	{
		this.initArrayDigit(size);
		this.isNegative = number < 0; 

		this.nbDigit    = (number + "").length();
		this.fillArrayDigit(number + "");
	}



	private void initArrayDigit ( int size )
	{
		if ( size < BigInteger.MIN_DIG )
			this.arrayInt = new int[BigInteger.MIN_DIG];
		else
			this.arrayInt = new int[size];
	}

	private void fillArrayDigit ( String number )
	{
		for ( int cpt = 0; cpt < this.nbDigit; cpt ++ )
			this.arrayInt[cpt] = Integer.parseInt( number.charAt(cpt) + "" );
	}


	public String toString ()
	{
		String res = "";

		if ( this.isNegative ) res += "-";

		for ( int cpt = 0; cpt < this.nbDigit; cpt ++ )
			res += this.arrayInt[cpt] + "";

		return res;
	}


	public static void main (String[] a)
	{
		BigInteger test = new BigInteger(6, 256);

		System.out.println( test );
	}



}
