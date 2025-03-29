package LeetCode;

import java.util.Arrays;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[]res = new int[nums1.length];
        Arrays.fill(res,-1);
        for (int i = 0; i < nums1.length; i++) {
            int n2Index = findIndex(nums2,nums1[i]);
            System.out.println(n2Index);
            if (n2Index == -1) continue;
            for (int j = n2Index; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
    
    public static int findIndex(int[]a,int b){
        int i = -1;
        int j = a.length;
        while (!(++i>--j)){
            if (a[i] ==b){
                return i;
            }else if (a[j] == b){
                return j;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[]a = new int[]{1,3,5,2,4};
        int[]b = new int[]{6,5,4,3,2,1,7};
        
        System.out.println(Arrays.toString(nextGreaterElement(a,b)));
    }
}
