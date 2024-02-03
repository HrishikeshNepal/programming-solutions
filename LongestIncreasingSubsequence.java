import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] array = { 1, 4, 3, 2, 3, 5 };
		LIS(array);
		System.out.println(LIS(array, 0, array.length, Integer.MIN_VALUE));
	}

	public static void LIS(int[] array) {
		int n = array.length;
		int[] L = new int[n];
		L[0] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (array[i] > array[j] && L[i] < L[j]) {
					L[i] = L[j];
				}
			}
			L[i]++;
		}
		for (int i : L) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Length of longest Increasing Subsequence is : " + Arrays.stream(L).max().getAsInt());
		System.out.println("Longest increasing suubsequence is : ");
		printLISArray(array, L);
	}

	public static void printLISArray(int[] array, int[] L) {
		for (int i = 0; i < L.length - 1; i++) {
			if (L[i] != L[i + 1]) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.print(array[L.length - 1]);
	}

	// Recursive approach to find length of LIS
	public static int LIS(int[] array, int i, int n, int prev) {
		if (i == n)
			return 0;

		// exclude first element from the solution
		int excl = LIS(array, i + 1, n, prev);

		// include first element in the solution
		int incl = 0;
		if (array[i] > prev) {
			incl = 1 + LIS(array, i + 1, n, array[i]);
		}

		return Math.max(incl, excl);
	}
}
