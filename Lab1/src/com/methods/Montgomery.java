package com.methods;
import java.math.BigInteger;


public class Montgomery {

    public static BigInteger montgomery(BigInteger a, BigInteger b, BigInteger n) {
        AdvancedEuclid advancedEuclidean = new AdvancedEuclid();
        BigInteger r = BigInteger.TWO.shiftLeft(n.bitLength());
        BigInteger[] euclid = advancedEuclidean.arrGCD(n, r);
        BigInteger t = a.multiply(b);
        BigInteger m = t.multiply(euclid[0].negate()).and(r.subtract(BigInteger.ONE));
        BigInteger u = t.add(m.multiply(n)).shiftRight(n.bitLength());
        if (u.compareTo(n) >= 0) return u.subtract(n);
        else return u;
    }

    public static BigInteger montgomeryMultiply(BigInteger a, BigInteger b, BigInteger n) {
        BigInteger a1 = a.shiftLeft(n.bitLength()).mod(n);
        BigInteger b1 = b.shiftLeft(n.bitLength()).mod(n);
        BigInteger u1 = montgomery(a1, b1, n);
        return montgomery(u1, BigInteger.ONE, n);
    }
    public static BigInteger montgomeryPow(BigInteger m, BigInteger e, BigInteger n) {
        BigInteger m1 = m.shiftLeft(n.bitLength()).mod(n);
        BigInteger x1 = BigInteger.ONE.shiftLeft(n.bitLength()).mod(n);
        for (int i = e.bitLength() - 1; i >= 0; i--) {
            x1 = montgomery(x1, x1, n); if (e.testBit(i)) x1 = montgomery(m1, x1, n);
        }
        return montgomery(x1, BigInteger.ONE, n);
    }

}