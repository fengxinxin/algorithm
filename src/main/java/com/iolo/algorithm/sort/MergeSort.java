package com.iolo.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * <p>
 * 作为一种典型的分而治之思想的算法应用，归并排序的实现由两种方法：
 * <p>
 * 自上而下的递归（所有递归的方法都可以用迭代重写，所以就有了第 2 种方法）；
 * <p>
 * 自下而上的迭代；
 * 算法步骤
 * <p>
 * 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 * <p>
 * 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 * <p>
 * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 * <p>
 * 重复步骤 3 直到某一指针达到序列尾；
 * <p>
 * 将另一序列剩下的所有元素直接复制到合并序列尾。
 *
 * @author Fengxinxin
 * @date 2019-02-02
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] ints = { 0, 1, 3, 5, 4, 9, 6, 8, 7, 2 };
        int[] ints1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println(Arrays.toString(sort(ints1)));

    }

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        System.out.println("数组长度：" + arr.length);
        //知道长度最短的时候，就剩两个数进行比较
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        System.out.println("left : " + Arrays.toString(left) + " right : " + Arrays.toString(right));
        //从最底层开始，也就是还剩下两个数的时候开始merge
        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0;
        //两个数组进行比较，直到有一个数组里面的数都比较完毕
        //通过Arrays.copyOfRange 减小数组的长度和内容
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        //循环赋值
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }
}
