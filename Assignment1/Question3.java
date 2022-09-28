package Assignment1;

/*
Question 3 : Swapping Nodes in a Linked List(https://leetcode.com/problems/swapping-nodes-in-a-linked-list/)
This program uses ListNode.java class
Time Complexity : O(n)
 */
public class Question3 {
    public static void main(String[] args) {
        //Creating a single ListNode "head" and providing input values. This list is 1-indexed
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        //Providing value k (he values of the kth node from the beginning and the kth node from the end will be swapped)
        int k = 2;

        //Printing the original list before swapping
        System.out.println("Before swapping the elements, the list is: ");
        System.out.println(head + "\n");

        //Creating new list called result to store the list post swapping the nodes
        ListNode result = swapNodes(head,k);

        //Printing the new list post swapping the Kth nodes
        System.out.println("After swapping the"+" "+ k +"th" +" "+"element, the list is :");
        System.out.println(result + "\n");
    }

    public static ListNode swapNodes(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        //Initializing pointers to head
        ListNode front = head, tempHead = head, back = head;
        int numberOfNodes = 0;
        int counter = 1;

        //Calculating the number of nodes
        while(tempHead != null){
            tempHead = tempHead.next;
            numberOfNodes++;
        }

        if(k > numberOfNodes) {
            System.out.println("Invalid test : Value of K should be less than total nodes in linked list");
            return null;
        }

        //finding the kth position from front and back of the list
        while(counter != k){
            front = front.next;
            counter++;
        }

        //Again initializing the counter to 0 to check the kth node from the back of the list
        counter = 0;
        k = numberOfNodes - (k -1);
        while(counter < k-1 ){
            back = back.next;
            counter++;
        }

        //After finding the kth position nodes, we will swap the nodes
        int temp = front.val;
        front.val = back.val;
        back.val = temp;

        //Return the new list with swapped kth position nodes
        return head;
    }
}
