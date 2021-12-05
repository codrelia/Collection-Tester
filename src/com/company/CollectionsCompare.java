package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A class that is designed to test two collections: ArrayList and LinkedList.
 * Calculates the execution time of three main methods: add, get and delete.
 *
 * @author Dasha Shevchenko
 */
public class CollectionsCompare {
    /**
     * ArrayList and LinkedList Size.
     */
    private int sizeOfLists;
    /**
     * A two-dimensional array that stores the results of each of the objects
     * and the current method that we performed.
     */
    private String[][] table;

    /**
     * Initializer of the class. Sets all variables to the required values.
     * @param size The size of the collections.
     */
    public CollectionsCompare(int size){
        sizeOfLists = size;
        table = new String[][]{{"Add", "0", "0"}, {"Get", "0", "0"}, {"Remove", "0", "0"}};
    }

    /**
     * Getting the table with results
     * @return Returns a table with results.
     */
    public String[][] getTable() {
        return table;
    }

    /**
     * Sets tabular values.
     * The second column is for ArrayList, and the third column is for LinkedList.
     * @param timeArray The result of ArrayList
     * @param timeLink The result of LinkedList
     * @param indexRow The line where the current data should be inserted.
     */
    private void tableConfigure(int indexRow, long timeArray, long timeLink) {
        table[indexRow][1] = Long.toString(timeArray) + " мс";
        table[indexRow][2] = Long.toString(timeLink) + " мс";
    }

    /**
     * The main method that calls the tested methods and the method that writes the result to the table
     */
    public void tester() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        tableConfigure(0, addTest(arrayList), addTest(linkedList));
        tableConfigure(1, getTest(arrayList), getTest(linkedList));
        tableConfigure(2, removeTest(arrayList), removeTest(linkedList));
        displayTheTable();
    }

    /**
     * Testing the addition method. Marks the start and end times, and then subtracts one from the
     * other. Adds as many items as specified in size for each collection.
     */
    private long addTest(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < sizeOfLists; i++) {
            list.add((int) (Math.random() * 1001));
        }
        return System.currentTimeMillis() - timeStart;
    }

    /**
     * Testing the deleting method. Marks the start and end times, and then subtracts one from the
     * other. Deletes as many items as specified in size for each collection.
     */
    private long removeTest(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        for(int i = sizeOfLists - 1; i >= 0; i--) {
            list.remove(i);
        }
        return System.currentTimeMillis() - timeStart;
    }

    /**
     * Testing the getting method. Marks the start and end times, and then subtracts one from the
     * other. Gets as many items as specified in size for each collection.
     */
    private long getTest(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < sizeOfLists; i++) {
            list.get(i);
        }
        return System.currentTimeMillis() - timeStart;
    }

    /**
     * Displaying a table with the results on the screen
     */
    private void displayTheTable() {
        JFrame frame = new JFrame("Testing Сollections");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(500, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable TableOfResults = new JTable(table, new String[]{"", "ArrayList", "LinkedList"});
        JScrollPane scroll = new JScrollPane(TableOfResults);
        TableOfResults.setPreferredScrollableViewportSize(new Dimension(500, 150));
        frame.getContentPane().add(scroll);
        frame.setVisible(true);
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
        CollectionsCompare that = (CollectionsCompare) o;
        return sizeOfLists == that.sizeOfLists;
    }

    /**
     * Counts the hashcode of the current object.
     * @return hash code.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                hash += Integer.parseInt(table[i][i]);
            }
        }
        return hash;
    }
}
