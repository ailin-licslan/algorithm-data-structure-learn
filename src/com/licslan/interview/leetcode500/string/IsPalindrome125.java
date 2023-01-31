package com.licslan.interview.leetcode500.string;
/**
 *  https://leetcode-cn.com/problems/valid-palindrome/
 *
 * LeetCode 专栏  ♥  NO125
 *  125. 验证回文串
 * */
public class IsPalindrome125 {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */

    public static boolean isPalindrome(String str){
        //1.首先将字符串转为字符
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            //获取字符
            char c = str.charAt(i);
            //判断是否是字符或者数字  Determines if the specified character (Unicode code point) is a letter or digit.
            if(Character.isLetterOrDigit(c)){
                //装入新数组sb
                sb.append(Character.toLowerCase(c));
            }
        }
        //2.翻转这个新的字符
        StringBuffer sbNew = new StringBuffer(sb).reverse();
        return sbNew.toString().equals(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNew("123abBa 321"));
    }

    public static boolean isPalindromeNew(String s){
        //1.将字符串转成字符
        StringBuffer stringBuffer = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
            stringBuffer.append(Character.toLowerCase(c));
            }
        }
        //翻转字符
       return stringBuffer.toString().equals(new StringBuffer(stringBuffer).reverse().toString());
    }



}
