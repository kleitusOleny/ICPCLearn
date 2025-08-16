
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemC {
    public static class Edge{
        public int x;
        public int y;
        public Edge(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,0,-1,0,1,-1};
    static int[] dy = {0,1,0,-1,-1,1};
    static int[][]d;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static Queue<Edge> pq = new LinkedList<>();
    public static void bfs(){
        for (int[] val : d) Arrays.fill(val, -1);
        d[1000][1000] = 0;
        pq.add(new Edge(1000, 1000));
        while (!pq.isEmpty()){
            Edge e = pq.poll();
            if (d[e.x][e.y] == -1){ continue;}
            
            for (int i = 0; i < 6; i++) {
                int x = e.x + dx[i];
                int y = e.y + dy[i];
                if (x >= 0 && x <=2000 && y >= 0 && y<= 2000 && d[x][y] == -1){
                    d[x][y] = d[e.x][e.y] + 1;
                    pq.add(new Edge(x, y));
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[2005][2005];
        
        bfs();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(d[Integer.parseInt(st.nextToken())+1000][Integer.parseInt(st.nextToken())+1000]).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
