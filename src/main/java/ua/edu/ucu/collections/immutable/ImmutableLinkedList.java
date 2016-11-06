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
            this.data = null;
        }
        LinkedListNode(Object data){
            this.data = data;
        }

        private  void setData(Object newData){
            this.data = newData;
        }
        private  void setNextNode(LinkedListNode newNextNode){
            this.nextNode = newNextNode;
        }

        LinkedListNode(LinkedListNode nodeExample){
            this.nextNode = nodeExample.nextNode;
            this.data = nodeExample.data;
        }



    }

    public int size(){
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


    private LinkedListNode getLastNode(){
        LinkedListNode currentNode = this.headNode;
        while (currentNode.nextNode != null){
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    public ImmutableLinkedList add(Object e) {
        if (this.isEmpty()) {
            return new ImmutableLinkedList(new LinkedListNode(e));
        }
        LinkedListNode currentNewNode = new LinkedListNode(this.headNode.data);
        LinkedListNode newHeadNode = currentNewNode;
        LinkedListNode currentOldNode = this.headNode;
            while (currentOldNode.nextNode != null) {
                currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
                currentNewNode = currentNewNode.nextNode;
                currentOldNode = currentOldNode.nextNode;
            }
        currentNewNode.nextNode = new LinkedListNode(e);
        return new ImmutableLinkedList(newHeadNode);
    }


    public ImmutableLinkedList add(int index, Object e) {
        if (index >= this.length - 1 || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if (this.isEmpty()) {
            return new ImmutableLinkedList(new LinkedListNode(e));
        }
        int currentIndex = 0;
        LinkedListNode currentNewNode = new LinkedListNode(this.headNode.data);
        LinkedListNode newHeadNode = currentNewNode;
        LinkedListNode currentOldNode = this.headNode;
        while (currentOldNode.nextNode != null) {
            if (index == currentIndex){
                currentNewNode.nextNode = new LinkedListNode(e);
                currentNewNode = currentNewNode.nextNode;
            }
            currentIndex++;
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
        }
        currentNewNode.nextNode = new LinkedListNode(e);
        return new ImmutableLinkedList(newHeadNode);
    }

    public ImmutableList addAll(Object[] c) {
        LinkedListNode currentNewNode = new LinkedListNode(this.headNode.data);
        LinkedListNode newHeadNode = currentNewNode;
        LinkedListNode currentOldNode = this.headNode;
        if (this.isEmpty()) {
            for (Object element :c){
                currentNewNode.nextNode = new LinkedListNode(element);
                currentNewNode = currentNewNode.nextNode;
            }
            return new ImmutableLinkedList(newHeadNode);
        }
        while (currentOldNode.nextNode != null) {
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
        }
        for (Object element :c){
            currentNewNode.nextNode = new LinkedListNode(element);
            currentNewNode = currentNewNode.nextNode;
        }
        return new ImmutableLinkedList(newHeadNode);
    }

    public ImmutableList addAll(int index, Object[] c) {
        if (index >= this.length - 1 || index < 0){
            throw new IndexOutOfBoundsException();
        }
        LinkedListNode currentNewNode = new LinkedListNode(this.headNode.data);
        LinkedListNode newHeadNode = currentNewNode;
        LinkedListNode currentOldNode = this.headNode;
        if (this.isEmpty()) {
            return addAll(c);
        }
        int currentIndex = 0;
        while (currentOldNode.nextNode != null) {
            if (index == currentIndex){
                for (Object element :c){
                    currentNewNode.nextNode = new LinkedListNode(element);
                    currentNewNode = currentNewNode.nextNode;
                }
            }
            currentIndex++;
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
        }
        return new ImmutableLinkedList(newHeadNode);
    }

    //returns value of data-key of object with requested indx
    public Object get(int index) {
        if (this.size() < index || index < 0) {
            throw new IndexOutOfBoundsException("list has no elements with such index");
        }
        int counter = 0;
        LinkedListNode currentNode;

            currentNode = this.headNode;
            while (counter != index && currentNode.nextNode != null){
                currentNode = currentNode.nextNode;
                counter ++;
            }

        return currentNode.data;
    }

    public ImmutableList remove(int index) {
        if (index >= this.size() - 1 || index < 0){
        throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        LinkedListNode currentNewNode = new LinkedListNode(this.headNode.data);
        LinkedListNode newHeadNode = currentNewNode;
        LinkedListNode currentOldNode = this.headNode;
        while (currentOldNode.nextNode != null) {
            if (index == currentIndex){
                currentOldNode = currentOldNode.nextNode;
            }
            currentIndex++;
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
        }
        return new ImmutableLinkedList(newHeadNode);
    }

    public ImmutableList set(int index, Object e) {
        return null;
    }

    public int indexOf(Object e) {
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
        Object[] rez = new Object[this.size()];
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
        System.out.println(test_bool);
        int size = test_list.size();
        System.out.println(size);
        test_list = test_list.add("newNode");
        size = test_list.size();
        System.out.println(size);

        test_list = test_list.add("newNode");
        size = test_list.size();
        System.out.println(size);

        ImmutableLinkedList test_list2 = test_list.add("newNode2");
        size = test_list2.size();

        System.out.println(size);
        size = test_list.size();
        System.out.println(test_list2.isEmpty());


        System.out.println(test_list.getLastNode().data);
        System.out.println(test_list2.getLastNode().data);
    }
}
