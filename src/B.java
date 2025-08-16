import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3 6
1 2 3
3 1 1
3 1 3
1 1 1 2
3 1 3
2 2 2 0
3 2 3
 */

public class B {
    static StringBuilder sb = new StringBuilder();
    static int n,q;
    static int []arr, prefixSum,weight;
    
    public static void raise(int l, int r,int x){
        prefixSum[l] += x;
        weight[l] += l * x;
        if (r + 1 <= prefixSum.length - 1) {
            prefixSum[r + 1] -= x;
            weight[r + 1] -= (r + 1) * x;
        }
    }
    
    public static void change(int l, int r,int x){
        int oldSum = prefixSum[r] - prefixSum[l -1];
        int oldWeight = weight[r] - weight[l -1];
        int newSum = (r - l +1 )* x;
        int newWeight = 0;
        for (int j = l; j <= r; j++) {
            newWeight += j * x;
        }
        int diffSum = newSum - oldSum;
        int diffWeighted = newWeight - oldWeight;
        prefixSum[l] += diffSum;
        weight[l] += diffWeighted;
        if (r + 1 <= prefixSum.length - 1) {
            prefixSum[r + 1] -= diffSum;
            weight[r + 1] -= diffWeighted;
        }
        for (int j = l; j <= r; j++) arr[j] = x;
    }
    
    public static void check(int l, int r){
        long sumA = prefixSum[r] - prefixSum[l - 1];
        long sumWeighted = weight[r] - weight[l - 1];
        for (int k = l; k <= r; k++) {
            long total = sumWeighted - k * sumA;
            if (total == 0) {
                sb.append("YES\n");
                return;
            }
        }
        sb.append("NO\n");
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1];
        prefixSum = new int[n+1];
        weight = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + arr[i];
            weight[i] = weight[i - 1] + i * arr[i];
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            if (t == 1){
                int x = Integer.parseInt(st.nextToken());
                raise(l,r,x);
                
            }else if (t == 2){
                int x = Integer.parseInt(st.nextToken());
                change(l,r,x);
                
            }else {
                check(l,r);
            }
        }
        System.out.println(sb.toString().trim());
    }
}
