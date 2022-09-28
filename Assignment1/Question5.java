package Assignment1;

import java.util.ArrayList;

/*
  Question 5: Insert into a Sorted Circular Linked List(https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/)
  This program uses Node.java class
  Time complexity : O(n)
 */

public class Question5 {
    public static void main(String[] args) {
        //Creating a circular linked list and providing the input values
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = head;

        //Provide the insertVal (Value to be inserted)
        int insertVal = 2;

        //Printing the original circular linkedlist
        System.out.println("Before inserting the value, the list is: ");
        System.out.println(printList(head));

        //Defining a new result list for storing the final list post insertion
        Node result = insert(head, insertVal);

        //Printing the final list
        System.out.println("After inserting the value" + " " + insertVal + " " + "the list is :");
        System.out.println(printList(result));
    }

    public static Node insert(Node head, int insertVal) {
        //if head is null i.e., original list provided was null, then we will create a new node and insert the value provided by the user. This will be the head
        if(head == null) {
            Node tempHead= new Node(insertVal, null);
            tempHead.next= tempHead;
            return tempHead;
        }

        //Defining two pointers previous and current and initializing them such that current is ahead of previous
        Node previous= head;
        Node current= head.next;
        //We will find the position where the user provided value needs to be inserted. We need to search the nodes such that previous is less than the value which needs to be inserted and current should be greater
        while(current != head) {
            if(previous.val <= insertVal && current.val >= insertVal) {
                break;
            }

            if(previous.val > current.val) {
                if(insertVal >= previous.val || insertVal <= current.val) {
                    break;
                }
            }
            previous= previous.next;
            current= current.next;
        }

        //Once we get the correct position where the value needs to inserted, we will insert the node between previous ans current
        Node tmpNode= new Node(insertVal, previous.next);
        previous.next= tmpNode;
        return head;
    }

    //This function prints the original and final circular linked list
    public static ArrayList<Integer> printList(Node head){
        Node tempHead = head;
        ArrayList<Integer> listOfNodeValues = new ArrayList<>();
        if(head != null){
            do{
                listOfNodeValues.add(tempHead.val);
                tempHead = tempHead.next;
            } while (tempHead != head);
        }
        return listOfNodeValues;
    }
}
