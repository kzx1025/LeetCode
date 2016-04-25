package zero_twenty.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iceke on 15/12/10.
 */
public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length()==0) {
            return 0;
        }
        Map<Character,Integer> numMap = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
        };
        int length = s.length();
        int result = numMap.get(s.charAt(length - 1));
        for (int i = length - 2; i >= 0; i--) {
            if (numMap.get(s.charAt(i + 1)) <= numMap.get(s.charAt(i))) {
                result += numMap.get(s.charAt(i));
            } else {
                result -= numMap.get(s.charAt(i));
            }
        }
        return result;
    }

}
