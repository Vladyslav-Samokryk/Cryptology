package test;

import com.methods.AdvancedEuclid;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestAdvancedEuclidean {
    @Test
    public void testAdvancedEuclideanAlgorithm() {
        BigInteger x = new BigInteger("17");
        BigInteger y = new BigInteger("19");

        AdvancedEuclid advancedEuclid = new AdvancedEuclid();
        BigInteger GCD1 = advancedEuclid.gcd(x,y);

        BigInteger GCD2 = x.gcd(y);
        boolean result = false;

        if (GCD1.compareTo(GCD2) == 0) {
            result = true;
        }
        Assert.assertTrue(result);
    }
}
