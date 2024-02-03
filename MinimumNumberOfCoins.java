public class MinimumNumberOfCoins {
	public static void main(String[] args) {
		int[] coins = { 2, 3, 5, 7 };
		int V = 37;
		int m = coins.length;
		System.out.println(minCoins(coins, m, V));
	}

	// minimum number of coins is one case of greedy algorithm
	// Given array of available coins, find the minimum number of coins required to
	// make the given value (V)
	// coins can be reused
	static int minCoins(int coins[], int m, int V) {
		if (V == 0)
			return 0;

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			if (coins[i] <= V) {
				int sub_res = minCoins(coins, m, V - coins[i]);
				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
					res = sub_res + 1;
			}
		}
		return res;
	}
}
