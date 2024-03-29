package DataStructures;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private int count = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
        this.count++;
    }

    public void remove(int index) {
        for (int i = index + 1; i < this.size; i++) {
            this.elements[i-1] = this.elements[i];
        }
        this.count--;
    }

    public int count() {
        return this.count;
    }

    private void ensureCapacity() {
        int newSize = (int)Math.round(elements.length * 1.5);
        elements = Arrays.copyOf(elements, newSize);
    }

    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
}