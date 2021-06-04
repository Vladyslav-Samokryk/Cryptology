package com.methods;

import java.math.BigInteger;
import java.util.Random;

public class FermaTest {

    public boolean ferma(BigInteger p, int n){
        Random rand = new Random();
        BigInteger x;
        BigInteger result;

        if (p.compareTo(BigInteger.valueOf(2)) == 0) {
            return true;
        }
        if (p.compareTo(BigInteger.valueOf(2)) == -1 || p.mod(BigInteger.valueOf(2)) == BigInteger.valueOf(0)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            do {
                x = (((BigInteger.valueOf(rand.nextLong() * rand.nextLong())).mod(p)).abs()).add(BigInteger.valueOf(1));
            } while (!(p.compareTo(x) == 0));

            result = x.modPow(p.subtract(BigInteger.valueOf(1)), p);

            if (result.compareTo(BigInteger.valueOf(1)) == 0) return false; //точно складене
        }
        return true;
    }

}
