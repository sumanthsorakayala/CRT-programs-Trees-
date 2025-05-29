public class KnapsackMemoization {

    public static int knapsack(int[] weights, int[] values, int capacity, int n, Integer[][] memo) {
        if (n == 0 || capacity == 0) return 0;
        if (memo[n][capacity] != null) return memo[n][capacity];

        if (weights[n - 1] <= capacity) {
            int include = values[n - 1] + knapsack(weights, values, capacity - weights[n - 1], n - 1, memo);
            int exclude = knapsack(weights, values, capacity, n - 1, memo);
            memo[n][capacity] = Math.max(include, exclude);
        } else {
            memo[n][capacity] = knapsack(weights, values, capacity, n - 1, memo);
        }

        return memo[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;
        int n = weights.length;
        Integer[][] memo = new Integer[n + 1][capacity + 1];
        System.out.println("Max value: " + knapsack(weights, values, capacity, n, memo));  // Output: 7
    }
}
