
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Nearst {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[]arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i <= n; i++) {
            //remove
            while (!stack.isEmpty() ){
                if (arr[i] <= arr[stack.peek()]) {
                    stack.pop();
                }else {
                    System.out.print(stack.peek()+ " ");
                    break;
                }
            }
            stack.push(i);
        }
        
    }
}
