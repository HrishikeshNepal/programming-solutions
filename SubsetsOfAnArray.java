import java.math.BigInteger;

public class SubsetsOfAnArray {
	public static void main(String[] args) {
		int[] array = { 1, 3, 5, 7 };
		printSubsets(array, 4);
	}

	static void printSubsets(int[] array, int n) {
		int opsize = (int) Math.pow(2, n);

		for (int counter = 0; counter < opsize; counter++) {
			for (int j = 0; j <= n; j++) {
				if (BigInteger.valueOf(counter).testBit(j)) {
					System.out.print(array[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
