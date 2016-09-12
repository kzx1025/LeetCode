package exam;

/**
 * Created by iceke on 16/9/12.
*/
public class Qianzhui {
    /**
     * do it myself
     * 采用两个窗口，分两种情况讨论
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLength = 0;
        String subString = s.charAt(0)+"";
        for (int i = 0; i < s.length(); i++) {
            char indexChar = s.charAt(i);
            int window1 = i;
            int window2 = i;
            int tempLength1 = 0;
            int tempLength2 = 0;
            int flag = -1;
            while ( window1 >= 0 && i + window1 < s.length() && s.charAt(i - window1) == s.charAt(i + window1)) {
                if(i-window1 ==0) {
                    tempLength1 = window1 * 2 + 1;
                }
                window1--;

            }
            while ( window2 >= 0 && i + window2 + 1 < s.length() && s.charAt(i - window2) == s.charAt(i + window2 + 1)) {
                if(i-window2 == 0) {
                    tempLength2 = (window2 + 1) * 2;
                }
                window2--;
            }
            int tempLength = Math.max(tempLength1, tempLength2);
            flag = tempLength1 >= tempLength2 ? 0 : 1;

            if (tempLength > maxLength) {
                if ((flag == 0)&&(i - tempLength / 2==0)) {
                    subString = s.substring(i - tempLength / 2, i + tempLength / 2 + 1);
                } else if ((flag == 1)&&(i + 1 - tempLength / 2==0)) {
                    subString = s.substring(i + 1 - tempLength / 2, i + tempLength / 2 + 1);
                }

                maxLength = tempLength;
            }


        }

        return subString;

    }

    /**
     * 百度一下Manacher算法吧
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        return null;
    }

    public static void main(String args[]) {
        String a = "ssogou";
        System.out.println(longestPalindrome(a));

    }

}
