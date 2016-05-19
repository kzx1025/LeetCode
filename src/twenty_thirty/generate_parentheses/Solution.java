package twenty_thirty.generate_parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Created by iceke on 16/5/19.
 */
public class Solution {

    public static void main(String args[]) {
        List<String> result = generateParenthesis2(3);
        System.out.println(result);
    }

    public static List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            return result;
        }

        recursive(0, 0, n, sb, result);

        return result;


    }

    public static void recursive(int left, int right, int n, StringBuilder sb, List<String> list) {
        if (left < right) {
            return;
        }
        if (left == n && right == n) {
            list.add(sb.toString());
            return;
        }
        if(left<n){
            StringBuilder tempSB = new StringBuilder(sb.toString());
            recursive(left+1,right,n,tempSB.append('('),list);
        }
        if(right<n){
            StringBuilder tempSB = new StringBuilder(sb.toString());
            recursive(left,right+1,n,tempSB.append(')'),list);
        }


    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        if (n == 1) {
            result.add("(");
            return result;
        }

        result.add("(");
        char[] para = {'(', ')'};
        for (int i = 1; i < n * 2; i++) {
            List<String> tempRes = new ArrayList<String>();
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < result.size(); k++) {
                    String tempString = result.get(k) + para[j];
                    tempRes.add(tempString);

                }
            }
            result = tempRes;

        }

        for (int m = result.size() - 1; m >= 0; m--) {
            if (!isValid(result.get(m))) {
                result.remove(m);
            }
        }

        return result;

    }

    public static boolean isValid(String s) {
        Stack<Character> brackets = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '}' && c != ')' && c != ']') {
                brackets.push(c);
            } else {
                if (brackets.size() == 0) {
                    return false;
                }
                char pre = brackets.lastElement();
                switch (c) {
                    case '}':
                        if (pre == '{')
                            brackets.pop();
                        else
                            return false;

                        break;
                    case ')':
                        if (pre == '(')
                            brackets.pop();
                        else
                            return false;

                        break;
                    case ']':
                        if (pre == '[')
                            brackets.pop();
                        else
                            return false;

                        break;
                }


            }

        }
        return brackets.size() == 0 ? true : false;
    }

}
