public class BigInteger
{
	private final static int MIN_DIG = 10;

	private int[] arrayInt;

	private boolean isNegative;


	public BigInteger ()
	{
		this.initArrayDigit(0);

		this.isNegative = false;
	}

	public BigInteger ( int size )
	{
		this.initArrayDigit(size);

		this.isNegative = false;
	}

	public BigInteger ( int size, long number )
	{
		String numberString = number + "";

		this.initArrayDigit(size);
		this.isNegative = number < 0;

		for ( int cpt = 0; cpt < numberString.length(); cpt ++ )
			this.arrayInt[cpt] = Integer.parseInt( numberString.charAt(cpt) + "" );

		if ( this.arrayInt.length > numberString.length() ) this.arrayInt[numberString.length()] = -1;
	}


	private void initArrayDigit ( int size )
	{
		if ( size < BigInteger.MIN_DIG )
			this.arrayInt = new int[BigInteger.MIN_DIG];
		else
			this.arrayInt = new int[size];
	}


	protected int returnNumber ()
	{
		String res = "";

		if ( this.isNegative ) res += "-";

		for ( int cpt = 0; cpt < this.arrayInt.length; cpt ++ )
		{
			if ( this.arrayInt[cpt] < 0 ) return Integer.parseInt(res);

			res += this.arrayInt[cpt] + "";
		}

		return Integer.parseInt(res);
	}


	public String toString () { return this.returnNumber() + ""; }


	public static void main (String[] a)
	{
		BigInteger test = new BigInteger(6, 256);

		System.out.println( test );
	}



}
