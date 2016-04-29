package pl.pollub.training.model.day4;

public class StringHolder extends ObjectHolder<String> {
    @Override
    public String sum(String... elements) {
        StringBuilder builder = new StringBuilder(elements.length);
        for (String element : elements) {
            builder.append(element);
        }
        return builder.toString();
    }
}
