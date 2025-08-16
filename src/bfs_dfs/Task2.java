package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
B. MOVE
You have a number m, a starting number s0 and two sequences of numbers ai and bi. Your goal is to go from s0 to 0
in as few moves as possible. In each move, you choose an i, then multiply your current number by ai, add bi to it,
and reduce the result modulo m. That is
sj = (sj-1 * aij + bij) % m.
INPUT
The first line of input contains three integers 0 < m ≤ 1000000, 0 ≤ n ≤ 10, and 0 < s0 < m. The next n lines each
contain two integers, a pair 0 ≤ ai ≤ 1000000000 and 0 ≤ bi ≤ 1000000000.
OUTPUT
Output the shortest number of moves needed to reach 0 starting from s0. If it is not possible to reach 0 in any number
of moves, output -1.
 */

/*
5 2 1
2 1
3 1
 */
public class Task2 {
    static int[][] pair;
    static int m, n, s;
    static int[] d;
    static boolean[] visited;
    static int[][]dp;
    
    public static int BFS(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        
        d[start] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            
            for (int i = 0; i < n; i++) {
                long v = (long) ((long) u * pair[i][0] + pair[i][1]) % m;
                if (d[(int) v] == -1) {
                    d[(int) v] = d[u] + 1;
                    q.add((int) v);
                }
            }
        }
        return 0;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        s = Integer.parseInt(stringTokenizer.nextToken());
        
        d = new int[1000005];
        Arrays.fill(d, -1);
        visited = new boolean[1000005];
        pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            pair[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            pair[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        BFS(s);
        System.out.println(d[0]);
    }
}
