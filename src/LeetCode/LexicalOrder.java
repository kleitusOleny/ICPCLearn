package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LexicalOrder {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(n == 1){
            result.add(1);
        }else{
            List<String> resS = new ArrayList<String>();
            resS.add("1");
            for(int i = 2; i <= n; i++){
                resS.add(i+"");
            }
            resS.sort(String::compareTo);
            for (String s: resS){
                result.add(Integer.parseInt(s));
            }
        }
        return result;
    }
}
