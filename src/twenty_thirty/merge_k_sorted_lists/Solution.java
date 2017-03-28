package twenty_thirty.merge_k_sorted_lists;

/**
 * Created by iceke on 16/4/25.
 */
public class Solution {
    public static void main(String args[]) {
        int[] l1Num = {};
        int[] l2Num = {2, 4, 7, 9, 10, 11};
        ListNode l1 = null;
        ListNode l2 = new ListNode(2);
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;

        for (int i = 1; i < l1Num.length; i++) {
            ListNode temp = new ListNode(l1Num[i]);
            l1Temp.next = temp;
            l1Temp = l1Temp.next;
        }
        for (int i = 1; i < l2Num.length; i++) {
            ListNode temp = new ListNode(l2Num[i]);
            l2Temp.next = temp;
            l2Temp = l2Temp.next;
        }

        ListNode[] lists = {l1,l2};

        ListNode result = mergeKLists(lists);
        System.out.println();

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }else if(lists.length == 1){
            return lists[0];
        }
        else{
            return sort(lists,0,lists.length-1);
        }

    }

    //归并排序
    public static ListNode sort(ListNode[]lists, int low, int high){
        int mid = (low+high)/2;
        if(low < high){
            ListNode l1 = sort(lists,low,mid);
            ListNode l2 = sort(lists,mid+1,high);
            return mergeTwoLists(l1,l2);
        }

        return lists[low];


    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if (l1 == null && l2 == null) {
            return null;
        } else if (l2 == null) {
            head = l1;
            l1 = l1.next;
        } else if (l1 == null) {
            head = l2;
            l2 = l2.next;
        } else {
            if (l1.val < l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
        }
        ListNode finalHead = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            head.next = l1;
        }

        if (l2 != null) {
            head.next = l2;
        }

        return finalHead;


    }
}
