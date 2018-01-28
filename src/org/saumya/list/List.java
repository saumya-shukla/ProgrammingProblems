package org.saumya.list;

/**
 * This interface defines the common methods of a List
 *
 * @author Shukla, Saumya
 */
public interface List {

    boolean isEmpty();

    int size();

    void insertFirst(int element);

    void insertEnd(int element);

    void insertAtIndex(int element, int index);

    int indexOf(int element);

    void delete(int index);
}
