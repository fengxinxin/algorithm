package com.iolo.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 生成数组
 *
 * @author Fengxinxin
 * @date 2019-01-18
 */
public class GenerateList {
    public static void main(String[] args) {
//        generateIntList(100);
        genRandomIntList(10);
    }

    public static int[] generateIntList(int size) {
        int[] oldInts = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            oldInts[i] = (random.nextInt(size));
        }
        System.out.println(Arrays.toString(oldInts));
        return oldInts;
    }

    public static int[] genRandomIntList(int size) {
        int[] randoms = new int[size];
        List<Integer> listRandom = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            listRandom.add(i);
        }

        for (int i = 0; i < size; i++) {
            Random randomInt = new Random();
            int index = randomInt.nextInt(listRandom.size() - 1 > 0 ? listRandom.size() - 1 : 1);
            randoms[i] = listRandom.get(index);
            listRandom.remove(index);
        }

        System.out.println(Arrays.toString(randoms));
        return randoms;
    }
}
