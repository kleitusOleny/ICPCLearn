package DynamicPrograme;

import java.util.Arrays;

public class LSI {
    public static int lSI(int[]a){
        int[]l = new int[a.length];
        Arrays.fill(l,1);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]){
                    l[i] = Math.max(l[i], l[j]+1);
                }
            }
        }
        return Arrays.stream(l).max().orElseThrow();
    }
    
    public static void main(String[] args) {
        int[]a = {128,104,53,876,660,961,754,775,290,231,224,915,392,994};
        
        System.out.println(lSI(a));
    }
}
