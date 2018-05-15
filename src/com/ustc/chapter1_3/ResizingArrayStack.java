package com.ustc.chapter1_3;

import java.util.Iterator;

/**
 * @Author: AsmallCoder
 * @Description
 * @Date: Created in 23:11 2018/5/15 0015
 */

public class ResizingArrayStack<Item> implements Iterable{
    private Item[] a =(Item[])new Object[1];
    private int N = 0;
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    private void resize(int max){
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }
    public void push(Item item){
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if(N > 0 && N < a.length / 4)
            resize(a.length / 2);
        return item;
    }

    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }
        @Override
        public Item next() {
            return a[--i];
        }
        @Override
        public void remove() {
        }
    }
}

