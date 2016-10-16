package org.lingyv.sorting;

import static org.lingyv.sorting.Sorting.less;

/**
 * 归并排序
 * 归并-->将两个有序的数组归并成一个更大的有序数组
 */
public class Merge {
    // auxiliary array for merges
    //归并所需的辅助数组
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        // Allocate space just once.
        //一次性分配内存
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * 自顶向下的归并排序
     * 分治思想
     * 这段代码是归纳证明算法能够正确地将数组排序的基础:如果它能将两个子数组排序,它就能够通过归并两个子数组来将整个数组排序。
     *
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        // Sort a[lo..hi].
        //将数组a[lo..hi]排序
        if (hi <= lo) {
            return;
        }
        //将数组分为左右两半
        int mid = lo + (hi - lo) / 2;
        // Sort left half.
        //将数组左边排序
        sort(a, lo, mid);
        // Sort right half.
        //将数组右边排序
        sort(a, mid + 1, hi);
        // Merge results
        //如果a[mid]大于a[mid+1],归并结果
        if (less(a[mid + 1], a[mid])) {
            merge(a, lo, mid, hi);
        }
    }

    /**
     * 原地归并
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    protected static void merge(Comparable[] a, int lo, int mid, int hi) {
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;
        // Copy a[lo..hi] to aux[lo..hi].
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        // Merge back to a[lo..hi].
        for (int k = lo; k <= hi; k++)
            if (i > mid) {
                //left half exhausted (take from the right)
                //左半边元素用尽,取右半边元素,取值后,索引加1
                a[k] = aux[j++];
            } else if (j > hi) {
                //right half exhausted (take from the left)
                //右半边元素用尽,取左半边元素,取值后,索引加1
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                //current key on right less than current key on left (take from the right)
                //右半边当前元素小于左半边的当前元素,取右半边的当前元素,取值后,索引加1
                a[k] = aux[j++];
            } else {
                //current key on right greater than or equal to current key on left (take from the left).
                //右半边的当前元素大于左半边的当前元素,取左半边的当前元素,取值后,索引加1
                a[k] = aux[i++];
            }
    }

}
