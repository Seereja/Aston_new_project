package hw1_castomArrayList;

import java.util.Arrays;
import java.util.Comparator;


public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }


    public boolean add(int index, E element) {
        try {
            if (size == elements.length) {
                increaseCapacity();
            } else {
                elements[index] = element;
                size++;
                return true;
            }
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    public boolean addAll(MyArrayList<? extends E> collection) {
        ensureCapacity(size + collection.getSize());
        for (E elem : collection.elements) {
            add(elem);
        }
        return true;
    }

    public void add(E element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size] = element;
        size++;
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }


    public void clear() {
        final Object[] es = elements;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }


    public E get(int index) {
        return elements[index];
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void remove(int index) {
        try {
            E[] temp = elements;
            elements = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, elements, 0, index);
            int amountElemsAfterIndex = temp.length - index + 1;
            System.arraycopy(temp, index + 1, elements, index, amountElemsAfterIndex);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }


    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            removeAtIndex(index);
            return true;
        }
        return false;
    }

    private int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void removeAtIndex(int index) {
        int numToMove = size - index - 1;
        if (numToMove > 0) {
            System.arraycopy(elements, index + 1, elements, index, numToMove);
        }
        elements[--size] = null;
    }


    public void mergeSort(Comparator<E> comparator) {
        if (size < 2) {
            return;
        }

        int mid = size / 2;

        MyArrayList<E> left = new MyArrayList<>();
        MyArrayList<E> right = new MyArrayList<>();

        for (int i = 0; i < mid; i++) {
            left.add((E) elements[i]);
        }
        for (int i = mid; i < size; i++) {
            right.add((E) elements[i]);
        }

        left.mergeSort(comparator);
        right.mergeSort(comparator);

        merge(left, right, this, comparator);
    }

    private void merge(MyArrayList<E> left, MyArrayList<E> right, MyArrayList<E> a, Comparator<E> comparator) {
        int leftIndex = 0, rightIndex = 0, aIndex = 0;

        while (leftIndex < left.getSize() && rightIndex < right.getSize()) {
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
                a.set(aIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                a.set(aIndex, right.get(rightIndex));
                rightIndex++;
            }
            aIndex++;
        }

        while (leftIndex < left.getSize()) {
            a.set(aIndex, left.get(leftIndex));
            leftIndex++;
            aIndex++;
        }

        while (rightIndex < right.getSize()) {
            a.set(aIndex, right.get(rightIndex));
            rightIndex++;
            aIndex++;
        }
    }

    public int getSize() {
        return this.size;
    }

    public void set(int index, E e) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        elements[index] = e;
    }


}

