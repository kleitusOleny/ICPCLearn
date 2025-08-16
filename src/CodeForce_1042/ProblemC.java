package CodeForce_1042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemC {
    static StringBuilder sb = new StringBuilder();
    static boolean[]check;
    static int[]T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nTest = Integer.parseInt(br.readLine());
        outer:
        while (nTest--> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            check = new boolean[n];
            T = new int[n];
            for (int i = 0; i < n;i ++){
                T[i] = Integer.parseInt(st2.nextToken());
            }
            for (int i = 0; i < n; i++) {
                int s = Integer.parseInt(st1.nextToken());
                for (int j = 0; j < n; j++){
                    int t = T[j];
                    if (!check[j] && ((s + t) % k == 0 || Math.abs(s - t) % k == 0)){
                        check[j] = true;
                        break;
                    }
                }
            }
            for (boolean b: check){
                if (!b){
                    sb.append("NO").append("\n");
                    continue outer;
                }
            }
            sb.append("Yes").append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
