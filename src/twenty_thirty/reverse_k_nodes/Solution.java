package twenty_thirty.reverse_k_nodes;

/**
 * Created by iceke on 16/12/7.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String args[]){
        ListNode start = new ListNode(1);
        ListNode head = start;
        int i = 2;
        while (i < 1) {
            ListNode temp = new ListNode(i);
            head.next = temp;
            head = temp;
            i++;
        }

        ListNode result =reverseKGroup(start,3);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = null;
        if(head == null){
            return null;
        }else{
            ListNode start = head;
            ListNode end = head;
            ListNode oldStart = null;

            int m = 0;
            while(end != null) {


                for (int i = 0; i < k-1; i++) {
                    end = end.next;
                    if(end == null){
                        if(m == 0){
                            //first time
                            return head;
                        }else {
                            oldStart.next = start;
                            return result;
                        }
                    }

                }


                if(m == 0){
                    result = end;
                }else{
                    oldStart.next =end;
                }
                //start reverse
                ListNode prev = start;
                ListNode after = prev.next;
                ListNode newStart = end.next;

                while(after != newStart){
                    //reverse two
                    ListNode temp = after.next;
                    after.next = prev;
                    prev = after;
                    after = temp;
                }
                oldStart = start;
                start = newStart;
                end = start;
                m++;
            }

            oldStart.next = start;

        }



        return result;
    }

}
