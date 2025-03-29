package LeetCode;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        if(k == 0){
            return new int[code.length];
        }else if (k > 0){
            for(int i = 0; i < code.length; i++){
                int len = code.length;
                int tmp = subSolve(code,k,i);
                code[i] = tmp;
            }
            return code;
        }else{
            for(int i = 0; i < code.length; i++){
                int len = code.length;
                int tmp = 0;
                k = Math.abs(k);
                for (int j = 1; j<= k;j++){
                    tmp += code[i+ (j % len)];
                }
            }
            return code;
        }
    }
    
    private int subSolve(int[] code, int k,int cur) {
        int index = 0;
        int res = 0;
        while (k > 0){
            if (cur != code.length){
                res += code[index];
                k--;
            }
        }
        return 0;
    }
}
