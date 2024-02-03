/*
How to find all pairs of elements in an array whose sum is equal to given number?
Write a Java program to find all pairs of elements in the given array whose sum is
equal to a given number. For example, if {4, 5, 7, 11, 9, 13, 8, 12} is an array and
20 is the given number, then you have to find all pairs of elements in this array
whose sum must be 20. In this example, (9, 11), (7, 13) and (8, 12) are such pairs whose sum is 20.
 */
class PairsOfElementsWithGivenSum {
    public static void main(String[] args) {
        int array[] = {4, 5, 7, 11, 9, 13, 8, 12};
        int sum = 20;
        getPairsWithGivenSum(array, sum);
    }

    // solution 1
    public static void getPairsWithGivenSum(int[] array, int sum) {
        /*
        time complexity = O(n * n - 1) = O(n*n)
        space complexity: O(n) ==> since an array of length n has to be available in the memory (ignoring constants)
         */
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] + array[j] == sum) {
                    System.out.print("(" + array[i] + ", " + array[j] + ")");
                    System.out.print(",");
                }
            }
        }
    }
}
