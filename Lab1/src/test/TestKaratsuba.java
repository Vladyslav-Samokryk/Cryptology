package test;

import com.methods.Karatsuba;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestKaratsuba {
    @Test
    public void testKaratsuboMultiply() {
        Karatsuba karatsuba = new Karatsuba();
        BigInteger a = new BigInteger("12345784746468468464600000000008");
        BigInteger b = new BigInteger("12345844654464698779878880000005");
        BigInteger mult = karatsuba.multiply(a, b);
        BigInteger mult2 = a.multiply(b);
        boolean result = false;
        if (mult.compareTo(mult2) == 0) {
            result = true;
        }
        Assert.assertTrue(result);
    }
}
