package study.ss.book.algs4.practice1_3;

import study.ss.book.algs4.Practice;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

@Practice("1.3.34")
public class RandomBag<T> implements Iterable<T>{

    Item<T>[] arr = new Item[10];

    int size;

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public void add(Item t) {
        if (size <= arr.length - 1) {
            arr[size] = t;
        }else{
            Item[] items = new Item[arr.length * 2];
            System.arraycopy(arr, 0, items, 0, size);
            this.arr = items;
            arr[size] = t;
        }
        size ++;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomBagIterator();
    }

    class  RandomBagIterator implements Iterator{

        int i;

        public RandomBagIterator() {
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                int i1 = random.nextInt(size);
                Item r = arr[i];
                arr[i] = arr[i1];
                arr[i1] = r;
            }
        }


        @Override
        public boolean hasNext() {
            return i != size;
        }

        @Override
        public Object next() {
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object r =  arr[i];
            i++;
            return r;
        }

        @Override
        public void remove() {

        }
    }


    static class Item<T>{
        T v;

        public Item(T v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {
        RandomBag<Item> integers = new RandomBag<Item>();

        for (int i = 0; i < 20; i++) {
            integers.add(new Item(i));

        }


        for (Item item : integers) {
            System.out.println(item.v);
        }
    }



}
