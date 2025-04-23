package DynamicPrograme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
    public static int test(int n, int[] a){
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[1] = 0;
        for (int i = 1; i < n; i++) {
            if (i+1 <= n) {
                dp[i+1] = Math.min(dp[i+1],dp[i] + Math.abs(a[i] - a[i+1]));
            }
            if (i+2 <= n){
                dp[i+2] = Math.min(dp[i+2],dp[i] + Math.abs(a[i] - a[i+2]));
            }
        }
        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[]res = new int[n+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            res[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(test(n,res));
        
    }
}
