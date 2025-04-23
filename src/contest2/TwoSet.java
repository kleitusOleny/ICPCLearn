package contest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//greedy
//Algo sum fix
public class TwoSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        long totalSum = ((long)n * (n + 1)) / 2;
        
        if ((n % 4 != 0) && (n % 4 != 3)) {
            System.out.println("NO");
            return;
        }
        boolean[] inSet1 = new boolean[n + 1];
        int[] set1 = new int[n];
        int set1Size = 0;
        long currentSum = 0;

        for (int i = n; i >= 1; i--) {
            if (currentSum + i <= totalSum/2) {
                inSet1[i] = true;
                set1[set1Size++] = i;
                currentSum += i;
            }
        }

        int[] set2 = new int[n];
        int set2Size = 0;
        for (int i = 1; i <= n; i++) {
            if (!inSet1[i]) {
                set2[set2Size++] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("YES\n");
        
        sb.append(set1Size).append("\n");
        for (int i = 0; i < set1Size; i++) {
            sb.append(set1[i]);
            if (i < set1Size - 1) sb.append(" ");
        }
        sb.append("\n");

        sb.append(set2Size).append("\n");
        for (int i = 0; i < set2Size; i++) {
            sb.append(set2[i]);
            if (i < set2Size - 1) sb.append(" ");
        }
        sb.append("\n");
        
        System.out.print(sb);
    }
}
