package fifty_sixty;

import java.util.Stack;

/**
 * Created by iceke on 17/4/1.
 */
public class Add_Binary {
    public static void main(String args[]){
        System.out.println(addBinary("001","0"));

    }
    public static String addBinary(String a, String b) {
        Stack<Integer> stack = new Stack<Integer>();
        int aLength = a.length();
        int bLength = b.length();
        int remainValue = 0;
        for(int i = aLength-1,j=bLength-1;i>=0&&j>=0;i--,j--){
            int temp = 0;
            int tempA = a.charAt(i)-48;
            int tempB = b.charAt(j) - 48;
            int sum = tempA+tempB+remainValue;
            if(sum == 2){
                temp=0;
                remainValue=1;
            }else if(sum ==1){
                temp=1;
                remainValue=0;

            }else if(sum == 3){
                temp =1;
                remainValue=1;
            }else{
                temp = 0;
                remainValue = 0;
            }
            stack.push(temp);

        }

        if(aLength>bLength){
            for(int i = a.length()-b.length()-1;i>=0;i--){
                int temp = 0;
                int tempA = a.charAt(i)-48;
                int sum = tempA+remainValue;
                if(sum == 2){
                    temp =0;
                    remainValue = 1;
                }else if(sum ==1){
                    temp =1;
                    remainValue = 0;
                }else{
                    temp = 0;
                    remainValue = 0;
                }
                stack.push(temp);
            }
        }else{
            for(int i = b.length()-a.length()-1;i>=0;i--){
                int temp = 0;
                int tempB = b.charAt(i)-48;
                int sum = tempB+remainValue;
                if(sum == 2){
                    temp =0;
                    remainValue = 1;
                }else if(sum ==1){
                    temp =1;
                    remainValue = 0;
                }else{
                    temp = 0;
                    remainValue = 0;
                }
                stack.push(temp);
            }

        }
        stack.push(remainValue);

        StringBuilder sb = new StringBuilder();
        int sLength = stack.size();
        boolean startNoZero = false;
        for(int i=0;i<sLength;i++){
            int temp = stack.pop();
            if(temp != 0||startNoZero){
                sb.append(temp);
                startNoZero = true;
            }

        }


        return sb.length()==0?"0":sb.toString();


    }
}
