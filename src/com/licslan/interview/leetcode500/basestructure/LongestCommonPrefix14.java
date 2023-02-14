package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                //公共前缀不匹配就让它变短！ 在变短过程中 能匹配到就能匹配到  否则不行  因为是这个几个字符串都是相同的前缀
                //说明这个几个字符串肯定有相同的字符 不断变短去匹配
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
