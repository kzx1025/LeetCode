package reverse_integer;

/**
 * Created by iceke on 15/11/3.
 */
public class Solution {
    public static int reverse(int x) {
        int initNum = x;
        if(x == 0){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        while(x != 0){
            int temp = Math.abs(x%10);
            sb.append(temp);
            x/=10;
        }
        try {
            return initNum >= 0 ? Integer.parseInt(sb.toString()) : 0 - Integer.parseInt(sb.toString());
        }catch(Exception e){
            return 0;
        }

    }



    public static void main(String args[]){

        System.out.println(reverse(1534236469));

    }
}
