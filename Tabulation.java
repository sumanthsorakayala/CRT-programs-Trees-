class Tabulation {
  
    // Function to calculate the nth Fibonacci number using iteration
    static int nthFibonacci(int n) {
        // Handle the edge cases
        if (n <= 1) return n;
      
        // Create an array to store Fibonacci numbers
        int[] dp = new int[n + 1];

        // Initialize the first two Fibonacci numbers
        dp[0] = 0;
        dp[1] = 1;

        // Fill the array iteratively
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the nth Fibonacci number
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int result = nthFibonacci(n);
        System.out.println(result);
    }
}