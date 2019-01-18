package com.iolo.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位；
 * 希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
 * 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序
 *
 * @author Fengxinxin
 * @date 2019-01-14
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] ints = { 0, 24, 3, 5, 4, 9, 6, 8, 7, 2 };

        int[] ints1 = GenerateList.genRandomIntList(100);
        System.out.println(Arrays.toString(sort(ints1)));
        System.out.println(Arrays.toString(sort1(ints1)));
//        Arrays.toString(sort(ints1));
//        Arrays.toString(sort1(ints1));

    }

    public static int[] sort(int[] sourceArray) {
        long starTime = System.currentTimeMillis();
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        System.out.println("数组长度：" + arr.length);

        int length = arr.length;
        for (int gap = length / 3 + 1; gap > 0; gap = (int) Math.floor(gap / 3)) {
            for (int i = gap; i < length; i++) {
                int temp = arr[i];
                int j = i;
                while (j - gap >= 0 && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                if (j != i) {
                    arr[j] = temp;
                }
//                System.out.println(i + "次变更后的数组："+ Arrays.toString(arr));
            }
        }
        System.out.println(" /3 + 1 消耗的时间 ： " + (System.currentTimeMillis() - starTime));
        return arr;
    }

    public static int[] sort1(int[] sourceArray) {
        long starTime = System.currentTimeMillis();
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        System.out.println("数组长度：" + arr.length);

        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap = (int) Math.floor(gap / 2)) {
            for (int i = gap; i < length; i++) {
                int temp = arr[i];
                int j = i;
                while (j - gap >= 0 && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                if (j != i) {
                    arr[j] = temp;
                }
//                System.out.println(i + "次变更后的数组："+ Arrays.toString(arr));
            }
        }
        System.out.println("/2 消耗的时间 ： " + (System.currentTimeMillis() - starTime));
        return arr;
    }
}
