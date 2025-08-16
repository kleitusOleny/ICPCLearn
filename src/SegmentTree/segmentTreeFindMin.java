
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class segmentTreeFindMin {
    static StringBuilder sb = new StringBuilder();
    static int N = 200005;
    static int[]tree = new int[N*4];
    static int[]a = new int[N];
    public static void BuildSegmentTree(int i,int l,int r){
        if (l == r){
            tree[i] = a[l];
            return;
        }
        int mid = (l+r)/2;
        BuildSegmentTree(i*2,l,mid);
        BuildSegmentTree(i*2 +1,mid+ 1, r);
        tree[i] = Math.min(tree[i*2],tree[i*2 +1]);
    }
    
    public static int get(int i,int l, int r,int L, int R) {
        if (l > R || L > r) {
            return Integer.MAX_VALUE;
        }
        if (L <= l && r <= R) {
            return tree[i];
        }
        int mid = (l + r) / 2;
        int left = get(i * 2, l, mid, L, R);
        int right = get(i * 2 + 1, mid+1, r, L, R);
        return Math.min(left,right);
    }
    
    public static void update(int i, int L, int R,int pos ,int val){
        if (pos > R || pos < L){
            return;
        }
        if (L == R){
            tree [i] = val;
            return;
        }
        int mid = (L + R)/2;
        update(i*2,L,mid,pos,val);
        update(i*2 +1,mid+1, R,pos,val);
        tree[i] = Math.min(tree[i*2],tree[i*2 +1] );
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        BuildSegmentTree(1,1,n);
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            if(type == 2){
                sb.append(get(1,1,n,L,R)).append("\n");
            }else {
                update(1,1,n,L,R);
            }
        }
        System.out.println(sb.toString().trim());
    }
}
