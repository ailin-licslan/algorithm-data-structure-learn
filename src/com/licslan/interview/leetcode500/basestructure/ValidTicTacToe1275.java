package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 * 1275. 找出井字棋的获胜者
 * 简单
 * 67
 * 相关企业
 * A 和 B 在一个 3 x 3 的网格上玩井字棋。
 * <p>
 * 井字棋游戏的规则如下：
 * <p>
 * 玩家轮流将棋子放在空方格 (" ") 上。
 * 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
 * "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
 * 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
 * 如果所有方块都放满棋子（不为空），游戏也会结束。
 * 游戏结束后，棋子无法再进行任何移动。
 * 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
 * <p>
 * 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
 */
public class ValidTicTacToe1275 {

    public String tictactoe(int[][] moves) {


        return "";
    }


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
        String[] a = new String[]{"O  ", "   ", "   "};
        System.out.println(validTicTacToe(a));
    }


}
