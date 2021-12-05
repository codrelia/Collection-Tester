package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    CollectionsCompare test;
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
            test = new CollectionsCompare(100000);
        }
        else {
            test = new CollectionsCompare(valueOfItem);
        }
        System.out.println("The beginning of counting...");
        test.tester();
    }
}
