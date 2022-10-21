package Assignment3;

//Question 3: Letter Combinations of a Phone Number (https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

import java.util.ArrayList;
import java.util.List;

public class Question3 {
    public static void main(String[] args) {
       String digits = "23";
        List<String> resultList = letterCombinations(digits);
        System.out.println("All possible letter combinations are : "+resultList);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if(digits == null || digits.equals("")) {
            return result;
        }

        String[] allLetters  = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        getLetterCombinations(digits, allLetters, result, 0, "");
        return result;
    }

    private static void getLetterCombinations(String digits, String[] allLetters, List<String> result, int currentDigitPosition, String currentCombination) {
        if(currentDigitPosition == digits.length()) {
            result.add(currentCombination);
            return;
        }

        int position = digits.charAt(currentDigitPosition) - '0';
        String letters = allLetters[position];
        for(int i=0; i<letters.length(); i++) {
            getLetterCombinations(digits, allLetters, result, currentDigitPosition+1, currentCombination + letters.charAt(i));
        }
    }
}
