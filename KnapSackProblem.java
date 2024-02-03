/*
 * Given N items where each item has some weight and profit associated with it and 
 * also given a bag with capacity W, [i.e., the bag can hold at most W weight in it].
 * The task is to put the items into the bag such that the sum of profits associated
 * with them is the maximum possible. 
   Note: The constraint here is we can either put an item completely into the bag or
   cannot put it at all [It is not possible to put a part of an item into the bag].
 */
public class KnapSackProblem {
	// Driver code 
    public static void main(String args[]) 
    { 
        int profit[] = new int[] { 60, 100, 120 }; 
        int weight[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
        int n = profit.length; 
        System.out.println(knapSack(W, weight, profit, n)); 
    } 
	
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static int knapSack(int W, int wt[], int val[], int n) {
		// Base Case
		if (n == 0 || W == 0)
			return 0;

		if (wt[n - 1] > W)
			return knapSack(W, wt, val, n - 1);
		else
			return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
	}

	// or you can use below method
	public static int knapsack(int[] wt, int[] values, int capacity, int length) {
		if (capacity == 0 || length == 0)
			return 0;

		int total = 0;
		for (int i = 0; i < length; i++) {
			if (wt[length - 1] <= capacity) {
				total = Math.max(values[length - 1] + knapsack(wt, values, capacity - wt[length - 1], length - 1),
						knapsack(wt, values, capacity, length - 1));
			}
		}
		return total;
	}
}
