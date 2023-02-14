package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 * 58. 最后一个单词的长度
 * 简单
 * 551
 * 相关企业
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 */
public class LengthOfLastWord58 {

    public int lengthOfLastWord(String s) {

        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            if (s1[s1.length - 1] != " ") {
                return s1[s1.length - 1].toCharArray().length;
            } else {
                return s1[s1.length - 2].toCharArray().length;
            }
        }

        return -1;
    }
}
