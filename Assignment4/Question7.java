package Assignment4;

//Question 7 : Inorder Successor in BST ****(https://leetcode.com/problems/inorder-successor-in-bst/Links to an external site.)

public class Question7 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);


        TreeNode result = inorderSuccessor(root,root.left);
        if(result == null) {
            System.out.println("Null");
            return;
        }

        System.out.println(result.val);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode iOSuccessor = null;
        //While the node is not empty we will traverse the tree
        while (root != null) {
            //If root is greater than p value, we will put the root node in the iOSuccessor variable else we will traverse right
            if (p.val < root.val) {
                iOSuccessor = root;
                root = root.left;
            }
            else
                root = root.right;
        }
        return iOSuccessor;

    }
}
