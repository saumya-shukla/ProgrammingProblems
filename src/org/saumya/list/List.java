package org.saumya.list;

/**
 * This interface defines the common methods of a List
 *
 * @author Shukla, Saumya
 */
public interface List<T> {

    boolean isEmpty();

    int size();

    void insertFirst(T element);

    void insertEnd(T element);

    void insertAtIndex(T element, int index);

    int indexOf(T element);

    void delete(int index);

    void reverse();

    T get(int index);

    int detectLoop();

    List<T> intersect(List<T> second);
}
