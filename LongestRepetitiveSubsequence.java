import java.util.Arrays;

public class LongestRepetitiveSubsequence {
	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 2, 2, 2, 2, 3, 3, 4 };
		System.out.println(LIS(array));
	}

	public static int LIS(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int[] L = new int[arr.length];
		L[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr[i]) {
					L[i] = L[j] + 1;
				} else
					L[i] = 1;
			}

		}
		return Arrays.stream(L).max().getAsInt();
	}
}
