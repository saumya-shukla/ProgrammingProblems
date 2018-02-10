package org.saumya.stack;


/**
 * This class implements the  Stack using Arrays
 *
 * @author Shukla, Saumya
 */

public class ArrayStack<T> implements IStack<T> {

    static int MAX = 10;
    int top;
    int n;
    private T[] a;

    public ArrayStack() {
        this.MAX = 2;
        this.a = (T[]) new Object[MAX];
        this.n = 0;
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return (top < 0);
    }

    private void resize(int newSize) {
        assert newSize >= n;
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
        this.MAX = newSize;
    }

    @Override
    public void push(T x) {
        if (top >= MAX) {
            System.out.println("Stack Overflow");

        } else {
            if (n + 1 == MAX) {
                resize(2 * MAX);
            }
            a[++top] = x;
            n++;

        }
    }

    @Override
    public T pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
        }
        T x = a[top--];
        return x;


    }

    @Override
    public T peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
        }

        return a[top];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < n; i++) {
            sb.append(a[i]);
            if (i != n - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        ArrayStack st = new ArrayStack();
        st.push(3);
        st.push(5);
        st.push(6);
        st.push(7);
        st.toString();
        System.out.println(" " + st.toString());
        System.out.println("Element at peek :" + st.peek());
        System.out.println("Element popped from stack :" + st.pop());

    }
}




