public class SubArraysWithGivenSum {
	public static void main(String[] args) {
		int[] array = { 2, 3, 1, 4, 7, 17 };
		PSA(array, 10);
	}

	public static void PSA(int[] array, int sum) {

		if (sum <= 0)
			return;

		int subsum;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				subsum = calculateSum(array, i, j);
				if (subsum == sum)
					for (int k = i; k <= j; k++) {
						System.out.print(array[k] + " ");
					}
			}
			System.out.println();
		}
	}

	public static int calculateSum(int[] array, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += array[i];
		}
		return sum;
	}
}
