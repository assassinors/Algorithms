package com.ustc.chapter1_3;

/**
 * @Author: AsmallCoder
 * @Description
 * @Date: Created in 13:16 2018/5/17 0017
 */

public class Queue<Item> {
    private class Node{
        Item item;
        Node next;
    }
    private Node first;
    private Node last;
    private int N;

    private boolean isEmpty(){ return first == null;} //或者"first == null"
    private int size(){ return N; }

    //表尾插入元素
    public void enqueue(Item item){
        Node Oldlast = last;
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            Oldlast.next = last;
        N++;
    }

    //表头删除元素
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }

}
