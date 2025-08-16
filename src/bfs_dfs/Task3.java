

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.math.BigInteger;

/*
11
6 4
9 4
4 2
18 27
27 4
27 2
27 10
1 1
3 1
5 1
746001 2984004
 */
public class Task3 {
    static int n;
    static int[][] m;
    static boolean[] visited;
    
    static void DFS(int start, int end) {
        if (start == end) {
            System.out.println("YES");
            return;
        }
        if (start % 3 != 0 || start < end) {
            System.out.println("NO");
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(start);
            visited[start] = true;
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                if (cur == end) {
                    System.out.println("YES");
                    return;
                }
                if (cur % 3 == 0) {
                    int s = cur / 3;
                    int l = cur / 3 * 2;
                    if (!visited[s]) {
                        stack.push(s);
                        visited[s] = true;
                    }
                    if (!visited[l]) {
                        stack.push(l);
                        visited[l] = true;
                    }
                }
            }
            System.out.println("NO");
        }
    }
    
    static void reset(int v) {
        if (!visited[v]) {
            return;
        }
        visited[v] = false;
        if (v % 3 == 0) {
            reset(v / 3);
            reset(v / 3 * 2);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = new int[n][2];
        visited = new boolean[10000005];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m[i][0] = Integer.parseInt(st.nextToken());
            m[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            DFS(m[i][0], m[i][1]);
            reset(m[i][0]);
        }
    }
}
