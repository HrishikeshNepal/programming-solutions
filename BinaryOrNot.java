/*
17) How to check whether given number is binary or not?
Write a Java program to check whether given number is binary or not.
A binary number is a number which contains only 0 or 1.
For example : 101101, 110010110, 10010011 are binary numbers.
This program is one of the number related basic Java programs for interview.
 */

class BinaryOrNot{
    /*
    time complexity: O(n)
    space complexity: O(c) = O(1)
    test cases:
    1) number longer than 16 bits
    2) number is 0 or 1
    3) negative number
     */
    public static void main(String[] args){
        long number = 1100101100100011010L;
        System.out.println(isBinary(number));
    }

    public static boolean isBinary(long number){
        boolean result = false;
        while(number != 0) {
            result = number % 10 == 0 || number % 10 == 1;
            if(!result){
                return false;
            }
            number = number / 10;
        }
        return result;
    }
}
