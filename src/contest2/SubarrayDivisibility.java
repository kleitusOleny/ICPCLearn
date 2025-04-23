package contest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//
public class SubarrayDivisibility {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
   
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
    
        long[] freq = new long[n];
        freq[0] = 1;
        
        long sum = 0;
        long count = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            int rem = (int) (((sum % n) + n) % n);
            count += freq[rem];
            freq[rem]++;
        }
        System.out.println(count);
    }
}
