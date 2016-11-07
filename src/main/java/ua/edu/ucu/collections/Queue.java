package main.java.ua.edu.ucu.collections;

import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList list;
    public Queue(){
        list = new ImmutableLinkedList();
    }

    public Queue(Object el){
        list = new ImmutableLinkedList().add(el);
    }

    public Object peek (){
        return this.list.getFirst();
    }

    public Object dequeue(){
        Object rez = this.list.getFirst();
        this.list.removeFirst();
        return rez;
    }

    public void enqueue(Object e){
        this.list.addLast(e);
    }
}
