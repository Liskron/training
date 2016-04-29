package pl.pollub.training.model.day4;

public interface ICalculator {
    int calculate(Calculator.Action action, int... numbers) throws OperationNotSupportedException;

    default String info() {
        return "Calculator v1.0";
    }
}
