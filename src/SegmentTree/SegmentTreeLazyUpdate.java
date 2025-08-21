import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SegmentTreeLazyUpdate {
    
    private static long[] tree;
    private static long[] lazy;
    private static int[] arr;
    private static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        tree = new long[4 * n +1];
        lazy = new long[4 * n +1];
        BuildSegmentTree(1,1,n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            
            if (type == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());
                update(a,b,u);
            } else {
                int k = Integer.parseInt(st.nextToken());
                sb.append(get(1,1,n,k,k)).append("\n");
            }
        }
        System.out.print(sb.toString().trim());
    }
    
    public static void BuildSegmentTree(int i, int l, int r) {
        if (l == r) {
            tree[i] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        BuildSegmentTree(i * 2, l, mid);
        BuildSegmentTree(i * 2 + 1, mid + 1, r);
        tree[i] = (tree[i * 2] + tree[i * 2 + 1]);
    }
    
    public static void pushDown(int i, int l, int r) {
        if (lazy[i] == 0) return;
        
        int m = (l + r) >> 1;
        
        tree[2 * i] += lazy[i] * (m - l +1);
        tree[2 * i + 1] += lazy[i] * (r - m);
        lazy[2 * i] += lazy[i];
        lazy[2 * i + 1] += lazy[i];
        
        lazy[i] = 0;
    }
    
    public static void updateRange(int i, int l, int r, int u, int v, int c){
        if (l > v || r < u || l > r || v < u) return;
        
        if (u <= l && r <= v) {
            tree[i] += (long) c *(r  - l +1);
            lazy[i] += c;
            return;
        }
        
        pushDown(i, l, r);
        int m = (l + r) /2;
        updateRange(2 * i, l, m, u, v, c);
        updateRange(2 * i + 1, m + 1, r, u, v, c);
        
        tree[i] = tree[2 * i] + tree[2 * i + 1];
    }
    
    public static long get(int i,int l, int r,int u, int v) {
        if (l > v || r < u || l > r || v < u) return 0;
        
        if (u <= l && r <= v) return tree[i];
        pushDown(i, l, r);
        int m = (l + r) /2;
        
        long L = get(2 * i, l, m, u, v);
        long R = get(2 * i + 1, m + 1, r, u, v);
        return L + R;
    }
    
    static void update(int l, int r, int c) {
        updateRange(1, 1, n, l, r, c);
    }
}