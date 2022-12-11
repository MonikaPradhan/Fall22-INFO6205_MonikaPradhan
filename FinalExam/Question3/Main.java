package Question3;

/*Question 3:
            Given a string s of '(' , ')' and lowercase English characters.
            Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 */

/*Complexity :
    Time Complexity : O(n), where n is the length of s
    Space Complexity : O(n), where n is length of s
 */

import java.sql.SQLOutput;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String inputString = "lee(t(c)o)de)";
        String result = minimumNumberOfParanthesisForValidString(inputString);
        System.out.println("The final string is : "+result);
    }

    public static String minimumNumberOfParanthesisForValidString(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char[] sChar = s.toCharArray();

        // Collect invalid paranthesis indexes in stack.
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] == '(') {
                stack.push(i);
            } else if (sChar[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sChar[i] = ' ';
                }
            }
        }

        // Set invalid paranthesis index value to empty.
        while(!stack.isEmpty()) {
            sChar[stack.pop()] = ' ';
        }

        // create result string by skipping the invalid paranthesis index.
        StringBuilder sb = new StringBuilder();
        for(char c : sChar) {
            if(c != ' ') {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
