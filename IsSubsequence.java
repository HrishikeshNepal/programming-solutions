/*
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting 
some (can be none) of the characters without disturbing the relative positions of the remaining 
characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
 */
public class IsSubsequence {
	public static void main(String[] args) {
		String s = "ahbgdc", t = "abc";
		System.out.println(isSubsequence(s, t));
	}

	public static boolean isSubsequence(String s, String t) {
		
		if(s.length() == 0 || t.length() == 0)
			return false;
		int m = s.length() - 1;
		int n = t.length() - 1;
		boolean result = false;
		
		while(m != 0 || n != 0) {
			if(s.charAt(m) == t.charAt(n)) {
				s = s.substring(0, m);
				t = t.substring(0, n);
				m = s.length() - 1;
				n = t.length() - 1;
			} else {
				s = s.substring(0, m);
				m = s.length() - 1;
			}
		}
		
		if (t.length() - 1 == 0) {
			result = true;
		}
		
		return result;
	}
}
