package test;

import com.methods.BigInt;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestBigInt {
    @Test
    public void testBigInt() {
        BigInt qw = new BigInt();

        BigInteger base = new BigInteger("123");
        BigInteger exponent = new BigInteger("875");
        BigInteger modulus = new BigInteger("123");

        BigInteger result1 = qw.bigInt(base, exponent, modulus);
        BigInteger result2 = base.modPow(exponent, modulus);

        boolean result = false;
        if (result1.compareTo(result2) == 0) {
            result = true;
        }
        Assert.assertTrue(result);
    }

}
