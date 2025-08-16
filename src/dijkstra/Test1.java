import java.io.*;
import java.util.*;

public class Test1 {
    static int n, m, q;
    static List<Node>[] adj;
    static long[][] d;
    static class Node {
        int vertex;
        long weight;
        int k;
        Node(int vertex, long weight, int k) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    
    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
        d[1][0] = 0;
        pq.add(new Node(1, 0, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            long w = cur.weight;
            int u = cur.vertex;
            int k = cur.k;
            
            if (d[u][k] != w) continue;
            
            for (int i = 0; i < adj[u].size(); i++) {
                long cost = adj[u].get(i).weight;
                int v = adj[u].get(i).vertex;
                int id = 0;
                long tmp = -1;
                for (int j = 0; j < q; j++) {
                    if (d[v][j] > tmp) {
                        id = j;
                        tmp = d[v][j];
                    }
                }
                if (tmp > w + cost) {
                    d[v][id] = w + cost;
                    pq.offer(new Node(v,d[v][id],id));
                }
            }
        }

        Arrays.sort(d[n]);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        d = new long[n+1][q+1];
        for (long[] b : d){
            Arrays.fill(b, Long.MAX_VALUE);
        }
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            adj[a].add(new Node(b, c,0));
        }
        br.close();
        dijkstra();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(d[n][i]).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}