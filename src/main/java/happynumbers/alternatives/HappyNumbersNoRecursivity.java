package happynumbers.alternatives;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

public class HappyNumbersNoRecursivity {

	public static void main(String[] args) throws Exception {
		OutputStream out = new BufferedOutputStream(System.out);

		long start = System.nanoTime();
		for (int i = 1; i <= 1000; i++) {
			if (isHappyNumber(i)) {

				out.write((i + "\n").getBytes());
			}
		}
		out.flush();
		long stop = System.nanoTime();

		System.out.println("executed in: " + (stop - start) / 1000);

	}

	private static boolean isHappyNumber(int i) {

		// get digits
		int sum = 0;
		int digit = 0;
		int temp = 0;
		while (sum != 1) { //not recursive, yet not better as performance
			sum = 0;
			while (i != 0) { //determine the sum
				digit = i % 10;
				sum += Math.pow(i % 10, 2);
				i = i / 10;
			}
			i = sum;

			if (sum < 10)
				break;
		}
		return sum == 1;
	}
}
