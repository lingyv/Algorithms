package org.lingyv.dataStructures;

/*
链表是线性表的一种。线性表是最基本、最简单、也是最常用的一种数据结构。线性表中数据元素之间的关系是一对一的关系，
即除了第一个和最后一个数据元素之外，其它数据元素都是首尾相接的。线性表有两种存储方式，一种是顺序存储结构，
另一种是链式存储结构。我们常用的数组就是一种典型的顺序存储结构。

相反，链式存储结构就是两个相邻的元素在内存中可能不是相邻的，每一个元素都有一个指针域，指针域一般是存储着到下一个元素的指针。
这种存储方式的优点是插入和删除的时间复杂度为 O(1)，不会浪费太多内存，添加元素的时候才会申请内存，删除元素会释放内存。
缺点是访问的时间复杂度最坏为 O(n)。

顺序表的特性是随机读取，也就是访问一个元素的时间复杂度是O(1)，链式表的特性是插入和删除的时间复杂度为O(1)。

链表就是链式存储的线性表。根据指针域的不同，链表分为单向链表、双向链表、循环链表等等。
 */
public class Node<T> {
    T value;
    //指向下一个节点
    Node next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    /**
     * 遍历链表
     * <p>
     * 思想:
     * 将循环的索引变量i初始化为链表的首节点,然后通过i.value访问节点的值,并将i设为i.next来访问链表的下一个节点,直到i为null为止
     *
     * @param head
     */
    public void Traversal(Node head) {
        for (Node i = head; i != null; i = i.next) {
            Object value = i.value;
        }
    }

    /**
     * 反转链表
     * 单向链表
     * <p>
     * 链表的基本形式是：1 -> 2 -> 3 -> null，反转需要变为 3 -> 2 -> 1 -> null。
     * 思想:
     * 每次取出待反转链表的首个节点,使其指向已反转链表的首节点,然后将取出的节点作为已反转链表的首节点。
     * 循环至待反转链表为空停止
     * <p>
     * 注意：
     * 访问某个节点 curt.next 时，要检验 curt 是否为 null。
     * 要把反转后的最后一个节点（即反转前的第一个节点）指向 null。
     *
     * @param head
     * @return
     */
    public Node reverse(Node head) {
        //prev用于存储已反转链表
        Node prev = null;
        //循环至待反转链表为空
        //head用于存储待反转链表
        while (head != null) {
            //保存取出首节点后的待反转链表
            Node next = head.next;
            //使待反转链表的首个节点指向已反转链表
            head.next = prev;
            //将取出的首节点设为已反转链表的首节点
            prev = head;
            //使用head保存待反转链表,进入下一轮循环
            head = next;
        }

        return prev;
    }


}
