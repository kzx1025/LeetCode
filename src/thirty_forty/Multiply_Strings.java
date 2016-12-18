package thirty_forty;

import java.util.Arrays;

/**
 * Created by iceke on 16/12/16.
 */
public class Multiply_Strings {
    public static void main(String args[]){
        System.out.println(multiply("1","1"));
        System.out.println(999*6389);

    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }

        int[] results = new int[num1.length()+num2.length()+1];
        for(int i =num1.length()-1;i>=0;i--){
            for(int j =num2.length()-1;j>=0;j--){
                char temp2 = num2.charAt(j);
                char temp1 = num1.charAt(i);
                int tempValue = (temp2-'0')*(temp1-'0');
                int gewei = tempValue%10;
                int shiwei = tempValue/10;

                int geIndex = num1.length()-1-i+num2.length()-1-j;
                int geValue = results[geIndex] + gewei;
                if(geValue>=10){
                    results[geIndex] = geValue%10;
                    results[geIndex+1] += geValue/10;
                }else{
                    results[geIndex]=geValue;
                }

                int shiIndex = num1.length()-1-i+num2.length()-1-j+1;
                int shiValue = results[shiIndex] + shiwei;
                if(shiValue>=10){
                    results[shiIndex] = shiValue%10;
                    results[shiIndex+1] += shiValue/10;

                }else{
                    results[shiIndex] = shiValue;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        boolean noZero = false;
        for(int i = results.length-1;i>=0;i--){
            int value =results[i];
            if(value != 0){
                noZero = true;
            }
            if(noZero) {
                sb.append(results[i]);
            }
        }

        //System.out.println(Arrays.toString(results));
        return sb.toString();

    }
}
