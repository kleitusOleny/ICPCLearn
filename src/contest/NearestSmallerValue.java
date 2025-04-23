
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NearestSmallerValue {
    public static void nearst(int n,int[]arr) {
        Stack<Integer> stack = new Stack<>();
        int[] arr2 = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr2[i] = arr[i-1];
        }
        stack.push(0);
        for (int i = 1; i <= n; i++) {
            //remove
            while (!stack.isEmpty() ){
                if (arr2[i] <= arr2[stack.peek()]) {
                    stack.pop();
                }else {
                    System.out.print(stack.peek()+ " ");
                    break;
                }
            }
            stack.push(i);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[]arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        nearst(n,arr);
        br.close();
    }
}
