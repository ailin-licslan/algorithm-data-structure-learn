package com.licslan.leetcode;



import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * LeetCode ä¸æ   â¥  NO40 ð¡â offer   TOP K é®é¢
 *
 * @author LICSLAN
 * */
public class GetLeastNumbers {
    
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

        PriorityQueue<Integer> pq = new PriorityQueue<> ();
        //å°æ°ç»åç´ ä¸­çåkä¸ªåç´ æ¾å¥ä¼åéåéé¢å»
        for (int i = 0; i < k; i++)
            pq.enqueue(arr[i]);

        for (int i = k; i < arr.length; i++) {
            //ä¿è¯ä¼åéåä¸ä¸ºç©º
            if(!pq.isEmpty()&& arr[i] < pq.getFront()){  //pq.getFront()å éé¢æå¤§çåç´ 
                pq.dequeue();//åºéåä¸¢å¼
                pq.enqueue(arr[i]);//æ¾å¥å¤§ç
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = pq.dequeue();

        return res;

    }
    
    
}

interface QueueQ<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();


}


class PriorityQueue<E extends Comparable<E>> implements QueueQ<E> {


    //å®ç°ä¼åéåæ¹å¼
    //æ®éçº¿æ§ç»æ  å¥é:O(1)  åºé:O(n)
    //é¡ºåºçº¿æ§ç»æ  å¥é:O(n)  åºé:O(1)
    //å            å¥é:O(logn)  åºé:O(logn)


    //æå¤§å    ä½æ¯jdkä¸­PriorityQueueå¶å®æ¯æå°å ç»æ
    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize(){
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront(){
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e){
        maxHeap.add(e);
    }

    @Override
    public E dequeue(){
        return maxHeap.extractMax();
    }

    //ä¼åéåçç»å¸é®é¢  (å¨Nä¸ªåç´ ä¸­éåºæå¤§/å°çkä¸ªåç´ )


    //å¨100000000ä¸ªåç´ ä¸­éåºå100åï¼
    // 1.å¨Nä¸ªåç´ ä¸­éåºåMä¸ªåç´   æåº  Nlogn
    // 2.ä¼åéå  ç»´æ¤å½åçå°çåMä¸ªåç´ éè¦ä½¿ç¨æå°å  NlogM

    //Leetcode No347 åKä¸ªé«é¢åç´    ç»å®æ°ç»[1,1,1,2,2,3,4,5,6] k=2 è¿å[1,2]



    //å¯æ¯è¾çåé¨ç±»
    private class Freq implements Comparable<Freq>{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            if(this.freq < another.freq)
                return 1;
            else if(this.freq > another.freq)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.getSize() < k)
                pq.enqueue(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.dequeue().e);
        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

//    public static void main(String[] args) {
//
//        int[] numb = {1, 1, 1, 2, 2, 3};
//        int k = 2;
//        printList((new PriorityQueue()).topKFrequent(numb, k));
//    }

}


class MaxHeap<E extends Comparable<E>> {
    private ArrayDynamic<E> data;
    public MaxHeap(int capacity){
        data=new ArrayDynamic<>(capacity);
    }

    public MaxHeap(){
        data = new ArrayDynamic<>();
    }
    //è¿åå ä¸­çåç´ ä¸ªæ°
    public int size(){
        return data.getSize();
    }
    //å æ¯å¦ä¸ºç©º
    public boolean isEmpty(){
        return data.isEmpty();
    }
    //è¿åå®å¨äºåæ æ°ç»è¡¨ç¤º ä¸ä¸ªç´¢å¼æè¡¨ç¤ºçåç´ ç¶èç¹çç´¢å¼
    private int parent(int index){
        if(index==0)throw new IllegalArgumentException("index-0 doesn`t have parent");
        return (index-1)/2;
    }
    //è¿åå®å¨äºåæ æ°ç»  ä¸ä¸ªç´¢å¼æè¡¨ç¤ºçåç´ å·¦å­©å­èç¹ç´¢å¼
    private int leftChild(int index){return index*2+1;}
    //è¿åå®å¨äºåæ æ°ç»  ä¸ä¸ªç´¢å¼æè¡¨ç¤ºçåç´ å³å­©å­èç¹ç´¢å¼
    private int rightChild(int index){return index*2+2;}

    //å ä¸­åç´ æ¯ä½¿ç¨æ°ç»ç»æç  sift up  ä¸æµ®  å½¢æå çæ§è´¨
    // 0    1   2  3  4  5  6  7  8  9 10
    // 62   41 30 28 16 22 13 19 17 15 -

