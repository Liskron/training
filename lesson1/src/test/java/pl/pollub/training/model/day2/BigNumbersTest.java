package pl.pollub.training.model.day2;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumbersTest {

    private BigNumbers numbers = new BigNumbers();

    @Test
    public void add() throws Exception {
        BigInteger a = new BigInteger("555555555555555555555555555555555555555555555555555");
        BigInteger b = new BigInteger("9999999999999999999999999999999999999999999999");
        BigInteger result = numbers.add(a, b);
        System.out.println(result);
    }

    @Test
    public void multiply() throws Exception {
        BigDecimal a = new BigDecimal("55555555555.5555555555555555555555555555555555555555");
        BigDecimal b = new BigDecimal("999999999999999999999.9999999999999999999999999");
        BigDecimal result = numbers.multiply(a, b);
        System.out.println(result);
    }
}
