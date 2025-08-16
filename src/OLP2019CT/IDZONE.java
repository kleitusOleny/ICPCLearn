package OLP2019CT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IDZONE {
    static final long modulo = 998244353;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        long[]fib = new long[(int)n+2];
        long res = 1;
        if (fib.length == 1){
            System.out.println(res);
            return;
        }else {
            fib[0] = 0;
            fib[1] = 1;
            for (int i = 2; i <= n+1; i++) {
                fib[i] = (fib[i - 1] + fib[i - 2]) % modulo;
                res += (fib[i]*fib[i] % modulo);
                res %= modulo;
            }
        }
        System.out.println(res % modulo);
    }
//    public static
}
