package com.licslan.interview.algorithmskills.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 * 438. 找到字符串中所有字母异位词
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class FindAnagrams438 {

    public List<Integer> findAnagrams(String s, String t) {
        //need 需要凑齐的字符+次数     window 记录窗口中的字符+次数
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        char[] charArray = t.toCharArray();
        for (char c : charArray) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }


        //左闭右开的区间 初始化没有任何元素
        int left = 0, right = 0;
        //记录有多少个字符满足条件
        int valid = 0;

        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            // c 移入窗口的字符
            char c = s.charAt(right);
            //扩大窗口
            right++;

            //进行窗口内数据一系列的更新 如果向右滑动过程中 子串字符包含滑动过程中遇到的字符 就把这个字符记录到window的map中 数量+1
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                //如果此时记录的字符和子串中的正好相等
                if (window.get(c).equals(need.get(c))) {
                    //合法记录的数量+1
                    valid++;
                }
            }

            //判断左窗口是否要收缩
            while (right - left >= t.length()) {

                if (valid == need.size()) {
                    res.add(left);
                }

                //d 将要移除窗口的字符
                char d = s.charAt(left);
                //缩小窗口
                left++;
                //进行窗口内一系列数据的更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return res;
    }
}
