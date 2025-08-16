import java.io.*;
import java.util.*;

public class BoNam {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w1 = Integer.parseInt(st.nextToken());
        int w2 = Integer.parseInt(st.nextToken());
        
        if (n < 0) {
            System.out.println("n không hợp lệ");
            br.close();
            return;
        }

        int[] a = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (!st.hasMoreTokens()) throw new IOException("Thiếu phần tử a[" + i + "]");
            a[i] = Integer.parseInt(st.nextToken());
        }
       
        if (w1 == 0 && w2 == 0) {
            int max = a[1];
            for (int i = 2; i <= n; i++) {
                max = Math.max(max, a[i]);
            }
            System.out.println(max);
            br.close();
            return;
        }

        long[][] dp = new long[2][6];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE / 2);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int curr = i % 2;
            int prev = (i - 1) % 2;

            for (int k = 0; k <= 5; k++) {
                dp[curr][k] = Long.MIN_VALUE / 2;
            }

            for (int k = 0; k <= 5; k++) {
                if (dp[prev][k] != Long.MIN_VALUE / 2) {
                    dp[curr][k] = Math.max(dp[curr][k], dp[prev][k]);
                }

                if (k > 0 && dp[prev][k - 1] != Long.MIN_VALUE / 2) {
                    long weight;
                    if (k % 2 == 0) {
                        weight = (long) a[i] * w2;
                    } else if (k == 3) {
                        weight = a[i];
                    } else {
                        weight = (long) a[i] * w1;
                    }
                    dp[curr][k] = Math.max(dp[curr][k], dp[prev][k - 1] + weight);
                }
            }
        }
        long result = dp[n % 2][5];
        System.out.println(result);
        br.close();
    }
}