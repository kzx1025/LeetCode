package zero_twenty.lonest_substring;

import java.util.*;

/**
 * Created by iceke on 15/9/30.
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Solution {

    /**
     * exceed the limit time....
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if(s.equals("")){
            return 0;
        }
        char[] arrayString = s.toCharArray();
        HashSet<Character> hs = new HashSet<Character>();
        int result = 0;
        int max = 0;
        int i = 0;
        while(i<arrayString.length){
            hs.add(arrayString[i]);
            int j=i+1;
            for (; j < arrayString.length; j++) {
                if (!hs.contains(arrayString[j])) {
                    hs.add(arrayString[j]);
                    max++;
                } else {
                    max = 0;
                    hs.clear();
                    break;
                }
                if(max>result){
                    result = max;
                }
            }
            i=j+1;

        }
        return result+1;

    }

    /**
     * 采用了一种类似窗口的机制
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s){
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        Arrays.fill(map, -1);

        int start = 0;
        int end = 0;
        int maxLength = 0;
        for(;end < s.length(); end++){
            int indexChar = s.charAt(end);
            while(map[indexChar] != -1&&start < end){
                int tempChar = s.charAt(start);
                map[tempChar] = -1;
                start++;
            }
            map[indexChar] = 0;
            maxLength = (maxLength < end-start+1)?end-start+1:maxLength;
        }
        return maxLength;

    }

    public int lengthOfLongestSubstring3(String s){
        Set<Character> charSet = new HashSet<Character>();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        for(;end < s.length(); end++){
            char indexChar = s.charAt(end);
            while(charSet.contains(indexChar) &&start < end){
                char tempChar = s.charAt(start);
                charSet.remove(tempChar);
                start++;
            }
            charSet.add(indexChar);
            maxLength = (maxLength < end-start+1)?end-start+1:maxLength;
        }
        return maxLength;

    }



    public static void main(String args[]) {
        String testString = "abcdefb";
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstring3(testString);
        System.out.println(result);

    }

}
