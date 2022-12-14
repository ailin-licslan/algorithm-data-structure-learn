package com.licslan.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
/**
 * LeetCode ä¸æ   â¥  NO40 ð¡â offer   TOP K é®é¢
 *
 * @author LICSLAN
 * */
public class GetLeastNumbersByJDKPriorityQueue {
    
    /**
     * åæ Offer 40. æå°çKä¸ªæ°
     * è¾å¥æ´æ°æ°ç» arr ï¼æ¾åºå¶ä¸­æå°ç k ä¸ªæ°ãä¾å¦ï¼è¾å¥4ã5ã1ã6ã2ã7ã3ã8è¿8ä¸ªæ°å­ï¼åæå°ç4ä¸ªæ°å­æ¯1ã2ã3ã4ã
     *
     *
     *
     * ç¤ºä¾ 1ï¼
     *
     * è¾å¥ï¼arr = [3,2,1], k = 2
     * è¾åºï¼[1,2] æè [2,1]
     * ç¤ºä¾ 2ï¼
     *
     * è¾å¥ï¼arr = [0,1,2,1], k = 1
     * è¾åºï¼[0]
     *
     *
     * éå¶ï¼
     *
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     *
     * ä¼åéåå»å®ç° MaxHeapæ¥å®ç°
     * */


    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<> (Collections.reverseOrder());
        //å°æ°ç»åç´ ä¸­çåkä¸ªåç´ æ¾å¥ä¼åéåéé¢å»
        for (int i = 0; i < k; i++)
            pq.add(arr[i]);

        for (int i = k; i < arr.length; i++) {
            //ä¿è¯ä¼åéåä¸ä¸ºç©º
            if(!pq.isEmpty()&& arr[i] < pq.peek()){  //pq.getFront()å éé¢æå¤§çåç´ 
                pq.remove();//åºéåä¸¢å¼
                pq.add(arr[i]);//æ¾å¥å¤§ç
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = pq.remove();

        return res;

    }
    
    
}

