import java.math.BigInteger;
import java.util.Arrays;

class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] array = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int m = 4;
        int[] arrayWithM1sInBinaryPositions = getBinaryPositionsWithMBitsAs1(array, m);
        int totalZeroes = (int) Arrays.stream(array).filter(p -> p == 0).count();
        int[] arrayWith0Positions = getArrayWithPositionsHavingValueAs0(array, totalZeroes);
        for (int value : arrayWithM1sInBinaryPositions) {
            System.out.print(value + " ");
        }
        System.out.println();
        //need to get arrays for 6 different cases
        int[] maxLengtsForEachArray = new int[arrayWithM1sInBinaryPositions.length];
        for (int i = 0; i < arrayWithM1sInBinaryPositions.length; i++) {
            int[] replacedArray = placeM1sInPlaceOf0s(array, arrayWithM1sInBinaryPositions[i]);
//            for (int value : replacedArray) {
//                System.out.print(value + " ");
//            }
            System.out.println();
            // find longest array with consecutive 1s
            maxLengtsForEachArray[i] = longestArrayWithConsecutive1s(replacedArray);
            replacedArray = rePlaceM0sInPlaceOf1s(array, arrayWith0Positions);
            for (int value : maxLengtsForEachArray) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
        System.out.println("Maximum length after removal of M zeroes is : " + Arrays.stream(maxLengtsForEachArray).max().getAsInt());
    }

    public static int[] getBinaryPositionsWithMBitsAs1(int[] array, int m) {
        //count total zeroes in original array
        int totalZeroes = (int) Arrays.stream(array).filter(p -> p == 0).count();
        int opSize = (int) Math.pow(2, totalZeroes);
        int[] result = new int[opSize];
        int index = 0;
        for (int i = 0; i < opSize; i++) {
            int count = 0;
            for (int j = 0; j < totalZeroes; j++) {
                if (BigInteger.valueOf(i).testBit(j)) {
                    count++;
                }
            }
            if (count == m) {
                result[index] = i;
                index++;
            }
        }
        int i = 0;
        while (result[i] != 0) {
            i++;
        }
        int[] arrayWithM1sInBinaryPositions = new int[i];
        for (int j = 0; j < i; j++) {
            arrayWithM1sInBinaryPositions[j] = result[j];
            //System.out.print(arrayWithM1sInBinaryPositions[j] + " ");
        }
        return arrayWithM1sInBinaryPositions;
    }

    public static int[] placeM1sInPlaceOf0s(int[] array, int value) {
        int totalZeroes = (int) Arrays.stream(array).filter(p -> p == 0).count();
        for (int j = 0; j < totalZeroes; j++) {
            if (BigInteger.valueOf(value).testBit(j)) {
                // when j = 2, which means remove 3rd 0 to 1 and j = 3, which is 4rth 0 to 1 in array
                // and return array
                //remove (j+1)th 0 from array
                removeJthElementFromArray(array, j);
            }
        }
        return array;
    }

    public static int[] rePlaceM0sInPlaceOf1s(int[] array, int[] arrayWith0Positions) {
        int j = 0;
        for (int i = 0; i<array.length; i++) {
            if (i == arrayWith0Positions[j]) {
                array[i] = 0;
                j++;
                if(j == arrayWith0Positions.length)
                    break;
            }
        }
        return array;
    }

    public static void removeJthElementFromArray(int[] array, int j) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                counter++;
            }
            if (counter == j + 1) {
                array[i] = 1;
            }
        }
    }

    public static int longestArrayWithConsecutive1s(int[] array) {
        int n = array.length;
        int[] L = new int[array.length];
        int counter = 1;
        for (int i = 0; i < n; i++) {
            if(array[i] == 0) {
                counter = 1;
                L[i] = counter;
            }
            else
                L[i] = counter++;
        }
        return Arrays.stream(L).max().getAsInt();
    }

    public static int[] getArrayWithPositionsHavingValueAs0(int[] array, int totalZeroes){
        int[] result = new int[totalZeroes];
        int k = 0;
        for(int i = 0; i<array.length; i++){
            if(array[i] == 0){
                result[k] = i;
                k++;
            }
        }
        return result;
    }
}
