package contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SumOfThreeValues {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        StringBuilder res = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> pos = new LinkedHashMap<>();
        int[]arr = new int[n+1];
        
        for (int i = n-1; i <= 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ans = arr[i] + arr[j];
                if (x - ans > 0) {
                
                }
            }
        }
        
        System.out.println("IMPOSSIBLE");
    }
}