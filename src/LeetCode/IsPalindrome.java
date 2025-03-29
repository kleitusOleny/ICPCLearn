package LeetCode;

public class IsPalindrome {
    
    public boolean isPalindrome(int x){
        String s = String.valueOf(x);
        int i = 0, j = s.length() -1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
