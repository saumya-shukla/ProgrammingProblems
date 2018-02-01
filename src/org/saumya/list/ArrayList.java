package org.saumya.list;

/**
 * This class implements the Array List
 *
 * @author Shukla, Saumya
 */
public class ArrayList<T> implements List<T> {

    private T[] array;
    private int noOfElements;
    private int maxCapacity;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.maxCapacity = 2;
        this.array = (T[]) new Object[maxCapacity];
        this.noOfElements = 0;
    }

    public ArrayList(T... elements) {
        this.maxCapacity = 2 * elements.length;
        this.noOfElements = elements.length;
        for (int i = 0; i < elements.length; i++) {
            array[i] = elements[i];
        }
    }

    @Override
    public boolean isEmpty() {
        return noOfElements == 0;
    }

    @Override
    public int size() {
        return noOfElements;
    }

    @Override
    public void insertFirst(T element) {
        if (noOfElements + 1 == maxCapacity) {
            resize(2 * maxCapacity);
        }

        for (int i = noOfElements - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }

        array[0] = element;
        noOfElements++;
    }

    @Override
    public void insertEnd(T element) {
        if (noOfElements + 1 == maxCapacity) {
            resize(2 * maxCapacity);
        }
        array[noOfElements] = element;
        noOfElements++;
    }

    @Override
    public void insertAtIndex(T element, int index) {
        if (noOfElements + 1 == maxCapacity) {
            resize(2 * maxCapacity);
        }

        for (int i = noOfElements - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        noOfElements++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        assert newSize >= noOfElements;
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < noOfElements; i++) {
            temp[i] = array[i];
        }
        array = temp;
        this.maxCapacity = newSize;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < noOfElements; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void delete(int index) {
        if (index > noOfElements) {
            throw new IllegalArgumentException("List size is " + size() + ", could not insert at index: " + index);
        }

        for (int i = index; i < noOfElements - 1; i++) {
            array[i] = array[i + 1];
        }
        noOfElements--;

        if (4 * noOfElements <= maxCapacity) {
            resize(maxCapacity / 2);
        }
    }

    @Override
    public void reverse() {
        T[] temp = (T[]) new Object[maxCapacity];
        for (int i = 0; i < noOfElements; i++) {
            temp[i] = array[noOfElements - 1 - i];

        }
        array = temp;

    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public int detectLoop() {
        return 0;
    }

    @Override
    public List<T> intersect(List<T> second) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < noOfElements; i++) {
            sb.append(array[i]);
            if (i != noOfElements - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<Integer>();
        System.out.println("Initial size: " + list.size());

        list.insertEnd(10);
        list.insertEnd(20);
        System.out.println("After inserting 10 and 20 at end: " + list.toString());

        list.insertFirst(5);
        list.insertFirst(9);
        System.out.println("After inserting 9 and 5 at beginning: " + list.toString());

        list.insertAtIndex(6, 1);
        System.out.println("After inserting 6 at index 1: " + list.toString());

        System.out.println("Index of 5 in list: " + list.indexOf(5));
        System.out.println("Index of 20 in list: " + list.indexOf(20));

        list.delete(1);
        System.out.println("After deleting element at index 1: " + list.toString());
        System.out.println("Size of list: " + list.size());

        list.reverse();
    }
}
