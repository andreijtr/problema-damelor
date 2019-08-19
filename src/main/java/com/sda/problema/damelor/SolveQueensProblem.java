package com.sda.problema.damelor;

import java.util.Arrays;

public class SolveQueensProblem {

    private int size;

    public SolveQueensProblem(int size) {
        this.size = size;
    }

    public int[][] findSolution () throws QueenException {

        if (size < 4) {
            throw new QueenException("Size of table must be greater than or equal to 4.");
        }

        int[][] table = new int[size][size];

        //initialize table with 0 value every position
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = 0;
            }
        }

        //in this array will keep the previous positions where queens was placed
        //if can't find any place in a row, go back to last place using positions[] and move that queen from that column(not from
        // 0 because these places was already ckeched) to right to end of the row. If there is no good solution, go back another
        //position and move that queen further. when decide to come back to a queen, make the position from actual queen back 0
        //so at next search program will consider all the row
        Position[] positions = new Position[size];

        //index will parse the rows, on every row will place one queen
        int index = 0;

        while (index < size) {
            //j will parse column for every row
            int j;

            //if for row index is no position in positions[], it means there is no queen placed in that row, so check from j = 0
            //but, if there is a gueen (exist a position in posiitons[]) look for another place but starting with column (j+1)
            //because from 0 to position.getIndexOfColumn program already check, so that is first OK column, which is not good,
            //so keep looking for another one starting with that point
            if (positions[index] != null) {
                j = positions[index].getIndexOfColumn();
                table[index][j] = 0;
                //pt ca nu stergeam pozitiile anterioare din array, programul ajungea din nou la primul rand, dar cnd sa urce la urmatotrul rand, gasea
                //deja o pozitie aici si incepea sa caute in coloane de la indexulColoanei acelei pozitii
                //asa ca acum sterg pozitiile din array daca trebuie sa ma intorc. astfel incat programul incepe o cautare de la 0
                //nu e suficient sa stergi doar 0-urile din table[][] ci si pozitiile (obiectele) din positions[]
                positions[index] = null;
                j++;
            } else {
                j = 0;
            }

            //index will increment only if can find a OK position to place a queen; if NO position is find, index not change so
            //program will go back one position in positions[] and look for another place for queen on that row
            int aux = index;

            for (; j < size; j++) {
                if (isOk(index, j, table)) {
                    positions[index] = new Position(index,j);
                    table[index][j] = 1;
                    index++;
                    System.out.println(Arrays.toString(positions));
                    break;
                }
            }

            //if can't find a place, go back one position and move the queen on other column
            if (index == aux) {
                index--;
            }
        }

        return table;
    }

    private boolean isOk(int indexOfRow, int indexOfColumn, int[][] table) {

        //check row
        for (int i = 0; i < size; i++) {
            if (table[indexOfRow][i] == 1) {
                return false;
            }
        }

        //check column
        for (int i = 0; i < size; i++) {
            if(table[i][indexOfColumn] == 1) {
                return false;
            }
        }

        //check on first diagonal
        int i = indexOfRow + 1;
        int j = indexOfColumn + 1;
        while (i < size && j < size) {
            if(table[i][j] == 1) {
                return false;
            }
            i++;
            j++;
        }

        i = indexOfRow - 1;
        j = indexOfColumn - 1;
        while (i >= 0 && j >= 0) {
            if(table[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        //check on second diagonal
        for (int k = 0; k < table.length; k++) {
            for (int l = 0; l < table[0].length; l++) {
                if (((k + l) == (indexOfRow + indexOfColumn)) && table[k][l] == 1 ) {
                    return false;
                }
            }
        }

        return true;
    }
}
