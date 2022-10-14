package Assignment2;

/*Question 8 : Find Leaves of Binary Tree (https://leetcode.com/problems/find-leaves-of-binary-tree/)
This class used TreeNode.java class
The complexity of the below solution is O(n) */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question8 {
    public static void main(String[] args) {
        //We will create tree and pass the values to the tree
        TreeNode tree = new TreeNode();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        //We will create a new list variable to store the result returned by the function findLeaves
        List<List<Integer>> resultFinalList = findLeaves(tree.root);
        //We will print the result
        System.out.println("The leaves of the tree are : "+resultFinalList);
    }

    public static List<List<Integer>> findLeaves(TreeNode root){
        Map<Integer,List<Integer>> tempMap = new HashMap<>();
        getLeaveNodes(root,tempMap);
        return new ArrayList<>(tempMap.values());
    }

    private static int getLeaveNodes(TreeNode root, Map<Integer,List<Integer>> tempMap){
        if(root == null){
            return -1;
        }

        // calculate left and root values by recursively calling the same methode and passing left and right node to the function
        int left = getLeaveNodes(root.left,tempMap);
        int right = getLeaveNodes(root.right,tempMap);

        //if only root is present and no left and right nodes, we will add the values to the map with height / index as 0 else we will calculate the max height using math.max function
        if(root.left == null && root.right == null ){
            addValuesToMap(tempMap,0,root.val);
            return 1;
        } else {
            int height = Math.max(left,right);
            addValuesToMap(tempMap,height,root.val);
            return height + 1;
        }
    }

    //We are using below method to add the values to the final array list from the map
    private static void addValuesToMap(Map<Integer,List<Integer>> map, int height, int value){
        //We have created a temporary list and pass the index value as height
        List<Integer> tempList = map.get(height);

        //If the list is empty we will create a new list and put the values in the list. If the list is already present we will add the value to list directly
        if(tempList == null){
            tempList = new ArrayList<>();
            map.put(height,tempList);
        }

        tempList.add(value);
    }
}
