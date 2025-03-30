package contest;

import java.util.*;

public class SumOfThreeValues {
    static class Pair {
        int value, index;
        
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    public static int[] sumOfThreeValues(int[] nums, int s, int n) {
        Pair[] arr = new Pair[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i + 1);
        }
        
        Arrays.sort(arr, Comparator.comparingInt(a -> a.value));
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = arr[i].value + arr[left].value + arr[right].value;
                if (sum == s) {
                    int[] res = new int[]{arr[i].index, arr[left].index, arr[right].index};
                    Arrays.sort(res);
                    return res;
                } else if (sum < s) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
        return new int[0];
    }
    
    
    
}