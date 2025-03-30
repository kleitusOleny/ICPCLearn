package contest;


public class BanDua {
    public static int getEdgeOfSquare(int n,int[]arr){
        int res = 1;
        int left =0, right = 0;
        int edge = 0;
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
        int[]arr = new int[]{8,8,1,4,6,8,2};
        System.out.println(getEdgeOfSquare(arr.length,arr));
    }
}
