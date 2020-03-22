package com.sudoku;

import java.util.*;

public class MatrixGenerator {

    public static final int row = 3;
    public static final int col = 3;

    public int[][] generateMatrix(){

        int matrix[][] = new int[row][col];
        int randomInt;
        Set<Object> usedSet = new HashSet<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                 randomInt = getNextAvailableInt(usedSet);
                 usedSet.add(randomInt);
                 matrix[i][j] = randomInt;
            }
        }

       // printMatrix(matrix);
        return matrix;
    }

    public void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public int getNextAvailableInt(Set usedSet) {

        int randomInt = new Random().nextInt(9)+1;
        while(usedSet.contains(randomInt)){
            //System.out.println("Regenerating : "+randomInt);
            randomInt = new Random().nextInt(9)+1;
        }
        return randomInt;
    }


}
