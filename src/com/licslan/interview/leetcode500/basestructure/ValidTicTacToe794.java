package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 *794. 有效的井字游戏
 * 中等
 * 116
 * 相关企业
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 *
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 */
public class ValidTicTacToe794 {

    public static boolean validTicTacToe(String[] board) {

        //x win x-0=1
        //o win x-0=0
        //pending 行动中 x-0=1
        //draw 平局 x-0=0
        int xCount = 0;
        int oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'x') {
                    xCount++;
                }
                if (c == 'o') {
                    oCount++;
                }
            }
        }

        //1.draw x-0=0 pending x-0=1
        if (xCount - oCount != 0 && xCount - oCount != 1) {
            return false;
        }

        //3.x win x-0=1
        if (xCount - oCount != 1 && win(board, "xxx")) {
            return false;
        }
        //4.o win x-0=0
        if (xCount - oCount != 0 && win(board, "ooo")) {
            return false;
        }
        return true;
    }

    private static boolean win(String[] broad, String flag) {

        for (int i = 0; i < 3; i++) {
            //纵向3连
            if (flag.equals("" + broad[0].charAt(i) + broad[1].charAt(i) + broad[2].charAt(i))) {
                return true;
            }
            //横向3连
            if (flag.equals(broad[i])) {
                return true;
            }
        }

        // \向3连   // /向3连
        if (flag.equals("" + broad[0].charAt(0) + broad[1].charAt(1) + broad[2].charAt(2)) ||
                flag.equals("" + broad[0].charAt(2) + broad[1].charAt(1) + broad[2].charAt(0))) {
            return true;
        }


        return false;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"O  ","   ","   "};
        System.out.println(validTicTacToe(a));
    }



}
