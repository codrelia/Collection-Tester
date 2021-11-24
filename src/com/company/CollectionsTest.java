package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 * A class that is designed to test two collections: ArrayList and LinkedList.
 * Calculates the execution time of three main methods: add, get and delete.
 *
 * @author Dasha Shevchenko
 */
public class CollectionsTest {
    /**
     * An object of type ArrayList.
     */
    private ArrayList<Double> arrayList;
    /**
     * An object of type LinkedList.
     */
    private LinkedList<Double> linkedList;
    /**
     * ArrayList Size.
     */
    private int sizeOfArrayList;
    /**
     * LinkedList Size.
     */
    private int sizeOfLinkedList;
    /**
     * A two-dimensional array that stores the results of each of the objects
     * and the current method that we performed.
     */
    private String[][] table;

    /**
     * Initializer of the class. Sets all variables to the required values.
     * @param size The size of the collections.
     */
    public CollectionsTest(int size){
        sizeOfArrayList = size;
        sizeOfLinkedList = size;
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        table = new String[3][3];
    }

    /**
     * @return Returns a table with results.
     */
    public String[][] getTable() {
        return table;
    }

    /**
     * Sets tabular values. The first column is the method being called,
     * the second column is for ArrayList, and the third column is for LinkedList.
     * @param testMethod The method under test
     * @param timeForArray The result of ArrayList
     * @param timeForLinked The result of LinkedList
     * @param index The line where the current data should be inserted.
     */
    private void tableConfigure(String testMethod, long timeForArray, long timeForLinked, int index) {
        table[index][0] = testMethod;
        table[index][1] = Long.toString(timeForArray) + " мс";
        table[index][2] = Long.toString(timeForLinked) + " мс";
    }

    /**
     * Testing the addition method. Marks the start and end times, and then subtracts one from the
     * other. Adds as many items as specified in size for each collection.
     */
    public void addTest() {
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < sizeOfArrayList; i++) {
            arrayList.add(Math.random() * 1001);
        }
        long timeEnd = System.currentTimeMillis();
        long timeForArray = timeEnd - timeStart;

        timeStart = System.currentTimeMillis();
        for(int i = 0; i < sizeOfLinkedList; i++) {
            linkedList.add(Math.random() * 1001);
        }
        timeEnd = System.currentTimeMillis();
        long timeForLinked = timeEnd - timeStart;
        tableConfigure(" Method Add ", timeForArray, timeForLinked, 0);
    }

    /**
     * Testing the deleting method. Marks the start and end times, and then subtracts one from the
     * other. Deletes as many items as specified in size for each collection.
     */
    public void deleteTest() {
        long timeStart = System.currentTimeMillis();
        for(int i = sizeOfArrayList - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        long timeEnd = System.currentTimeMillis();
        long timeForArray = timeEnd - timeStart;

        timeStart = System.currentTimeMillis();
        for(int i = sizeOfArrayList - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        timeEnd = System.currentTimeMillis();
        long timeForLinked = timeEnd - timeStart;
        tableConfigure(" Method Delete ", timeForArray, timeForLinked, 2);
    }

    /**
     * Testing the getting method. Marks the start and end times, and then subtracts one from the
     * other. Gets as many items as specified in size for each collection.
     */
    public void getTest() {
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < sizeOfArrayList; i++) {
            arrayList.get(i);
        }
        long timeEnd = System.currentTimeMillis();
        long timeForArray = timeEnd - timeStart;

        timeStart = System.currentTimeMillis();
        for(int i = 0; i < sizeOfLinkedList; i++) {
            linkedList.get(i);
        }
        timeEnd = System.currentTimeMillis();
        long timeForLinked = timeEnd - timeStart;
        tableConfigure(" Method Get ", timeForArray, timeForLinked, 1);
    }

    /**
     * Redefining the comparison method.
     * @param o The parameter that is submitted for comparison.
     * @return true if the objects are equal and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionsTest that = (CollectionsTest) o;
        return sizeOfArrayList == that.sizeOfArrayList && sizeOfLinkedList == that.sizeOfLinkedList && Objects.equals(arrayList, that.arrayList) && Objects.equals(linkedList, that.linkedList);
    }

    /**
     * Counts the hashcode of the current object.
     * @return hash code.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hash += Integer.parseInt(table[i][i]);
            }
        }
        return hash;
    }
}
