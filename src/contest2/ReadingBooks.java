package contest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReadingBooks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        int[]books = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }
        
        
        int sum = 0;
        int i =0;
        int count = 0;
        
        for (int j = 0; j < n; j++) {
            sum+= books[j];
            while (sum > t && j>=i){
                sum -= books[i];
                i++;
            }
            count = Math.max(count, j - i + 1);
        }
        
        System.out.println(count);
    }
}
