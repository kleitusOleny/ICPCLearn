
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IncreasingArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]a = new int[n];
        for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
        }
        long count = 0;
        for (int i = 0; i < n -1; i++) {
            if (a[i] > a[i+1]){
                count+= (a[i] - a[i+1]);
                a[i+1] = a[i];
            }
        }
        System.out.println(count);
    }
}
