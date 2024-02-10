import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] nums = {4,5};
        int val = 4;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        // length = nums.length
        // need to remove val from nums
        // i = 0, nums[0] = val, count ++;
        // swap nums[i] with last element
        // decrease last element position;
        // check nums[i] until nums[i] != val
        int count = (int) Arrays.stream(nums).filter(p -> p != val).count();
        int n = nums.length - 1;
        int i = 0;
        int j = n;
        while (i < count) {
            if(nums[i] != val){
                i++;
                if(i==count)
                    break;
            }
            while (nums[i] == val) {
                if (nums[i] == nums[j]) {
                    j--;
                } else if (i == count){
                    break;
                }else {
                    swapElements(nums, i, j);
                    i++;
                }
            }
        }
        return (int) Arrays.stream(nums).filter(p -> p != val).count();
    }

    public static void swapElements(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}