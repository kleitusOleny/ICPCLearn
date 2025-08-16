
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;

public class DrunkenMaze {
    static int m, n;
    static int[][][][] d = new int[n + 5][m + 5][7][7];
    static char[][] maze;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    
    static void BFS(Path start, Path end) {
        Queue<Path> q = new LinkedList<>();
        q.add(start);
        int ans = -1;
        d[start.x][start.y][0][0] = 0;
        while (!q.isEmpty()) {
            Path p = q.poll();
            int x = p.x;
            int y = p.y;
            int dir = p.dir;
            int step = p.dis;
            
            if (x == end.x && y == end.y) {
                ans = d[x][y][dir][step];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= m && maze[nextX][nextY] != '#') {
                    if (i == dir) {
                        if (step + 1 < 3) {
                            if (d[nextX][nextY][i][step + 1] == -1) {
                                d[nextX][nextY][i][step + 1] = d[x][y][dir][step] + 1;
                                q.add(new Path(nextX, nextY, i, step + 1));
                            }
                        }
                    } else {
                        if (d[nextX][nextY][i][0] == -1) {
                            d[nextX][nextY][i][0] = d[x][y][dir][step] + 1;
                            q.add(new Path(nextX, nextY, i, 0));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new char[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            String line = br.readLine();
            for (int j = 1; j < m + 1; j++) {
                maze[i][j] = line.charAt(j - 1);
            }
        }
        d = new int[n + 5][m + 5][7][7];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                for (int k = 0; k < d[i][j].length; k++) {
                    Arrays.fill(d[i][j][k], -1);
                }
            }
        }
        
        Path start = null, end = null;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (maze[i][j] == 'S') {
                    start = new Path(i, j, 0, 0);
                }
                if (maze[i][j] == 'T') {
                    end = new Path(i, j, 0, 0);
                }
            }
        }
        BFS(start, end);
    }
    
    record Path(int x, int y, int dir, int dis) {
    }
}