    //åå ä¸­æ·»å åç´ 
    public void add(E e){
        data.addLast(e);
        //æ·»å å®æè¿ä¸å¤  è¿éè¦ç»´æ¤å çæ§è´¨
        siftUp(data.getSize()-1);
    }

    //ä¸æµ®æä½
    private void siftUp(int i) {
        //å¦æä¸æ»¡è¶³å çæ§è´¨  å°±è¿éè¦å¯¹æ¯
        while (i>0&&data.getIndex(parent(i)).compareTo(data.getIndex(i))<0){
            //ä¸æ»¡è¶³å çæ§è´¨å°±äº¤æ¢ä¸ä¸ä½ç½®
            data.swap(i,parent(i));
            //å¦æä¸æ»¡è¶³å çæ§è´¨  å°±è¿éè¦å¯¹æ¯
            i=parent(i);
        }
    }

    //æ¾å°å ä¸­æå¤§çåç´ 
    public E findMax(){
        if(data.getSize()==0)throw new IllegalArgumentException("can not findMax when heap is empty!");
        return data.getIndex(0);
    }
    //ååºå ä¸­æå¤§çåç´ 
    public E extractMax(){
        E ret=findMax();
        //äº¤æ¢å ä¸­æå¤§çåç´ åæåä¸ä¸ªåç´ çå¼
        data.swap(0,data.getSize()-1);
        //å°æåä¸ä¸ªåç´ ç§»é¤æ
        data.removeLast();
        //sift down ä¸æ²
        siftDown(0);
        return ret;
    }

    private void siftDown(int i) {
        //å¦æå·¦å­©å­ç´¢å¼æ¯å åç´ æ°éå°
        while (leftChild(i)<data.getSize()){
            //è¯´æå·¦å­©å­æ¯å­å¨ç
            int j= leftChild(i);
            //å¦æå³å­©å­ä¹å­å¨ å¹¶ä¸å³å­©å­å¤§äºå·¦å­©å­ ï¼å³è¾¹>å·¦è¾¹ï¼
            if(j+1<data.getSize()&&
                    data.getIndex(j+1).compareTo(data.getIndex(j))>0){
                //å³å­©å­å¼èµå¼ç»j
                j=rightChild(i);
            }
            //data[j]æ¯leftChild & rightChild ä¸­çæå¤§å¼

            //å¦æå½ååç´ çå¼å¤§äºç­äºå³å­©å­(å·¦å³å­©å­æå¤§çä¸ä¸ªå¼)  ä¸è¿åå çæ§è´¨ å°±ä¸äº¤æ¢äº
            if(data.getIndex(i).compareTo(data.getIndex(j))>=0)break;

            //å¦åå°±ä¸æ²äº¤æ¢ä¸ä¸
            data.swap(i,j);
            //å°jèµå¼ç»i  è¿è¡æ°ä¸è½®å¾ªç¯æ¥æ¯è¾åæä¸è¿°çé»è¾æä½
            i=j;
        }
    }


    // add  &  extractMax çæ¶é´å¤æåº¦é½æ¯O(logn)
    // äºåæ é«åº¦çè¿ä¸ªçº§å«  å æ¯ä¸é¢å®å¨äºåæ  æ°¸è¿ä¸ä¼éåä¸ºé¾è¡¨ççº¿æ§ç»æ

    //replace  ååºæå¤§åç´ å  æ¾å¥ä¸ä¸ªæ°åç´ 
    // å®ç°æ¹æ¡ä¸ï¼  åexarctMax å add ä¸¤æ¬¡O(logn)
    // å®ç°æ¹æ¡äºï¼  å¯ä»¥ç´æ¥å°å é¡¶åç´ æ¿æ¢ä»¥åsiftDown ä¸æ¬¡O(logn)

    //ååºå ä¸­æå¤§åç´   å¹¶ä¸æ¿æ¢æåç´ e
    public E replace(E e){
        E ret=findMax();
        //æ¿æ¢
        data.set(0,e);
        //ä¸æ²
        siftDown(0);
        return ret;
    }

    //Heapify  å°ä»»ææ°ç»æ´çæå çå½¢ç¶
    // å®ç°æ¹æ¡ä¸ï¼  å°æ°ç»ä¸­Nä¸ªåæ·»å å°æä»¬å®ç°çheapç»æçå¯¹è±¡ä¸­å°±å¯ä»¥äº  O(logn)
    // å®ç°æ¹æ¡äºï¼  å°å½åæ°ç»çææ¯ä¸é¢å®å¨äºåæ  ä»æåä¸ä¸ªéå¶å­èç¹ä¸æ­ååsiftDownå°±è¡äº  O(n)

