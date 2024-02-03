
public class longestCommonSubsequence {
	public static void main(String[] args) {
		char[] str1 = "corona".toCharArray();
		char[] str2 = "verona".toCharArray();
		System.out.println(lcs("corona", "verona"));
		System.out.println(lcs(str1, str2, str1.length, str2.length));

	}

	// using substring method
	public static String lcs(String a, String b) {
		int alength = a.length() - 1;
		int blength = b.length() - 1;

		if (alength < 0 || blength < 0)
			return "";

		if (a.substring(alength).equals(b.substring(blength))) {
			return lcs(a.substring(0, alength), b.substring(0, blength)) + a.substring(alength);
		} else {
			String first = lcs(a, b.substring(0, blength));
			String second = lcs(a.substring(0, alength), b);
			if (first.length() > second.length()) {
				return first;
			} else {
				return second;
			}
		}
	}

	// alternatively using character arrays
	static String lcs(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0)
			return "";
		if (X[m - 1] == Y[n - 1]) {
			return lcs(X, Y, m - 1, n - 1) + X[m - 1];
		} else {
			String first = lcs(X, Y, m, n - 1);
			String second = lcs(X, Y, m - 1, n);
			if (first.length() > second.length())
				return first;
			else
				return second;

		}
	}
}
