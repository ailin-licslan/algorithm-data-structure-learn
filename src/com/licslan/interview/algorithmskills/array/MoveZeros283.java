package com.licslan.interview.algorithmskills.array;

/**
 * @author WEILIN
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveZeros283 {

    public void moveZeros(int[] nums) {

        //1.判断元素个数 只有一个不用移动
        if (nums == null || nums.length <= 1) {
            return;
        }

        //2.定义数组 来装不是0 的数据  双指针思想
        int index = 0;
        for (int num : nums) {
            if ((num != 0)) {
                nums[index] = num;
                index++;
            }
        }

        //3.从index 开始 后面的值来赋值为0 就行了
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

    }


    public void moveZerosV2(int[] nums) {

        //1.判断元素个数 只有一个不用移动
        if (nums == null || nums.length <= 1) {
            return;
        }



        //2.定义数组 来装不是0 的数据
        int[] newArray = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if ((num != 0)) {
                newArray[index] = num;
                index++;
            }
        }

        //3.从index 开始 后面的值来赋值为0 就行了
        for (int i = index; i < nums.length; i++) {
            newArray[i] = 0;
        }






    }



    public void moveZeros4(int[] nums) {

        //1.判断元素个数 只有一个不用移动
        if (nums == null || nums.length <= 1) {
            return;
        }

        //2.定义数组 来装不是0 的数据
        int index = 0;
        for (int num : nums) {
            if ((num != 0)) {
                nums[index] = num;
                index++;
            }
        }

        //3.从index 开始 后面的值来赋值为0 就行了
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

}
