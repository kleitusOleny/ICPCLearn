package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineTwoArray {
    public static List<Integer> combineTwoArrays(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int n = a.length -1, m = b.length - 1;
        List<Integer> res = new ArrayList<Integer>();
        while(i <= n || j <= m){
            if (j > m || (i <= n && a[i] <= b[j])) res.add(a[i++]);
            else res.add(b[j++]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[]a = new int[]{1,3,6,8,10};
        int[]b = new int[]{2,6,7,12,14,15};
        System.out.println(combineTwoArrays(a,b));
    }
}
