import java.util.Arrays;

class ContainerWithMostWater {
    /*
    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints
    of the ith line are (i, 0) and (i, height[i]).
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
    the max area of water (blue section) the container can contain is 49.
    */

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    /*
    time complexity: O(n*n)
    space complexity: O(2n) ~ O(n)
     */
    public static int maxArea(int[] height) {
        int n = height.length;
        int[] area = new int[n];
        if (n == 1) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            int temp = 0;
            for (int j = 0; j <= i; j++) {
                temp = Math.max(temp, (i - j) * Math.min(height[i], height[j]));
            }
            area[i] = temp;
        }
        return Arrays.stream(area).max().getAsInt();
    }
}
