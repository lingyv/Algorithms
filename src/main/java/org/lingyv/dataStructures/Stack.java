package org.lingyv.dataStructures;

/**
 * 栈
 * 栈由高位向低位扩展
 * 使用链表实现
 */
public class Stack<T> {
    //栈顶
    private Node frist;
    //元素数量
    private int N;

    private class Node {
        T item;
        Node next;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public Boolean isEmpty() {
        return frist == null;       //or N==0;
    }

    /**
     * 查询栈内元素数量
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 入栈
     *
     * @param item
     */
    public void push(T item) {
        Node oldFrist = frist;
        frist = new Node();
        frist.item = item;
        frist.next = oldFrist;
        N++;
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        T item = frist.item;
        frist = frist.next;
        N--;
        return item;
    }

}
