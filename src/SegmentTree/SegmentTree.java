
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SegmentTree {
    static StringBuilder sb = new StringBuilder();
    static int N = 200005;
    static long[] tree = new long[N * 4];
    static long[] lazy = new long[N * 4];
    static int[] a = new int[N];
    static int n;
    public static void BuildSegmentTree(int i, int l, int r) {
        if (l == r) {
            tree[i] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        BuildSegmentTree(i * 2, l, mid);
        BuildSegmentTree(i * 2 + 1, mid + 1, r);
        tree[i] = (tree[i * 2] + tree[i * 2 + 1]);
    }
    
    public static void pushDown(int i, int l, int r) {
        if (lazy[i] == 0) return;
        
        int m = l + (r - l) / 2;
        tree[2 * i] += lazy[i] * (m - l + 1);
        tree[2 * i + 1] += lazy[i] * (r - m);
        lazy[2 * i] += lazy[i];
        lazy[2 * i + 1] += lazy[i];
        
        lazy[i] = 0;
    }
    
    public static long get(int i, int l, int r, int u, int v) {
        // Nếu đoạn cần truy vấn nằm ngoài đoạn hiện tại
        if (l > v || u > r) {
            return 0;
        }
        
        // Nếu đoạn cần truy vấn chứa hoàn toàn đoạn hiện tại
        if (u <= l && r <= v) {
            return tree[i];
        }
        
        pushDown(i, l, r);
        int mid = (l + r) >> 1;
        long left = get(i * 2, l, mid, u, v);
        long right = get(i * 2 + 1, mid + 1, r, u, v);
        return left + right;
    }
    
    public static void updateRange(int i, int l, int r, int u, int v, int val) {
        
        
        // Nếu đoạn cần cập nhật nằm ngoài đoạn hiện tại của cây
        if (l > v || u > r) {
            return;
        }
        
        // Nếu đoạn cần cập nhật chứa hoàn toàn đoạn hiện tại
        if (u <= l && r <= v) {
            tree[i] += (long) val * (r - l + 1);
            lazy[i] += val;
            return;
        }
        
        // Đẩy các giá trị lazy xuống các nút con trước
        pushDown(i, l, r);
        
        int mid = (l + r) >> 1;
        updateRange(i * 2, l, mid, u, v, val);
        updateRange(i * 2 + 1, mid + 1, r, u, v, val);
        
        // Cập nhật giá trị nút cha sau khi cập nhật các nút con
        tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
    
    public static long getSum(int l, int r){
        return get(1,1,n,l,r);
    }
    
    public static void update(int l, int r, int c){
        updateRange(1,1,n,l,r,c);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        BuildSegmentTree(1, 1, n);
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            
            if (type == 1) {
                int val = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                update(L,R,val);
            } else {
                int a = Integer.parseInt(st.nextToken());
                sb.append(getSum(a,a)).append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
