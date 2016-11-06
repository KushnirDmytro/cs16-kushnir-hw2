package main.java.ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList{
    private final LinkedListNode headNode;
    private final int length;

    private static class LinkedListNode /*implements Cloneable */{
        LinkedListNode nextNode;
        private Object data;

        /*
        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
        */

        LinkedListNode(){
            this.nextNode = null;
        }


        LinkedListNode(LinkedListNode nodeExample){
            this.nextNode = nodeExample.nextNode;
            this.data = nodeExample.data;
        }



    }

    public int getLength(){
        LinkedListNode currentNode;
        currentNode = this.headNode;
        if ( this.isEmpty() ) return 0;
        int len = 1;
        while (currentNode.nextNode != null){
            ++len;
            currentNode = currentNode.nextNode;
        }
        return len;
    }

    public ImmutableLinkedList(){
        this.headNode = null;
        this.length = 0;
    }

    //creating new instance
    // WRONG!!!

    private ImmutableLinkedList(LinkedListNode firstNode){
        int len = 0;
        if (firstNode != null){
            LinkedListNode currentNode = firstNode; //new LinkedListNode(firstNode);
            while (currentNode.nextNode != null){
                currentNode = currentNode.nextNode;
                ++len;
            }
        }
        this.headNode = new LinkedListNode(firstNode);
        this.length = len;
    }


    public ImmutableList add(Object e) {
        return null;
    }

    public ImmutableList add(int index, Object e) {
        return null;
    }

    public ImmutableList addAll(Object[] c) {
        return null;
    }

    public ImmutableList addAll(int index, Object[] c) {
        return null;
    }

    //returns value of data-key of object with requested indx
    public Object get(int index) {
        int counter = 0;
        LinkedListNode thisNode;
        if (index < this.size()){
            thisNode = this.headNode;
            while (counter != index && thisNode.nextNode != null){
                thisNode = thisNode.nextNode;
            }
            return thisNode.data;
        }
        else throw new IndexOutOfBoundsException("list has no elements with such index");
    }

    public ImmutableList remove(int index) {
        return null;
    }

    public ImmutableList set(int index, Object e) {
        int counter = 0;

            return null;
        //}
      //  else throw new IndexOutOfBoundsException("list has no elements with such index");
    }

    public int indexOf(Object e) {
        return 0;
    }

    public int size() {
        return 0;
    }

    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    //returns true if object is empty
    public boolean isEmpty() {
        return  (this.headNode == null);
    }

    //transforms to array of objects
    public Object[] toArray() {
        LinkedListNode currentNode = headNode;
        if (this.isEmpty()){return new Object[0];}
        Object[] rez = new Object[this.getLength()];
        int i = 0;
        while (currentNode.nextNode != null){
            rez[i] = currentNode;
            currentNode = currentNode.nextNode;
        }
        return rez;
    }

    public static void main(String [] args){
        ImmutableLinkedList test_list = new ImmutableLinkedList();
        boolean test_bool = test_list.isEmpty();
        System.out.print(test_bool);
    }
}
