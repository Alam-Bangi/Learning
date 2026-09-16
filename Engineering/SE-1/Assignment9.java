/*
Write a Python program to compute following computation on matrix:
و
a) Addition of two matrices
B) Subtraction of two matrices
c) Multiplication of two matrices
d) Transpose of a matrix
*/

import java.util.Scanner;

class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Enter Matrix A Details ---");
        System.out.print("Enter number of rows: ");
        int rowsA = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int colsA = sc.nextInt();
        int[][] matrixA = new int[rowsA][colsA];
        System.out.println("Enter the elements of Matrix A:");
        readMatrix(sc, matrixA);

        System.out.println("\n--- Enter Matrix B Details ---");
        System.out.print("Enter number of rows: ");
        int rowsB = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int colsB = sc.nextInt();
        int[][] matrixB = new int[rowsB][colsB];
        System.out.println("Enter the elements of Matrix B:");
        readMatrix(sc, matrixB);

        printMatrix(matrixA);
        printMatrix(matrixB);

        System.out.println("\n--- RESULTS ---");

        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("\nAddition:");
            printMatrix(addMatrices(matrixA, matrixB));
        } else {
            System.out.println("\nAddition: Not possible (Dimensions must match).");
        }

        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("\nSubtraction:");
            printMatrix(subtractMatrices(matrixA, matrixB));
        } else {
            System.out.println("\nSubtraction: Not possible (Dimensions must match).");
        }

        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("\nMultiplication:");
            printMatrix(multiplyMatrices(matrixA, matrixB));
        } else {
            System.out.println("\nMultiplication: Not possible (Dimensions must match).");
        }

        if (rowsA == colsB) {
            System.out.println("\nTranspose A:");
            printMatrix(transposeMatrix(matrixA));
        } else {
            System.out.println("\nTranspose: Not possible (Dimensions must match).");
        }

        if (rowsA == colsB) {
            System.out.println("\nTranspose B:");
            printMatrix(transposeMatrix(matrixB));
        } else {
            System.out.println("\nTranspose: Not possible (Dimensions must match).");
        }
        sc.close();
    }

    private static void readMatrix(Scanner sc, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    private static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    private static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    private static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] * B[i][j];
            }
        }
        return result;
    }

    private static int[][] transposeMatrix(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
