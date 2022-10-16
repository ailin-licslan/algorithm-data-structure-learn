package com.licslan.interview;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("foo");
        List<String> list2 = list1;

        List<String> list3 = new ArrayList<>(list2);
        list1.clear();
        list2.add("bar");
        list3.add("baz");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        System.out.println("==============");
        //Collection<String> collection = new ArrayDeque<>();
        Collection<String> collection = new ArrayList<>();
        collection.add("foo");
        collection.add("bar");
        collection.add("baz");

        collection.forEach(System.out::println);


        System.out.println("-----------------");

        Integer myArray[] = {2, 3, 1};
        
        List<Integer> list = Arrays.asList(2, 3, 1);
        list.sort(new Sorting());
        System.out.println(list);


        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        stack.push("Apple");
        stack.push("Banna");
        stack.push("Chery");
        ((LinkedList<String>) queue).add(stack.pop());
        stack.push("Diinnn");
        stack.push("Eddfa");
        ((LinkedList<String>) queue).add("Fig");
        stack.push(queue.remove());
        ((LinkedList<String>) queue).add(stack.pop());
        ((LinkedList<String>) queue).add(stack.pop());

        System.out.println(stack);
        System.out.println(queue);

        String x = "abc";
        String y = "abc";
        x.concat(y);
        System.out.println(x);

        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String(s1);
        System.out.println(s1 == s2);
        System.out.println(s1 = s2);
        System.out.println(s3 == s1);
        System.out.println(s3 = s1);
        System.out.println(s1 != s2);


    }

    static class Sorting implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }


    class Super {
        void foo() {
            System.out.println("Super");
        }
    }

    class Subclass extends Super {
        void fooTest() {
            System.out.println();
        }
    }
}
