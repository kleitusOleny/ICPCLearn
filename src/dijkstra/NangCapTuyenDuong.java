import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class NangCapTuyenDuong {
    static final int N = 2001;
    static final int INF = (int) 1e7 + 7;
    static int n, m, q;
    static int[][] d = new int[N][3];
    static ArrayList<int[]>[] adj = new ArrayList[N];
    static PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
    
    public static class Edge {
        int w, u, val;
        
        Edge(int w, int u, int val) {
            this.w = w;
            this.u = u;
            this.val = val;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        q = Integer.parseInt(input[2]);
        
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            int w = Integer.parseInt(edge[2]);
            adj[u].add(new int[]{w, v});
        }
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], INF);
        }
        
        d[1][0] = 0;
        pq.offer(new Edge(0, 1, 0));
        
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int w = e.w;
            int u = e.u;
            int val = e.val;
            
            if (d[u][val] != w) {
                continue;
            }
            
            for (int[] edge : adj[u]) {
                int v = edge[1];
                int cost = edge[0];
                
                if (val == 0) {
                    if (d[v][1] > d[u][val]) {
                        d[v][1] = d[u][val];
                        pq.offer(new Edge(d[v][1], v, 1));
                    }
                    if (d[v][0] > d[u][val] + cost) {
                        d[v][0] = d[u][val] + cost;
                        pq.offer(new Edge(d[v][0], v, 0));
                    }
                } else {
                    if (d[v][1] > d[u][val] + cost) {
                        d[v][1] = d[u][val] + cost;
                        pq.offer(new Edge(d[v][1], v, 1));
                    }
                }
            }
        }
        
        while (q-- > 0) {
            String[] query = br.readLine().split(" ");
            int s = Integer.parseInt(query[0]);
            int t = Integer.parseInt(query[1]);
            System.out.println(Math.min(d[s][0], d[s][1] + t));
        }
    }
}