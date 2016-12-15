package com.hackbulgaria.java.week1;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Stack;

import javax.swing.KeyStroke;

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
	
	static HashMap<Integer, char[]> initNokiaKeyboard() {
		HashMap<Integer, char[]> hm = new HashMap<>();
		char[] two = {'a','b','c'};
		char[] three = {'d','e','f'};
		char[] four = {'g','h','i'};
		char[] five = {'j','k','l'};
		char[] six = {'m','n','o'};
		char[] seven = {'p','q','r','s'};
		char[] eight = {'t','u','v'};
		char[] nine = {'w','x','y','z'};
		hm.put(2, two);
		hm.put(3, three);
		hm.put(4, four);
		hm.put(5, five);
		hm.put(6, six);
		hm.put(7, seven);
		hm.put(8, eight);
		hm.put(9, nine);
		return hm;
	}
	
	static String numberToMessage(int[] in) {
		HashMap<Integer, char[]> hm = initNokiaKeyboard();
		StringBuilder sb = new StringBuilder();
		boolean capitalized = false;
		int key, value;
		
		for (int i = 0; i < in.length; i++) {
			
			
			if (in[i] == 0) {
				sb.append(' ');		
				continue;
			} else if (in[i] == 1) {
				capitalized = true;
			} else if (in[i] != -1){
				key = in[i];
				value = 0;
				while (i + 1 < in.length && in[i] == in[i+1]){
					value+=1;
					value = (value == hm.get(key).length) ? 0 : value;
					i++;
				}
				sb.append((capitalized == true) ? Character.toUpperCase(hm.get(key)[value]) : hm.get(key)[value]);
				capitalized = false;
				key = 0;
				value = 0;
				
			}
		}
		return sb.toString();
	}
	
	static int[] returnValueCharArrayIndex(HashMap<Integer, char[]> hm, char c) {
		int[] answer = new int[2]; // first is the key, the second is the index in the Value char array
		for (Integer k : hm.keySet()) {
			if (new String(hm.get(k)).indexOf(c) != -1 ){
				answer[0] = k;
				answer[1] = new String(hm.get(k)).indexOf(c);
				
			}
		}
		return answer;
	}
	
	
	//We can return an array here as well
	static void messageToNumbers(String msg) {
		ArrayList<Integer> keyStroke = new ArrayList<>();
		HashMap<Integer, char[]> hm = initNokiaKeyboard();
		
		for (char c : msg.toCharArray()) {
			if ( c == ' ') {
				keyStroke.add(0);
			} else {
				int[] answer = returnValueCharArrayIndex(hm, Character.toLowerCase(c));
				if (answer[0] == 0) {
					System.out.println("Invalid character input");
				} else {
					if (Character.isUpperCase(c)) {
						keyStroke.add(1);
					}
					if (keyStroke.size() > 0 && keyStroke.get(keyStroke.size() - 1) == answer[0]){
						keyStroke.add(-1);
					}
					for (int i = 0; i <= answer[1]; i++) {
						keyStroke.add(answer[0]);
					}
				}
			}
		}
		for (Integer i: keyStroke) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	
	static int friday_years(String start, String end) {
		// check if the year starts at Friday or Thurstday (or Wednesday if high year)
		int startYear = Integer.valueOf(start);
		int endYear = Integer.valueOf(end);
		int counter = 0;
		
		for (int i = startYear; i <= endYear; i++){
			
			Calendar c = Calendar.getInstance();
			c.set(i, 0, 0);
			int day_of_week = c.get(Calendar.DAY_OF_WEEK);

			counter += ( day_of_week == 5) ? 1 : 0;
			counter += (i % 4 == 0 && day_of_week == 4) ? 1 : 0;
			
		}
		return counter;
	
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(friday_years("1000", "2000"));
		
		
		int[] myarr = {1, 4, 4, 4, 8, 8, 8, 6, 6, 6, 0, 3, 3, 0, 1, 7, 7, 7, 7, 7, 2, 6, 6, 3, 2};
		System.out.println(numberToMessage(myarr));
		messageToNumbers("aabbcc");
		
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
