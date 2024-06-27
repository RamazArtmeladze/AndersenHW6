package app.com.HW6andHalf;

import java.util.LinkedList;
import java.util.Iterator;

public class CustomHashSet<T> implements Iterable<T> {
    private LinkedList<T>[] data;
    private int size;


    public CustomHashSet() {
        this.data = new LinkedList[20];
        this.size = 0;
    }

    private int getDataIndex(T element) {
        return element.hashCode() & (data.length - 1);
    }

    public int size() {
        return size;
    }

    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }
        int dataIndex = getDataIndex(element);
        if (data[dataIndex] == null) {
            data[dataIndex] = new LinkedList<>();
        }
        data[dataIndex].add(element);
        size++;
        return true;
    }

    public boolean contains(T element) {
        int dataIndex = getDataIndex(element);
        LinkedList<T> dataList = data[dataIndex];
        if (dataList == null) {
            return false;
        }
        return dataList.contains(element);
    }

    public boolean remove(T element) {
        int dataIndex = getDataIndex(element);
        LinkedList<T> dataList = data[dataIndex];
        if (dataList == null || !dataList.remove(element)) {
            return false;
        }
        size--;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomHashSetIterator();
    }

    private class CustomHashSetIterator implements Iterator<T> {
        private int currentDataIndex;
        private Iterator<T> dataIterator;

        public CustomHashSetIterator() {
            currentDataIndex = 0;
            dataIterator = null;
            moveToNextData();
        }

        private void moveToNextData() {
            while (currentDataIndex < data.length &&
                    (data[currentDataIndex] == null ||
                            !data[currentDataIndex].iterator().hasNext())) {
                currentDataIndex++;
            }
            if (currentDataIndex < data.length) {
                dataIterator = data[currentDataIndex].iterator();
            }
        }

        @Override
        public boolean hasNext() {
            if (dataIterator == null) {
                return false;
            }
            if (!dataIterator.hasNext()) {
                currentDataIndex++;
                moveToNextData();
            }
            return dataIterator != null && dataIterator.hasNext();
        }

        @Override
        public T next() {
            return dataIterator.next();
        }
    }

    public static void main(String[] args) {
        CustomHashSet<String> set = new CustomHashSet<>();
        set.add("Hello");
        set.add("World");
        set.add("Hello");
        set.add("Andersen");
        set.add("Andersen");
        System.out.println(set.size());
        System.out.println(set.contains("Hello"));
        System.out.println(set.contains("Java"));
        set.remove("Hello");
        System.out.println(set.contains("Hello"));

        for (String s : set) {
            System.out.println(s);
        }
    }
}