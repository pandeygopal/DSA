import java.util.Arrays;
class Main {
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    static int knapsack(int n, int m, int[] p, int[] w,int [][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (m >= w[n - 1]) {
            int no ;
            if(dp[n][m]!=-1){
            no=dp[n][m];
            }else{
             no = knapsack(n - 1, m, p, w,dp);  
            }
            int yes;
             if(dp[n][m]!=-1){
            yes=dp[n][m];
            }else{
            yes = p[n - 1] + knapsack(n - 1, m - w[n - 1], p, w,dp);
            }
            dp[n][m]=max(no,yes);
            return dp[n][m];
        } else {
            dp[n][m]=knapsack(n - 1, m, p, w,dp);
            return dp[n][m];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 8;
        int[] p = {1, 2, 5, 6};
        int[] w = {2, 3, 4, 5};

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = knapsack(n, m, p, w, dp);
        System.out.println("Maximum Profit: " + result);
    }
}
