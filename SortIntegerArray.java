import java.util.Arrays;

public class SortIntegerArray {
	public static void main(String args[]) {
		int[] array = { 1, 5, 2, 2, 1, 7, 7, 3 };
		Arrays.stream(sortIntegers(array)).forEach(p -> System.out.print(p + " "));
		// alternatively
		Arrays.stream(array).sorted().forEach(p -> System.out.print(p + " "));
	}

	public static int[] sortIntegers(int[] array) {
		int n = array.length;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}
