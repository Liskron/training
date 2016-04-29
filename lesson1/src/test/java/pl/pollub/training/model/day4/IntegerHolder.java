package pl.pollub.training.model.day4;

public class IntegerHolder extends ObjectHolder<Integer> {
    @Override
    public Integer sum(Integer... elements) {
        Integer result = 0;
        for (Integer element : elements) {
            result += element;
        }
        return result;
    }
}
