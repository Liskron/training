package pl.pollub.training.model.day4;

import java.util.ArrayList;
import java.util.List;

public abstract class ObjectHolder<E> implements IObjectHolder<E> {

    private List<E> list = new ArrayList<>();

    @Override
    public boolean add(E... elements) {
        boolean result = true;
        for (E element : elements) {
            result &= list.add(element);
        }
        return result;
    }

    @Override
    public boolean remove(E element) {
        return list.remove(element);
    }

    @Override
    public int size() {
        return list.size();
    }
}
