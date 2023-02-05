package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 * 26. 删除有序数组中的重复项
 * 简单
 * 3K
 * 相关企业
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * <p>
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * <p>
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * <p>
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 判题标准:
 * <p>
 * 系统会用下面的代码来测试你的题解:
 * <p>
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 * <p>
 * int k = removeDuplicates(nums); // 调用
 * <p>
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 */
public class DelArrayDup26 {


    //首先注意数组是有序的，那么重复的元素一定会相邻。
    //要求删除重复元素，实际上就是将不重复的元素移到数组的左侧
    //双指针写法

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // p 指针
        int p = 0;
        // q 指针
        int q = 1;
        while (q < nums.length) {
            //找到不相等的 就把那个值覆盖到p+1的位置上面去
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                //赋值了之后指针需要往后移动一位
                p++;
            }
            //如果相等 后移动一位
            q++;
        }
        return p + 1;
    }


    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicates2(new int[]{0, 1, 2, 2, 2, 4}));
    }


}
