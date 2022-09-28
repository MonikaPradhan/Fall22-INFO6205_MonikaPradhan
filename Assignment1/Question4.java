package Assignment1;

/*
 Question 4: Split Linked List in Parts (https://leetcode.com/problems/split-linked-list-in-parts/)
 This program uses ListNode.java class
 Time complexity : O(n)
 */
public class Question4 {
    public static void main(String[] args) {
        //Creating a single ListNode "head" and providing input values. This list is 1-indexed
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        //Providing the value of k (which will split the linked list into k consecutive linked list parts)
        int k = 5;

        //Printing the list before splitting
        System.out.println("Before splitting the elements, the list is: ");
        //We are calling below function defined in the ListNode class to print the list
        System.out.println(head.getListArray() + "\n");

        //defining a listnode array called result to display the splited linked list
        ListNode[] result = splitListToParts(head,k);

        //Printing the result list
        System.out.println("After splitting the list"+" "+ k +" "+"times, the list is :");
        for(ListNode node : result) {
            if(node != null) {
                System.out.print(node.getListArray());
            } else {
                System.out.print("[]");
            }
        }
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        //Defining a new ListNode array called finalList of length k
        ListNode[] finalList = new ListNode[k];

        //If head is null returning finalList
        if(head == null){
            return finalList;
        }

        //Calculating the length of the original list node
        int lengthOfList = 0;
        ListNode current = head;
        while (current != null){
            lengthOfList++;
            current = current.next;
        }

        //Pointing current to head again
        current = head;

        //Calculating the length of each node
        int lengthOfEachPart = lengthOfList / k;

        //Calculating the remaining length
        int remLength = lengthOfList % k;
        int index = 0;

        /*
        We will divide the list according to the lengthOfEachPart value we received. This length is fixed for every node
        whatever is the remaining length, the difference will be added to the starting nodes. If the length of list was less than k,
        the remaining number of arrays will be printed as null.
        */
        while (current != null){
            ListNode root = current;
            int extraLength = 0;
            if(remLength > 0) {
                extraLength = 1;
            }

            for (int i=0;i< lengthOfEachPart + extraLength - 1;i++){
                current = current.next;
            }
            ListNode temp = current.next;
            current.next = null;
            current = temp;
            finalList[index++] = root;
            remLength--;
        }

        //Returning the listnode array of the k splitted parts
        return finalList;
    }
}
