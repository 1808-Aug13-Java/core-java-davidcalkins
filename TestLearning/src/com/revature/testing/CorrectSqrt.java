package com.revature.testing;

public class CorrectSqrt {

	public static void main(String[] args) {
		boolean error = false;
		for (long x = 0; x <= Math.sqrt(Long.MAX_VALUE); x++) {
			if (x != (long) Math.sqrt(x * x)) {
				System.out.println(x);
				error = true;
			}
			if (x % 1000000000L == 0L) {
				System.out.println(x + " billion  error=" + error);
			}
		}
	}

}
