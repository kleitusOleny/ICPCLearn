package random;

import java.io.*;
import java.util.*;

/*
10
25 19 16 7 6 5 5 4 2 2
 */
public class subArrayDivideBy4 {
    static int n;
    static int[] arr;
    static long[][][] dp;
    static List<List<Integer>> result;
    
    public static void main(String[] args) throws IOException {
        // Đọc input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if (n < 4) {
            return;
        }
        
        dp = new long[n + 1][5][4];
        dp[0][0][0] = 1;
        
        for (int pos = 0; pos < n; pos++) {
            for (int cnt = 0; cnt <= 4; cnt++) {
                for (int sumMod4 = 0; sumMod4 < 4; sumMod4++) {
                    if (dp[pos][cnt][sumMod4] == 0) continue;
                    dp[pos + 1][cnt][sumMod4] += dp[pos][cnt][sumMod4];
                    if (cnt < 4) {
                        int newSumMod4 = (sumMod4 + (arr[pos] % 4 + 4) % 4) % 4;
                        dp[pos + 1][cnt + 1][newSumMod4] += dp[pos][cnt][sumMod4];
                    }
                }
            }
        }
        result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, 0, 0, current);
        
        if (result.isEmpty()) {
            return;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (List<Integer> indices : result) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("(").append(arr[indices.get(0)]).append(", ").append(arr[indices.get(1)]).append(", ").append(arr[indices.get(2)]).append(", ").append(arr[indices.get(3)]).append(")");
                System.out.println(stringBuilder);
            }
        }
    }
    
    static void backtrack(int pos, int cnt, int sumMod4, List<Integer> current) {
        if (cnt == 4) {
            if (sumMod4 == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        if (pos >= n) return;
        
        backtrack(pos + 1, cnt, sumMod4, current);
        
        if (cnt < 4) {
            current.add(pos);
            int newSumMod4 = (sumMod4 + (arr[pos] % 4 + 4) % 4) % 4;
            backtrack(pos + 1, cnt + 1, newSumMod4, current);
            current.removeLast();
        }
    }
}