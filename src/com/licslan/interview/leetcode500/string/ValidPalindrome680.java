package com.licslan.interview.leetcode500.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author licslan
 * 680. 验证回文串 II
 * 简单
 * 568
 * 相关企业
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * <p>
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 * <p>
 * 输入：s = "abc"
 * 输出：false
 */
public class ValidPalindrome680 {

    //双指针思路
    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            //天生就是回文的情况
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                //需要删除元素的情况
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    public static boolean validPalindrome(String s, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            //删除元素后  只要有一个不相等就不是回文的了
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(validPalindrome("abbaf"));
    }


}
