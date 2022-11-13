package MidTerm.Question5;

//Question 5 : Write a function where I pass an sorted integer array  and another array of integers and the function returns me start indexes of those values in second array

 /*
    Time complexity : O(m log n) , where m is length of values array and n is length of arr array.
    Space complexity : O(1)
  */

public class main {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11};
        int[] values = {1,4,5,10};

        int[] result = getStartOfEachValues(arr, values);

        for(int value : result) {
            System.out.print(value + " ");
        }

    }

    private static int[] getStartOfEachValues(int[] arr, int[] values){
        int[] indexes = new int[values.length];
        int i = 0;
        for(int value : values) {
            int index = binarySearch(arr, value);
            indexes[i] = index;
            i++;
        }

        return indexes;
    }

    private static int binarySearch(int[] arr, int element){
        int elementIndex = -1;
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] >= element){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            if(arr[mid] == element) {
                elementIndex = mid;
            }
        }
        return elementIndex;
    }
}


