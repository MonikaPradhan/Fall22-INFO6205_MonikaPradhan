package Assignment2;

/*Question 3 : Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
This class used TreeNode.java class
The complexity of the below solution is O(n) */

import java.util.ArrayList;
import java.util.List;

public class Question3 {
    public static void main(String[] args) {
        //We will create tree and pass the values to the tree
        TreeNode tree = new TreeNode();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);

        List<Integer> finalList = rightSideView(tree.root);
        System.out.println("The right side view of the Binary tree is : "+finalList);
    }
    public static List<Integer> rightSideView(TreeNode root) {
        //We will create an arraylist 'list' which we will return at the end. Also, we will create a currentLevel array
        List<Integer> list = new ArrayList<>();
        List<TreeNode> currentLevel = new ArrayList<>();

        //If the current level is not null we will add root to the current level
        if(root !=null){
            currentLevel.add(root);
        }

        //We will run the loop while we have elements in the Arraylist
        while(!currentLevel.isEmpty()) {
            //We will get the last element in the current level and add it to our final list
            list.add(currentLevel.get(currentLevel.size() - 1).val);

            // Create a nextLevel array
            List<TreeNode> nextLevel = new ArrayList<>();

            for(TreeNode n : currentLevel){
                if(n.left != null){
                    nextLevel.add(n.left);
                }
                if(n.right != null){
                    nextLevel.add(n.right);
                }
            }
            currentLevel = nextLevel;
        }
        return list;
    }
}
