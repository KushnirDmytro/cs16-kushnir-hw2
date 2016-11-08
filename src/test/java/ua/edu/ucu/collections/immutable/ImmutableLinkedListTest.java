package test.java.ua.edu.ucu.collections.immutable;

import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    @Test
    public void emptyConstructorTest(){
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals(testList.size(), 0);
    }

    @Test
    public void addTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableLinkedList newList = new ImmutableLinkedList();
        ImmutableLinkedList testList = newList.add(testObject);
        assertEquals("testStringIsAlsoObject", testList.toString());
    }


    @Test
    public void indexAddTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableLinkedList testList = new ImmutableLinkedList().add(testObject);
        testList.add(testObject);
        Object testObject2 = "testStringIsAlsoObject2";
        ImmutableLinkedList testList2 = testList.add(0,testObject2);
        assertEquals(testList2.toString(), "testStringIsAlsoObject2 testStringIsAlsoObject ");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void indexAddTestExeptin(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableLinkedList testList = new ImmutableLinkedList().add(testObject);
        testList.add(testObject);
        Object testObject2 = "testStringIsAlsoObject2";
        ImmutableLinkedList testList2 = testList.add(5,testObject2);
        //assertEquals(testList.toString(), "testStringIsAlsoObject ");
    }


    @Test
    public void sizeTest(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        ImmutableLinkedList testList1 = new ImmutableLinkedList().add(testObject);
        assertEquals(testList1.size(), 1);
        testList1 = testList1.add(testObject2);
        assertEquals(testList1.size(), 2);
    }

    @Test
    public void setTest(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        ImmutableLinkedList testList1 = new ImmutableLinkedList().add(testObject);
        ImmutableLinkedList testList2 = testList1.set(0, testObject2);
        assertEquals(testObject2, testList2.get(0));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void setTestExeption(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        ImmutableLinkedList testList1 = new ImmutableLinkedList().add(testObject);
        ImmutableLinkedList testList2 = testList1.set(4, testObject2);
        assertEquals(testObject2, testList2.get(1));
    }


    @Test
    public void indexOfTest(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        Object testObject3 = "testStringIsAlsoObject3";
        ImmutableLinkedList testList1 = new ImmutableLinkedList().add(testObject);
        testList1 = testList1.add(testObject2);
        assertEquals(testList1.indexOf(testObject), 0);
        assertEquals(testList1.indexOf(testObject2), 1);
        assertEquals(testList1.indexOf(testObject3), -1);
    }


    @Test
    public void clearTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableLinkedList testList1 = new ImmutableLinkedList().add(testObject);
        testList1 = testList1.clear();
        assertEquals(testList1.isEmpty(), true);
        assertEquals(testList1.size(), 0);
    }

    @Test
    public void isEmptyTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableLinkedList testList1 = new ImmutableLinkedList().add(testObject);
        assertEquals(testList1.isEmpty(), false);
        testList1 = testList1.clear();
        assertEquals(testList1.isEmpty(), true);
    }

    @Test
    public void indexAddAllTest(){
        Object [] testLinked = new Object[3];
        Object testObject = "testStringIsAlsoObject";
        for (int i  = 0 ; i < 3; i++){
            testLinked[i] = testObject;
        }
        ImmutableLinkedList testList = new ImmutableLinkedList().addAll(testLinked);
        assertEquals(testList.toString(), "testStringIsAlsoObject testStringIsAlsoObject testStringIsAlsoObject ");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void indexAddAllIndexTestExeption(){
        Object [] testLinked = new Object[3];
        Object testObject = "testStringIsAlsoObject";
        for (int i  = 0 ; i < 3; i++){
            testLinked[i] = testObject;
        }
        ImmutableLinkedList testList = new ImmutableLinkedList().addAll(3, testLinked);
        assertEquals(testList.toString(), "testStringIsAlsoObject testStringIsAlsoObject testStringIsAlsoObject ");
    }

    @Test
    public void indexAddAllIndexTest(){
        Object [] testLinked = new Object[3];
        Object testObject = "testStringIsAlsoObject";
        for (int i  = 0 ; i < 3; i++){
            testLinked[i] = testObject;
        }
        ImmutableLinkedList testList = new ImmutableLinkedList();
        testList = testList.addAll(0, testLinked);
        assertEquals("testStringIsAlsoObject testStringIsAlsoObject testStringIsAlsoObject ", testList.toString());
    }

    @Test
    public void getTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableLinkedList testList = new ImmutableLinkedList().add(testObject);
        assertEquals(testObject, testList.get(0));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getTestExeption(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableLinkedList testList = new ImmutableLinkedList().add(testObject);
        assertEquals(testList.get(4), testObject);
    }



    @Test (expected = IndexOutOfBoundsException.class)
    public void removeTestExeption(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableLinkedList testList = new ImmutableLinkedList().add(testObject);
        testList.remove(2);
    }

    @Test
    public void removeTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableLinkedList testList1 = new ImmutableLinkedList().add(testObject);
        ImmutableLinkedList testList3 = testList1;
        testList1 = testList1.add(testObject);
        ImmutableLinkedList testList2 = testList1.remove(1);
        assertEquals(testList3.toString(), testList2.toString());
    }



    @Test
    public void toArrayTest(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        Object testObject3 = "testStringIsAlsoObject3";
        Object [] testLinked = new Object[3];
        testLinked[0] = testObject;
        testLinked[1] = testObject2;
        testLinked[2] = testObject3;
        ImmutableLinkedList testList1 = new ImmutableLinkedList().add(testObject);
        testList1 = testList1.add(testObject2);
        testList1 = testList1.add(testObject3);
        int index= 0;
        Object [] testArray = testList1.toArray();
        for (Object c: testArray){
            assertEquals(c, testLinked[index]);
            ++index;
        }
    }




    @Test
    public void toStringTest(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        Object testObject3 = "testStringIsAlsoObject3";
        String testString = testObject + " " + testObject2 + " " + testObject3;
        Object [] testArray = new Object[3];
        testArray[0] = testObject;
        testArray[1] = testObject2;
        testArray[2] = testObject3;
        ImmutableLinkedList testList1 = new ImmutableLinkedList().add(testObject);
        testList1 = testList1.add(testObject2);
        testList1 = testList1.add(testObject3);
        assertEquals(testString, testList1.toString());
    }

}
