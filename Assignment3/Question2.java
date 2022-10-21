package Assignment3;

//Question 2: Permutations (https://leetcode.com/problems/permutations/)

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public static void main(String[] args) {
        int[] nums ={1,2,3};
        List<List<Integer>> resultList = permute(nums);
        System.out.println("All possible permutations are : "+resultList);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        getPermutations(nums, result, new ArrayList());
        return result;
    }

    private static void getPermutations(int[] nums, List<List<Integer>> result, List<Integer> current) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if (current.contains(nums[i])) {
                continue;
            }
            current.add(nums[i]);
            getPermutations(nums, result, current);
            current.remove(current.size()-1);
        }
    }
}
