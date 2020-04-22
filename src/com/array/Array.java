package com.array;


//自己实现的数组类
public class Array<E> {

    private E[] data;
    private int size;

    //构造函数，传入数组的容量capacity
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //数组元素是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在数组的最后添加一个元素
    public void addLast(E e){
       add(size,e);
    }

    //向元素的指定位置插入元素
    public void add(int index,E e) {
        if (index == data.length)
            throw new IllegalArgumentException("addLast failed, Array is empty");
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed, please check your index range");

        if (size == data.length)
            resize(2 * data.length);
        for (int i = size - 1; i >= index;i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }



    //在数组的最前面插入一个新元素e
    public void addFirst(E e){
        add(0,e);
    }

    //获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get failed, please check your index range");
        return data[index];
    }

    //修改index索引位置的元素为e
    public void set(int index,E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("set failed, please check your index range");
        data[index] = e;
    }

    //查询数组中是否包含某个元素
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }
    //查找数组中元素e所在的索引，如果不存在元素 返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("remove failed, please check your index range");
        E ret = data[index];

        if (size == data.length / 2)
            resize(data.length / 2);
        for (int i = index + 1;i < size; i++)
            data[i - 1] = data[i];
        size--;
        return ret;
    }

    //从数组中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    //从数组中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0;i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
       res.append(String.format("Array: size = %d,capacity = %d\n",size,data.length));
       res.append("[");
       for(int i = 0;i < size; i++) {
           res.append(data[i]);
           if (i != size - 1)
               res.append(", ");
       }
       res.append("]");
       return res.toString();
    }
}
