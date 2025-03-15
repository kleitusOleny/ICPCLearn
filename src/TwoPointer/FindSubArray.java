package TwoPointer;

import java.util.Arrays;

public class FindSubArray {
    public static int[] findLongestSubArrayBelowInput(int s, int[]arr){
        int min=0, max= 1;
        int len = arr.length - 1;
        int tmpSum = arr[0];
        while(max < len ||min < len || min < max){
            if (tmpSum < s){
                tmpSum+= arr[max++];
            }else {
                tmpSum -= arr[min++];
            }
        }
        return Arrays.copyOfRange(arr,min,max);
    }
    
    public static void main(String[] args) {
        int[]arr = new int[]{2,6,5,3,6,8,9};
        System.out.println(Arrays.toString(findLongestSubArrayBelowInput(20,arr)));
    }
}
