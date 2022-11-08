package Assignment4;

//Question 2 : Convert Binary Search  to Sorted Doubly Linked List (https://leetcode.com/problems/convert-binary-search--to-sorted-doubly-linked-list/Links to an external site.)

import java.util.ArrayDeque;
import java.util.Queue;

public class Question2 {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Node result = ToDoublyList(root);
        Node start = result;
        if(start == null){
            System.out.println("Result is NULL");
            return;
        }
        do{
            System.out.print(start.val+" ");
            start = start.right;
        } while(start!=result);

    }

    public static Node ToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node (0);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(dummy);
        inOrder(root, queue);

        // In the end, the queue stores the rightmost node, link this node with the leftmost node;
        Node last = queue.remove();
        last.right = dummy.right;
        dummy.right.left = last;
        return dummy.right;
    }

    private static void inOrder(Node root, Queue<Node> queue) {
        if (root != null) {
            inOrder(root.left, queue);

            Node pre = queue.remove();
            pre.right = root;
            root.left = pre;
            queue.add(root);

            inOrder(root.right, queue);
        }
    }

}
