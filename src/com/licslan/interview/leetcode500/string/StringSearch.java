package com.licslan.interview.leetcode500.string;

/**
 * @author licslan
 * 给定2个字符串  A,B 判断B在A中是否存在 存在返回A中的下标
 */
public class StringSearch {

    //BF  Brute Force {a,bc,a}  {a,a,bc,a,d}


    public static int search(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        for (int i = 0; i <= n - m; i++) {
            int k;
            for (k = 0; k < m; k++) {
                if (pat.toCharArray()[k] != txt.toCharArray()[i + k]) {
                    break;
                }
            }
            if (k == m) {
                return i;
            }

        }

        return -1;
    }

    //BM Boyer-Moore

    //KMP Knuth-Morris-Pratt

    public static void main(String[] args) {

        String pat = "abca";
        String txt = "aabcad";
        System.out.println(search(pat, txt));
    }
}
