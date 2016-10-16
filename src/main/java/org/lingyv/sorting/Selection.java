package org.lingyv.sorting;

import static org.lingyv.sorting.Sorting.exch;
import static org.lingyv.sorting.Sorting.less;

/**
 * 选择排序
 *
 * 思想:
 * 位置选择元素。
 * --> 每个循环寻找相对索引"i"的最小数a[min],把它放在第i的位置上
 *     从i开始,比较a[i]、a[i+1]、a[i+2]...a[N-1]的大小。将最小的那个a[?]放在i的位置上。
 *     --› 把第i小的元素放在a[i]之中。数组的第i个位置的左边是i个最小的元素且它们不会被访问。
 *
 * -->  首先,遍历找到数组中最小的元素,然后把它和数组的第一个元素交换,
 *      然后,遍历找到剩余元素的最小元素,把它与数组的第二个元素交换,
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
                if (less(a[j], a[min])) {
                    min = j;
                }
                exch(a, i, min);  //将a[i]和a[min]交换
                min = i;
            }
        }
    }

    /*
    Proposition A. Selection sort uses  (N^2)/2 compares and N exchanges to sort an array of length N.
    命题A：对于长度为N的数组,选择排序大约需要(N^2)/2次比较和N次交换。


    Proof: You can prove this fact by examining the trace,
     which is an N-by-N table in which unshaded letters correspond to compares.
     About one-half of the entries in the table are unshaded—those on and above the diagonal.
     The entries on the diagonal each correspond to an exchange.
     More precisely,examination of the code reveals that,for each i from 0 to N-1,there is one exchange and N-1-i compares,
     so the totals are N exchanges and (N-1) + (N-2) + . . . + 2 + 1+ 0 = N(N-1) / 2 - (N^2)/ 2 compares.
     */
}
