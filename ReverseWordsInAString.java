class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        /*
        time complexity: O(n)
        space complexity: O(n)
         */
        String[] array = s.trim().split("\\s+");
        System.out.println(array.length);
        int n = array.length;
        String str = "";
        for (int i = 0; i < n - 1; i++) {
            str += array[n - 1 - i] + " ";
        }
        str = str + array[0];
        return str;
    }


}
