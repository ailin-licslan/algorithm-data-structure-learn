package com.licslan.interview.algorithmskills.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/permutation-in-string/description/
 * 567. 字符串的排列
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class CheckInclusion567 {


    //维护的是一个 定长 窗口
    public boolean checkInclusion(String t, String s) {

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
                    return true;
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
        return false;
    }

}
