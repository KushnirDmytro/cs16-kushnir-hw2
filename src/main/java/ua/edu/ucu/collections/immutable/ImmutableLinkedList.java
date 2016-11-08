package main.java.ua.edu.ucu.collections.immutable;

import java.util.EmptyStackException;

public class ImmutableLinkedList implements ImmutableList {
    private final LinkedListNode headNode;
    private final int length;

    private static class LinkedListNode /*implements Cloneable */ {
        LinkedListNode nextNode;
        Object data;

        /*
        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
        */

        LinkedListNode() {
            this.nextNode = null;
            this.data = null;
        }

        LinkedListNode(Object data) {
            this.data = data;
        }

        LinkedListNode(LinkedListNode node_to_copy) {
            this.data = node_to_copy.data;
            this.nextNode = node_to_copy.nextNode;
        }

        private void setData(Object newData) {
            this.data = newData;
        }

        private void setNextNode(LinkedListNode newNextNode) {
            this.nextNode = newNextNode;
        }


    }

    public int size() {
        LinkedListNode currentNode;
        currentNode = this.headNode;
        if (this.isEmpty()) return 0;
        int len = 1;
        while (currentNode.nextNode != null) {
            ++len;
            currentNode = currentNode.nextNode;
        }
        return len;
    }

    public ImmutableLinkedList() {
        this.headNode = null;
        this.length = 0;
    }

    //creating new instance
    // WRONG!!!

