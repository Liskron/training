package pl.pollub.training.model.day1.home;

/**
 * Created by Wlad on 25.04.2016.
 */
public class ElementList<E> {
    public ElementList<E> next = null;
    public E data;

    public ElementList(E data){
        this.data = data;
    }
}
