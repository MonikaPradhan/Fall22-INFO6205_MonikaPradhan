package Assignment1;

/*
Question 2 : Remove Linked List Elements (https://leetcode.com/problems/remove-linked-list-elements/)
This program uses ListNode.java class
Time complexity : O(n)
 */
public class Question2 {
    public static void main(String[] args) {
        //Creating a single ListNode "head" and providing input values
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        //Defining the value which is to be removed from the given linkedList
        int val = 6;

        //Printing the original linkedList
        System.out.println("Before removing the elements, the list is: ");
        System.out.println(head + "\n");

        //Defining a result LinkedList which will store the new list post removing the val
        ListNode result = removeElements(head,val);

        //Printing the new LinkList
        System.out.println("After removing"+" "+ val +" "+"the list is :");
        System.out.println(result + "\n");
    }

    public static ListNode removeElements(ListNode head, int val) {

        //Defining two pointers previous and current, pointing to null and head respectively.
        ListNode previous = null, current = head;

        /*We will traverse the list, till end and if the node value matches the provided value to be removed, we
        will remove the node from list by pointing the previous node to the current.next node*/
        while(current != null){
            if(current.val == val){
                if(previous != null)
                    previous.next = current.next;
                else
                    head = head.next;
            } else {
                previous = current;
            }
            current = current.next;
        }

        //Returning the list post removing the val provided.
        return head;
    }
}
