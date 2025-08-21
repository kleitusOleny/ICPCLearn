
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class testA {
    static int n;
    static List<Pair>[] list= new List[5005];
    static boolean[]track;
    static record Pair(int u, int w){}
    static PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
    static int[]d;
    static int[]count;
    public static void dijkstra(){
        d[1] = 0;
        count[1] = 1;
        pq.offer(new Pair(1,0));
        while (!pq.isEmpty()){
            Pair pair = pq.poll();
            int u = pair.u;
            for (Pair pair2 : list[u]){
                int v = pair2.u;
                int w = pair2.w;
                if (d[v] > d[u] + w){
                    d[v] = d[u] + w;
                    pq.offer(new Pair(v,w));
                    count[v] = count[u];
                }else if (d[v] == d[u] + w){
                    count[v] += count[u];
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        d = new int[n+1];
        count = new int[n+1];
        track = new boolean[n+5];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(d,Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (type == 1){
                list[u].add(new Pair(v,w));
            }else {
                list[u].add(new Pair(v,w));
                list[v].add(new Pair(u,w));
            }
        }
        dijkstra();
        System.out.println(d[n] + " "+ count[n]);
    }
}
