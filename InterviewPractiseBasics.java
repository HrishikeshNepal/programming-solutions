import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewPractiseBasics {
	public static void main(String[] args) {
		// Print sum of 10 digits from 1 to 10
		int sum = IntStream.range(1, 10).sum();
		System.out.println(sum);
		// Print sum of squares of digits from 1 to 10
		int sumOfSquares = IntStream.range(1, 10).map(p -> p * p).sum();
		System.out.println(sumOfSquares);
		// Concepts of int array[]
		int[] array = { 1, 5, 2, 2, 1, 7, 7, 3 };
		// Aum of first 4 digits of array
		System.out.println(Arrays.stream(Arrays.copyOfRange(array, 0, 4)).sum());
		// To get array of first 4 elements
		int[] subarray = Arrays.copyOf(array, 4);
		Arrays.stream(subarray).forEach(p -> System.out.print(p + " "));
		// System.out.println(); //added just to go to next line
		// max, min, sum, average, count, sort value in an integer Array
		System.out.println(Arrays.stream(array).max().getAsInt());
		System.out.println(Arrays.stream(array).min().getAsInt());
		System.out.println(Arrays.stream(array).sum());
		System.out.println(Arrays.stream(array).average().getAsDouble());
		System.out.println(Arrays.stream(array).count());
		Arrays.stream(array).sorted().forEach(p -> System.out.print(p + " "));
		// To create Stream of Integers
		Stream<Integer> stream = IntStream.range(1, 10).boxed();
		stream.forEach(p -> System.out.print(p + " "));

		// Concepts for String array[] and Strings
		// Add two strings
		String s = "abc" + "def";
		System.out.println(s); // answer : abcdef
		// Sort a String array
		String[] strArray = { "Hrishikesh", "hrishikesh", "yogesh", "gia", "Tesla" };
		// Aorts based upon the ascii values
		// ASCII values of A-Z ranges from 65 to 90
		// ASCII values of a-z ranges from 97 to 122
		Arrays.stream(strArray).sorted().forEach(p -> System.out.print(p + " "));
		// output: Hrishikesh Tesla gia hrishikesh yogesh

		// Use compareTo method to compare two strings
		System.out.println("abc".compareTo("acb")); // output: -1
		System.out.println("abc".compareTo("abc")); // output: 0
		System.out.println("acb".compareTo("abc")); // output: 1
		System.out.println("xyz".compareTo("acb")); // output: 23
	}
}
