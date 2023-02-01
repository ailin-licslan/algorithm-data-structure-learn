package com.licslan.week05;

/**
 * @author licslan
 */
public interface QueueQ<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();


}
