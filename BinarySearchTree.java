public class BinarySearchTree {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 6, 7, 9, 11, 12, 13, 17};
        System.out.println(binarySearchForValue(array, 11, 0, array.length - 1));
    }

    // array will be sorted
	/*
	time complexity: In a balanced BST, the time complexity for searching an element is O(log(n))
	, where n is the number of nodes in the tree. This efficiency is achieved by halving the search
	space at each level as we compare the target value with the current node's value and proceed left or right.
	In an unbalanced BST, the worst-case time complexity for searching can be O(n)
	if the tree is completely skewed, as each node needs to be traversed in a linear fashion.

	space complexity: O(n) to store array of length n
	*/
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
