package bfs_dfs;//package Graph;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//
///*
//5 8
//########
//#..#...#
//####.#.#
//#..#...#
//########
// */
//public class Task1 {
//    static boolean[][] visited = new boolean[1005][1005];
//    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
//    static int n, m;
//    static String[][]building;
//    public static void DFS(int x,int y){
//        visited[x][y] = true;
//        for (int i = 0; i < 4; i++) {
//            int newX = x + dx[i];
//            int newY = y + dy[i];
//            if (newX >= 0 && newX < n && newY < m && newY >= 0 && !visited[newX][newY] && building[newX][newY].equals(".")) {
//                DFS(newX, newY);
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        building = new String[n][m];
//
//        for (int i = 0; i < n; i++) {
//            String[] split = br.readLine().split("|");
//            for (int j = 0; j < m; j++) {
//                    building[i][j] = split[j];
//            }
//        }
//
//        int nRooms = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (building[i][j].equals(".") && !visited[i][j]) {
//                    nRooms++;
//                    DFS(i, j);
//                }
//            }
//        }
//        System.out.println(nRooms);
//    }
//}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Task1 {
    static boolean[][] visited = new boolean[1005][1005];
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int n, m;
    static char[][] a;
    
    // Iterative DFS using a stack
    public static void DFS(int startX, int startY) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0], y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && a[newX][newY] == '.') {
                    visited[newX][newY] = true;
                    stack.push(new int[]{newX, newY});
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = line.charAt(j);
            }
        }
        
        int nRooms = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '.' && !visited[i][j]) {
                    nRooms++;
                    DFS(i, j);
                }
            }
        }
        System.out.println(nRooms);
    }
}
