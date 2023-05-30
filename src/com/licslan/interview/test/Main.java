package com.licslan.interview.test;

import java.util.*;

public class Main {
    public static void main2(String[] args) {
        int n = 6;
        int[] ids = {1, 2, 3, 1, 2, 2, 1};
        int m = 3;
        int minNum = minNumIds(n, ids, m);
        System.out.println(minNum); // Output: 2
    }

    public static int minNumIds(int n, int[] ids, int m) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int id : ids) {
            freq.put(id, freq.getOrDefault(id, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            int maxFreqId = Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();
            if (freq.get(maxFreqId) == 1) {
                freq.remove(maxFreqId);
            } else {
                freq.put(maxFreqId, freq.get(maxFreqId) - 1);
            }
        }
        return freq.size()-1;
    }






    public static int deleteProducts(List<Integer> ids, int m) {
        Map<Integer, Integer> freq = new HashMap<>(); // to store the frequency of each ID
        for (int id : ids) {
            freq.put(id, freq.getOrDefault(id, 0) + 1); // increment the frequency of the ID
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // to keep track of IDs with highest frequency
        pq.addAll(freq.values());

        while (m > 0 && !pq.isEmpty()) {
            int maxFreq = pq.poll();
            if (maxFreq > 1) {
                pq.offer(maxFreq - 1);
            }
            m--;
        }

        return pq.size()-1; // number of unique IDs remaining
    }

    public static void main3(String[] args) {
        List<Integer> ids1 = Arrays.asList(1, 1, 1, 2, 3, 2);
        int m1 = 2;
        System.out.println(deleteProducts(ids1, m1)); // output: 1

        List<Integer> ids2 = Arrays.asList(1, 1, 5, 5);
        int m2 = 2;
        System.out.println(deleteProducts(ids2, m2)); // output: 1

        List<Integer> ids3 = Arrays.asList(1, 2, 3, 1, 2, 2, 1);
        int m3 = 3;
        System.out.println(deleteProducts(ids3, m3)); // output: 2
    }



    public static long getIdealNums(long low, long high) {
        int max_x = (int) (Math.log(high) / Math.log(3));
        int max_y = (int) (Math.log(high) / Math.log(5));
        Set<Long> idealNums = new HashSet<>();
        for (int x = 0; x <= max_x; x++) {
            for (int y = 0; y <= max_y; y++) {
                long n = (long) Math.pow(3, x) * (long) Math.pow(5, y);
                if (n >= low && n <= high) {
                    idealNums.add(n);
                }
            }
        }
        return idealNums.size();
    }

    public static void main(String[] args) {
        System.out.println(getIdealNums(400000,500000));
    }

}
