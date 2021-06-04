package com.methods;

import java.math.BigInteger;

public class AdvancedEuclid {

    public BigInteger gcd(BigInteger x, BigInteger y) {

        if (x.compareTo(y) == -1) {
            swapXY(x, y);
        }
        double len = Math.log(x.doubleValue()) * (Math.log(x.doubleValue() - Math.log(x.doubleValue()) + 1));

        BigInteger[] r = new BigInteger[(int)len + 3];
        BigInteger[] q = new BigInteger[(int)len + 3];

        r[0] = x;
        r[1] = y;
        r[2] = r[0].mod(r[1]);
        q[0] = x.subtract(r[2]).divide(y);

        int n = 0;

        while (r[n + 2].compareTo(BigInteger.valueOf(0)) != 0) {
            n++;
            r[n + 2] = r[n].mod(r[n + 1]);
            q[n] = r[n].subtract(r[n + 2]).divide(r[n + 1]);

        }

        BigInteger[] u = new BigInteger[n + 3];
        BigInteger[] v = new BigInteger[n + 3];

        u[0] = BigInteger.valueOf(1);
        u[1] = BigInteger.valueOf(0);
        v[0] = BigInteger.valueOf(0);
        v[1] = BigInteger.valueOf(1);

        for (int i = 0; i < n; i++) {

            u[i + 2] = u[i].subtract(q[i].multiply(u[i + 1]));
            v[i + 2] = v[i].subtract(q[i].multiply(v[i + 1]));

        }

        BigInteger result = u[n + 1].multiply(x).add(v[n + 1].multiply(y));
        return result;
    }

    public static BigInteger[] arrGCD(BigInteger x, BigInteger y) {

        if (x.equals(BigInteger.ZERO)) {

            return new BigInteger[] { BigInteger.ZERO, BigInteger.ONE, y };
        }

        BigInteger[] gcdRes = arrGCD(y.mod(x), x);

        return new BigInteger[]{
                gcdRes[1].subtract(y.divide(x).multiply(gcdRes[0])),
                gcdRes[0], gcdRes[2]
        };
    }
    private void swapXY(BigInteger x, BigInteger y) {
        BigInteger n = x;
        x = y;
        y = n;
    }
}

