package Assignment2;

/*Question 6 : Maximum Width of Binary Tree (https://leetcode.com/problems/maximum-width-of-binary-tree/)
This class used TreeNode.java class
The complexity of the below solution is O(n) */

import java.util.LinkedList;
import java.util.Queue;

public class Question6 {
    public static void main(String[] args) {
        //We will create tree and pass the values to the tree
        TreeNode tree = new TreeNode();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(3);
        tree.root.right.right = new TreeNode(9);

        //We will create a integer variable "result" to store the result of the function
        int result = widthOfBinaryTree(tree.root);
        //We will print the answer
        System.out.println("The maximum width of the binary tree is : "+ result);
    }

    public static int widthOfBinaryTree(TreeNode root){
        //If the root is null, the width is 0, we will return 0
        if(root == null){
            return 0;
        }

        // Create two queues, one to store the value of the nodes and one to store the index.
        Queue<TreeNode> tempQueue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();

        //We need 3 variables to store the width calculated during computation, leftnode and right node
        int maxWidth = 0, leftNode = 0, rightNode = 0;

        tempQueue.add(root);
        index.add(0);

        while(!tempQueue.isEmpty()){
            int size = tempQueue.size();
            leftNode = rightNode = index.peek();

            // run the for loop till the size of the queue.
            for(int i = 0; i<size; i++){
                // Fetch the value from queue in the current node
                TreeNode currentNode = tempQueue.poll();

                int currentIndex = index.poll();
                if(i == 0){
                    leftNode = currentIndex;
                }

                if(i == size -1){
                    rightNode = currentIndex;
                }

                //If current node has left child, we will add it to the tempQueue and similarly if the right child exists we will add it to tempqueue
                if(currentNode.left != null){
                    tempQueue.add(currentNode.left);
                    index.add(currentIndex*2+1);
                }

                if(currentNode.right != null){
                    tempQueue.add(currentNode.right);
                    index.add(currentIndex*2+2);
                }
            }

            maxWidth = Math.max(maxWidth,rightNode - leftNode + 1);
        }

        return maxWidth;
    }
}
