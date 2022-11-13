package MidTerm.Question2;

//Question 2 : Populate parent of each node. in the binary tree

/*
       Time complexity: o(n)
       Space complexity: O(h), where h is height of tree
*/


import MidTerm.Question1.Node;

public class main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node(5);
        root.left.right = new Node(6);

        populateParent(root);

        System.out.println(root.left.left.parent.data);
        System.out.println(root.left.right.parent.data);
    }

    private static Node populateParent(Node root) {
        if(root == null) {
            return null;
        }

        if(root.left != null) {
            root.left.parent = root;
        }

        if(root.right != null) {
            root.right.parent = root;
        }

        populateParent(root.left);
        populateParent(root.right);

        return root;
    }

}
