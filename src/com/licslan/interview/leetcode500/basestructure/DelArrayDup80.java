package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 * 80. 删除有序数组中的重复项 II
 * 中等
 * 764
 * 相关企业
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
 */
public class DelArrayDup80 {


    public static int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int slow = 2;
        for (int fast = 2; fast < n; fast++) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }


    public static void main(String[] args) {

        System.out.println(removeDuplicates2(new int[]{0, 1,1, 2,2, 2, 2, 4}));
    }


}
