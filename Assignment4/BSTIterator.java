package Assignment4;

//Question 5: Binary Search Tree Iterator (https://leetcode.com/problems/binary-search-tree-iterator/Links to an external site.)

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class BSTIterator {
    Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        //Declaring an arraylist which will be passed with the root node of the input tree to the inOrderTraversal function
        List<Integer> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);
        iterator = inorder.iterator();
    }

    public int next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void inOrderTraversal(TreeNode node, List<Integer> inOrder)
    {
        //Till the node is not null, using recursion for left and right node and adding the values in the ArrayList as well.
        if(node != null)
        {
            inOrderTraversal(node.left, inOrder);
            inOrder.add(node.val);
            inOrderTraversal(node.right, inOrder);
        }
    }
}