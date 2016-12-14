package com.hackbulgaria.java.week1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;



/**
 * Created by Dimitar on 21/11/2016.
 */


public class SmallTasks {
    static boolean isOdd(int n) {
        if (n % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isPrime(int n) {
        for (int i = 2; i < n/2; i++) {
            if ( n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int min(int... array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    static int kthMin(int k, int[] array) {
        Arrays.sort(array);
        return array[k-1];
    }

    static int getAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length ; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    static long doubleFac(int n) {
        int limit = n;
        for (int i = 2; i < limit; i++) {
                n *= i;
        }
        limit = n;
        for (int i = 2; i < n; i++) {
            limit *= i;
        }
        return limit;
    }

    static long kthFac(int k, int n) {
        int currentLimit = n;
        int result = 0;

        for (int i = 0; i < k; i++) {
            int res = 1;

            for (int j = 1; j < currentLimit+1; j++) {
                res *= j;
            }
            currentLimit = res;
            result = res;
        }
        return result;
    }

    static long getSmallestMultiple(int upperBound) {
        for (long i = 2; i < 1000000000; i++) {
            boolean divisible = true;

            for (int j = upperBound; j > 1 ; j--) {
                if (i % j != 0) {
                    divisible = false;
                    break;
                }
            }

            if (divisible == true){
                return i;
            }
        }
        return -1;
    }


    static long getLargestPalindrome(long N) {
        if (N >= 0 && N < 10){
            return N;
        }
        else if (N < 100) {
            while (N % 10 != N / 10) {
                N--;
            }
            return N;
        }
        else {
            boolean flag = true;
            while (flag) {
                flag = false;
                String myN = String.valueOf(N);
                char[] chN = myN.toCharArray();
                for (int i = 0; i < chN.length/2; i++) {
                    if (chN[i] == chN[chN.length - 1 - i]) {
                        continue;
                    } else {
                        N--;
                        flag = true;
                        break;
                    }
                }
            }
            return N;
        }
    }

    static int[] histogram(short[][] image) {
        int[] result =  new int[256];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                result[image[i][j]] += 1;
            }
        }
        return result;
    }

    static long pow(int a, int b) {
        if (b == 0){
            return 1;
        } else if (b % 2 == 0) {
            return pow(a*a, b/2);
        } else {
            return a * pow(a, b-1);
        }
    }

    static int getOddOccurrence(int... array) {
//        ArrayList<Integer> checkedNumbers = new ArrayList<>();
        Map<Integer, Integer> numberCounter = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (numberCounter.containsKey(array[i])) {
                numberCounter.put(array[i], numberCounter.get(array[i]) + 1);
            } else {
                numberCounter.put(array[i], 1);
            }
        }

        for (Integer intche : numberCounter.keySet()) {
            if (isOdd(numberCounter.get(intche))){
                return intche;
            }
        }
        return -1;
    }

    static int[] reverseSortIntArray(int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length/2 ; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
        return a;
    }

    static long maximalScalarSum(int[] a, int[] b) {
        long result = 0;
        reverseSortIntArray(a);
        reverseSortIntArray(b);

        int arrLenght = (a.length > b.length ? a.length : b.length); //Can reverse statements around ":"
        for (int i = 0; i < arrLenght; i++) {
            int aNum = (i >= a.length) ? 0 : a[i];
            int bNum = (i >= b.length) ? 0 : b[i];
            result += aNum * bNum;
        }
        return result;
    }

    static int maxSpan(int[] numbers) {
        int distance = 1;
// Optimize with a stack to keep the checked numbers
        for (int i = 0; i < numbers.length; i++) {
            int currentDistance = 1;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]){
                    currentDistance =  j - i + 1;
                }
            }
            if (currentDistance > distance) {
                distance = currentDistance;
            }
        }
        return distance;
    }

