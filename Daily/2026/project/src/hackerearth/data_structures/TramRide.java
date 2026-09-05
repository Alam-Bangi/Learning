/*
A city has N Tram stations numbered from 1 to N  that are connected to one another and form a circle. You are given an array ticket_cost  where ticket_cost[i] is the cost of a ticket between the stops number i and (i + 1) % N. The Tram can travel in both directions i.e. clockwise and anti-clockwise.

Return the minimum cost to travel between the given start and finish station.

You are given an integer N where N represents the total number of the tram stations, an integer start which represents the start station, and an integer finish which represents the finish station. You are given an array of positive integers  ticket_cost where ticket_cost[i] represents the ticket cost between the station number i and (i + 1) % N.

Task

Determine the minimum cost to travel between the given start and finish station.

Example

Assumptions

N = 4
start = 1
finish = 4
ticket_cost = [1, 2, 2, 4 ]
Approach

path1 -> 1------1-----> 2 -------2------> 3 -------2------> 4 . => 1+2+2 => 5

path2 -> 1------4------>4 . => 4

Path2 will give the minimum cost. Therefore return 4.

Function description

Complete the Solve() function provided in the editor below that takes the following arguments and finds the minimum cost to travel between the given start and finish station:

N: Represents the total number of tram stations
start: Represents the start station
finish: Represents the finish station
ticket_cost: Represents ticket_cost[i] denoting the ticket-cost between the station number i and (i + 1) %N
Input format

The first line contains an integer N denoting the total number of tram stations.
The second line contains an integer start denoting the start station.
The third line contains an integer finish denoting the finish station.
The fourth line contains an N space-separated integer array ticket_cost, ticket_cost[i] represents the ticket-cost between the station number i and (i + 1) %N.
Output format

Return the minimum cost to travel between the given start and finish station.

Constraints




Sample Input
4
1
3
1 2 3 4
Sample Output
3
Time Limit: 1
Memory Limit: 256
Source Limit:
Explanation
path1 -> 1------1-----> 2 -------2------> 3 . => 1+2 => 3

path2 -> 1------4------>4 -------3------> 3 . =>  4+3 => 7

Path1 will give the minimum cost. Therefore return 3.
 */
package hackerearth.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TramRide {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int start = Integer.parseInt(br.readLine().trim());
        int finish = Integer.parseInt(br.readLine().trim());
        String[] arr_Ticket_cost = br.readLine().split(" ");
        int[] Ticket_cost = new int[N];
        for(int i_Ticket_cost = 0; i_Ticket_cost < arr_Ticket_cost.length; i_Ticket_cost++)
        {
            Ticket_cost[i_Ticket_cost] = Integer.parseInt(arr_Ticket_cost[i_Ticket_cost]);
        }

        long out_ = solve(N, start, finish, Ticket_cost);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static long solve(int N, int start, int finish, int[] ticket_cost) {

        start--;
        finish--;

        if (start > finish) {
            int temp = start;
            start = finish;
            finish = temp;
        }

        long path1 = 0;
        long path2 = 0;

        for (int i = 0; i < N; i++) {
            if (i >= start && i < finish) {
                path1 += ticket_cost[i];
            } else {
                path2 += ticket_cost[i];
            }
        }
        return Math.min(path1, path2);
    }
}
