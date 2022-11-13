package MidTerm.Question4;

public class LinkList {

        public Node head;

        public int length = 0;

        public LinkList() {
            head = null;
        }

        public void insert(Integer data) {
            if (head == null || head.data >= data) {
                Node currentNode = new Node(data);
                currentNode.next = head;
                head = currentNode;
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.data < data) {
                temp = temp.next;
            }

            Node currentNode = new Node(data);
            currentNode.next = temp.next;
            temp.next = currentNode;
        }
    }


