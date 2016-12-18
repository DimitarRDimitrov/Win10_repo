package com.hackbulgaria.java.week1;

public class SmallTasks3 {

	static long fibbNumbers(int n) {
		if (n == 0) {
			return 0L;
		}
		int[] numbers = new int[n];
		numbers[0] = 1;
		for (int i = 1; i < n; i++) {
			numbers[i] = (i - 2 < 0) ? numbers[i - 1] : numbers[i - 1] + numbers[i - 2];
		}
		String s = "";
		for (int intche : numbers) {
			s += intche;
		}
		return Long.valueOf(s);

	}

	static int nthLucas(int n) {
		if (n == 0) {
			return 2;
		} else if (n == 1) {
			return 1;
		} else {
			return nthLucas(n - 1) + nthLucas(n - 2);
		}
	}

	static boolean isIncreasing(int[] seq) {
		if (seq.length < 2) {
			return false;
		}
		for (int i = 0; i < seq.length - 1; i++) {
			if (!(seq[i] < seq[i + 1])) {
				return false;
			}
		}
		return true;
	}

	static boolean isDecreasing(int[] seq) {
		if (seq.length < 2) {
			return false;
		}
		for (int i = 0; i < seq.length - 1; i++) {
			if (!(seq[i] > seq[i + 1])) {
				return false;
			}
		}
		return true;
	}

	static int maxEqualConsecutive(int[] iSeq) {
		int result = 0;
		for (int i = 0; i < iSeq.length; i++) {
			int temp = 1;
			for (int j = i + 1; j < iSeq.length; j++) {
				if (iSeq[i] == iSeq[j]) {
					temp++;
				} else
					break;
			}
			result = (result < temp) ? temp : result;
		}
		return result;
	}

	static int maxIncreasingConsecutive(int[] iSeq) {
		int result = 0;
		for (int i = 0; i < iSeq.length; i++) {
			int temp = 1;
			for (int j = i; j < iSeq.length - 1; j++) {
				if (iSeq[j] > iSeq[j + 1]) {
					i = j++;
					break;
				} else
					temp++;
			}
			result = (result < temp) ? temp : result;
		}
		return result;
	}

	// unoptimized with 2 for cycles
	static int uniqueWordsCount(String[] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean hasWord = false;
			for (int j = 0; j < i; j++) {
				if (arr[i].equals(arr[j])) {
					hasWord = true;
				}
			}
			if (hasWord == false) {
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		System.out.println(uniqueWordsCount(new String[] {"HELLO!", "HELLO!", "HELLO!", "HELLO!"}));
		System.out.println(maxIncreasingConsecutive(new int[] { 1, 2, 3, 1, 6, 1, 2, 3, 4 }));
		System.out.println(maxEqualConsecutive(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5 }));
		System.out.println(nthLucas(10));
		System.out.println(fibbNumbers(3));
		System.out.println(fibbNumbers(10));
		
		
	}

}
