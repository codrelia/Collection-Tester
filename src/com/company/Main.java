package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    CollectionsTest test;
        int valueOfItem = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the ArrayList and LinkedList you are interested in. " +
                "\nEnter a negative number to leave the default values.");
        while (!scanner.hasNextInt()) {
            System.out.println("Please, enter only integer!");
            scanner.next();
        }
        valueOfItem = scanner.nextInt();
        if (valueOfItem <= 0) {
            System.out.println("The default value is 100000.\n");
            test = new CollectionsTest(100000);
        }
        else {
            test = new CollectionsTest(valueOfItem);
        }
        System.out.println("The beginning of counting...");
        test.addTest();
        test.getTest();
        test.deleteTest();
        String[][] table = test.getTable();
        String[] head = new String[3];
        head[0] = " ";
        head[1] = "ArrayList";
        head[2] = "LinkedList";
        Table tableUi = new Table(table, head);
    }
}
