public class IntegerArraysPermutation {
	// write a program to do the integer array permutation
	// int[] array = {1, 2, 3, 4};

	public static void main(String[] args) {
		/*
		 * what is permutation? having all the possible combinations of elements from an
		 * array which means each element from an array in every positions possible
		 */
		int[] array = { 1, 2, 3 };
		generatePermutation(array, 0);
	}

	public static void generatePermutation(int[] array, int index) {
		if (index == array.length - 1) {
            // Base case: reached the end of the array, print the permutation
            printArray(array);
            return;
        }

        for (int i = index; i < array.length; i++) {
            // Swap elements at index and i
            swap(array, index, i);
            // Recursively generate permutations for the remaining elements
            generatePermutation(array, index + 1);
            System.out.println();
            // Undo the swap to backtrack
            swap(array, index, i);
        }
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
	}
}
