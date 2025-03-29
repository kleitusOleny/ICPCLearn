package DynamicPrograme;

public class test {
    public static void main(String[] args) {
        String number = "19248759123798125132";
        int n = number.length();
        int[][] dp = new int[n][10]; // dp[i][d] lưu số lần xuất hiện của d từ 0 đến i
        
        // Khởi tạo hàng đầu tiên
        dp[0][number.charAt(0)-'0'] = 1;
        
        // Duyệt qua từng ký tự
        for (int i = 1; i < n; i++) {
            int digit = number.charAt(i) - '0';
            
            // Kế thừa số lần xuất hiện từ dp[i-1]
            for (int d = 0; d < 10; d++) {
                dp[i][d] = dp[i - 1][d];
            }
            
            // Cập nhật chữ số hiện tại
            dp[i][digit]++;
        }
        
        for (int[] intA : dp) {
            for (int j = 0; j < intA.length; j++) {
                System.out.print(intA[j] + " ");
            }
            System.out.println();
        }
        // In kết quả
        for (int d = 0; d < 10; d++) {
            if (dp[n - 1][d] > 0) {
                System.out.println("Chữ số " + d + " xuất hiện " + dp[n - 1][d] + " lần.");
            }
        }
    }
}
