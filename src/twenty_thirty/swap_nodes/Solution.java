package twenty_thirty.swap_nodes;

/**
 * Created by iceke on 16/12/6.
 */

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Solution {

    public static void main(String args[]) {

        ListNode start = new ListNode(1);
        ListNode head = start;
        int i = 2;
        while (i < 0) {
            ListNode temp = new ListNode(i);
            head.next = temp;
            head = temp;
            i++;
        }


        ListNode result = swapPairs(start);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prev = head;
        ListNode after = head.next;
        ListNode result = after;
        if(result == null){
            return head;
        }
        while (after != null) {
            ListNode temp = after.next;
            after.next = prev;
            prev.next = temp;

            //skip two
            if (temp == null) {
                break;
            }else if(temp.next == null){
                prev.next = temp;
                break;
            } else {
                prev.next = temp.next;
                prev = temp;
                after = prev.next;
            }


        }

        return result;

    }
}