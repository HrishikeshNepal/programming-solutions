public class StringCompression {
	public static void main(String[] args) {
		char[] array = {'a','a','b','b','c','c','c', 'd'};
		System.out.println("result string : " + getCompressedStringFromCharArray(array, 0, 1, 1));

	}

	public static String getCompressedStringFromCharArray(char[] array, int prev, int next, int count) {
		String s = "";
		int n = array.length;
		if (next == n) {
			return s;
		}
		if (array[prev] == array[next]) {
			count++;
			getCompressedStringFromCharArray(array, next, next + 1, count);
		} else {
			System.out.println(String.valueOf(array[prev]) + count);
			String temp = String.valueOf(array[prev]) + count;
			count = 1;
			s = temp + getCompressedStringFromCharArray(array, next, next + 1, count);
		}
		return s;
	}
}
