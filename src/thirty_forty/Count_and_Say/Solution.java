package thirty_forty.Count_and_Say;

/**
 * Created by iceke on 16/12/13.
 */
public class Solution {
    public static void main(String args[]) {
        System.out.println(countAndSay2(4));

    }

    public static String countAndSay(int n ) {
        if(n == 1){
            return "1";
        }else if(n==2){
            return "11";
        }
       String result = "11";
        n-=2;
        while(n>0){
            result = transform(result);
            n--;
        }
        return result;

    }

    public static String countAndSay2(int n){
        if(n == 1){
            return "1";
        }else if(n==2){
            return "11";
        }else if(n == 3){
            return transform("11");
        }else{
            return transform(countAndSay2(n-1));
        }

    }

    public static String transform(String b) {
        StringBuilder sb = new StringBuilder();
        char prevChar = b.charAt(0);
        char curChar;
        int sameLength = 1;

        for (int i = 1; i < b.length(); i++) {
            curChar = b.charAt(i);
            if (curChar == prevChar) {
                sameLength++;
            } else {

                sb.append(sameLength);
                sb.append(prevChar);
                sameLength = 1;

                prevChar = curChar;

            }
            if(i == b.length()-1){
                sb.append(sameLength);
                sb.append(curChar);

            }
        }

        return sb.toString();
    }
}
