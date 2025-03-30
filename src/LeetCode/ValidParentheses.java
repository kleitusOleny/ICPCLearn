package LeetCode;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
        if(s.length() % 2 != 0){
            return false;
        }else {
            Stack <Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c){
                    case '(': stack.push(')'); break;
                    case '[': stack.push(']'); break;
                    case '{': stack.push('}'); break;
                    default: if (stack.isEmpty() || stack.pop() != c){
                        return false;
                    }
                }
                System.out.println(stack);
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        String s = "([])";
        System.out.println(isValid(s));
    }
}
