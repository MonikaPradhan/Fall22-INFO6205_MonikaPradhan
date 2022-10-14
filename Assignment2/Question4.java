package Assignment2;

/*Question 4 : Binary Tree Zigzag Level Order Traversal (https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
This class used TreeNode.java class
The complexity of the below solution is O(n) */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question4 {
    public static void main(String[] args) {
        //We will create tree and pass the values to the tree
        TreeNode tree = new TreeNode();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(20);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(7);

        //We will create a new final list, which will store the result of the zigzag level order traversal
        List<List<Integer>> finalList = zigzagLevelOrder(tree.root);
        //We will print the final list
        System.out.println("The zigzag level order traversal of the tree is : "+finalList);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //We will first create a temporary arraylist. We will compute the values in this list and return to the main function same list
        List<List<Integer>> tempList = new ArrayList<>();

        //If root is null, we will return the tempList here itself.
        if(root == null){
            return tempList;
        }

        //We are using Queue for storing and fetching the values from the tree. We will define a temporary queue variable
        Queue<TreeNode> tempQueue = new LinkedList<>();

        tempQueue.add(root);
        boolean value = false;

        //While queue is not empty, we will traverse the tree
        while(!tempQueue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int queueSize = tempQueue.size();

            //We will iterate till the end of queue size.
            for(int i = 0; i < queueSize; i++){
                TreeNode node = tempQueue.poll();

                //If value is true, we will add the node value with the index, else we will add it without index
                if(value) {
                    levelList.add(0, node.val);
                } else {
                    levelList.add(node.val);
                }

                //If node has left child, we will add the left node to the queue, similarly if the right child exists, we will add the right child to the queue
                if(node.left != null){
                    tempQueue.add(node.left);
                }

                if(node.right != null){
                    tempQueue.add(node.right);
                }
            }

            //We will add the levelList to the tempList and change the value of the value variable
            tempList.add(levelList);
            value =! value;
        }

        //We will return the tempList
        return tempList;
    }
}
