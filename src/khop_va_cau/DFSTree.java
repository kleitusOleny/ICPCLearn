package khop_va_cau;

import java.io.*;
import java.util.*;

public class DFSTree {
    static int numNode, numEdge;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] parent;
    static List<int[]> treeEdges;
    static int[] startTime, endTime;
    static int time;

    static void dfs(int u) {
        visited[u] = true;
        startTime[u] = time++;
        for (int v : adj[u]) {
            if (!visited[v]) {
                parent[v] = u;
                treeEdges.add(new int[]{u, v});
                dfs(v);
            }
        }
        endTime[u] = time++;
    }

    static boolean isAncestor(int u, int v) {
        return startTime[u] <= startTime[v] && endTime[v] <= endTime[u];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numNode = Integer.parseInt(st.nextToken());
        numEdge = Integer.parseInt(st.nextToken());

        adj = new ArrayList[numNode + 1];
        for (int i = 1; i <= numNode; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < numEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u); // Đồ thị vô hướng
        }
        
        // Khởi tạo các mảng và danh sách
        visited = new boolean[numNode + 1];
        parent = new int[numNode + 1];
        startTime = new int[numNode + 1];
        endTime = new int[numNode + 1];
        treeEdges = new ArrayList<>();
        time = 0;
        
        // Chạy DFS để xây dựng rừng DFS
        int numComponents = 0; // Đếm số TPLT
        for (int i = 1; i <= numNode; i++) {
            if (!visited[i]) {
                parent[i] = -1; // Đỉnh gốc không có cha
                dfs(i);
                numComponents++;
            }
        }
        
        // In số TPLT
        System.out.println("Số TPLT: " + numComponents);
        
        // In các cạnh thuộc cây DFS
        System.out.println("Các cạnh thuộc cây DFS:");
        for (int[] edge : treeEdges) {
            System.out.println(edge[0] + " " + edge[1]);
        }
        
        // Kiểm tra tính chất: Nếu cạnh (u, v) không thuộc cây DFS, u là tổ tiên của v hoặc ngược lại
        System.out.println("Kiểm tra tính chất tổ tiên:");
        for (int u = 1; u <= numNode; u++) {
            for (int v : adj[u]) {
                // Kiểm tra xem (u, v) có thuộc cây DFS không
                boolean isTreeEdge = false;
                for (int[] edge : treeEdges) {
                    if ((edge[0] == u && edge[1] == v) || (edge[0] == v && edge[1] == u)) {
                        isTreeEdge = true;
                        break;
                    }
                }
                // Nếu không thuộc cây DFS, kiểm tra tính chất tổ tiên
                if (!isTreeEdge && u < v) { // Chỉ xét mỗi cạnh một lần (vô hướng)
                    if (isAncestor(u, v)) {
                        System.out.println("Cạnh (" + u + ", " + v + ") không thuộc cây DFS, u là tổ tiên của v");
                    } else if (isAncestor(v, u)) {
                        System.out.println("Cạnh (" + u + ", " + v + ") không thuộc cây DFS, v là tổ tiên của u");
                    } else {
                        System.out.println("Lỗi: Cạnh (" + u + ", " + v + ") không thỏa mãn tính chất tổ tiên!");
                    }
                }
            }
        }
    }
}