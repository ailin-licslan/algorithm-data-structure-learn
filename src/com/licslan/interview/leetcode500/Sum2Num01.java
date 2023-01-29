package com.licslan.interview.leetcode500;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author WEILIN
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


    private static int[] numList = new int[]{1, 3, 4, 5, 6};

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


    public static void main(String[] args) {
        int[] index = getIndex(numList, 11);
        for (int i : index) {
            System.out.println(i);
        }
        System.out.println(index);
    }

}
