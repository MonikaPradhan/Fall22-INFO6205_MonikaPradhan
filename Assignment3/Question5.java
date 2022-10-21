package Assignment3;

//Question 5: Numbers With Same Consecutive Differences (https://leetcode.com/problems/numbers-with-same-consecutive-differences/)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question5 {
    public static void main(String[] args) {
        int n = 3, k = 7;
        int[] result = numsSameConsecDiff(n,k);
        System.out.println("All the integers of length n where the difference between every two consecutive digits is k are : "+ Arrays.toString(result));
    }

    public static int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> result = new HashSet();
        for(int i=1; i<10; i++){
            getResult(n, k, result, i);
        }

        int[] solution = new int[result.size()];
        int i=0;
        for(int x : result) {
            solution[i++] = x;
        }

        return solution;
    }

    private static void getResult(int n, int k, Set<Integer> result, int num) {
        if(String.valueOf(num).length() >= n) {
            result.add(num);
            return;
        }

        int lastDigit = num % 10;
        if(lastDigit+k < 10) {
            getResult(n, k, result, (num*10)+(lastDigit+k));
        }

        if(lastDigit-k >= 0) {
            getResult(n, k, result, (num*10)+(lastDigit-k));
        }
    }
}
