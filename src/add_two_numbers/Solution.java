package add_two_numbers;

public class Solution {


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long sum1 = transformDigit(reverseList(l1));
        long sum2 = transformDigit(reverseList(l2));
        long totalSum = sum1 + sum2;
        return reverseList(transformList(totalSum));
    }

    private static long transformDigit(ListNode listNode) {
        long sum = 0;
        while (listNode != null) {
            if (listNode.val < 0) {
                System.exit(-1);
            }
            sum = listNode.val + sum * 10;
            listNode = listNode.next;
        }
        return sum;
    }

    private static ListNode transformList(long number){
        char a[] = Long.toString(number).toCharArray();
        ListNode result = new ListNode(Integer.parseInt(a[0]+""));
        ListNode finalResult = result;
        for(int i = 1; i<a.length;i++){
            result.next = new ListNode(Integer.parseInt(a[i]+""));
            result = result.next;
        }
        return finalResult;
    }

    private static ListNode reverseList(ListNode listNode) {
        if (listNode.next == null) {
            return listNode;
        } else {
            ListNode temp1 = listNode;
            ListNode temp2;
            ListNode temp3;
            temp2 = temp1.next;
            temp3 = temp2.next;
            temp1.next = null;
            while (temp3 != null) {
                temp2.next = temp1;
                temp1 = temp2;
                temp2 = temp3;
                temp3 = temp3.next;
            }
            temp2.next = temp1;
            return temp2;
        }


    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        ListNode a = new ListNode(2);
        ListNode tempA = a;
        a.next = new ListNode(4);
        a = a.next;
        a.next = new ListNode(3);


        ListNode b = new ListNode(3);
        ListNode tempB = b;
       // b.next = new ListNode(6);
        //b=b.next;
        //b.next = new ListNode(4);

         ListNode x = reverseList(transformList(1999999999));
        long num = transformDigit(x);

    }
}
