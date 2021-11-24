package com.company;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {

    Table(String[][] data, String[] headers) {
        JFrame frame = new JFrame("Testing Сollections");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(500, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable TableOfResults = new JTable(data, headers);
        JScrollPane scroll = new JScrollPane(TableOfResults);
        TableOfResults.setPreferredScrollableViewportSize(new Dimension(500, 150));
        frame.getContentPane().add(scroll);
        frame.setVisible(true);
    }
}
