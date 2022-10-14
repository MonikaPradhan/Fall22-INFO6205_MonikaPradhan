package Assignment2;

/*Question 7 : Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
This class used TreeNode.java class
The complexity of the below solution is O(n) */

public class Question7 {
    public static void main(String[] args) {
        //We will create tree and pass the values to the tree
        TreeNode tree = new TreeNode();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(1);
        tree.root.left.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(0);
        tree.root.right.right = new TreeNode(8);
        tree.root.left.right.left = new TreeNode(7);
        tree.root.left.right.right = new TreeNode(4);
        TreeNode p = tree.root.left;
        TreeNode q = tree.root.right;
        TreeNode result = lowestCommonAncestor(tree.root,p,q);
        System.out.println("The LCA of nodes "+" "+p.val+" "+"and"+" "+q.val+" "+"is : "+ result.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == root || q == root){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        }

        if(left != null){
            return left;
        } else {
            return right;
        }
    }
}
