
public class BinarySearchTree {
	public static void main(String[] args) {
		int[] array = { 1, 3, 4, 6, 7, 9, 11, 12, 13, 17 };
		System.out.println(binarySearchForValue(array, 11, 0, array.length - 1));
	}

	// array will be sorted
	public static boolean binarySearchForValue(int[] array, int value, int start, int end) {
		int mid = (end + start) / 2;
		boolean result = false;

		if (value == array[mid])
			return true;
		else if (value < array[0] || value > array[array.length - 1])
			return false;
		else if (end - start == 1 && (array[start] == value || array[end] == value)) {
			return true;
		} else if (end - start == 1 && array[start] != value && array[end] != value) {
			return false;
		} else if (value < array[mid]) {
			result = binarySearchForValue(array, value, start, mid);
		} else {
			start = mid + 1;
			result = binarySearchForValue(array, value, start, end);
		}

		return result;
	}
}
