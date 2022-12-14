package com.licslan.week04;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class BinarySearch {
    /**
     * 二分查找法
     * */
    private BinarySearch(){}
    public static <E extends Comparable<E>> int searchR(E[] data,E target){
        return searchR(data,target,0,data.length-1);
    }
    //递归搜索
    private static <E extends Comparable<E> > int searchR(E[] data, E target,int l,int r){
        if(l>r) return -1;//空数组
        //中间那个元素
        int mid = l+(r-l)/2;  //避免整型溢出
        if(data[mid].compareTo(target)==0)return mid;//正好相等
        if(data[mid].compareTo(target)<0)return searchR(data,target,mid+1,r);//右侧去找
        return searchR(data,target,l,mid-1);//左侧找
    }

    //非递归写法
    public static <E extends Comparable<E>> int search(E[] data,E target){
        int l=0,r=data.length-1;
        //循环不变量 在data[l,r]范围中不断去查找target
        while (l <=r) {
            int mid =l+(r-l) / 2;
            if(data[mid].compareTo(target) == 0)return mid;

            if(data[mid].compareTo(target) >0)
                r=mid-1;//修改右边界的值 （l,mid-1）
            else l=mid+1;//修改左边界的值 (mid+1,r)
        }
        return -1;
    }

    //upper  找出大于target的最小索引值
    public static <E extends Comparable<E>> int upper(E[] data,E target){
        int l=0,r=data.length;
        //循环不变量 在data[l,r]范围中不断去查找target
        while (l < r) {
            int mid =l+(r-l) / 2;
            if(data[mid].compareTo(target) <= 0)
                l=mid+1;  //  （mid+1,r）
            else
                r = mid;  // (l,mid)  mid以右的都比target大  那么mid有可能是符合条件的或者是（l,mid）范围内的其他值
        }
        return l;
    }


    //> target 返回最小值索引  ceil
    //==target 返回最大索引    ceil
    public static <E extends Comparable<E>> int ceil(E[] data,E target){
        int u= upper(data,target);
        //u-1代表的就是target的值
        if(u-1>=0&&data[u-1].compareTo(target) == 0)
            return u-1;
        //否则就不存这个target值
        return u;
    }
}
