import java.io.*;
import java.util.*;

public class FlightRoutes {
    static int n, m, k;
    static PriorityQueue<Long>[] bes;
    static List<Node>[] adj;
    
    static class Node {
        int vertex;
        long weight;
        
        Node(int vertex, long weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    
    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
        bes = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            bes[i] = new PriorityQueue<Long>(Collections.reverseOrder());
        }
        bes[1].add(0L);
        pq.add(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.vertex;
            if (!bes[u].isEmpty() && cur.weight > bes[u].peek()) {
                continue;
            }
            
            for (Node node : adj[u]) {
                int v = node.vertex;
                long newDist = cur.weight + node.weight;
                
                if (bes[v].size() < k || newDist < bes[v].peek()) {
                    bes[v].add(newDist);
                    if (bes[v].size() > k) {
                        bes[v].poll();
                    }
                    pq.add(new Node(v, newDist));
                }
            }
        }
        
        Object[] path = bes[n].toArray();
        Arrays.sort(path);
        PrintStream out = new PrintStream(new BufferedOutputStream(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(path[i]).append(" ");
        }
        out.print(sb.toString().trim());
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            adj[a].add(new Node(b, c));
        }
        br.close();
        dijkstra();
    }
}