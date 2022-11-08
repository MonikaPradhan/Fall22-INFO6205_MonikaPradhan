package Assignment4;

//Question 8  Range Sum of BST (https://leetcode.com/problems/range-sum-of-bst/Links to an external site.)

public class Question8 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        int low = 7;
        int high = 15;

        int result = rangeSumBST(root,low, high);
        System.out.println("The sum of values of all nodes with a value in inclusive range of low and high is: "+result);

    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        //If the root is null we will return 0
        if(root == null){
            return 0;
        }
        //If low is greater than root, we will use recursion and call the function again by passing the right node and low and high values
        if(root.val < low){
            return rangeSumBST(root.right, low, high);
        }
        //If high is greater than root, we will use recursion and call the function again by passing the left node and low and high values
        if(root.val > high){
            return rangeSumBST(root.left, low, high);
        }
        //The final result will be the sum of root, left and right node values calculated by using recurssion in the above steps
        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
    }
}
