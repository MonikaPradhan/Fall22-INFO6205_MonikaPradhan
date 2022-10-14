package Assignment2;

/*Question 2 : Maximum Depth of Binary Tree (https://leetcode.com/problems/maximum-depth-of-binary-tree/)
This class used TreeNode.java class
The complexity of the below solution is O(n) */

public class Question2 {
    public static void main(String[] args) {
        //We will create tree and pass the values to the tree
    TreeNode tree = new TreeNode();
    tree.root = new TreeNode(3);
    tree.root.left = new TreeNode(9);
    tree.root.right = new TreeNode(20);
    tree.root.left.left = new TreeNode();
    tree.root.left.right = new TreeNode();
    tree.root.right.left = new TreeNode(15);
    tree.root.right.right = new TreeNode(7);

    //We will create a int variable "depth" to store the value returned by the function
    int depth = maxDepth(tree.root);

    //We will print the depth of the tree
        System.out.println("The maximum depth of the tree is : "+depth);
    }

    public static int maxDepth(TreeNode root) {
        //If the root is null, we will return 0
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        //Here we are using Math.max function to fetch the max value between left and right path of the tree. We are recursively calling the function for left ans right nodes
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
