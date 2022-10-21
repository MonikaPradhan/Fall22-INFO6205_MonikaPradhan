package Assignment3;

//Question 1: Combination Sum (https://leetcode.com/problems/combination-sum/)

import java.util.ArrayList;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {
        int[] candidates ={2,3,6,7};
        int target = 7;
        List<List<Integer>> resultList = combinationSum(candidates,target);
        System.out.println("The list of unique combination of candidates is : "+resultList);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        getCombinations(candidates, target, result, new ArrayList(), 0);
        return result;
    }

    private static void getCombinations(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int start) {
        if(target < 0) {
            return;
        }

        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            current.add(candidates[i]);
            getCombinations(candidates, target-candidates[i], result, current, i);
            current.remove(current.size()-1);
        }
    }
}
