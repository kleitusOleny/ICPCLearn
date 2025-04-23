package contest;


import java.util.Scanner;

public class BanDua {
    public static int getEdgeOfSquare(int n,int[]arr){
        int res = 1;
        int left =0, right = 0;
        int edge = 0, min =0;
        while (left < n && right < n){
            if (minOfAll(arr,left,right) > edge){
                edge++;
                right++;
            }else {
                edge--;
                left++;
            }
            if (edge > res){
                res = edge;
            }
        }
        return res;
    }
    
    public static int minOfAll(int[]arr,int left,int right){
        int res = arr[left];
        for (int i = left+1; i <= right; i++) {
            res = Math.min(res,arr[i]);
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
        System.out.println(getEdgeOfSquare(n,arr));
        
    }
}
