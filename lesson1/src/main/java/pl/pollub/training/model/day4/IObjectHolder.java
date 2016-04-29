package pl.pollub.training.model.day4;

public interface IObjectHolder<E> {
    boolean add(E... elements);
    boolean remove(E element);
    int size();
    E sum(E...elements);
}
