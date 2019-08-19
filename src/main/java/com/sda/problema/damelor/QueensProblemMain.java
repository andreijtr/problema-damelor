package com.sda.problema.damelor;

public class QueensProblemMain {

    public static void main(String[] args) throws QueenException {

        SolveQueensProblem solver = new SolveQueensProblem(5);

        QueensProblemPrinter printer = new QueensProblemPrinter();

        int[][] queens = solver.findSolution();

        printer.printTable(queens);
    }
}
