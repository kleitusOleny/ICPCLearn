package LeetCode;

public class CheckValidCuts {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int countGrid = 0;
        int[][]trackMatrix = new int[n][n];
        for (int i = 1; i < n-1; i++) {
            for (int[] rec : rectangles){
                if (i > rec[0] && i< rec[3]){
                
                }else {
                    countGrid++;
                }
            }
        }
        return countGrid > 1;
    }
    
    public int[][] fillMatrix(int[][]input, int startX,int startY, int endX, int endY){
        int[][] result = input.clone();
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                result[i][j] = 1;
            }
        }
        return result;
    }
    
    public static void printMatrix(int[][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        
    }
    
    public static void main(String[] args) {
        CheckValidCuts checkValidCuts = new CheckValidCuts();
        int[][] test = new int[5][5];
        printMatrix(checkValidCuts.fillMatrix(test,1,0,5,2));
    }
}
