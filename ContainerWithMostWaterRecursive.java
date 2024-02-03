class ContainerWithMostWaterRecursive {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height, 0, 1));
    }

    public static int maxArea(int[] height, int start, int end) {
        //height = [1,8,6,2,5,4,8,3,7]
        int n = height.length;
        int result = 0;
        int tempEnd = end;
        if(end == n && start == n)
            return result;
        if(start == end)
            maxArea(height, start+1, end + 1);
        else {
            result = (end - start) * Math.min(height[start], height[end]);
            result = Math.max(result, maxArea(height, start, end + 1));
            System.out.println(result);
            return Math.max(result , maxArea(height, start, end + 1));
        }
    }
}
