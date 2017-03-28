package fifty_sixty;

import twenty_thirty.merge_k_sorted_lists.ListNode;

/**
 * Created by iceke on 17/3/28.
 */
public class Rotate_List {
    public static void main(String args[]){
        ListNode node = new ListNode(1);
        ListNode head = node;
        for(int i =2;i<6;i++){
            ListNode temp = new ListNode(i);
            node.next = temp;
            node = node.next;

        }

        ListNode result = rotateRight(head,11);

        while(result!= null){
            System.out.println(result.val);
            result = result.next;
        }


    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }

        if(head.next == null || k == 0){
            return head;
        }

        ListNode oldStart = head;
        ListNode testNode = head;
        ListNode lNode = head;
        int length = 0;
        for ( length =0;lNode!=null;length++)//Get the total length
            lNode=lNode.next;

        if(k>length) {
            k %= length;
        }



        for(int i = 0;i<k;i++){
            testNode = testNode.next;
        }

        if(testNode == null || k== 0){
            return oldStart;
        }

        while(testNode.next!=null){
            head = head.next;
            testNode = testNode.next;
        }



        ListNode end = head;

        head = head.next;
        end.next = null;


        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = oldStart;

        return head;

    }


}
