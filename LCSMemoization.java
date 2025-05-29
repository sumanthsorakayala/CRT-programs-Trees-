public class LCSMemoization {

    public static int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0) return 0;
        if (memo[m][n] != -1) return memo[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        } else {
            memo[m][n] = Math.max(
                lcs(s1, s2, m - 1, n, memo),
                lcs(s1, s2, m, n - 1, memo)
            );
        }

        return memo[m][n];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int m = s1.length(), n = s2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) java.util.Arrays.fill(row, -1);
        System.out.println("LCS length: " + lcs(s1, s2, m, n, memo));  // Output: 3
    }
}