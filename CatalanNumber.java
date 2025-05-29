public class CatalanNumber {

    public static long catalan(int n) {
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Catalan Number C(" + n + ") = " + catalan(n)); 
    }
}