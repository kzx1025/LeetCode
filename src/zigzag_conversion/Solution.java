package zigzag_conversion;

import java.util.Arrays;

/**
 * Created by iceke on 15/10/23.
 */
public class Solution {

    /**
     * 敢不敢不纯考数学，还是类似矩阵的。。
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        int loop = 2*(numRows - 1);
        int length = s.length();
        if (length == 0 || numRows < 2) return s;
        char[] result = new char[length];
        int count = 0;
        for(int i = 0;i<numRows;i++){
            for(int j =i;j<length;j=j+loop){
                result[count] = s.charAt(j);
                count++;
                if(i!=0&&i!=numRows - 1){
                    int t = j+loop-2*i;
                    if(t<length){
                    result[count] = s.charAt(t);
                    count++;
                    }
                }

            }
        }
        return String.valueOf(result);


    }

    public static void main(String args[]){
        String result = convert("PAYPALISHIRING",3);
        System.out.println(result);
    }
}
