package org.lingyv.sorting;

import static org.lingyv.sorting.Sorting.exch;
import static org.lingyv.sorting.Sorting.less;

/**
 *插入排序
 * 思想:
 * --> 元素选择位置
 *     从i=1开始,比较a[i]与a[i-1]、a[i-2]...的大小,依次将a[i]与比它大的a[?]调换位置,直到a[i]大于a[?-1]为止。此时,i左边的位置都是有序的。
 *
 *瓶颈:
 * 对于大规模乱序数组,插入排序速度很慢,因为它只会交换相邻的元素,因此元素只能一点点的从一端移动道另一端。
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        //将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // Insert a[i] among a[i-1], a[i-2], a[i-3]... ...
            //将a[i]插入到a[i-1], a[i-2], a[i-3]... ...中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }
}
