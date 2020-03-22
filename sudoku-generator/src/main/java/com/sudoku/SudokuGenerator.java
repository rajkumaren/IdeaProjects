package com.sudoku;

import java.util.*;

import static java.util.Arrays.asList;

public class SudokuGenerator {

    public static final int row = 9;
    public static final int col = 9;
    static int[][] sudokuGrid = new int[9][9];
    static int[][] matrix = new int[3][3];
    //MatrixGenerator matrixGenerator;

    public static void main(String[] args) {


        MatrixGenerator matrixGenerator = new MatrixGenerator();
       // matrix = matrixGenerator.generateMatrix();
       // mergeMatrixIntoSudokuGrid(matrix,0,0);
        //matrixGenerator.printMatrix(sudokuGrid);
      //  matrix = matrixGenerator.generateMatrix();
      //  mergeMatrixIntoSudokuGrid(matrix,3,3);
        //matrixGenerator.printMatrix(sudokuGrid);
      //  matrix = matrixGenerator.generateMatrix();
     //  mergeMatrixIntoSudokuGrid(matrix,6,6);
        //matrixGenerator.printMatrix(sudokuGrid);
        //System.out.println(collectUsedListVertically(1));
        //System.out.println(collectUsedListHorizontally(1));

        List<MatrixPos> matrixPosList = asList(
                new MatrixPos(0, 0),
                new MatrixPos(0, 3),
                new MatrixPos(0, 6),
                new MatrixPos(3, 0),
                new MatrixPos(3, 3),
                new MatrixPos(3, 6),
                new MatrixPos(6, 0),
                new MatrixPos(6, 3),
                new MatrixPos(6, 6)
        );

        MatrixPos matrixPos;
        int check =0;
        for (int i = 0; i < matrixPosList.size();) {
             matrixPos = matrixPosList.get(i);
            boolean filled = fillInMatrix(matrixPos.getRow(),matrixPos.getCol());
            if(filled){
                i++;
                check = 0;
            }else if(!filled && check==3){
                i--;
                check = 0;
            }
            else{
                check++;
            }
           // matrixGenerator.printMatrix(sudokuGrid);
        }
        matrixGenerator.printMatrix(sudokuGrid);

    }


    static void mergeMatrixIntoSudokuGrid(int[][] matrixBlock, int rowPos, int colPos){
        for(int i=rowPos,iIndex=0; i<rowPos+3;i++,iIndex++){
            for(int j=colPos,jIndex=0;j<colPos+3;j++,jIndex++){
                sudokuGrid[i][j] = matrixBlock[iIndex][jIndex];
            }
        }
        //matrixGenerator;
    }

   static boolean fillInMatrix(int rowPos, int colPos){
       resetMatrix(rowPos,colPos);
       Set<Object> verticalSet;
       Set<Object> horizontalSet;
       Set<Object> subMatrixSet = new HashSet<>();
       Set<Object> localMatrixSet = new HashSet<>();
       MatrixGenerator matrixGenerator = new MatrixGenerator();
       for(int i=rowPos,iIndex=0; i<rowPos+3;i++,iIndex++){
           for(int j=colPos,jIndex=0;j<colPos+3;j++,jIndex++){
               subMatrixSet = new HashSet<>();
               verticalSet = collectUsedListVertically(j);

               horizontalSet = collectUsedListHorizontally(i);
              // System.out.println("V" + verticalSet);
              // System.out.println("H" + horizontalSet);
              // System.out.println("L" + localMatrixSet);

               subMatrixSet.addAll(verticalSet);
               subMatrixSet.addAll(horizontalSet);
               subMatrixSet.addAll(localMatrixSet);
               // System.out.println("S" + subMatrixSet);

               if(subMatrixSet.size()==9){
                   //System.out.println("Entering Circuit Breaker");
                   resetMatrix(rowPos,colPos);
                   return false;
               }

               int populatedVal = matrixGenerator.getNextAvailableInt(subMatrixSet);
               sudokuGrid[i][j] = populatedVal;
               localMatrixSet.add(populatedVal);
               //System.out.println();
               //matrixGenerator.printMatrix(sudokuGrid);

           }
       }


       return true;

    }

    private static void resetMatrix(int rowPos, int colPos) {
        for(int i=rowPos,iIndex=0; i<rowPos+3;i++,iIndex++) {
            for (int j = colPos, jIndex = 0; j < colPos + 3; j++, jIndex++) {
                sudokuGrid[i][j] = 0;
            }
        }
        //fillInMatrix(rowPos,colPos);
    }


    static Set<Object> collectUsedListVertically(int colPos){
        Set<Object> verticalSet = new HashSet<>();
        for(int i=0;i<9;i++){
            verticalSet.add(sudokuGrid[i][colPos]);
        }
        verticalSet.remove(0);
        return verticalSet;
    }

    static Set<Object> collectUsedListHorizontally(int rowPos){
        Set<Object> horizontalSet = new HashSet<>();
        for(int j=0;j<9;j++){
            horizontalSet.add(sudokuGrid[rowPos][j]);
        }
        horizontalSet.remove(0);
        return horizontalSet;
    }

    Set<Object> collectUsedListSubMatrix(int rowPos,int colPos){
        Set<Object> horizontalSet = new HashSet<>();
        for(int j=0;j<9;j++){
            horizontalSet.add(sudokuGrid[rowPos][j]);
        }
        horizontalSet.remove(0);
        return horizontalSet;
    }




}
