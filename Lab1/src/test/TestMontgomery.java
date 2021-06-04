package test;

import com.methods.Montgomery;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class TestMontgomery {
    @Test
    public void montgomeryMultiplyTest() {
        Montgomery montgomery = new Montgomery();

        BigInteger a, b, n;

        a = BigInteger.valueOf(123L);
        b = BigInteger.valueOf(567L);
        n = BigInteger.valueOf(43L);
        assertEquals(a.multiply(b).mod(n), montgomery.montgomeryMultiply(a,b,n));


    }

    @Test
    public void montgomeryPowTest() {
        Montgomery montgomery = new Montgomery();
        BigInteger a, b, n;

        a = BigInteger.valueOf(12L);
        b = BigInteger.valueOf(5L);
        n = BigInteger.valueOf(43L);

        assertEquals(a.modPow(b, n), montgomery.montgomeryPow(a,b,n));

    }
}
