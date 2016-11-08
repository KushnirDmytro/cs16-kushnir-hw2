package main.java.ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] array;
    //private final int size;

    public ImmutableArrayList(){
        array = new Object[0];
    }

    private ImmutableArrayList(Object[] array){
        this.array = new Object[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        //size = array.length;
    }


    public ImmutableArrayList add(Object e) {
        Object [] newArray = new Object[this.size() + 1];
        System.arraycopy(this.array, 0, newArray, 0, this.size());
        newArray[newArray.length -1] = e;
        return new ImmutableArrayList(newArray);
    }

    public ImmutableArrayList add(int index, Object e) {
        if (index > this.size() - 1 || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Object [] newArray = new Object[this.size() + 1];
        System.arraycopy(this.array, 0, newArray, 0, index);
        newArray[index] = e;
        System.arraycopy(this.array, index, newArray, index+1, this.size() - index);
        return new ImmutableArrayList(newArray);
    }

    public ImmutableArrayList addAll(Object[] c) {
        if (this.isEmpty()){
            return new ImmutableArrayList(c);
        }
        Object [] newArray = new Object[this.size() + c.length];
        System.arraycopy(this.array, 0, newArray, 0, this.size());
        System.arraycopy(c, 0, newArray, this.size() -1, c.length);
        return new ImmutableArrayList(newArray);
    }

    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index > this.size() -1|| index < 0){
            if (index == 0){
                ImmutableArrayList newList = new ImmutableArrayList();
                for (Object k:c){
                    newList = newList.add(k);
                }
                return newList;
            }
            throw new IndexOutOfBoundsException();
        }
        if (this.isEmpty()){ //if get to this case -> index == 0
            return new ImmutableArrayList().addAll(c);
        }
        Object [] newArray = new Object[this.size() + c.length];
        System.arraycopy(this.array, 0, newArray, 0, index + 1);
        System.arraycopy(c, 0, newArray, index + 1, c.length);
        System.arraycopy(this.array, index + 1, newArray, index + 1 + c.length, this.size() - (index + 1) );
        return new ImmutableArrayList(newArray);
    }

    public Object get(int index) {
        if (index > this.size() - 1 || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    public ImmutableArrayList remove(int index) {
        if (index > this.size() - 1 || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Object [] newArray = new Object[this.size() - 1];
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(this.array, index + 1, newArray, index, this.size() - index - 1);
        return new ImmutableArrayList(newArray);
    }

    public ImmutableArrayList set(int index, Object e) {
        if (index > this.size() - 1 || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Object [] newArray = new Object[this.size()];
        System.arraycopy(this.array, 0, newArray, 0, this.size());
        newArray[index] = e; // simple way :-)
        return new ImmutableArrayList(newArray);
    }

    public int indexOf(Object e) {
        int counter = 0;
        for (Object c:this.array){
            if (c.equals(e)){
                return counter;
            }
            ++counter;
        }
        return -1;
    }

    public int size() {
        return this.array.length;
    }

    public ImmutableArrayList clear() {
        return new ImmutableArrayList(new Object [0]);
    }

    public boolean isEmpty() {
        return  ( (this.size() == 0) || this.array == null);
    }

    public Object[] toArray() {
        Object [] newArray = new Object[this.size()];
        System.arraycopy(this.array, 0, newArray, 0, this.size());
        return  newArray;
    }

    @Override
    public String toString(){
        StringBuilder stB = new StringBuilder();
        if (this.isEmpty()){return "";}
        for (Object c:this.array){
            stB.append(c.toString());
            stB.append(" ");
        }
        return stB.toString();
    }


}
