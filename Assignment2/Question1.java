package Assignment2;

/*Question 1 : Symmetric Tree (https://leetcode.com/problems/symmetric-tree/)
This class used TreeNode.java class
The complexity of the below solution is O(n) */

import java.util.Stack;

public class Question1 {
    public static void main(String[] args) {
        //We will create a binary tree
        TreeNode tree = new TreeNode();

        //Now we will add value to the tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(3);

        //We will call the function to check whether the tree is Symmetric and the result will be stored in result variable
        boolean result = isSymmetric(tree.root);

        //We will print the result now
        if(result){
            System.out.println("The given tree is Symmetric Tree");
        }
        else {
                System.out.println("The given tree is Not Symmetric Tree");
        }
    }

    public static boolean isSymmetric(TreeNode root){
        //If both left and right nodes are null, then it is symmetric tree and we will return true
         if(root.left == null && root.right ==null ){
             return true;
         }

         //If one of the nodes is null and other has data, it means the tree is not symmetric tree
         if(root.left == null || root.right == null){
             return false;
         }

         //To check the rest of the tree, we will use stack and push the left and right nodes of the tree.
         Stack<TreeNode> temp = new Stack<>();
         temp.push(root.left);
         temp.push(root.right);

         // The below while loop will run while the stack is not empty.
         while(!temp.empty()){
            // We will define temporary nodes to fetch the value from the stack.
            TreeNode temp1, temp2;
            temp1 = temp.pop();
            temp2 = temp.pop();

            //If both the nodes are null, we will continue further till the stack becomes empty.
            if(temp1 == null && temp2 == null){
                continue;
            }

            //If one of the nodes is null or the value of the nodes does not match, that means it is not a symmetric tree and we will return false.
            if(temp1 == null || temp2 == null || temp1.val != temp2.val){
                return false;
            }

            /*If the above condition is false, we will push the further nodes in the stack.
             Here, we have to sequentially push the data in stack. The Left node of the temp1 will be compared to the right
             node of the temp2 and right node of temp1 will be compared to the left node of temp2. Hence the push operation should be sequential.
             */
            temp.push(temp1.left);
            temp.push(temp2.right);
            temp.push(temp1.right);
            temp.push(temp2.left);
         }

         //If we come out of while loop successfully, it means we have traverse the tree and the it is symmetric.
         return true;
    }
}
