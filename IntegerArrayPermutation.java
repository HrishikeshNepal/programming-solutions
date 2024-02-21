class IntegerArrayPermutation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        permute(array, 0);
    }

    /*
     time complexity: O(2^n)
     space complexity: O(n) - same array of size n can be used
    */
    public static void permute(int[] array, int j) {
        int n = array.length;
        if (j == n - 1) {
            //print all elements from array
            printArray(array);
            System.out.println();
        }
        for (int i = j; i < n; i++) {
            //swap i and j
            swap(array, i, j);
            permute(array, j + 1);
            //revert to original array and do the rest of the swapping
            swap(array, i, j);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