    //Heapify
    public MaxHeap(E[] arr){
        data=new ArrayDynamic<>(arr);
        //å°å½åæ°ç»çææ¯ä¸é¢å®å¨äºåæ  ä»æåä¸ä¸ªéå¶å­èç¹ä¸æ­ååsiftDownå°±è¡äº  O(n)
        if(arr.length != 1){
            for(int i=parent(arr.length-1);i>=0;i--)
                siftDown(i);
        }
    }

}


class ArrayDynamic<E> {

    //LICSLAN  day1 æ°ç»å­¦ä¹   æ°æ®ç»æ   è¿ä¸ªæ¶åå¼å§å­¦ä¹   ç®æ³ä¸æ°æ®ç»æ!!!  <ä¹åä¸ç´æ²¡æä¸å³å¿å­¦æ°æ®ç»æåç®æ³>

    //æ°æ®åºCRUD æä»¬å¯¹èªå·±å°è£çæ°ç»ä¹è¿è¡ç¸åºçåå­çº§å«çCRUD   å¨ææ°ç»å­¦ä¹  ç¨æ·ä¸è½ç¥éåºå±åäºä»ä¹æä½

    //å®ä¹ä¸ä¸ªç©ºæ°ç»
    private E[] data;
    //æ°ç»å®éå¤§å°  ç§ææååé
    private int size;

    //è·åæ°ç»åç´ ä¸ªæ°
    public int getSize(){
        return size;
    }
    //è·åæ°ç»çå®¹é
    public int getcapacity(){
        return data.length;
    }
    //å¤æ­æ°ç»æ¯å¦ä¸ºç©º
    public boolean isEmpty(){
        return size==0;
    }
    //åå§åç©ºæ°ç» æé å½æ°  ä¼ å¥æ°ç»å®¹é
    public ArrayDynamic(int capacity){
        data=(E[]) new Object[capacity];
        size=0;
    }

    public ArrayDynamic(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i=0;i<arr.length;i++)
            data[i]=arr[i];
        size=arr.length;
    }
    //æ åæé å½æ°
    public ArrayDynamic(){
        this(10);
    }

    //åæå®åç´ ä½ç½®æå¥åç´   é£ä¹æå®åç´ ä½ç½®åé¢çåç´ éè¦å¾åç§»å¨
    public void add(int index,E e){
        /*if(size==data.length)
            throw new IllegalArgumentException("array is full");*/
        if(index<0||index>size)
            throw new IllegalArgumentException("Require index>=0 and index < size");
        if(size==data.length)
            //è¿ä¸ªæ¶åä¸æ¯æ¥éäº  èæ¯æ©å®¹ 2å 1.5  3é½å¯ä»¥
            resize(2*data.length);

        //ç§»å¨åç´   ä»æåçå¼å§  ä¹å°±æ¯ä»åå¾ååç´ ä¸æ¬¡é½å¾åç§»å¨ä¸ä½
        for(int i=size-1;i>=index;i--)
            //å°å¤§äºç­äºindexçå¼å¾åä¾æ¬¡ç§»å¨ä¸ä½åç´ 
            data[i+1]=data[i];
        //æ­¤æ¶data[index]çå¼èµå¼ä¸ºè¦æå¥çå¼
        data[index]=e;
        size++;

    }

    //è·åæå®åç´ çä½ç½®
    public E getIndex(int index){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Get failed! Index is illegal");
        return data[index];
    }

    private void resize(int newCapacity) {
        //ç³æä¸ä¸ªæ°çæ°ç»  å¹¶å°åæ¥æ°ç»çå¼èµå¼å°æ°çæ°ç»éé¢æ¥
        E[] newData = (E[]) new Object[newCapacity];
        for(int i=0;i<size;i++)
            newData[i]=data[i];

        //å°dataæåæ°çæ°ç»newData  é£ä¹ä»¥åçdataæ°ç»JVM gcèªå·±èªå¨åæ¶äº
        data=newData;

    }

    //ä¿®æ¹æå®åç´ çå¼
    public void set(int index,E e){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Set failed! Index is illegal");
        data[index] = e;
    }

    public void addLast(E i) {
        add(size,i);
    }



