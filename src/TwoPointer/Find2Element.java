package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find2Element {
    //sorted
    public static int[] find2EExactInput(int x,int[]arr) {
        int start = 0, end = arr.length - 1, max = arr.length - 1;
        while (arr[start] < arr[end]) {
            if (arr[start] + arr[end] == x) {
                return new int[]{start, end};
            } else if (arr[start] + arr[end] > x) {
                end--;
            } else start++;
        }
        return null;
    }
    public static void main(String[] args) {
        int[]a = new int[]{2,5,6,8,12,15};
        System.out.println(Arrays.toString(find2EExactInput(10,a)));
    }
}
