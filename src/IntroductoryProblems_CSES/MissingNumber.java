
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean[]check = new boolean[n+1];
        while (st.hasMoreTokens()){
            check[Integer.parseInt(st.nextToken())] = true;
        }
        for (int i = 1; i < check.length; i++) {
            if (!check[i]){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
