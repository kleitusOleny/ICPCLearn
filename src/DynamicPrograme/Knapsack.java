package DynamicPrograme;

import java.util.Arrays;

public class Knapsack {
    public static int[][] knapsack(int[]w, int[]v, int sum){
        int[][]dp = new int[w.length + 1][sum + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j >= w[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i-1]] + v[i-1]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[w.length][sum]);;
        return dp;
    }
    
    public static String printMatrix(int[][]a){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                s.append(a[i][j]).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
        int[]w = {2,1,4,3};
        int[]v = {3,3,4,2};
        System.out.println(printMatrix(knapsack(w,v,6)));
    }
}
