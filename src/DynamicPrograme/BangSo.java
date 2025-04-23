package DynamicPrograme;

import java.util.Scanner;

/*
7
4 9 2 4 1 3 7
 */

public class BangSo {
    public static int test(int n,int[]a){
        int[]f = new int[n+1];
        f[1] = a[1];
        for (int i = 1; i < n; i++) {
            if (i+1 <= n) {
                
                f[i + 1] = Math.max(f[i + 1], f[i] - a[i]);
            }
        }
        return f[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]a = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(test(n,a));
    }
}
