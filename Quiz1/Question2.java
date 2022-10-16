package Quiz1;

/*Question 2: Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.*/

public class Question2 {
    public static void main(String[] args) {
        //Create the input trees
        TreeNode tree1 = new TreeNode();
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);
        tree1.root.right = new TreeNode(3);


        TreeNode tree2 = new TreeNode();
        tree2.root = new TreeNode(1);
        tree2.root.left = new TreeNode(2);
        tree2.root.right = new TreeNode(3);
        //Call the function and print the result if the tree is same or not
        boolean result = isSameTree(tree1,tree2);
        System.out.println("The Result is : "+result);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //If both the trees are null, we will return true
        if(p == null && q == null) {
            return true;
        }
        //If any one tree is null and the value does not match we return false
        if(p == null || q == null || (p.val != q.val)) {
            return false;
        }
        //Else we will recursively call the same function till it traverse all the roots
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
