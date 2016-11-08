package test.java.ua.edu.ucu.collections;

import main.java.ua.edu.ucu.collections.Queue;
import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void constructorAndPeekTest() {
        Object testObject = "TestObject1";
        Queue testQueue = new Queue(new ImmutableLinkedList().add(testObject));
        assertEquals(testObject, testQueue.peek().toString());
    }


    @Test
    public void pushTest() {
        Object testObject = "TestObject1";
        Queue testQueue = new Queue();
        testQueue.enqueue(new ImmutableLinkedList().add(testObject));
        assertEquals(testObject, testQueue.peek().toString());
    }

    @Test
    public void dequeueTest() {
        Object testObject = "TestObject1";
        Object testObject2 = "TestObject2";
        Queue testQueue = new Queue();
        testQueue.enqueue(testObject);
        testQueue.enqueue(testObject2);
        assertEquals(testObject, testQueue.dequeue());
        assertEquals(testObject2, testQueue.peek().toString());
    }

    @Test
    public void testSomeMethod() {
    }

}
