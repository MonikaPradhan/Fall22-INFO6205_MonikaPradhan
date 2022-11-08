package Assignment4;

import com.sun.source.tree.Tree;

import java.sql.SQLOutput;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public void printTree() {
        printPreorder(this);
    }

    private void printPreorder(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.val+ " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
