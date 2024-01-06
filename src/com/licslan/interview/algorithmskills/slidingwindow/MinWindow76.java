package com.licslan.interview.algorithmskills.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/description/
 * 76. 最小覆盖子串
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 */
public class MinWindow76 {

    public String minWindow(String s, String t) {

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

        //记录最小覆盖字串的起始索引以及长度
        int start = 0, len = Integer.MAX_VALUE;

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
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
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

        //返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);


    }


}
