package test.java.ua.edu.ucu.collections;


import main.java.ua.edu.ucu.collections.Stack;
import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {


    @Test
    public void constructorAndPeekTest() {
        Object testObject = "TestObject1";
        Stack testStack = new Stack(new ImmutableLinkedList().add(testObject));
        assertEquals(testObject, testStack.peek().toString());
    }


    @Test
    public void pushTest() {
        Object testObject = "TestObject1";
        Stack testStack = new Stack();
        testStack.push(testObject);
        assertEquals(testObject, testStack.peek().toString());
    }

    @Test
    public void popTest() {
        Object testObject = "TestObject1";
        Object testObject2 = "TestObject2";
        Stack testStack = new Stack();
        testStack.push(testObject);
        testStack.push(testObject2);
        assertEquals(testObject2, testStack.pop());
        assertEquals(testObject, testStack.peek().toString());
    }

    @Test
    public void testSomeMethod() {
    }
    
}
