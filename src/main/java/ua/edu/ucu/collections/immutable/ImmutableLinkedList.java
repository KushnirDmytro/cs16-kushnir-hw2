package main.java.ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList{
    LinkedListNode firstListNode;
    class LinkedListNode{
        private LinkedListNode nextNode;
        private Object data;

        LinkedListNode(){

        }

        LinkedListNode(LinkedListNode nodeExample){
            this.nextNode = nodeExample;

        }

        //private void setNextNode(LinkedListNode nextNode){
        //    this.nextNode = nextNode;
        //}

        //private void setData(Object val){
        //    this.data = val;
        //}

    }

    ImmutableLinkedList(){

    }

    //creating new instance
    // WRONG!!!

    ImmutableLinkedList(LinkedListNode firstNode){
        this.firstListNode = new LinkedListNode(firstNode);
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
            thisNode = this.firstListNode;
            while (counter != index){
                thisNode = thisNode.nextNode;
            }
            return thisNode.data;
        }
        else throw new IndexOutOfBoundsException("list has no elements with such index");
    }

    public ImmutableList remove(int index) {
        return null;
    }

    public ImmutableList set(int index, Object e) {        int counter = 0;
        LinkedListNode thisNode;
        ImmutableLinkedList newList = new ImmutableLinkedList(this.firstListNode); //initialize new list
        if (index < this.size()){
            thisNode = this.firstListNode;
            while (counter != index){
                thisNode = thisNode.nextNode;
            }
          //  thisNode.data = new ;
            return null;
        }
        else throw new IndexOutOfBoundsException("list has no elements with such index");
    }

    public int indexOf(Object e) {
        return 0;
    }

    public int size() {
        return 0;
    }

    public ImmutableList clear() {
        return null;
    }

    public boolean isEmpty() {
        if (this.firstListNode == null)
            return true;
        else return false;
    }

    public Object[] toArray() {
        return new Object[0];
    }
}
