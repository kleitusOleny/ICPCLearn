package LeetCode;

public class RomanToInt {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'X':
                    result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100;
                    break;
                
                default:
                    throw new IllegalStateException("Unexpected value: " + s.charAt(i));
            }
        }
        return result;
    }
}
