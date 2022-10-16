package com.licslan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author licslan
 */
public class FindMax {

    public static void main(String[] args) {

        List<Long> a = new ArrayList<>();

        a.add(1L);
        a.add(2L);
        a.add(5L);

        Long maxNum = 0L;
        Long minNum = 0L;

        for (Long aLong : a) {
            if (aLong > maxNum) {
                maxNum = aLong;
            }
        }

        for (Long aLong : a) {
            if (aLong < minNum) {
                minNum = aLong;
            }
        }
        System.out.println(maxNum);
        System.out.println(minNum);

    }
}
