package com.licslan.interview.leetcode500.basestructure;

/**
 * @author WEILIN
 * LeetCode 专栏  ♥  NO09
 * 判断回文数   121  true  123 false  11211 true
 * 从左到右  和  从右到左一样
 * https://leetcode.cn/problems/palindrome-number/
 */
public class IsPalindrome09 {

    public static void main(String[] args) {

        int abs = 12343217;
        boolean palindromeCheck = isPalindromeCheck(abs);
        System.out.println(palindromeCheck);

    }

    public static boolean isPalindromeCheck(int num) {

        char[] chars = String.valueOf(num).toCharArray();

        String strNum = String.valueOf(num);

        int length = chars.length;

        if (length % 2 == 0) {

            String first = strNum.substring(0, length / 2);
            String end = strNum.substring(length / 2, length);
            end = new StringBuilder(end).reverse().toString();

            if (first.equals(end)) {
                return Boolean.TRUE;
            }

        } else {

            String first = strNum.substring(0, length / 2);
            String end = strNum.substring(length / 2 + 1, length);
            end = new StringBuilder(end).reverse().toString();

            if (first.equals(end)) {
                return Boolean.TRUE;
            }
        }


        return false;
    }

}
