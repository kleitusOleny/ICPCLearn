package TwoPointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    
    
    
    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {3,2,4};
        int target2 = 6;
        int target1 = 9;
        int[] result = twoSum(nums2, target2);
        System.out.println(Arrays.toString(result));
    }
}
