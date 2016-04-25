package zero_twenty.palindrome_number;

import java.util.Map;

/**
 * Created by iceke on 15/11/4.
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int testDigit = x;
        int length = 0;
        while (testDigit != 0) {
            testDigit /= 10;
            length++;
        }
        int tempLength = length;
        for (int i = 0; i < length / 2; i++) {
            int left = (int) (x / (Math.pow(10, (tempLength - 1))));
            int right = (int) (x % (Math.pow(10, 1)));
            if (left != right) {
                return false;
            } else {
                x = x / 10;
                x =(int)( x - (int) (x / (Math.pow(10, tempLength - 2))) * (Math.pow(10, tempLength - 2)));
                tempLength-=2;
            }
        }
        return true;

    }

    /**
     * 卧槽 我想复杂了..
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if(x < 0) {
            return false;
        }
        return x == reverse(x);
    }

    public static int reverse(int x) {
        int rst = 0;
        while(x != 0) {
            rst = rst * 10 + x % 10;
            x = x / 10;
        }
        return rst;
    }

    public static void main(String args[]) {
        if (isPalindrome2(1324231)) {
            System.out.println("succeed");
        }
    }
}
