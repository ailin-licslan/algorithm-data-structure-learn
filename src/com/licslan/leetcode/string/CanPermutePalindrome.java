package com.licslan.leetcode.string;

import java.util.HashSet;
import java.util.Set;
/**
 *
 * 回文排列
 *
 * */
public class CanPermutePalindrome {

    /**
     * 面试题 01.04. 回文排列
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     *
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     *
     * 回文串不一定是字典当中的单词。
     *
     *
     *
     * 示例1：
     *
     * 输入："tactcoa"
     * 输出：true（排列有"tacocat"、"atcocta"，等等）
     * */

    public static boolean canPermutePalindrome(String s) {
        //排除为null的空字符串
        if(s==null){
            return false;
        }
        char[] chars = s.toCharArray();
        //hashset 不允许元素重复
        Set<Character> set = new HashSet<>();
        //遍历字符
        for(char c : chars){

            //如果是回文串的话 那么一定满足abcdcba这样的格式 或者 a  或者 abccba
            //所以是成双成对一样的元素的或者多一个元素
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("123abba321"));
    }

}
