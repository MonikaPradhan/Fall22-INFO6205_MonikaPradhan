package Assignment3;

//Question 7 : Generate Parentheses (https://leetcode.com/problems/generate-parentheses/)

import java.util.ArrayList;
import java.util.List;

public class Question7 {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println("The combinations are : "+result);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        getAllValidParenthesis(n, "(", 1, 0, result);
        return result;
    }

    private static void getAllValidParenthesis(int n, String current, int open, int close, List<String> result) {
        if(current.length() == n*2) {
            result.add(current);
            return;
        }

        if(open < n) {
            getAllValidParenthesis(n, current+"(", open+1, close, result);
        }

        if(close < open) {
            getAllValidParenthesis(n, current+")", open, close+1, result);
        }
    }
}
