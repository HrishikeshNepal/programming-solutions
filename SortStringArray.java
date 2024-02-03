import java.util.*;

public class SortStringArray {

	public static void main(String[] args) {
		String[] array = { "fuck you", "abc", "xyz", "bac", "cab", "acb", "bca", "abc" };
		// Arrays.stream(array).sorted().forEach(System.out::println);
		for (int j = 0; j < array.length; j++) {
			int i = j;
			while (i < array.length - 1) {
				if (array[i].compareTo(array[i + 1]) >= 0) {
					String temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
				}
				i++;
			}
		}

		Arrays.stream(array).forEach(System.out::println);

	}
}
