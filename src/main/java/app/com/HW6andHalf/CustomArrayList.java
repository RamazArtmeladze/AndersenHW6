package app.com.HW6andHalf;

import java.util.Arrays;

public class CustomArrayList {
    private int[] data;
    private int size;

    public CustomArrayList() {
        data = new int[10];
        size = 0;
    }

    public void put(int item) {
        if (size == data.length) {
            resize();
        }
        data[size++] = item;
    }

    public int get(int index) {
        if (index >= 0 && index < size) {
            return data[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[--size] = 0; // Optional: clear the last element
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    private void resize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.put(10);
        list.put(20);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        list.delete(0);
        System.out.println(list.get(0));
    }
}

