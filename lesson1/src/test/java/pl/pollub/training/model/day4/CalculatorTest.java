package pl.pollub.training.model.day4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddWithOneArgument() throws OperationNotSupportedException {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(Calculator.Action.ADD);
        assertEquals(0, result);
    }

    @Test
    public void testAddWithMultipleArguments() {
        Calculator calculator = new Calculator();
        try {
            int result = calculator.calculate(Calculator.Action.ADD, 1, 2, 3, 4, 5, 6);
            System.out.println(result);
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testMultiplyingWithMultipleArguments() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate(Calculator.Action.MULTIPLY, 1, 2, 3);
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCatchCustomException() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate(Calculator.Action.DIVADE, 0);
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testWithDefaultMethodInInterface() {
        ICalculator calculator = new Calculator();
        String result = calculator.info();
        System.out.println(result);
    }
}