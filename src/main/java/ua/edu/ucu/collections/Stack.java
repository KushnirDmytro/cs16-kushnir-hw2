package main.java.ua.edu.ucu.collections;

import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    ImmutableLinkedList list;

    public Stack(){
        list = new ImmutableLinkedList();
    }

    public Stack(Object el){
        list = new ImmutableLinkedList().add(el);
    }

    public Object peek (){
        return this.list.getLast();
    }

    public Object pop(){
        Object rez = this.list.getLast();
        this.list = this.list.removeLast();
        return rez;
    }

    public void push(Object e){
        this.list = this.list.addLast(e);
    }
}
