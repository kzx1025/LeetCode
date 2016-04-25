package zero_twenty.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iceke on 16/1/20.
 */
public class Solution {

    public static void main(String args[]){
        List<String> a = null;
        a = letterCombinations("23");
        System.out.println(a);

    }
    public static List<String> letterCombinations(String digits) {

        //就不应该用map这个数据结构,不好遍历,取而代之的应该使用字符串数组
        List<String> result = new ArrayList<String>();

        if (digits == null || digits.equals("")) {
            return result;
        }
        result.add("");
        String[] numRes = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i = 0;i<digits.length();i++){
            List<String> tempRes = new ArrayList<String>();
            int index = digits.charAt(i) - '0';
            String tempString = numRes[index];

            for(int j = 0;j<tempString.length();j++){
                for(int k = 0;k<result.size();k++){
                    tempRes.add(result.get(k)+tempString.charAt(j));
                }
            }
            result = tempRes;

        }

        return result;

    }

}
