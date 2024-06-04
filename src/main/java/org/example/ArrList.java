package org.example;

import java.util.Arrays;

/**
 * An implementation of an ArrayList-like data structure.
 *
 * @param <E> is the type of elements in the list.
 */
public class ArrList<E> {
    private static final int CAPACITY = 10;
    E[] elements;
    private int size = 0;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ArrList() {
        elements = (E[]) new Object[CAPACITY];
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list.
     * @throws IllegalArgumentException if the specified initial capacity is negative.
     */
    public ArrList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elements = (E[]) new Object[initialCapacity];
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param element element to be added to this list.
     */
    public boolean add(E element) {
        checkCapacity(size + 1);
        elements[size++] = element;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index at which the specified element is to be inserted.
     * @param element element to be inserted.
     */
    public void add(int index, E element) {
        checkIndexForAdd(index);
        checkCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Adds all the elements in the specified array to this list.
     *
     * @param elements array containing elements to be added to this list.
     */
    public boolean addAll(E[] elements) {
        int numNew = elements.length;
        checkCapacity(size + numNew);
        System.arraycopy(elements, 0, this.elements, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed.
     * @return the element that was removed from the list.
     */
    public E remove(int index) {
        checkIndex(index);
        E oldValue = elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return oldValue;
    }

    /**
     * Removes all the elements from the list.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Returns the element at the specified position in the list.
     *
     * @param index index of the element to return.
     */
    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }

    /**
     * Returns the number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Ensures that this list has enough capacity to store the specified number of elements.
     *
     * @param minCapacity the desired minimum capacity.
     */
    private void checkCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * Checks if the given index is in range for getting an element. If not, throws an appropriate runtime exception.
     *
     * @param index the index to check.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Checks if the given index is in range for adding an element. If not, throws an appropriate runtime exception.
     *
     * @param index the index to check.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size).
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}