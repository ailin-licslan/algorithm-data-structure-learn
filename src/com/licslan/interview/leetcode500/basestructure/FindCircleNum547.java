package com.licslan.interview.leetcode500.basestructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author licslan
 * 547. 省份数量
 * 中等
 * 924
 * 相关企业
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 * <p>
 * <p>
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 */
public class FindCircleNum547 {

    //DFS  stack over flow

    public int findCircleNum(int[][] isConnected) {
        int citys = isConnected.length;
        boolean[] visted = new boolean[citys];
        //省的数量
        int provinces = 0;
        for (int i = 0; i < citys; i++) {
            if (!visted[i]) {
                dfs(i, citys, visted, isConnected);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int i, int citys, boolean[] visted, int[][] isConnected) {
        for (int j = 0; j < citys; j++) {
            //没有被打标过才去访问
            if (isConnected[i][j] == 1 && !visted[j]) {
                visted[j] = true;
                dfs(j, citys, visted, isConnected);
            }

        }
    }


    //BFS

    public int findCircleNum2(int[][] isConnected) {
        int citys = isConnected.length;
        boolean[] visited = new boolean[citys];
        int provinces = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < citys; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int k = queue.poll();
                    visited[k] = true;
                    for (int j = 0; j < citys; j++) {
                        if (isConnected[k][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }


    //并查集

    public int findCircleNum3(int[][] isConnected) {
        int cities = isConnected.length;
        int[] parent = new int[cities];
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }


}
