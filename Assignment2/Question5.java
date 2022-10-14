package Assignment2;

/*Question 5 : Binary Tree Vertical Order Traversal (https://leetcode.com/problems/binary-tree-vertical-order-traversal/)
This class used TreeNode.java class
The complexity of the below solution is O(n) */

import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        //We will create tree and pass the values to the tree
        TreeNode tree = new TreeNode();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(0);
        tree.root.right.left = new TreeNode(1);
        tree.root.right.right = new TreeNode(7);
        //We will create a resultList to store the final list returned by the function
        List<List<Integer>> resultList = verticalOrder(tree.root);
        //We will print the final list
        System.out.println("The vertical order traversal for the given tree is : "+resultList);
    }

    public static List<List<Integer>> verticalOrder(TreeNode root){
        List<List<Integer>> finalList = new ArrayList<>();
        if(root == null){
            return finalList;
        }

        Map<Integer, ArrayList<Integer>> tempMap = new HashMap<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();
        treeNodeQueue.add(root);
        column.add(0);
        int min = 0;
        int max = 0;

        while(!treeNodeQueue.isEmpty()){
            TreeNode node = treeNodeQueue.poll();
            int tempColumn = column.poll();
            if(!tempMap.containsKey(tempColumn)){
                 tempMap.put(tempColumn,new ArrayList<Integer>());
            }
            tempMap.get(tempColumn).add(node.val);

            //If the node has left child, we will add the value to the queue.
            if(node.left!=null){
                treeNodeQueue.add(node.left);
                column.add(tempColumn - 1);
                min = Math.min(min,tempColumn -1);
            }

            //If the node has right child, we will add the value to the queue.
            if(node.right!=null){
                treeNodeQueue.add(node.right);
                column.add(tempColumn + 1);
                max = Math.max(max,tempColumn + 1);
            }
        }

        // Fetch the value from the map from min to max calculated from above if clause and add them to the finallist
        for(int i = min; i<=max; i++){
            finalList.add(tempMap.get(i));
        }

        return finalList;
    }
}
