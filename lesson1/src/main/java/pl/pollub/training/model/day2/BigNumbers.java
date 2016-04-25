package pl.pollub.training.model.day2;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumbers {
    public BigInteger add(BigInteger a, BigInteger b) {
        return a.modInverse(b);
    }

    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        int x = 5 % 2;
        return a.multiply(b);
    }
}
