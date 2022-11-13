package MidTerm.Question3;

//Question 3 : In a Binary search tree print values which are inside of range. Optimize it if possible

/*
        Time Complexity: O(n)
        Space Complexity: O(1)
*/

import MidTerm.Question1.Node;

public class main {
    public static void main(String[] args) {
        Node<Integer> root = getBST();
        printRange(root, 5, 8);
    }

   // Given range between 5 and 8 it will print 6, 7, 8
   private static Node<Integer> getBST(){
       Node<Integer> root = new Node<>(8);
       root.parent = root;

       root.left = new Node<>(3);
       root.right = new Node<>(10);
       root.left.parent = root;
       root.right.parent = root;


       root.left.left = new Node<>(1);
       root.left.right = new Node<>(6);
       root.left.left.parent = root.left;
       root.left.right.parent = root.left;

       root.right.right = new Node<>(14);
       root.right.right.parent = root.right;

       root.left.right.left = new Node<>(4);
       root.left.right.right = new Node<>(17);
       root.left.right.left.parent = root.left.right;
       root.left.right.right.parent = root.left.right;


       root.right.right.left = new Node<>(13);
       root.right.right.left.parent = root.right.right;

       return root;
   }

 private static void printRange(Node<Integer> root, int left, int right) {
        if (root == null) {
            return;
        }

        if (left < root.data) {
            printRange(root.left, left, right);
        }

        if (left <= root.data && right >= root.data) {
            System.out.print(root.data + " ");
        }

        printRange(root.right, left, right);
    }
}
