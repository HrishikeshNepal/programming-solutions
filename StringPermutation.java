public class StringPermutation {
	// Given string "YOGESH"
	// Do the permutation

	public static void main(String[] args) {
		String str = "YOGESH";
		permute(str, "");
	}

	public static void permute(String str, String prefix) {
		/*
		 * getting all sorts of combinations of characters in a String
		 */
		int n = str.length();
		if(n == 0) {
			System.out.println(prefix);
		} else {
			for(int i = 0; i< n; i++) {
				permute(str.substring(0,i) + str.substring(i + 1, n), prefix + str.charAt(i));
			}
		}
	}
}
