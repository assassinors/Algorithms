package com.ustc.chapter1_3;

import java.util.Iterator;

/**
 * @Author: AsmallCoder
 * @Description
 * @Date: Created in 13:28 2018/5/17 0017
 */

public class Bag<Item> implements Iterable {
    private Node first;
    private int N;
    private class Node{
        Node next;
        Item item;
    }
    public void add(Item item){
        Node Oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = Oldfirst;
        N++;
    }

    @Override
    public Iterator iterator() {
        return new BagIterator();
    }
    private class BagIterator implements Iterator{

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
