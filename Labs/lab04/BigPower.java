import java.math.*;
public class BigPower {
	static BigInteger zero = new BigInteger("0");
	static BigInteger one = new BigInteger("1");

	static BigInteger power (BigInteger A, BigInteger B) {
		if (B.equals(zero)) {
			return new BigInteger ("1");
		}
		return (A.multiply(power(A, B.subtract(one))));
	}
}