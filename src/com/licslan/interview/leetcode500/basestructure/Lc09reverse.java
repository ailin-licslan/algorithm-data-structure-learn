package com.licslan.interview.leetcode500.basestructure;

public class Lc09reverse {

    public static int reverse(int x) {

        int res = 0;
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        //负数
        StringBuilder sb = new StringBuilder();
        if (chars[0] == '-') {
            sb.append(chars[0]);
            for (int i = chars.length - 1; i > 0; i--) {
                sb.append(chars[i]);
            }
        } else {
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
        }
        try {
            res = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        return res;

    }


    public static int reverse2(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(x));
        try {
            int result = Integer.parseInt(sb.reverse().toString());
            return x > 0 ? result : -result;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse2(964632435));
    }
}
