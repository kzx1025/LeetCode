package twenty_thirty.merge_two_sorted_lists;


/**
 * Created by iceke on 16/4/25.
 */
public class Solution {
    public static  void main(String args[]){
        int[] l1Num= {1,3,5,6,9};
        int[] l2Num = {2,4,7,9,10,11};
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;

        for(int i = 1;i<l1Num.length;i++){
            ListNode temp = new ListNode(l1Num[i]);
            l1Temp.next = temp;
            l1Temp = l1Temp.next;
        }
        for(int i = 1;i<l2Num.length;i++){
            ListNode temp = new ListNode(l2Num[i]);
            l2Temp.next = temp;
            l2Temp = l2Temp.next;
        }

        ListNode result = mergeTwoLists(l1,l2);
        System.out.println(result);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if(l1 == null&& l2 ==null){
            return null;
        }else if(l2 ==null){
            head = l1;
            l1 = l1.next;
        }else if(l1 == null){
            head = l2;
            l2 = l2.next;
        }else {
            if (l1.val < l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
        }
        ListNode finalHead = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }else{
                head.next = l2;
                head = head.next;
                l2= l2.next;
            }
        }

        if(l1!=null){
            head.next = l1;
        }

        if(l2!=null){
            head.next = l2;
        }

        return finalHead;


    }
}
