package pl.pollub.training.model.day4;

public interface IExtGeneric<T extends Number> {
    T execute(T value);
}
