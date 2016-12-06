package com.hackbulgaria.java.week1;

import java.util.*;
import java.util.jar.Pack200;

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
        ArrayList<Integer> checkedNumbers = new ArrayList<>();
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
        int currentDistance = 1;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {

            }
        }
    }




    public static void main(String[] args) {
        int[] myArr = {1,2,2,1,3,8,3,4,4,6,5,6,5};
        int[] yourArr = {1,2};

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

        System.out.println(pow(3,3));
        System.out.println(getOddOccurrence(myArr));
        System.out.println(maximalScalarSum(myArr, yourArr));

    }



}
