package Assignment3;

//Question 6 : Subsets (https://leetcode.com/problems/subsets/)

import java.util.ArrayList;
import java.util.List;

public class Question6 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets(nums);
        System.out.println("All possible subsets (The power set) is : "+result);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        getSubsets(nums, result, new ArrayList(), 0);
        return result;
    }

    private static void getSubsets(int[] nums, List<List<Integer>> result, List<Integer> current, int start) {
        result.add(new ArrayList<>(current));
        for(int i=start; i<nums.length; i++) {
            current.add(nums[i]);
            getSubsets(nums, result, current, i+1);
            current.remove(current.size()-1);
        }
    }
}
