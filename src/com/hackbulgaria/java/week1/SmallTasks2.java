package com.hackbulgaria.java.week1;

import java.util.HashMap;

public class SmallTasks2 {

	static boolean isHack(int a) {
		int oddCounter = 0;
		String binaryA = Integer.toBinaryString(a);
		int binaryIntA = Integer.valueOf(binaryA);
		if (!SmallTasks.isPalindrome(binaryIntA)) {
			return false;
		}
		for (char c: binaryA.toCharArray()) {
			if (c == '1'){
				oddCounter++;
			}
		}
		if (SmallTasks.isOdd(oddCounter)){
			return true;
		} else {
			return false;
		}
		
	}
	
	static int nextHack(int a) {
		int checkNumber = a;
		while (!isHack(checkNumber)){
			checkNumber++;
		}
		return checkNumber;
	}
	
	static int countVowels(String s) {
		int counter = 0;
		String toCheck = new String(s);
		toCheck = toCheck.toLowerCase();
		for (char c: toCheck.toCharArray()) {
			if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' || c == 'y' ){
				counter++;
			}
		}
		return counter;
	}
	
	static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' || c == 'y' ){
			return true;
		}
		return false;
	}
	
	static int countConsonants(String s) {
		int counter = 0;
		String toCheck = new String(s);
		toCheck = toCheck.toLowerCase();
		for (char c: toCheck.toCharArray()) {
			if ((int)c > 96 && (int)c < 123 && !isVowel(c)){
				counter++;
			}
		}
		return counter;
	}
	
	static int pScore(int n) {
		if (SmallTasks.isPalindrome(n)) {
			return 1;
		} else {
			// reverse the int
			int initialN = n;
			int reversedN = 0;
			while (n != 0) {
				reversedN *= 10;
				reversedN += n % 10;
				n /= 10;
			}
			return 1 + pScore(initialN+reversedN);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		HashMap<Integer, Character> hm = new HashMap<>();
	
		
		
		System.out.println(pScore(198));
		int myInt = 256;
		System.out.println(Integer.toBinaryString(myInt));
		System.out.println(isHack(21));
		System.out.println(nextHack(10));
		System.out.println(countVowels("AAAAAA"));
		System.out.println(countConsonants("Github is the second best thing that happend to programmers, after the keyboard!"));
		
	}

}
