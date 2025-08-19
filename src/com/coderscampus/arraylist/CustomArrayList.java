package com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
    Object[] items = new Object[10];
    int size = 0;

    @Override
    public boolean add(T item) {
        if (size == items.length) {
            resizeArray();
        }
        items[size] = item;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw (new IndexOutOfBoundsException("Index " + index + " is invalid."));
        } else {
            if (items.length == size) {
                resizeArray();
            }
            Object[] temp = new Object[items.length];
            int added = 0;
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    temp[i] = item;
                    added = 1;
                }
                temp[i + added] = items[i];
            }
            if (added == 0) {
                temp[size] = item;
            }
                items = temp;
            size++;
        }
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Oops! The index " + index + " is out of bounds.");
        } else {
            return (T) items[index];
        }
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        T removedItem = null;
        if (index < 0 || index >= size) {
            throw (new IndexOutOfBoundsException("Index " + index + " is invalid."));
        } else {
            Object[] temp = new Object[items.length];
            int removed = 0;
            for (int i = 0; i < size; i++) {
                if (index != i) {
                    temp[i - removed] = items[i];
                } else {
                    removed = 1;
                    removedItem = (T) items[i];
                }
            }
            items = temp;
            size--;

        }
        return removedItem;
    }

    private void resizeArray() {
        Object[] tempArray = new Object[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            tempArray[i] = items[i];
        }
        items = tempArray;
    }

}
