package integer_to_roman;


/**
 * Created by iceke on 15/12/10.
 *Given an integer, convert it to a roman numeral.
 *Input is guaranteed to be within the range from 1 to 3999.
 *Subscribe to see which companies asked this question
 *
 */
public class Solution {

    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] dics = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < nums.length) {
            int times = num / nums[i];
            num -= nums[i] * times;
            for (int j = 0; j < times; j++) {
                sb.append(dics[i]);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.println(intToRoman(1900));
    }
}
