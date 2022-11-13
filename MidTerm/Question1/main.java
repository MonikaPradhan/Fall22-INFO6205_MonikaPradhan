package MidTerm.Question1;

//Question 1 : In a Binary Tree populate next left of a tree.

 /*
         Time complexity : O(n)
         Space Complexity : O(1)
 */

public class main {
    public static void main(String[] args) {
        BinTree<Integer> tree = new BinTree<>();

        tree.root = new Node<>(1);

        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);

        tree.root.left.left = new Node<>(4);
        tree.root.left.right = new Node<>(5);
        tree.root.right.left = new Node<>(6);
        tree.root.right.right = new Node<>(7);

        tree.root.left.left.left = new Node<>(8);
        tree.root.left.right.left = new Node<>(9);
        tree.root.right.left.right = new Node<>(10);
        tree.root.right.right.right = new Node<>(11);

        tree.populateNextRight();
        printTree(tree.root);
    }

    private static void printTree(Node root) {
        if(root == null) {
            return;
        }
        Integer next = null;
        if(root.nextLeft != null) {
            next = (Integer)root.nextLeft.data;
        }
        System.out.println("Node: " + root.data + " Next left node: " + next);
        printTree(root.left);
        printTree(root.right);
    }
}
