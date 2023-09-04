package com.licslan.interview.leetcode500.string;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）
 */
public class IsSubsequence392 {
    public static boolean isSubsequence(String s, String t) {

        char[] charArray = s.toCharArray();
        char[] charArray1 = t.toCharArray();
        int start1 = 0, start2 = 0;
        while (start1 < s.length() && start2 < t.length()) {
            if (charArray[start1] == charArray1[start2]) {
                start1++;
            }
            start2++;
        }
        return start1 == s.length();
    }

    public static void main(String[] args) {

        boolean subsequence = isSubsequence("aaaaaa", "bbaaaa");

        System.out.println(subsequence);
    }
}
