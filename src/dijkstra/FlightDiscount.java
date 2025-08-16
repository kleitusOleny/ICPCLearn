import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FlightDiscount {
    static int n,m;
    static List<Node>[]adj;
    static PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> Long.compare(a.w,b.w));
    static boolean[]visited;
    static long[][]d;
    public static class Node{
        int vertex;
        long w;
        int isHalve;
        public Node(int vertex, long w, int halve) {
            this.vertex = vertex;
            this.w = w;
            this.isHalve = halve;
        }
        
        @Override
        public String toString() {
            return "Node{" +
                    "isHalve=" + isHalve +
                    ", vertex=" + vertex +
                    ", w=" + w +
                    '}';
        }
    }
    
    public static void dijkstra(){
        pq.offer(new Node(1,0, 0));
        d[1][0] = 0;
        while (!pq.isEmpty()){
            Node current = pq.poll();
            int u = current.vertex;
            long w = current.w;
            int usedDiscount = current.isHalve;
            
            if (d[u][usedDiscount] < w) continue;
            
            for (Node edge : adj[u]) {
                int v = edge.vertex;
                long cost = edge.w;
                int halveAvailable = (usedDiscount == 1) ? 0 : 1;
                if (d[v][usedDiscount] > d[u][usedDiscount] + cost){
                    d[v][usedDiscount] = d[u][usedDiscount] + cost;
                    pq.offer(new Node(v, d[v][usedDiscount], usedDiscount));
                }
                
                if (halveAvailable == 1){
                    long discount = cost /2;
                   
                    if (d[v][1] > d[u][usedDiscount] + discount){
                        d[v][1] = d[u][usedDiscount] + discount;
                        pq.offer(new Node(v, d[v][1], 1));
                    }
                }
            }
        }
        System.out.println(d[n][1]);
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = new long[n+1][10];
        visited = new boolean[n+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(d[i], Long.MAX_VALUE);
        }
        adj = new List[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w, 0));
        }
        dijkstra();
    }
    
}
