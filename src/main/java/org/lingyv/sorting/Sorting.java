package org.lingyv.sorting;

/**
 * 排序
 */
public class Sorting {
    public void sort(Comparable[] a) {
        System.out.println("排序");
    }

    /**
     * 对元素进行比较
     * 比较第二个参数是否大于第一个参数
     *
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 将元素交换位置
     *
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印数组
     *
     * @param a
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 测试元素是否有序
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {8,2,5,3,6,9,1,7};
        //Selection.sort(a);
        //Insertin.sort(a);
        //Shell.sort(a);
        Merge.sort(a);
        System.out.println(isSorted(a));
    }
}
