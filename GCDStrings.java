class GCDStrings{
    /*
    Example 1:
    Input: str1 = "ABCABC", str2 = "ABC"
    Output: "ABC"
    Example 2:
    Input: str1 = "ABABAB", str2 = "ABAB"
    Output: "AB"
    Example 3:
    Input: str1 = "LEET", str2 = "CODE"
    Output: ""
     */
    public static void main(String args[]){
        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.println(findGCD(str1, str2));
    }

    public static String findGCD(String str1, String str2){
        int i = 1;
        String replacementStr = "";
        while(!replacementStr.equals(str2.substring(0,i))) {
            if (replacementStr.equals(str2.substring(0, i))) {
                str2 = str2.substring(i);
                i++;
                return replacementStr;
            } else {
                replacementStr = replacementStr + str2.substring(0, 1);
                str2 = str2.substring(i);
                i++;
            }
        }
        return replacementStr;
    }
}
