/*
probably not the ideal solution but it works
space complexity: O(2n) ~ O(n)
time complexity: worst case O(2^n * k)
*/

import java.math.BigInteger;
import java.util.Arrays;

class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1};
        int k = 4;
        //System.out.println(getMaxConsecutive1sFromNums(nums));
        System.out.println(longestOnes(nums, k));

    }

    /*
    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6
     */
    public static int longestOnes(int[] nums, int k) {

        //count number of 0s in nums
        int count = (int) Arrays.stream(nums).filter(p -> p == 0).count();
        k = Math.min(k, count);

        // get a new positions array from nums which contains positions in nums where element is 0
        int[] positions = new int[count];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                positions[j] = i;
                j++;
            }
        }

        // flip 0s in nums in positions where the binary values is 1s
        int result = flip0s(nums, positions, count, k);
        return result;

    }

    public static int flip0s(int[] nums, int[] positions, int count, int k) {
        int counter = 0;
        int result = 0;
        double opSize = Math.pow(2, count);
        for(int i = 1; i<opSize; i++){
            for(int j = 0; j<count; j++) {
                if (BigInteger.valueOf(i).testBit(j)){
                    counter ++;
                }
            }
            if(counter == k){
                for(int j = 0; j<count; j++) {
                    if (BigInteger.valueOf(i).testBit(j)){
                        nums[positions[j]] = 1;
                    }
                }
            }
            // get max consecutive 1s from nums
            result  = Math.max(result, getMaxConsecutive1sFromNums(nums));
            // revert to original nums
            if(counter == k){
                for(int j = 0; j<count; j++) {
                    if (BigInteger.valueOf(i).testBit(j)){
                        nums[positions[j]] = 0;
                    }
                }
            }
            counter = 0;

        }
        return result;
    }

    public static int getMaxConsecutive1sFromNums(int[] nums){
        int i = 0;
        int max = 0;
        int temp = 0;
        while(i != nums.length){
            if(nums[i] == 1){
                temp ++;
                i++;
            } else {
                i++;
                max = Math.max(temp, max);
                temp = 0;
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
