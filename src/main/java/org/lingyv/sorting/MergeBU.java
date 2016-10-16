package org.lingyv.sorting;

import static org.lingyv.sorting.Merge.merge;

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
}
