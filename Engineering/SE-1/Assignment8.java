/*
Write a Python program that determines the location of a saddle point of matrix if one
exists. An m x n matrix is said to have a saddle point if some entry a[i][j] is the smallest
value in row i and the largest value in j. 
*/

import java.util.*;

class Assignment8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter size of row: ");
        int row = sc.nextInt();
        
        System.out.print("\nEnter size of col: ");
        int col = sc.nextInt();
        
        int[][] matrix = new int[row][col];
        System.out.println("Enter elements: ");
        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        findSaddlePoint(matrix, row, col);
    }
    static void findSaddlePoint(int[][] matrix, int m, int n){
        boolean isSaddlePoint = false;
        for(int i = 0; i < m; i++) {
            int minInRow = matrix[i][0];
            int colIndex = 0;
            
            for(int j = 1; j< n; j++) {
                if(matrix[i][j] < minInRow) {
                    minInRow = matrix[i][j];
                    colIndex = j;
                }
            }
            
            boolean saddlePoint = true;
            for(int k = 0; k < m; k++) {
                if(matrix[k][colIndex] > minInRow) {
                    saddlePoint = false;
                    break;
                }
            }
            
            if(saddlePoint) {
                System.out.println("Saddle point is at position (" + i + ", "+ colIndex +") : " +minInRow);
                isSaddlePoint = true;
            }
        }
        if(!isSaddlePoint) {
                System.out.println("Saddle point is not present");
            }
    }
}