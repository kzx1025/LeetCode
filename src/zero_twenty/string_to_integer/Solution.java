package zero_twenty.string_to_integer;

/**
 * Created by iceke on 15/11/3.
 */
public class Solution {
    public static int myAtoi(String str) {
        int flag = 0;
        char[] strChar = str.toCharArray();
        int length = str.length();
        if(length == 0){
            return  0;
        }
        int result = 0;
        int i = 0;
        while(strChar[i] == ' '){
            i++;
        }
        if(strChar[i] == '-'){
            flag = 1;
            i++;
        } else if(strChar[i] == '+'){
            flag = 0;
            i++;
        }
        while(i<length){
            if('0'<=strChar[i]&&strChar[i]<='9'){
                if(result>(2147483647-(strChar[i]-48))/10){
                    return flag == 0?2147483647:-2147483648;
                }
                result=result*10+strChar[i]-48;
            }else{
                break;
            }
            i++;

        }
        return flag == 0?result:0-result;

    }

    public static void main(String args[]){
        int a = myAtoi("      -11919730356x");
        System.out.println(a);
    }
}
