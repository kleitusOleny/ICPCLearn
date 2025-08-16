import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumPath {
    static int n, m;
    static final int N = 200005;
    static long[][][] dist = new long[N][2][2];
    static final long INF = (long) 1e17;
    static ArrayList<int[]>[] adj = new ArrayList[N];
    
    public static class Edge {
        long d;
        int to, x, y;
        
        Edge(long d, int to, int x, int y) {
            this.d = d;
            this.to = to;
            this.x = x;
            this.y = y;
        }
    }
    
    public static void dijkstra() {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 1; k++) {
                    dist[i][j][k] = INF;
                }
            }
        }
        dist[1][0][0] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Long.compare(a.d, b.d));
        pq.offer(new Edge(0, 1, 0, 0));
        
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int u = e.to;
            long d = e.d;
            int x = e.x;
            int y = e.y;
            
            if (dist[u][x][y] != d) {
                continue;
            }
            
            for (int[] edge : adj[u]) {
                int v = edge[0];
                long w = edge[1];
                
                for (int j = x; j <= 1; j++) {
                    for (int k = y; k <= 1; k++) {
                        long sum = dist[u][x][y] + w;
                        if (x == 0 && j == 1) sum -= w;
                        if (y == 0 && k == 1) sum += w;
                        if (sum < dist[v][j][k]) {
                            dist[v][j][k] = sum;
                            pq.offer(new Edge(sum, v, j, k));
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            long w = Long.parseLong(edge[2]);
            adj[u].add(new int[]{v, (int) w});
            adj[v].add(new int[]{u, (int) w});
        }
        
        dijkstra();
        
        for (int i = 2; i <= n; i++) {
            System.out.print(dist[i][1][1] + " ");
        }
    }
}