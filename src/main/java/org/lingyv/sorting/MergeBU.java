package org.lingyv.sorting;

import static org.lingyv.sorting.Sorting.less;

/**
 * 自底向上归并
 */
public class MergeBU {
    // auxiliary array for merges
    private static Comparable[] aux;

    /**
     * 自底向上对并
     * 多次遍历整个数组,根据子数组大小进行两两归并
     * @param a
     */
    public static void sort(Comparable[] a) {
        // Do lg N passes of pairwise merges.
        //进行lg N次两两归并
        int N = a.length;
        aux = new Comparable[N];
        // sz: subarray size
        // sz: 子数组大小
        for (int sz = 1; sz < N; sz = sz + sz) {
            // lo: subarray index
            // lo: 子数组索引
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
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
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;
        // Copy a[lo..hi] to aux[lo..hi].
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // Merge back to a[lo..hi].
        for (int k = lo; k <= hi; k++) {
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
}
