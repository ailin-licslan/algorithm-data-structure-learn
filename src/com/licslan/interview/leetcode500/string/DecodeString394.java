package com.licslan.interview.leetcode500.string;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author licslan  中等难度题目
 * 394. 字符串解码 LeetCode 专栏  ♥  NO394
 * 中等
 * 1.4K
 * 相关企业
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class DecodeString394 {

    private int ptr;
    private static String SHORT_CHAR = "[";

    public String decodeString(String s) {

        LinkedList<String> stk = new LinkedList<>();
        ptr = 0;
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);

            if (Character.isDigit(cur)) {
                //处理数字
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                //处理普通字符 和 [
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                //遇见 ] 处理相匹配的 [ 之间的字符
                ptr++;
                //使用另一个list 将字符串进行组合
                LinkedList<String> sub = new LinkedList<>();
                while (!SHORT_CHAR.equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                //因为栈的特点 导致组合字符串和原本的字符串相比是倒序的 需要反转一次
                Collections.reverse(sub);
                //左括号出栈
                stk.removeLast();
                //此时栈顶为当前sub对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);
                while (repTime-- > 0) {
                    t.append(o);
                }
                //将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);

    }


    //判断字数

    public String getDigits(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr++));
        }
        return sb.toString();
    }



    //处理字符串

    public String getString(List<String> v) {
        StringBuilder sb = new StringBuilder();
        for (String s : v) {
            sb.append(s);
        }
        return sb.toString();
    }
}
