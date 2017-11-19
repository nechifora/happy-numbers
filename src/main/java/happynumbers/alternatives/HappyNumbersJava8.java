package happynumbers.alternatives;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.stream.IntStream;

public class HappyNumbersJava8 {

	public static void main(String[] args) throws Exception {

		long start = System.nanoTime();
		
		//use the praised stream and try and get performance.
		IntStream.range(1, 1001).filter(HappyNumbersJava8::isHappyNumber).forEach(System.out::println);

		long stop = System.nanoTime();

		System.out.println("executed in: " + (stop - start) / 1000); //not that good performance actually
	}

	private static boolean isHappyNumber(int i) {

		// get digits
		int sum = 0;
		int digit = 0;
		while (i != 0) {

			sum += Math.pow(i % 10, 2);
			i = i / 10;
		}

		if (sum == 1) {
			return true;
		} else if (sum < 10)
			return false;

		return isHappyNumber(sum);
	}
}
