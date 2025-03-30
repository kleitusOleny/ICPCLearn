
import java.util.Arrays;
import java.util.Scanner;

public class NearestSmallerValue {
    public static int[]nearestSmallerValue(int n,int[]arr){
        int[]res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] < arr[i]){
                    res[i] = j+1;
                    break;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[]arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int[]test = nearestSmallerValue(n,arr);
        for (int i = 0; i < n; i++) {
            System.out.print(test[i] + " ");
        }
    }
}
