package org.lingyv.sorting;

/**
 * 选择排序:
 * -->  首先,找到数组中最小的元素,然后把它和数组的第一个元素交换,
 *      然后,找到剩余元素的最小元素,把它与数组的第二个元素交换,
 *      循环下去,直到将整个数组排序。
 */
public class Selection {

    //将数组按升序排列
    public static void sort(Comparable[] a) {
        int N = a.length;  //数组长度
        for (int i = 0; i < N; i++) {
            //将a[i]和a[i+1...N]中的元素交换
            int min = i;    //最小元素索引
            for (int j = i + 1; j < N; j++) {
                if (Sorting.less(a[j], a[min])) {
                    min = j;
                }
                Sorting.exch(a, i, min);  //将a[i]和a[min]交换
                min = i;
            }
        }
    }
}
