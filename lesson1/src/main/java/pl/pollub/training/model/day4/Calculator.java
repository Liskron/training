package pl.pollub.training.model.day4;

public class Calculator implements ICalculator, IDivadable {

    @Override
    public int calculate(Action action, int... numbers) throws OperationNotSupportedException {
        switch (action) {
            case ADD: {
                int result = 0;
                for (int number : numbers) {
                    result += number;
                }
                return result;
            }
            case MULTIPLY: {
                int result = 1;
                for (int number : numbers) {
                    result *= number;
                }
                return result;
            }
            default:
                throw new OperationNotSupportedException(String.format("Operation not supported: %s", action));
        }
    }

    @Override
    public String info() {
        return "Calculator v2.0";
    }

    enum Action {
        ADD, MULTIPLY, DIVADE;
    }
}
