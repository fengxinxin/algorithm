package com.iolo.algorithm.sort;

import javax.xml.transform.Templates;
import java.util.Arrays;

/**
 * 选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
 * <p>
 * 1. 算法步骤
 * <p>
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * <p>
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * <p>
 * 重复第二步，直到所有元素均排序完毕。
 *
 * @author Fengxinxin
 * @date 2019-01-14
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] ints = { 0, 1, 3, 5, 4, 9, 6, 8, 7, 2 };
        System.out.println(Arrays.toString(sort(ints)));

    }

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        System.out.println("数组长度：" + arr.length);
        int iCount = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            System.out.println("i循环次数：" + iCount);
            iCount++;
            /*
            将i值进行剩余的数组进行对比，比i小的，进行角标替换，直到循环结束
             */
            int jCount = 0;
            for (int j = i + 1; j < arr.length; j++) {
                jCount++;
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            System.out.println("j循环次数：---" + jCount);
            /*
            如果i值发生了变化，也就是需要进行替换，将最小值进行位置替换到i的位置上
             */
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }
}
