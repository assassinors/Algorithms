package com.ustc.chapter1_3;

/**
 * @Author: AsmallCoder
 * @Description
 * @Date: Created in 22:45 2018/5/15 0015
 */

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;
    public FixedCapacityStack(int cap){
        a = (Item[]) new Object[cap];
    }
    public void push(Item item){
        if (N == a.length)
            resize(2*a.length);
        a[N++] = item;
    }
    public Item pop(){
        Item item = a[--N];
        a[N] = null; //解决对象游离问题
        if (N > 0 && N == a.length / 4)
            resize(a.length/2);
        return item;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }

    public void resize(int max){
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }
}