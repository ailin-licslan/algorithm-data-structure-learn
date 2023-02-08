package com.licslan.interview.leetcode500.string;

/**
 * @author licslan
 *
 * leetcode 415
 */
public class AddStrings415 {



    //124
    //017
    //141  7+4

    public String addStrings(String num1, String num2) {

        //num1 = 125 num2 =17
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            //ASCII  48-0 49-1 50-2 51-3 52-4 53-5 .... 十进制与字符的关系

            //x=5 第1轮循环   x=2 第2轮循环  x=1 第3轮循环
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            //y=7 第1轮循环   y=1 第2轮循环  y=0 第3轮循环
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            // result = 5+7+0=12  result = 2+1+1=4  result = 1+0+0
            int result = x + y + add;
            //12%10 =2   4%10=4  1%10=1   241
            ans.append(result % 10);
            //ans 241  反转一下  142

            //add = 12/10 =1  3/10=0  1/10=0
            add = result / 10;
            //指针都减一 进行下一次循环
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();


    }

    public static void main(String[] args) {
        //取余
        System.out.println(12%10);
        System.out.println(3%10);
        //取商
        System.out.println(12/10);
        System.out.println(3/10);
    }
}
