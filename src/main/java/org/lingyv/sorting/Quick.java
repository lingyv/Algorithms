package org.lingyv.sorting;

import static org.lingyv.sorting.Sorting.exch;
import static org.lingyv.sorting.Sorting.less;

/**
 * 快速排序
 * 一种分治的排序算法,将一个数组分成两个子数组,将两部分独立排序。
 * 快速排序和归并排序是互补的
 */
public class Quick {
    public static void sort(Comparable[] a) {
        //StdRandom.shuffle(a);          // Eliminate dependence on input.消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);  // Partition. 切分
        sort(a, lo, j - 1);              // Sort left part a[lo .. j-1].
        sort(a, j + 1, hi);              // Sort right part a[j+1 .. hi].
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi + 1;            // left and right scan indices
        Comparable v = a[lo];            // partitioning item
        while (true) {
            // Scan right, scan left, check for scan complete, and exchange.
            //找到左边大于v的元素
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            //找到右侧小于v的元素
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            //交换a[i]、a[j]
            exch(a, i, j);
        }
        //i、j相遇,交换a[lo]、a[j]
        exch(a, lo, j);
        return j;
    }
}