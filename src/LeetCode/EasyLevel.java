package LeetCode;

import java.util.Arrays;

public class EasyLevel {
    int[] nums =new int[]{3,2,2,3};
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        int[]tmp = new int[nums.length];
        Arrays.fill(tmp,-1);
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
                count++;
            }else{
                tmp[start] = nums[i];
            }
        }
        
        return count;
        
    }
    
    public static void main(String[] args) {
        EasyLevel test = new EasyLevel();
        System.out.println(removeElement( test.nums,3));
        System.out.println(Arrays.toString(test.nums));
    }
}
