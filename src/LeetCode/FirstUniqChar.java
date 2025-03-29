package LeetCode;

import java.util.*;

public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length() ; i++) {
            boolean isUniq = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)&&i!=j){
                    isUniq = false;
                    System.out.println("run");
                    break;
                }
            }
            if (isUniq){
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(firstUniqChar( "leetcode"));
    }
}
