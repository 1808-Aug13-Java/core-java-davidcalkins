package com.revature.testing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Snippet {
	
	
	public static void main(String[] args) {
		int longestLength = 0;
		for (long i=Long.MAX_VALUE; i>Long.MAX_VALUE-100000000L; i--) {
			List<Long> primeFactors = calculatePrimeFactorsOf(i);
			if (primeFactors.size() > longestLength) {
				longestLength = primeFactors.size();
				System.out.println("LongestLength=" + longestLength + "  at i=" + i);
			}
		}
	}
	
	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public static List<Long> calculatePrimeFactorsOf(long l) {
		// Get the factors of l
		LinkedList<Long> factors = getFactors(l);
		
		// For each factor, if a factor is not a prime number, defined as having 
		// two factors, remove it. 
		for (Iterator<Long> it = factors.iterator(); it.hasNext();) {
			if (getFactors(it.next()).size() != 2) {
				it.remove();
			}
		}
		
		return factors;
	}
	
	
	/** 
	 * Provided a long, computes the factors of said long. 
	 * Negative numbers not implemented. 
	 * @param l - The long to compute the factors of. 
	 * @return A list of factors
	 */
	private static LinkedList<Long> getFactors(long l) {
		// The list of factors
		LinkedList<Long> factors = new LinkedList<>();
		
		// Get the square root of the long, as there will never be a factor greater than
		// its square root. The loss of precision is accounted by incrementing by one, which
		// will cover cases where we might miss a number if l > 2^52. 
		long sqrt = (long) Math.sqrt(l) + 1L;
		
		// Go through each number from 1 up to the square root and check to see if it is 
		// a factor of l. If it is, add it and its complementary factor to the list
		for (long i=1; i<sqrt; i++) {
			if (l % i == 0) {
				factors.add(i);
				
				// Only add the complementing factor if it isn't a perfect square
				if (i * i != l) {
					factors.add(l / i);
				}
			}
		}
		
		
		return factors;
	}
}

