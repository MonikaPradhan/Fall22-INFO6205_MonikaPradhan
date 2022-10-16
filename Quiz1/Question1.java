package Quiz1;

//Question 1: Given an array, rotate the array to the right by k steps, where k is non-negative.

import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
        //Passing the inputs
        int[] nums = {1,2,3,4,5,6,7};
        //Assuming k is a non-negative vale
        int k = 3;
        //Calling the rotate function and printing the result
        int[] resultArray = rotate(nums,k);
        System.out.println("The rotated array is "+ Arrays.toString(resultArray));
    }

    public static int[] rotate(int[] nums, int k) {
        //Store the length in a variable and we will calculate the number of times we actually need to rotate the array using % operator
        int length = nums.length;
        k = k % length;
        //We will use recurssion in this scenario
        reverseArray(nums, 0, length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, length - 1);
        //return the rotated array to the main function
        return nums;
    }

    //Below function will help to swap the values
    public static void reverseArray(int[] nums, int first, int last) {
        while (first < last) {
            //We need temp variable to store the values while swapping
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
    }
}
