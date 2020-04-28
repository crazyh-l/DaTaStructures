package com.linkedlist;

public class LinkedList<E> {


    //private Node head;

    private Node dummyHead;

    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }



    //在链表的index位置添加新的元素
    public void add(int index,E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed,please check your index");

        //这步特殊的判断可以使用虚拟头节点进行优化
        /*if (index == 0)
            addFirst(e);
        else {
            Node prev = head;
            for (int i = 0; i < index - 1 ; i++) {
                prev = prev.next;
            }
            *//*Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;*//*
            prev.next = new Node(e,prev.next);
            size++;
        }*/

        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
        /*Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;*/
        prev.next = new Node(e,prev.next);
        size++;



    }

    //在链表中添加元素
    public void addFirst(E e) {
        /*head =  new Node(e,head);
        size++;*/
        add(0,e);
    }

    //在链表的末尾添加新的元素
    public void addLast(E e) {
        add(size,e);
    }

    //获得链表中的第index个位置的元素
    //在链表中不是一个常用的操作，练习
    public E get(int index) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed,please check your index");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast() {
        return get(size);
    }

    //修改链表中第index个位置的元素
    //练习用
    public void set(int index,E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed,please check your index");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }


    public E remove(int index) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed,please check your index");

        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    //删除链表中的第一个元素，返回删除的元素
    public E removeFirst() {
       return remove(0);
    }

    //删除链表的最后一个元素,返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        /*Node cur = dummyHead.next;

        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null");*/

       for (Node cur = dummyHead.next;cur != null;cur = cur.next) {
           res.append(cur + "->");
       }
        return res.toString();
    }

    private class Node {
        public E e;

        public Node next;

        public Node(E e,Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
           this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
