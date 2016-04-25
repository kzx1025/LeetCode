package zero_twenty.longest_common_prefix;

/**
 * Created by iceke on 15/12/10.
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        for (int j = 0; j < strs[0].length();j++){
            char temp = strs[0].charAt(j);
            for(int i=0;i <strs.length;i++){
                if(j == strs[i].length() || strs[i].charAt(j)!=temp){
                    return strs[0].substring(0,j);
                }

            }
        }


        return strs[0];

    }

    public static void main(String args[]){
        String[] strs = {"sdaf","sda","sda"};
        System.out.println(longestCommonPrefix(strs));

    }
}
