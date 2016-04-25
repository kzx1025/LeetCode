package twenty_thirty.valid_parentheses;

import java.util.Stack;

/**
 * Created by iceke on 16/4/22.
 */
public class Solution {
    public static void main(String args[]){
        if(isValid("]")){
            System.out.println("success");
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> brackets = new Stack<Character>();
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(c!='}'&&c!=')'&&c!=']'){
                brackets.push(c);
            }else{
                if(brackets.size()==0){
                    return false;
                }
                char pre = brackets.lastElement();
                switch (c){
                    case '}':
                        if(pre == '{')
                            brackets.pop();
                        else
                            return false;

                        break;
                    case ')':
                        if(pre == '(')
                            brackets.pop();
                        else
                            return false;

                        break;
                    case ']':
                        if(pre == '[')
                            brackets.pop();
                        else
                            return false;

                        break;
                }


            }

        }
       return brackets.size()==0?true:false;
    }
}
