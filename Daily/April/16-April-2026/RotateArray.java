/*
Monk and Rotation
Monk loves to preform different operations on arrays, and so being the principal of Hackerearth School, he assigned a task to his new student Mishki. Mishki will be provided with an integer array A of size N and an integer K , where she needs to rotate the array in the right direction by K steps and then print the resultant array. As she is new to the school, please help her to complete the task.

Video approach to solve this question: here

Input:
The first line will consists of one integer T denoting the number of test cases.
For each test case:
1) The first line consists of two integers N and K, N being the number of elements in the array and K denotes the number of steps of rotation.
2) The next line consists of N space separated integers , denoting the elements of the array A.

Output:
Print the required array.

Constraints:


Sample Input
1
5 2
1 2 3 4 5
Sample Output
4 5 1 2 3
Explanation
Here T is 1, which means one test case.
 denoting the number of elements in the array and 
, denoting the number of steps of rotations.
The initial array is: 

In first rotation, 5 will come in the first position and all other elements will move to one position ahead from their current position. Now, the resultant array will be 

In second rotation, 4 will come in the first position and all other elements will move to one position ahead from their current position. Now, the resultant array will be 

*/

import java.util.Scanner;

class RotateArray {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt())
            return;

        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            for (int i = N - K; i < N; i++) {
                System.out.print(A[i]);
                System.out.print(" ");
            }

            for (int i = 0; i < N - K; i++) {
                System.out.print(A[i]);
                System.out.print(" ");
            }
        }
    }
}

/*
 * import java.io.BufferedReader;
 * 
 * import java.io.InputStreamReader;
 * 
 * import java.util.*;
 * 
 * import java.util.stream.*;
 * 
 * class TestClass {
 * 
 * public static void main(String args[]) throws Exception {
 * 
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * 
 * int t = Integer.parseInt(br.readLine());
 * 
 * for (int i = 0; i < t; i++) {
 * 
 * String[] words = br.readLine().split(" ");
 * 
 * int n = Integer.parseInt(words[0]);
 * 
 * int k = Integer.parseInt(words[1]) % n;
 * 
 * String arr[] = br.readLine().split(" ");
 * 
 * System.out.println((IntStream.range(n - k, n).mapToObj(idx ->
 * arr[idx]).collect(Collectors.joining(" ", "", " ")) + IntStream.range(0, n -
 * k).mapToObj(idx -> arr[idx]).collect(Collectors.joining(" "))).trim());
 * 
 * }
 * }
 * }
 */