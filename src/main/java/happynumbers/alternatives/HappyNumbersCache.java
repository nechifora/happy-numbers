package happynumbers.alternatives;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

public class HappyNumbersCache {

	static int[] happyNumbers = new int[245]; // 245 is the maximum sum that
												// will be found in calculations
												// for maximum 3-digits numbers.
												// just the one 4-digit number
												// is neglectable in this case

	public static void main(String[] args) throws Exception {
		OutputStream out = new BufferedOutputStream(System.out);

		long start = System.nanoTime();
		for (int i = 0; i <= 1000; i++) {
			if (isHappyNumber(i)) {
				if (i < 245) // add the already known happy numbers which can be
								// found in calculations, which will lead to a
								// happy number as well. try and reduce the sum
								// calculations
					happyNumbers[i] = i;
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
		//get the sum
		while (i != 0) {
			sum += Math.pow(i % 10, 2);
			i = i / 10;
		}

		/*
		 * try and find to see if the number is happy based on the already found
		 * / happy numbers BEFORE we get to sum = 1; this way we spare some
		 * calculations
		 */
		if (happyNumbers[sum] == sum) {
			return true;
		}

		if (sum == 1) {
			return true;
		} else if (sum < 10)
			return false;
		//at this point we need to repeat the process on the new sum
		return isHappyNumber(sum);
	}
}