    static boolean canBalance(int[] numbers) {
        int sumNumbers = 0;
        int currentSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumNumbers += numbers[i];
        }
        if (sumNumbers % 2 != 0) {
            return false;
        } else {
            sumNumbers /= 2;
        }
        for (int i = 0; i < numbers.length ; i++) {
            currentSum += numbers[i];
            if (currentSum == sumNumbers) {
                return true;
            }
            if (currentSum > sumNumbers) {
                return false;
            }
        }
        return false;

    }

    static int[][] rescale(int[][] original, int newWidth, int newHeight) {

        //// TODO: 08/12/2016
        return new int[1][1];



    }

    static String reverseMe(String argument) {
        char[] argumentChars = argument.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = argumentChars.length - 1; i >= 0 ; i--) {
            sb.append(argumentChars[i]);
        }
        return sb.toString();
    }

    static String reverseEveryChar(String arg) {
        StringBuilder sb = new StringBuilder();
        String[] argSplit = arg.split(" ");
        for (String s:argSplit) {
            sb.append(reverseMe(s));
            if (!argSplit[argSplit.length-1].equals(s)){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    static boolean isPalindrome(int argument){
        int palindrome = argument;
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome /= 10;
        }

        if (reverse == argument) {
            return true;
        }
        return false;
    }

    static String copyEveryChar(String input, int k) {
        char[] myArr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : myArr) {
            for (int i = 0; i < k; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static int getPalindromeLength(String input) {
        int counter = 0;
        String[] starSplit = input.split("[*]");
        if (starSplit.length > 2) {
            System.out.println("Input contains more than one star!");
        }
        char[] arr1 = starSplit[0].toCharArray();
        char[] arr2 = starSplit[1].toCharArray();
        for (int i = 0; i <starSplit[0].length() ; i++) {
            if (arr1[arr1.length - 1 - i] == arr2[i]){
                counter++;
            } else break;
        }
        return counter;
    }

    static int countOcurrences(String needle, String haystack) {
        return (haystack.length() - haystack.replace(needle, "").length()) / needle.length();
    }

    static String decodeUrl(String input) {
        String result = new String(input);
        result = result.replace("%20", " ");
        result = result.replace("%3A", ":");
        result = result.replace("%3D", "?");
        result = result.replace("%2F", "/");
        return result;

    }

    static int sumOfNumbers(String input) {
        char[] symbolArr = input.toCharArray();
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < symbolArr.length; i++) {
            int j = i;
            while(j < symbolArr.length && (int)symbolArr[j] > 47 && (int)symbolArr[j] < 58) {
                sb.append(symbolArr[j]);
                j++;
            }
            i = j;
            if (sb.length() > 0) {
                result += Integer.parseInt(sb.toString());
                sb.delete(0,sb.length());
            }
        }
        return result;
    }


    static boolean anagram(String A, String B) {
    	//Done with ASCII in mind
    	char[] symbolArray = new char[94];
    	//offset 32
    	char[] toCheck = A.toLowerCase().toCharArray();
    	char[] anagram = B.toLowerCase().toCharArray();
    	for (char c: toCheck) {
    		symbolArray[(int)c-32] += 1;
    	}
    	for (char cc: anagram) {
    		symbolArray[(int)cc-32] -= 1;
    	}
    	for (int i = 0; i < symbolArray.length; i++) {
			if (symbolArray[i] != 0){
				return false;
			}
		}
    	return true;
    	
    }
    
    static boolean hasAnagramOf(String A, String B) {
    	String prepA = A.replace(" ", "");
    	String prepB = B.replace(" ", "");
    	int limit = prepA.length();
    	int target = prepB.length();
    	if (limit > target) {
    		return false;
    	}
    	for (int i = 0; i + limit < target; i++ ){
    		if (anagram(prepA,prepB.substring(i, i + limit)) == true){
    			return true;
    		}
    	}
    	return false;
    }
    
    static void convertToGreyscale(String imgPath) throws IOException {
    	File file = new File(imgPath);
    	BufferedImage bi = ImageIO.read(file);
    	Color c;
    	
    	for (int i = 0; i < bi.getWidth(); i++) {
			for (int j = 0; j < bi.getHeight(); j++) {
				c = new Color(bi.getRGB(i, j));
				int newRed = c.getRed();
				int newGreen = c.getGreen();
				int newBlue = c.getBlue();
				int newGray = (int) ((newRed * 0.2126 + newGreen * 0.7152 + newBlue*0.0722) / 3);
				//We need to convert it to INTEGER RGB
				int grayRGB = (newGray << 16) + (newGray << 8) + newGray;
				bi.setRGB(i, j, grayRGB);
							
			}
		}
    	ImageIO.write(bi, "png", new File("C:\\Users\\Dimitar\\input_modified.png"));
    	
    	
    	
    	return;

    }
    
    //NO image resizing
    
    
    public static void main(String[] args) {
    	  try {
			convertToGreyscale("C:\\Users\\Dimitar\\asd.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//        int[] myArr = {1, 2, 1, 1, 3};
//        int[] yourArr = {10, 10};
//        int[] copyTo = new int[10];
//        
//        System.arraycopy(myArr, 0, copyTo, 0, 0);
//        System.out.println(hasAnagramOf("Arrigo Boito","fffTo   bia Go  rr   ioasdasgasdasdad"));
//        System.out.println(anagram("Arrigo Boito","Tobia Gorrio"));
//        System.out.println(anagram("Dave Barry" , "Ray Adverb"));
//        System.out.println(isOdd(2));
//        System.out.println(isOdd(3));
//        System.out.println(isPrime(55));
//        System.out.println(isPrime(11));
//        System.out.println(min(myArr));
//        System.out.println(doubleFac(3));
//        System.out.println(kthFac(2,3));
//        System.out.println(getSmallestMultiple(10));
//
//        MathEquation[] equations = new MathEquation[4];
//        equations[0] = new MathEquation(100.0d, 50.0d, 'd');
//        equations[1] = new MathEquation(25.0d, 92.0d, 'a');
//        equations[2] = new MathEquation(225.0d, 17.0d, 's');
//        equations[3] = new MathEquation(11.0d, 3.0d, 'm');
//
//        for (MathEquation eq : equations) {
//            eq.execute();
//            System.out.print("result = ");
//            System.out.println(eq.result);
//        }
//
//        System.out.println(getLargestPalindrome(12322));
//        System.out.println(getLargestPalindrome(28));
//        System.out.println(getLargestPalindrome(55554));
//
//        System.out.println(pow(3,3));
//        System.out.println(getOddOccurrence(myArr));
//        System.out.println(maximalScalarSum(myArr, yourArr));
//        System.out.println(maxSpan(myArr));
//        System.out.println(canBalance(yourArr));
//        System.out.println(reverseMe("REVERSE"));
//        System.out.println(reverseEveryChar("What is this"));
//        System.out.println(isPalindrome(123211));
//        System.out.println(copyEveryChar("tldr", 3));
//        System.out.println(getPalindromeLength("taz*zad"));
//        System.out.println(countOcurrences("da", "daaadaadada"));
//        System.out.println(decodeUrl("kitten%20pic.jpg"));
//        System.out.println((int)'9');
//        System.out.println(sumOfNumbers("abc123dd34"));


    }



}
