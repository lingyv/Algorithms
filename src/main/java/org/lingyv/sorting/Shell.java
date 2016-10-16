package org.lingyv.sorting;

import static org.lingyv.sorting.Sorting.exch;
import static org.lingyv.sorting.Sorting.less;

/**
 * 希尔排序
 * 思想:
 * --> 改进版的插入排序,交换不相邻的元素以对数组的局部进行排序,并最终使用插入排序将局部有序的数组排序。
 * --> 使数组中任意间隔为h的元素都是有序的,这样的数组成为h有序数组,在进行排序时,如果h很大,我们就能将元素移动到很远的位置上,
 * 为实现更小的h有序创造方便。
 */
public class Shell {
    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        //将a[]按升序排列
        int N = a.length;
        int h = 1;
        //调整h的大小
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1) {
            // h-sort the array.
            //将数组变成h有序数组
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                //将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            //调整h大小
            h = h / 3;
        }
    }
}

