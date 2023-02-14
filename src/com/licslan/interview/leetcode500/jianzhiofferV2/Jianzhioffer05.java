package com.licslan.interview.leetcode500.jianzhiofferV2;

/**
 * @author licslan
 */
public class Jianzhioffer05 {

    public String replaceSpace(String s) {

        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                res.append("%20");
            } else {
                res.append(chars[i]);
            }

        }
        return res.toString();
    }

}