    private ImmutableLinkedList(LinkedListNode firstNode) {
        int len = 0;
        LinkedListNode newHeadNode;
        if (firstNode != null) {
            //LinkedListNode currentNode = firstNode; //new LinkedListNode(firstNode);
            LinkedListNode currentNode = new LinkedListNode(firstNode);
            newHeadNode = currentNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
                ++len;
            }
        } else {
            throw new NullPointerException();
        }
        this.headNode = new LinkedListNode(newHeadNode);
        this.length = len + 1;
    }


    private LinkedListNode getLastNode() {
        LinkedListNode currentNode = this.headNode;
        while (currentNode.nextNode != null) {
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
        if (index > this.size() - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        int currentIndex = 0;
        LinkedListNode currentNewNode;
        LinkedListNode currentOldNode = this.headNode;
        LinkedListNode newHeadNode = null;
        if (index == 0) {
            currentNewNode = new LinkedListNode(e);
            newHeadNode = currentNewNode;
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
            currentIndex++;
        } else {
            currentNewNode = new LinkedListNode(currentOldNode.data);
            currentIndex++;
        }
        if (newHeadNode == null) {
            newHeadNode = currentNewNode;
        }
        while (currentOldNode != null && currentOldNode.nextNode != null) {
            if (currentIndex == index) {
                currentNewNode.nextNode = new LinkedListNode(e);
                currentNewNode = currentNewNode.nextNode;
                currentIndex++;
            }
            currentIndex++;
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
        }
        if (index == currentIndex) {
            currentNewNode.nextNode = new LinkedListNode(e);
        }
        return new ImmutableLinkedList(newHeadNode);
    }

    public ImmutableLinkedList addAll(Object[] c) {
        LinkedListNode currentOldNode;
        LinkedListNode currentNewNode;
        LinkedListNode newHeadNode;
        if (this.isEmpty()) {
            currentNewNode = new LinkedListNode(c[0]);
            newHeadNode = currentNewNode;
            if (c.length > 1) {
                for (int i = 1; i < c.length; i++) {
                    currentNewNode.nextNode = new LinkedListNode(c[i]);
                    currentNewNode = currentNewNode.nextNode;
                }
            }
            return new ImmutableLinkedList(newHeadNode);
        }
        currentOldNode = this.headNode;
        currentNewNode = new LinkedListNode(currentOldNode);
        newHeadNode = currentNewNode;
        while (currentOldNode.nextNode != null) {
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
        }
        for (Object element : c) {
            currentNewNode.nextNode = new LinkedListNode(element);
            currentNewNode = currentNewNode.nextNode;
        }
        return new ImmutableLinkedList(newHeadNode);
    }

    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (index > this.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (this.isEmpty()) {
            return addAll(c);
        }
        LinkedListNode currentOldNode = this.headNode;
        LinkedListNode currentNewNode = new LinkedListNode(currentOldNode);
        LinkedListNode newHeadNode = currentNewNode;
        int currentIndex = 0;
        while (currentIndex < index - 1 && currentOldNode.nextNode != null) {
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
            currentIndex++;
        }
        for (Object element : c) {
            currentNewNode.nextNode = new LinkedListNode(element);
            currentNewNode = currentNewNode.nextNode;
        }
        while (currentOldNode.nextNode != null) {
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
        }
        return new ImmutableLinkedList(newHeadNode);
    }

    //returns value of data-key of object with requested indx
    public Object get(int index) {
        if (index > this.length - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        LinkedListNode currentOldNode = this.headNode;
        do {
            if (index == currentIndex) {
                return currentOldNode.data;
            }
            currentIndex++;
            currentOldNode = currentOldNode.nextNode;
        } while (currentOldNode.nextNode != null);
        return null;
    }

    public ImmutableLinkedList remove(int index) {
        if (index > this.size() - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        int currentIndex = 0;
        LinkedListNode currentNewNode;
        LinkedListNode currentOldNode = this.headNode;
        if (index == 0) {
            if (currentOldNode.nextNode != null) {
                currentOldNode = currentOldNode.nextNode;
                currentIndex++;
            } else {
                return new ImmutableLinkedList();
            }
        }
        currentNewNode = new LinkedListNode(currentOldNode.data);
        LinkedListNode newHeadNode = currentNewNode;
        while (currentOldNode.nextNode != null) {
            if (currentIndex == index - 1) {
                currentOldNode = currentOldNode.nextNode; //one step forward
            }
            if (currentOldNode.nextNode != null) {
                currentIndex++;
                currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
                currentNewNode = currentNewNode.nextNode;
                currentOldNode = currentOldNode.nextNode;
            }
        }
        return new ImmutableLinkedList(newHeadNode);
    }


    public ImmutableLinkedList set(int index, Object e) {
        if (index > this.size() - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        int currentIndex = 0;
        LinkedListNode currentNewNode;
        LinkedListNode currentOldNode = this.headNode;
        LinkedListNode newHeadNode;
        if (index == 0) {
            if (currentOldNode.nextNode != null) {
                currentOldNode = currentOldNode.nextNode;
                currentNewNode = new LinkedListNode(e);
            } else {
                return new ImmutableLinkedList(new LinkedListNode(e));
            }
        } else {
            currentNewNode = new LinkedListNode(currentOldNode.data);
        }
        newHeadNode = currentNewNode;
        while (currentOldNode.nextNode != null) {
            if (currentIndex == index - 1) {
                currentOldNode = currentOldNode.nextNode; //one step forward
                currentNewNode.nextNode = new LinkedListNode(e);
                currentNewNode = currentNewNode.nextNode;
                continue;
            }
            currentIndex++;
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
        }
        return new ImmutableLinkedList(newHeadNode);
    }

    //returns -1 if no element found
    public int indexOf(Object e) {
        if (this.isEmpty()) {
            throw new NullPointerException();
        }
        int currentIndex = 0;
        LinkedListNode currentOldNode = this.headNode;
        while (currentOldNode.nextNode != null) {
            if (currentOldNode.data.equals(e)) {
                return currentIndex;
            }
            currentIndex++;
            currentOldNode = currentOldNode.nextNode;
        }
        if (currentOldNode.data.equals(e)) {
            return currentIndex;
        }
        return -1;
    }

    public ImmutableLinkedList addFirst(Object e) {
        if (this.isEmpty()) {
            return new ImmutableLinkedList(new LinkedListNode(e));
        }
        LinkedListNode currentNewNode = new LinkedListNode(e);
        LinkedListNode newHeadNode = currentNewNode;
        currentNewNode.nextNode = new LinkedListNode(this.headNode.data);
        currentNewNode = currentNewNode.nextNode;
        LinkedListNode currentOldNode = this.headNode;
        while (currentOldNode.nextNode != null) {
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
        }
        return new ImmutableLinkedList(newHeadNode);
    }

    public ImmutableLinkedList addLast(Object e) {
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

    public Object getLast() {
        if (this.isEmpty()) {
            return null;
        }
        LinkedListNode currentOldNode = this.headNode;
        while (currentOldNode.nextNode != null) {
            currentOldNode = currentOldNode.nextNode;
        }
        return currentOldNode.data;
    }

    public Object getFirst() {
        if (this.isEmpty()) {
            return null;
        }
        return this.headNode.data;
    }


    public ImmutableLinkedList removeFirst() {
        return this.remove(0);
    }// - видаляє перший елемент

    public ImmutableLinkedList removeLast() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        if (this.size() == 1) {
            return new ImmutableLinkedList(new LinkedListNode());
        }
        LinkedListNode currentOldNode = this.headNode;
        LinkedListNode currentNewNode = new LinkedListNode(currentOldNode.data);
        LinkedListNode newHeadNode = currentNewNode;
        while (currentOldNode.nextNode.nextNode != null) {
            currentNewNode.nextNode = new LinkedListNode(currentOldNode.nextNode.data);
            currentNewNode = currentNewNode.nextNode;
            currentOldNode = currentOldNode.nextNode;
        }
        return new ImmutableLinkedList(newHeadNode);
    }// - видаляє останній елемент


    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    //returns true if object is empty
    public boolean isEmpty() {
        return (this.headNode == null);
    }

    //transforms to array of objects
    public Object[] toArray() {
        LinkedListNode currentNode = headNode;
        if (this.isEmpty()) {
            return new Object[0];
        }
        Object[] rez = new Object[this.size()];
        int i = 0;
        while (currentNode.nextNode != null) {
            rez[i++] = currentNode.data;
            currentNode = currentNode.nextNode;
        }
        rez[i] = currentNode.data;
        return rez;
    }

    @Override
    public String toString() {
        LinkedListNode currentNode = headNode;
        StringBuilder stB = new StringBuilder();
        if (this.isEmpty()) {
            return "";
        }
        while (currentNode.nextNode != null) {
            stB.append(currentNode.data.toString());
            stB.append(" ");
            currentNode = currentNode.nextNode;
        }
        stB.append(currentNode.data.toString());
        return stB.toString();
    }
}
