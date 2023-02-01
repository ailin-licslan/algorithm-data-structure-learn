package com.licslan.interview.leetcode500.sortten;

import java.util.ArrayList;

/**
 * @author licslan
 * 桶排序 是计数排序的升级版  不要比较元素大小排序算法
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

        //将原始数组数据分配到桶中 递归时桶里面的数据慢慢排好序了
        for (Integer array : arrays) {
            //分配数据大小到不同的桶  每个桶都有边界 [abc]
            bucketArr.get((array - min) / bucketCap).add(array);
        }


        //对每个桶进行排序
        for (int i = 0; i < bucketSize; i++) {

            if (bucketCap == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketSize == 1) {
                    bucketCap--;
                }
                //对每个桶数据进行排序
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
        System.out.println(arrayList1.toString());
    }
}
