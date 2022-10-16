package com.licslan;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
    //O(1)<O(logn)<O(根号n)<O(n)<O(nlogn)<O(n的平方)<O(2的n次方)<O(n!)
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        System.out.println(getArray(arrayList));
    }

    private static ArrayList getArray(ArrayList array){
        HashSet hashSet = new HashSet();
        for (int i = 0; i < array.size(); i++) {
            hashSet.add(array.get(i));
        }

        ArrayList arrayList = new ArrayList(hashSet.size());
        for (Iterator it = hashSet.iterator(); it.hasNext(); ) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
