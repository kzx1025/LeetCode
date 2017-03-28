package fifty_sixty;

import java.util.Stack;

/**
 * Created by iceke on 17/3/26.
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        if(s == null||s.length() == 0){
            return 0;
        }

        int length = s.length();

        StringBuilder sb = new StringBuilder();
        int result = 0;

        boolean hasC = false;
        for(int i = length-1;i>=0;i--){
            if(s.charAt(i) == ' '){
                if(hasC) {
                    break;
                }
            }else{
                hasC = true;
                result++;
            }

        }



        return result;

    }
    public static void main(String args[]){
        System.out.println(lengthOfLastWord("world "));

    }
}
