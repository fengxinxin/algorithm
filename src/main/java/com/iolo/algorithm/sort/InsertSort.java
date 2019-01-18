package com.iolo.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序的代码实现虽然没有冒泡排序和选择排序那么简单粗暴，
 * 但它的原理应该是最容易理解的了，因为只要打过扑克牌的人都应该能够秒懂。
 * 插入排序是一种最简单直观的排序算法，它的工作原理是通过构建有序序列，对于未排序数据，
 * 在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 * 插入排序和冒泡排序一样，也有一种优化算法，叫做拆半插入。
 *
 * 1. 算法步骤
 *
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 *
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
 * （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 * @author Fengxinxin
 * @date 2019-01-14
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ints = { 0, 1, 3, 5, 4, 9, 6, 8, 7, 2 };
        System.out.println(Arrays.toString(sort(ints)));

    }

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        System.out.println("数组长度：" + arr.length);

        /**
         * 因为第一个是默认顺序，不需要参与，从1位置开始
         */
        for (int i = 1; i < arr.length ; i++) {
            int temp = arr[i];
            int j = i;
            /**
             * 向前查询
             * 判断前一位的数，是否大于当前位置的值
             * 如果大于 当前位置的值，则赋值为前一位的值
             * j--继续查询
             */
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            /**
             * 如果j值发生了变化，则进行插入
             * 因为j--了，所以j就是要插入的位置的角标
             */
            if (j != i) {
                arr[j] = temp;
            }
            System.out.println(i + "次变更后的数组："+ Arrays.toString(arr));
        }
        return arr;
    }
}
