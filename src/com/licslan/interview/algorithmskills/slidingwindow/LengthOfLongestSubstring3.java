package com.licslan.interview.algorithmskills.slidingwindow;

import java.util.*;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 * 代码
 * <p>
 * 测试用例
 * 测试结果
 * 测试结果
 * <p>
 * 3. 无重复字符的最长子串
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring3 {

    public int lengthOfLongestSubstring(String s) {
        //维护当前最长不重复字符子串
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                //未查到重复字符就一直加，right右移
                set.add(s.charAt(right));
                right++;
            } else {
                //right查到重复字符先不动，left右移，set删left经过的字符，直到重复的这个字符删掉为止
                set.remove(s.charAt(left));
                left++;
            }
            //每一次计算当前set子串的长度
            max = Math.max(max, set.size());
        }
        return max;
    }


    public int lengthOfLongestSubstring2(String s) {
        //need 需要凑齐的字符+次数     window 记录窗口中的字符+次数
        Map<Character, Integer> window = new HashMap<>();

        //左闭右开的区间 初始化没有任何元素
        int left = 0, right = 0;
        //记录结果
        int res = 0;

        while (right < s.length()) {
            // c 移入窗口的字符
            char c = s.charAt(right);
            //扩大窗口
            right++;


            window.put(c, window.getOrDefault(c, 0) + 1);

            //判断窗口是否收缩
            while (window.get(c) > 1) {
                //d 将要移除窗口的字符
                char d = s.charAt(left);
                //缩小窗口
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }

            res = Math.max(res, right - left);

        }

        return res;
    }
}
