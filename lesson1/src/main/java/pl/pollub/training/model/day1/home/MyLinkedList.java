package pl.pollub.training.model.day1.home;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class MyLinkedList<E> implements List<E> {

    private ElementList<E> vertex;

    public int size() {
        int result = 0;
        ElementList element = vertex;
        if (vertex == null){
            return result;
        } else {
            result++;
            while(true){
                if(element.next != null) {
                    element = element.next;
                    result++;
                }else{
                    break;
                }
            }

        }

        return result;
    }

    public boolean isEmpty() {
        return this.size() == 0 ;
    }

    public boolean contains(Object o) {
        ElementList element = vertex;
        while (true){
            if(element.data.equals(o)){
                return true;
            }else{
                if(element.next != null){
                    element = element.next;
                }else{
                    break;
                }
            }
        }

        return false;
    }


    public E get(int index) {
        if(this.isEmpty() || this.size() < index){
            return null;
        }
        ElementList<E> element = vertex;

        for (int i = 0; i < index; i++) {
            element = element.next;
        }

        return element.data;
    }

    public E remove(int index) {




        return null;
    }




    public boolean add(E e) {
        ElementList element = this.vertex;
        if(this.vertex == null){
            this.vertex = new ElementList<E>(e);
        } else {
            while(true){
                if(element.next != null){
                    element = element.next;
                }else{
                    element.next = new ElementList<E>(e);
                    break;
                }
            }
        }
        return true;
    }

    public boolean remove(Object o) {
        if(this.isEmpty()){
            return false;
        }

        ElementList element = vertex;
        ElementList<E> elementNext = this.size() > 1 ? vertex.next : null;

        if(vertex.equals(o)){
            vertex = elementNext;
            return true;
        }

        while (true){
            if(elementNext.data.equals(o)){
                element.next = elementNext.next;
                elementNext = elementNext.next;
            }else{
                if(elementNext.next !=null){
                    element = elementNext;
                    elementNext = elementNext.next;
                }else {
                    break;
                }
            }
        }

        return false;
    }

    public void clear() {
        this.vertex = null;
    }

    public E set(int index, E element) {
        ElementList elementList = vertex;
        if(index > this.size())
            return null;
        for (int i = 0; i < index; i++) {
            elementList = elementList.next;
        }

        elementList.data = element;

        return element;
    }

    public void add(int index, E element) {

    }


    public Iterator<E> iterator() {
        return null;
    }

    public boolean containsAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    public boolean addAll(Collection<? extends E> c) {
        throw new NotImplementedException();
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        throw new NotImplementedException();
    }


    public boolean removeAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    public boolean retainAll(Collection<?> c) {
        throw new NotImplementedException();
    }


    public int indexOf(Object o) {
        throw new NotImplementedException();
    }

    public int lastIndexOf(Object o) {
        throw new NotImplementedException();
    }

    public Object[] toArray() {
        throw new NotImplementedException();
    }

    public <T> T[] toArray(T[] a) {
        throw new NotImplementedException();
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
