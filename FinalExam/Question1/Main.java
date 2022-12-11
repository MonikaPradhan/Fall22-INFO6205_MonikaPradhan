package Question1;

/*Question 1: Given an array of strings strs, group the anagrams together. You can return the answer in any order.
              An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically
              using all the original letters exactly once.*/

/*Complexity :
    Time Complexity : O(N * M) , where N is number of words in strs and M is max length of a word in strs
    Space Complexity : O(N)
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Declare the input string
        String[] string = {"eat","tea","tan","ate","nat","bat"};
        //Create an output variable result to store the final list of strings
        List<List<String>> result = groupAnagrams(string);
        System.out.println(result);
    }

    public static  List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for(String s : strs) {
            // count the letter count in each word and store in charCountArray
            char[] charCountArray = new char[26];
            for (char c : s.toCharArray()){
                charCountArray[c - 'a']++;
            }

            // Use the charCountArray to create a key to store in map.
            //If it exists, add word to existing anagramList or create new list and to it.
            String sorted = new String(charCountArray);
            if(map.containsKey(sorted)) {
                List<String> existingAnagrams = map.get(sorted);
                existingAnagrams.add(s);
            } else {
                List<String> newAnagramList = new ArrayList();
                newAnagramList.add(s);
                map.put(sorted, newAnagramList);
            }
        }

        // Iterate over the collection of anagram list and create a result array of list of anagrams.
        List<List<String>> result = new ArrayList();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}


