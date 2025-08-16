package OLP2019CT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HexFormat;

public class TOPO {
    static long x,y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String y = br.readLine();
        long sum = Long.parseLong(x.toUpperCase(),16);
        for (long i = Long.parseLong(x,16) +1; i <= Long.parseLong(y,16); i++) {
            sum *= i;
        }
        String sumS = Long.toHexString(sum);
        for (int i = 0; i < sumS.length(); i++) {
        
        }
    }
}
