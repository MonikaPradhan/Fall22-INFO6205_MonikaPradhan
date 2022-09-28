package Assignment1;

public class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }

    @Override
    public String toString() {
        String result = "";
        Node tempHead = this;
        while(tempHead != null){
            result = result + tempHead.val + " -> ";
            tempHead = tempHead.next;
        }
        result = result + "NULL";
        return result;
    }
}
