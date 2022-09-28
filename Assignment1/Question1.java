package Assignment1;

/*
Question 1 :  Rotate List (https://leetcode.com/problems/rotate-list/)
This program uses ListNode.java class
Time complexity : O(n)
*/
public class Question1 {
    public static void main(String[] args) {
        //Creating a single ListNode "head" and providing input values
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // k is the number of times the list is to be rotated
        int k = 2;

        //Printing the original list
        System.out.println("Before rotation the list is: ");
        System.out.println(head + "\n");

        // Get the rotated list.
        ListNode result = rotateRight(head,k);

        //Printing the rotated list
        System.out.println("After"+" "+ k +" "+"rotations the list is :");
        System.out.println(result + "\n");
    }

    public static ListNode rotateRight(ListNode head, int k) {
        //Creating a pointer called current to point to head
        ListNode current = head;

        //We will return the head if head is provided as null, or we will return the original list as it is if the number of rotations provided is 0
        if(head == null || head.next == null || k==0){
            return head;
        }

        //Counting the number of nodes in the given list
        int nodeCount = 1;
        while(current.next != null){
            current = current.next;
            nodeCount++;
        }

        //Again we will bring current pointer to head location as it will have reached end of list while counting the number of nodes in the above function
        current.next = head;
        current = head;

        /*
         We will use the modulo operator to calculate the actual number of rotations required. (Example, if k = 500, we will not rotate the list 500 times,
         which will indeed rise the cost of operation. if number of nodes = 5 and k = 500, then actual rotations required to get desired output is 0. The
         list of 5 nodes will remain same after 500 rotations)
        */
        k = k % nodeCount;
        for(int i=0; i< nodeCount-k-1 ; i++){
            current = current.next;
        }

        //Once we get the correct position from above loop, where the nodes will be moved before head of list, we will arrange the nodes, and the corresponding pointers to the new head by breaking the link
        head = current.next;
        current.next = null;

        //Return the new ListNode post rotation
        return head;
    }
}
