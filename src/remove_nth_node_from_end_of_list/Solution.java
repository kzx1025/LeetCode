package remove_nth_node_from_end_of_list;

/**
 * Created by iceke on 16/4/22.
 */
public class Solution {
    public static void main(String args[]){
        ListNode head = new ListNode(1);
        ListNode p= head;
        int[] nums = {1,2};
        for(int i =1;i<nums.length;i++){
            ListNode node = new ListNode(nums[i]);
            p.next = node;
            p = p.next;
        }

        ListNode result = removeNthFromEnd(head,1);
        System.out.println(result.val);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode prior = head;
        ListNode after = head;

        for(int i = 0;i<n;i++){
            after = after.next;
        }

        if(after == null){
            return head.next;
        }

        while(after.next!=null){
            prior = prior.next;
            after = after.next;
        }


        prior.next = prior.next.next;


        return head;

    }

}
