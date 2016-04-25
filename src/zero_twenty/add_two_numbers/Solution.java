package zero_twenty.add_two_numbers;


/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class Solution {


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long sum1 = transformDigit(reverseList(l1));
        long sum2 = transformDigit(reverseList(l2));
        long totalSum = sum1 + sum2;
        return reverseList(transformList(totalSum));
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        int carry = 0;//jinwei
        ListNode head = new ListNode(0);
        ListNode point  = head;
        while(l1!=null&&l2!=null){
            int sum = l1.val+l2.val+carry;
            carry = sum / 10;
            point.next = new ListNode(sum % 10);
            point = point.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            int sum = l1.val+carry;
            carry = sum / 10;
            point.next = new ListNode(sum % 10);
            point = point.next;
            l1 = l1.next;
        }

        while(l2!=null){
            int sum = l2.val+carry;
            carry = sum / 10;
            point.next = new ListNode(sum % 10);
            point = point.next;
            l2 = l2.next;
        }

        if(carry != 0){
            point.next = new ListNode(carry);
        }
        return head.next;
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
        b.next = new ListNode(6);
        b=b.next;
        b.next = new ListNode(4);

        // ListNode x = reverseList(transformList(1999999999));
        //long num = transformDigit(x);
        System.out.println(transformDigit(solution.addTwoNumbers2(tempA,tempB)));


    }
}
