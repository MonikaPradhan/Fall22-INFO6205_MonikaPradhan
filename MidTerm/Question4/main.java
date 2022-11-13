package MidTerm.Question4;

//Question 4 : Sorted insert in a Link list.

/*
    Time Complexity: O(n)
    Space Complexity: O(h) : h is the height of tree
 */

public class main {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(4);

        list.insert(3);

        Node head = list.head;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

}
