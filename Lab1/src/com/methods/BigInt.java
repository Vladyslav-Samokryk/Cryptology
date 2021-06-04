package com.methods;

import java.math.BigInteger;

public class BigInt {

    public BigInteger bigInt(BigInteger base, BigInteger exponent, BigInteger modulus){

        System.out.println(base.modPow(exponent, modulus));
        if (modulus.compareTo(BigInteger.valueOf(1)) == 0) {
            return BigInteger.valueOf(0);
        }
        BigInteger result = BigInteger.valueOf(1);
        base = base.mod(modulus);
        while (exponent.compareTo(BigInteger.valueOf(0)) == 1) {
            if ((exponent.mod(BigInteger.valueOf(2))).compareTo(BigInteger.valueOf(1)) == 0) {
                result = (result.multiply(base)).mod(modulus);
            }
            exponent = exponent.shiftRight(1);
            base = (base.multiply(base)).mod(modulus);
        }

        return result;
    }
}


