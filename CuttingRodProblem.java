/*
 * Given a rod of length n inches and an array of prices that includes prices of
 * all pieces of size smaller than n. Determine the maximum value obtainable by 
 * cutting up the rod and selling the pieces. For example, if the length of the 
 * rod is 8 and the values of different pieces are given as the following, then 
 * the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6) 

	length   | 1   2   3   4   5   6   7   8  
	--------------------------------------------
	price    | 1   5   8   9  10  17  17  20
 */
public class CuttingRodProblem {
	public static void main(String[] args) {
		int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = price.length;
		System.out.println(cutRod(price, n));
		System.out.println(cutRod(price, n-1, n));
	}

	public static int cutRod(int[] price, int n) {
		if (n == 0)
			return 0;

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			int cost = price[i - 1] + cutRod(price, n - i);
			if (cost > max && cost != Integer.MAX_VALUE) {
				max = cost;
			}
		}
		return max;
	}

	// alternative approach
	static int cutRod(int price[], int index, int n) {
        // base case
        if (index == 0) {
            return n * price[0];
        }
        // At any index we have 2 options either
        // cut the rod of this length or not cut
        // it
        int notCut = cutRod(price, index - 1, n);
        int cut = Integer.MIN_VALUE;
        int rod_length = index + 1;
 
        if (rod_length <= n)
            cut = price[index]
                  + cutRod(price, index, n - rod_length);
 
        return Math.max(notCut, cut);
    }
}
