package com.sda.problema.damelor;

public class QueensProblemPrinter {

    public void printTable (int[][] table) {

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
