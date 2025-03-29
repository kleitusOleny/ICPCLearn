package LeetCode;

import java.util.*;

public class RomanToInt {
    public static int romanToInt(String s) {
        int result = 0;
        int i = 0;
        while (i < s.length()){
            switch (s.charAt(i)) {
                case 'I':
                    result += (i+1 < s.length() && s.charAt(i + 1) != 'I' ? -1 : 1);
                    break;
                case 'V':
                    result +=  5;
                    break;
                case 'X':
                    if (i+1 < s.length()){
                        if (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'){
                            result -= 10;
                            break;
                        }
                    }
                    result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i+1 < s.length()){
                        if (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M'){
                            result -= 100;
                            break;
                        }
                    }
                    result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
            i++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
