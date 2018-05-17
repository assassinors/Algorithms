package com.ustc.chapter1_3;

/**
 * @Author: AsmallCoder
 * @Description
 * @Date: Created in 13:08 2018/5/17 0017
 */

/**
 * 链表实现
 */
public class Stack<Item> {
    private class Node{
        Item item;
        Node next;
    }

    private Node first;
//    private Node last;
    private int N = 0;

    public boolean isEmpty(){ return first == null;}
    public int size(){ return N; }

    //向栈顶添加元素，头插法
    public void push(Item item){
        Node Oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = Oldfirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
}
