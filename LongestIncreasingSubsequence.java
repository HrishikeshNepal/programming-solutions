import java.util.Arrays;

class LongestIncreasingSubsequence {
    /*
    let's write a program to find the longest increasing subsequence in an integer array:
    int array[] = {4,1,2,3,1,6,7}
    longest increasing subsequence = {1,2,3,6,7}
     */
    public static void main(String[] args) {
        int array[] = {4,1,2,3,1,6,7};
        findLIS(array);
    }

    public static void findLIS(int[] array){
        int n = array.length;
        int L[] = new int[n];
        L[0] = 1;
        for(int i = 1; i<n; i++){ //O(n)
            for(int j = 0; j<=i; j++){ //O(n) //O(n*n)
                if(array[i] > array[j] && L[j] > L[i]){
                    L[i] = L[j];
                }
            }
            L[i]++;
        }

        System.out.println("length of longest increasing subsequence is : "+ Arrays.stream(L).max().getAsInt());
        for(int value : L){ //O(n)
            System.out.print(value + " ");
        }
    }
}
