package Quiz1;

//Question 3: Binary Tree Level order traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question3 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(20);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(7);
        List<List<Integer>> resultList = levelOrder(tree.root);
        System.out.println("The Level Order traversal of the tree is : "+resultList);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList();
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll();

                level.add(current.val);

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
