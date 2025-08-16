package ICPC_Asia_Japan_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemA {
    static int n;
    static int[]a;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((n = Integer.parseInt(br.readLine())) != 0){
            a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (sum + a[i] <= 300){
                    sum += a[i];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
