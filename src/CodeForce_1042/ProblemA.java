package CodeForce_1042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemA {
    static int[] a,b;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nTest = Integer.parseInt(br.readLine());
        for (int t = 1; t <= nTest; t++) {
            int n = Integer.parseInt(br.readLine());
            a = new int[n];
            b = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            boolean run = true;
            while (run) {
                count++;
                run = false;
                for (int i = 0; i < n; i++) {
                    if (a[i] > b[i]) {
                        a[i]--;
                        run |= true;
                        break;
                    }
                    if (b[i] > a[i]) {
                        a[i]++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