    //å é¤æå®ç´¢å¼ä½ç½®çåç´   å¨æå é¤  å½å é¤å°ä¸å®ç¨åº¦çæ¶å  æ°ç»çå®¹écapacityå°±ä¼èªå¨ç¼©å°
    public E remove(int index){
        E indexValue= data[index];
        if(index<0||index>=size)
            throw new IllegalArgumentException("Remove failed! Index is illegal");

        //å°ç´¢å¼å¤§äºindexçå¼é½å¾åç§»å¨ä¸ä½  ä»indexç´¢å¼ä¸ä¸ä½å¼å§ç§»å¨
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;

//        if(size==data.length/2)
//            resize(data.length/2);

        //ä¸è¿°çå¨ææ°ç»ç¼©å®¹æ¶ä¼å ç¼©å®¹æ¶ä¸è½ä¸º0  ç©ºæ°ç»é¿åº¦ä¸è½ä¸º0å
        if(size==data.length/4 && data.length/2!=0)
            resize(data.length/2);

        return indexValue;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
        res.append("[");
        for(int i =0;i<size;i++){
            res.append(data[i]);
            //å¦æä¸æ¯æåä¸ä¸ªåç´ 
            if(i!=size-1)
                res.append(",");
        }
        //å¦ææ¯æåä¸ä¸ªåç´ 
        res.append("]");
        return res.toString();
    }

    //æ¥æ¾åç´ çç´¢å¼å¼  å¦ææ¾ä¸å°å°±è¿å-1  å½ç¶è¿éä¹åªæ¯æ¾äºä¸ä¸ªåç´ e  å¹¶æ²¡ææ¾å°ææåç´ e
    public int findIndex(E e){
        for(int i=0;i<size;i++){
            if(data[i]==e){
                //è¿åç´¢å¼å¼
                return i;
            }
        }
        return -1;
    }

    //å é¤ç¬¬ä¸ä½
    public E removeFirst(){
        return remove(0);
    }
    //å é¤æåä¸ä½
    public E removeLast(){
        return remove(size-1);
    }
    //å é¤æä¸ªåç´   å¦ææéå¤åç´ å¹¶ä¸è½ä¿è¯å®å¨å é¤åç´ e
    public void removeE(E e){
        //é¦åæ¾ä¸ä¸åç´ çç´¢å¼ä½ç½®
        int index = findIndex(e);
        if(index!=-1)
            remove(index);
    }

    //äº¤æ¢å¨ææ°ç»éé¢çä¸¤ä¸ªç´¢å¼åå«ä¸ºi & jçå¼
    public  void swap(int i,int j){
        if(i<0||i>=size||j<0||j>=size) throw new IllegalArgumentException("Index is illegal");
        E t=data[i];
        data[i]=data[j];
        data[j]=t;
    }


    //æ¶é´å¤æåº¦åæ  O(1)  O(n)  O(lgn) O(nlogn) O(n^2)

    //æ¶é´å¤æåº¦ å¿½ç¥å¸¸æ°

    // T=2*N+2                 O(n)
    // T=2000*N+10000          O(n)
    // T=1*N*N + 0.00001       O(n^2)

    //æ¸è¿æ¶é´å¤æåº¦ æè¿°å½Nè¶è¿äºæ ç©·æ¶çæåµ

    //[æ·»å æä½]
    //addLast()  O(1)  resize()  O(n)
    //addFirst() O(n)
    //add(index,e)  å¯è½æ¯  å¦æindex==size O(1) ä¹æå¯è½æ¯O(n) index=0   è®¡ç®æ°å­¦ææ  å¹³åèè¨ O(N/2)=O(N)
    //å¨ææ°ç»  resize()æä½  O(N)
    //[å é¤æä½]
    //removeLast()  O(1)
    //removeFirst() O(n)
    //remove(index,e)  å¯è½æ¯  å¦æindex==size O(1) ä¹æå¯è½æ¯O(n) index=0   è®¡ç®æ°å­¦ææ  å¹³åèè¨ O(N/2)=O(N)
    //[ä¿®æ¹æä½]
    //set() O(1)
    //[æ¥è¯¢æä½]
    //get(index) O(1)
    //contains(e) O(n)
    //find(e)  O(n)


    //æ»ç»ä¸ä¸æ°ç»çæ¶é´å¤æåº¦
    //add    O(n)     resize()
    //delete O(n)     resize()
    //update å·²ç¥ç´¢å¼ O(1)  æªç¥ç´¢å¼O(n)
    //query  å·²ç¥ç´¢å¼ O(1)  æªç¥ç´¢å¼O(n)


    //ç®æ³é¢åæ¶é´å¤æåº¦éå¸¸æç§æåçèè

    //å¤æåº¦éè¡ removeLast and addLast to  Eager  so we should lazy   æ©å®¹ ç¼©å°    å½size==capacity/4 æå°capacityåå

}