package com.licslan.interview.leetcode500.basestructure;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author WEILIN
 * LeetCode 专栏  ♥  NO1
 * 求2数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Sum2Num01 {


    private static int[] numList = new int[]{3, 2, 4};

    /**
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * <p>
     * 暴力求解 O(n^2)
     */

    private static int[] getIndex(int[] numList, int target) {


        for (int i = 0; i < numList.length; i++) {

            for (int j = i + 1; j < numList.length; j++) {

                if (numList[i] + numList[j] == target) {

                    int[] intList = new int[2];

                    intList[0] = i;
                    intList[1] = j;

                    return intList;
                }
            }
        }


        return numList;
    }


    //时间复杂度 O(n)

    private static int[] getIndex2(int[] numList, int target) {

        int[] targetIndex = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = numList.length;
        for (int i = 0; i < size; i++) {
            int find = target - numList[i];
            if (map.get(find) != null) {
                targetIndex[0] = map.get(find);
                targetIndex[1] = i;
                break;
            }
            map.put(numList[i], i);
        }
        return targetIndex;
    }


    private static int[] getIndex3(int[] numList, int target) {

        int[] targetIndex = new int[2];
        Arrays.sort(numList);
        //双指针写法
        int left = 0,right = numList.length-1;
        while (left<right){
            if(numList[left]+numList[right]==target){
                targetIndex[0]=right;
                targetIndex[1]=left;
                return targetIndex;
            }
            else if(numList[left]+numList[right]<target) {
                left++;
            } else {
                right--;
            }
        }
        return targetIndex;
    }


    public static void main(String[] args) {
        int[] index = getIndex3(numList, 6);
        for (int i : index) {
            System.out.println(i);
        }
        System.out.println(index);
    }

}
