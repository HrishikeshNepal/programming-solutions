class SecondHighestElementInAnArray {
    public static void main(String[] args){
     //  1,6,3,4,5,2
     int[] array = {1,6,3,4,5,2};
     System.out.println(getSecondHighestElementFromArray(array));

     //test cases
        // negative tests:
        // i) what if length of array is 1
        // ii) what if array has all same numbers like 2,2,2,2,2,2
        // iii) what if all negative numbers
        // iv) what if array is empty
    }

    public static int getSecondHighestElementFromArray(int[] array){
        int n = array.length;
        int highest = array[0];
        int secondHighest = array[0];

        int i = 1;
        while(i<n){
            if(array[i] > highest){
                secondHighest = highest;
               // System.out.println(secondHighest);
                highest = array[i];
            } else if (array[i] > secondHighest){
                secondHighest = array[i];
               // System.out.println(secondHighest);
            }
            if(highest == secondHighest){
                secondHighest = array[i];
            }
            i++;
        }
        return secondHighest;
    }
}
