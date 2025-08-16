package khop_va_cau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TimKhop {
    static final int MAX = 300300;
    static int numNode, numEdge;
    static int[][] edges = new int[MAX][2];
    static ArrayList<Integer>[] adj;
    static boolean[] used;
    static boolean[] bridge;
    static boolean[] isCut;
    static int[] low, num, numChild;
    static int cnt;
    
    static void minimize(int[] arr, int index, int value) {
        arr[index] = Math.min(arr[index], value);
    }

    static void dfs(int u, int p) {
        low[u] = numNode + 1;
        num[u] = ++cnt;
        
        for (int id : adj[u]) {
            if (!used[id]) {
                used[id] = true;
                
                int v = edges[id][0] + edges[id][1] - u;
                if (num[v] == 0) {
                    numChild[u]++;
                    dfs(v, u);
                    minimize(low, u, low[v]);
                    if (low[v] > num[u]) {
                        bridge[id] = true;
                    }
                    if (low[v] >= num[u] && p != -1) {
                        isCut[u] = true;
                    }
                } else {
                    minimize(low, u, num[v]);
                }
            }
        }
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

        used = new boolean[numEdge + 1];
        bridge = new boolean[numEdge + 1];
        isCut = new boolean[numNode + 1];
        low = new int[numNode + 1];
        num = new int[numNode + 1];
        numChild = new int[numNode + 1];

        for (int i = 1; i <= numEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[i][0] = u;
            edges[i][1] = v;
            adj[u].add(i);
            adj[v].add(i);
        }

        for (int i = 1; i <= numNode; i++) {
            if (num[i] == 0) {
                dfs(i, -1);
                if (numChild[i] == 1) {
                    isCut[i] = false;
                } else if (numChild[i] >= 2) {
                    isCut[i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // In các đỉnh là khớp
        sb.append("Cac dinh la khop:\n");
        for (int i = 1; i <= numNode; i++) {
            if (isCut[i]) {
                sb.append(i).append("\n");
            }
        }
        
        System.out.print(sb.length() > 0 ? sb : "Khong co cau va khop\n");
    }
}
