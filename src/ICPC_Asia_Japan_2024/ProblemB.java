package ICPC_Asia_Japan_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemB {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] a,b;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while ((n = Integer.parseInt(br.readLine())) != 0){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            a = new int[n+1];
            b = new int[n+1];
            for (int i = 1; i <= n; i++) {
                a[i] = a[i-1] + Integer.parseInt(st1.nextToken());
                b[i] = b[i-1] + Integer.parseInt(st2.nextToken());
            }
            int m = 0;
            if (a[1] != b[1]) {
                m = (a[1] > b[1] ? 1 : 2);
            }
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (m == 0){
                    if (a[i] > b[i]){m = 1; }
                    if (b[i] > a[i]){m = 2; }
                }else {
                    if (m == 1 && b[i] > a[i]){ count++; m = 2; }
                    if (m == 2 && a[i] > b[i]){ count++; m = 1; }
                }
            }
            stringBuilder.append(count).append("\n");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
