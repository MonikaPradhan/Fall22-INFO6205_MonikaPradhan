package Assignment1;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){}

    public ListNode(int _val){
        val = _val;
    }

    public ListNode(int _val, ListNode _next){
        val = _val;
        next = _next;
    }

    @Override
    public String toString() {
        String result = "";
        ListNode tempHead = this;
        while(tempHead != null){
            result = result + tempHead.val + " -> ";
            tempHead = tempHead.next;
        }
        result = result + "NULL";
        return result;
    }

    //This function is created to print the list
    public List<Integer> getListArray() {
        ListNode tempHead = this;
        ArrayList<Integer> listOfNodeValues = new ArrayList<>();
        while(tempHead != null) {
            listOfNodeValues.add(tempHead.val);
            tempHead = tempHead.next;
        }
        return listOfNodeValues;
    }
}
