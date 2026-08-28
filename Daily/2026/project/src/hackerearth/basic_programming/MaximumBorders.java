/*
You are given a table with
 rows and
 columns. Each cell is colored with white or black. Considering the shapes created by black cells, what is the maximum border of these shapes? Border of a shape means the maximum number of consecutive black cells in any row or column without any white cell in between.

A shape is a set of connected cells. Two cells are connected if they share an edge. Note that no shape has a hole in it.

Input format

The first line contains
 denoting the number of test cases.
The first line of each test case contains integers
 denoting the number of rows and columns of the matrix. Here, '#' represents a black cell and '.' represents a white cell.
Each of the next
 lines contains
 integers.
Output format

Print the maximum border of the shapes.

Sample Input
10
2 15
.....####......
.....#.........
7 9
...###...
...###...
..#......
.####....
..#......
...#####.
.........
18 11
.#########.
########...
.........#.
####.......
.....#####.
.....##....
....#####..
.....####..
..###......
......#....
....#####..
...####....
##.........
#####......
....#####..
....##.....
.#######...
.#.........
1 15
.....######....
5 11
..#####....
.#######...
......#....
....#####..
...#####...
8 13
.....######..
......##.....
########.....
...#.........
.............
#######......
..######.....
####.........
7 5
.....
..##.
###..
..##.
.....
..#..
.#...
14 2
..
#.
..
#.
..
#.
..
..
#.
..
..
..
#.
..
7 15
.###########...
##############.
...####........
...##########..
.......#.......
.....#########.
.#######.......
12 6
#####.
###...
#.....
##....
###...
......
.##...
..##..
...#..
..#...
#####.
####..
Sample Output
4
5
9
6
7
8
3
1
14
5

Time Limit: 1
Memory Limit: 256
Source Limit:
 */
package hackerearth.basic_programming;

import java.util.Scanner;

public class MaximumBorders {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        char[][] shapes;
        for (int n = 0; n < testCases; n++) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();
            shapes = new char[rows][columns];
            String s = "";
            for (int i = 0; i < rows; i++) {
                s = sc.next();
                for (int j = 0; j < columns; j++) {
                    shapes[i][j] = s.charAt(j);
                }
            }

            int c = 0;
            int count = 0;
            for (int i = 0; i < rows; i++) {
                if (c < count) {
                    c = count;
                }
                count = 0;
                for (int j = 0; j < columns; j++) {
                    if (shapes[i][j] == ('#')) {
                        count++;
                        if (shapes[i][j + 1] == ('.')) {
                            break;
                        }
                    }
                }
            }
            if (c > count) {
                System.out.println(c);
            } else {
                System.out.println(count);
            }
        }
    }
}
