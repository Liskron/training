package pl.pollub.training.model.day4;

public class ExtGeneric implements IExtGeneric<Float> {
    @Override
    public Float execute(Float value) {
        return value;
    }

    public static <T> T call(Object object, Class<? extends T> clazz) {
        return (T) object;
    }
}
