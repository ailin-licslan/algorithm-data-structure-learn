package com.licslan.interview.leetcode500.sortten;

import com.licslan.week05.Array;

import java.util.ArrayList;

/**
 * @author licslan
 * 桶排序
 */
public class BucketSortTest {

    public static ArrayList<Integer> bucketSortTest(ArrayList<Integer> arrays, int bucketCap) {

        if (arrays == null || arrays.size() < 2) {
            return arrays;
        }
        int max = arrays.get(0), min = arrays.get(0);
        for (Integer array : arrays) {
            if (array > max) {
                max = array;
            }
            if (array < min) {
                min = array;
            }
        }
        //桶的数量
        int bucketSize = (max - min) / bucketCap + 1;
        //构建桶
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketSize);
        for (int i = 0; i < bucketSize; i++) {
            bucketArr.add(new ArrayList<>());
        }
        //返回结果
        ArrayList<Integer> resArr = new ArrayList<>();

        //将原始数组数据分配到桶中
        for (Integer array : arrays) {
            bucketArr.get((array - min) / bucketCap).add(array);
        }


        for (int i = 0; i < bucketSize; i++) {

            if (bucketCap == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketSize == 1) {
                    bucketCap--;
                }
                ArrayList<Integer> temp = bucketSortTest(bucketArr.get(i), bucketCap);
                for (int j = 0; j < temp.size(); j++) {
                    resArr.add(temp.get(j));
                }
            }
        }
        return resArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(100);
        arrayList.add(100);
        arrayList.add(1000);
        arrayList.add(10);
        arrayList.add(1);
        arrayList.add(20);
        System.out.println(arrayList.toString());
        ArrayList<Integer> arrayList1 = bucketSortTest(arrayList, 2);
        System.out.println(arrayList1);
    }
}
