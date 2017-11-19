package happynumbers;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.Optional;

public class HappyNumbers {

	public static void main(String[] args) throws Exception {
		OutputStream out = new BufferedOutputStream(System.out);

		long start = System.nanoTime();
		for (int i = 0; i <= 1000; i++) {
			if (isHappyNumber(i)) {

				out.write((i + "\n").getBytes());
			}
		}
		out.flush();
		long stop = System.nanoTime();

		System.out.println("executed in: " + (stop - start) / 1000);

	}

	// This method is prone to NullPointerException if someone would pass an (Integer) null
	// This is possible to be happening from the data provider I have used, for example. However, int is more performant.
	// For Integer null pointer exceptions would be handled in the method
	// itself. This way we need to surround caller code with try/catch in tests

	// Long story short, I could have made this accept an Integer parameter and
	// handle NullPointerException in the method, but this is more performant
	protected static boolean isHappyNumber(int i) {

		// get digits
		int sum = 0;
		int digit = 0;

		sum = getSum(i);

		if (sum == 1) { // we have a happy number
			return true;
		} else if (sum < 10) // below 10 there are only 2 happy numbers: 1,
								// which would already cause the method to return true
								// as per the code above, and 7, which cannot be
								// obtained through a sum of 2 squares; this is
								// used for determining when to break the
								// recursive call stack and know that we don't have a
								// happy number, therefore return false
			return false;

		// at this point we need to repeat the process on the new number
		return isHappyNumber(sum);
	}

	// calculate the sum of digits for the current number
	static int getSum(int i) {
		int sum = 0;
		while (i != 0) {
			sum += Math.pow(i % 10, 2);
			i = i / 10;
		}

		return sum;

	}
}
