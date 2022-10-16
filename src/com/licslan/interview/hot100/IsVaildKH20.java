package com.licslan.interview.hot100;

import java.util.Stack;

/**
 * @author WEILIN
 * 有效括号
 * <p>
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class IsVaildKH20 {


    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //遍历左侧的括号并入栈
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                //对比右侧的括号  判断当前栈顶是否有元素  就是判断栈是否为空
                if (stack.isEmpty()) {
                    return false;
                }
                //栈顶取出一个元素
                char pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
            }
        }
        //判断所有元素都取完了 看栈里面的括号和右侧符号是不是都能匹配
        return stack.isEmpty();
    }
}
