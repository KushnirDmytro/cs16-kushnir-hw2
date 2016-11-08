package test.java.ua.edu.ucu.collections.immutable;

import main.java.ua.edu.ucu.collections.immutable.ImmutableArrayList;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test //(expected = NullPointerException.class)
    public void emptyConstructorTest(){
        ImmutableArrayList testList = new ImmutableArrayList();
        assertEquals(testList.size(), 0);
    }

    @Test
    public void addTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableArrayList testList = new ImmutableArrayList().add(testObject);
        assertEquals(testList.toString(), "testStringIsAlsoObject ");
    }


    @Test
    public void indexAddTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableArrayList testList = new ImmutableArrayList().add(testObject);
        testList.add(testObject);
        Object testObject2 = "testStringIsAlsoObject2";
        ImmutableArrayList testList2 = testList.add(0,testObject2);
        assertEquals(testList2.toString(), "testStringIsAlsoObject2 testStringIsAlsoObject ");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void indexAddTestExeptin(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableArrayList testList = new ImmutableArrayList().add(testObject);
        testList.add(testObject);
        Object testObject2 = "testStringIsAlsoObject2";
        ImmutableArrayList testList2 = testList.add(5,testObject2);
        //assertEquals(testList.toString(), "testStringIsAlsoObject ");
    }


    @Test
    public void sizeTest(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        ImmutableArrayList testList1 = new ImmutableArrayList().add(testObject);
        assertEquals(testList1.size(), 1);
        testList1 = testList1.add(testObject2);
        assertEquals(testList1.size(), 2);
    }

    @Test
    public void setTest(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        ImmutableArrayList testList1 = new ImmutableArrayList().add(testObject);
        ImmutableArrayList testList2 = testList1.set(0, testObject2);
        assertEquals(testObject2, testList2.get(0));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void setTestExeption(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        ImmutableArrayList testList1 = new ImmutableArrayList().add(testObject);
        ImmutableArrayList testList2 = testList1.set(4, testObject2);
        assertEquals(testObject2, testList2.get(1));
    }


    @Test
    public void indexOfTest(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        Object testObject3 = "testStringIsAlsoObject3";
        ImmutableArrayList testList1 = new ImmutableArrayList().add(testObject);
        testList1 = testList1.add(testObject2);
        assertEquals(testList1.indexOf(testObject), 0);
        assertEquals(testList1.indexOf(testObject2), 1);
        assertEquals(testList1.indexOf(testObject3), -1);
    }


    @Test
    public void clearTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableArrayList testList1 = new ImmutableArrayList().add(testObject);
        testList1 = testList1.clear();
        assertEquals(testList1.isEmpty(), true);
        assertEquals(testList1.size(), 0);
    }

    @Test
    public void isEmptyTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableArrayList testList1 = new ImmutableArrayList().add(testObject);
        assertEquals(testList1.isEmpty(), false);
        testList1 = testList1.clear();
        assertEquals(testList1.isEmpty(), true);
    }

    @Test
    public void indexAddAllTest(){
        Object [] testArray = new Object[3];
        Object testObject = "testStringIsAlsoObject";
        for (int i  = 0 ; i < 3; i++){
            testArray[i] = testObject;
        }
        ImmutableArrayList testList = new ImmutableArrayList().addAll(testArray);
        assertEquals(testList.toString(), "testStringIsAlsoObject testStringIsAlsoObject testStringIsAlsoObject ");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void indexAddAllIndexTestExeption(){
        Object [] testArray = new Object[3];
        Object testObject = "testStringIsAlsoObject";
        for (int i  = 0 ; i < 3; i++){
            testArray[i] = testObject;
        }
        ImmutableArrayList testList = new ImmutableArrayList().addAll(3, testArray);
        assertEquals(testList.toString(), "testStringIsAlsoObject testStringIsAlsoObject testStringIsAlsoObject ");
    }

    @Test
    public void indexAddAllIndexTest(){
        Object [] testArray = new Object[3];
        Object testObject = "testStringIsAlsoObject";
        for (int i  = 0 ; i < 3; i++){
            testArray[i] = testObject;
        }
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.addAll(0, testArray);
        assertEquals("testStringIsAlsoObject testStringIsAlsoObject testStringIsAlsoObject ", testList.toString());
    }

    @Test
    public void getTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableArrayList testList = new ImmutableArrayList().add(testObject);
        assertEquals(testList.get(0), testObject);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getTestExeption(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableArrayList testList = new ImmutableArrayList().add(testObject);
        assertEquals(testList.get(4), testObject);
    }



    @Test (expected = IndexOutOfBoundsException.class)
    public void removeTestExeption(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableArrayList testList = new ImmutableArrayList().add(testObject);
        testList.remove(2);
    }

    @Test
    public void removeTest(){
        Object testObject = "testStringIsAlsoObject";
        ImmutableArrayList testList1 = new ImmutableArrayList().add(testObject);
        ImmutableArrayList testList3 = testList1;
        testList1 = testList1.add(testObject);
        ImmutableArrayList testList2 = testList1.remove(1);
        assertEquals(testList3.toString(), testList2.toString());
    }



    @Test
    public void toArrayTest(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        Object testObject3 = "testStringIsAlsoObject3";
        Object [] testArray = new Object[3];
        testArray[0] = testObject;
        testArray[1] = testObject2;
        testArray[2] = testObject3;
        ImmutableArrayList testList1 = new ImmutableArrayList().add(testObject);
        testList1 = testList1.add(testObject2);
        testList1 = testList1.add(testObject3);
        int index= 0;
        for (Object c: testList1.toArray()){
            assertEquals(testArray[index], c);
            ++index;
        }
    }




    @Test
    public void toStringTest(){
        Object testObject = "testStringIsAlsoObject";
        Object testObject2 = "testStringIsAlsoObject2";
        Object testObject3 = "testStringIsAlsoObject3";
        String testString = testObject + " " + testObject2 + " " + testObject3 + " ";
        Object [] testArray = new Object[3];
        testArray[0] = testObject;
        testArray[1] = testObject2;
        testArray[2] = testObject3;
        ImmutableArrayList testList1 = new ImmutableArrayList().add(testObject);
        testList1 = testList1.add(testObject2);
        testList1 = testList1.add(testObject3);
        assertEquals(testList1.toString(), testString);
    }

    /*

    */
    @Test
    public void testSomeMethod() {
    }
    
}
