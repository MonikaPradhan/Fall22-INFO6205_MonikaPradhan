package Assignment4;

//Question 4: Recover Binary Search Tree (https://leetcode.com/problems/recover-binary-search-tree/)

import java.util.Stack;

public class Question4 {
     TreeNode first;
     TreeNode second;
     TreeNode previous;

    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }

        first = null;
        second = null;
        previous = null;

        inOrder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return;
    }

    private void inOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack();
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if(previous !=null && node.val <= previous.val) {
                if(first == null) {
                    first = previous;
                }
                second = node;
            }

            previous = node;

            node = node.right;
        }
    }
}
