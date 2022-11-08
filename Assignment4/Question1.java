package Assignment4;

//Question 1: Convert Sorted List to Binary Search Tree (https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)

public class Question1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode result = sortedListToBST(head);
        result.printTree();

    }

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return new TreeNode(head.val);
        }

        if(head.next.next == null) {
            TreeNode right = new TreeNode(head.next.val);
            TreeNode root = new TreeNode(head.val);
            root.right = right;
            return root;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = new ListNode(0);
        temp.next = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            temp = temp.next;
        }

        TreeNode root = new TreeNode();
        root.val = slow.val;
        ListNode newHead = slow.next;
        temp.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(newHead);
        return root;
    }
}

