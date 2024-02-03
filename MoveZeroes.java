/*
 * Given an integer array nums, move all 0's to the end of it while maintaining the 
 * relative order of the non-zero elements.
	Note that you must do this in-place without making a copy of the array.
	Example 1:
	Input: nums = [0,1,0,3,12]
	Output: [1,3,12,0,0]
	Example 2:
	Input: nums = [0]
	Output: [0]
 */
public class MoveZeroes {
	public static void main(String[] args) {
		int[] array = { 0, 1, 0, 3, 12 };
		array = moveZeroes(array);
		for (int value : array)
			System.out.print(value + " ");
	}

	public static int[] moveZeroes(int[] array) {
		int n = array.length;
		int i = 0;
		while (i < n) {
			if (array[i] == 0) {
				int j = i + 1;
				while (array[j] == 0 && j < n) {
					j++;
					if (j == n)
						break;
				}
				if (j != n) {
					array[i] = array[j];
					array[j] = 0;
				}
				if (j == n)
					break;
				else
					i++;
			}
		}
		return array;
	}
}
