package DynamicPrograme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
5
2 5 7 8 4
4 9 10 10

 */
public class XepHangMuaVe {
    public static int test(int n, int[] t, int[] r) {
        int[] f = new int[n + 1];
        
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 <= n) {
                f[i + 1] = Math.min(f[i + 1], f[i] + t[i + 1]);
            }
            if (i + 2 <= n) {
                f[i + 2] = Math.min(f[i + 2], f[i] + r[i + 1]);
            }
            
        }
        return f[n];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] t = new int[n + 1];
        int[] r = new int[n + 1];
        
        for (int i = 1; i < n+1; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            r[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(test(n, t, r));
    }
}
