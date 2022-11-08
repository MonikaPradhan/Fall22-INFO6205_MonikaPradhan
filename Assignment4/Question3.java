package Assignment4;

//Question 3 : https://leetcode.com/problems/validate-binary-search-tree/

import java.util.Stack;

public class Question3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        boolean result = isValidBST(root);
        System.out.println("The given tree is a valid binary search tree : "+result);
    }

    public static boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if(prev != null && prev.val >= root.val) {
                return false;
            }

            if(prev == null) {
                prev = root;
            } else {
                if(prev.val >= root.val) {
                    return false;
                }
                prev = root;
            }

            root = root.right;
        }

        return true;
    }
}
