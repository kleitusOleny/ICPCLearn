
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;

public class repetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[]charN = new int[150];
        Arrays.fill(charN,1);
        int max = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1) == str.charAt(i)) {
                charN[str.charAt(i)]++;
            }else {
                charN[str.charAt(i)] =1;
            }
            if (max < charN[str.charAt(i)]){
                max = charN[str.charAt(i)];
            }
        }
        System.out.println(max);
    }
}
