package fifty_sixty;

/**
 * Created by iceke on 17/4/1.
 */
public class PlusOne {
    public static void main(String args[]){

    }
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for(int i = length-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }else{
                digits[i]=0;
            }
        }

        int[] result = new int[length+1];
        result[0] = 1;
        return result;


    }
}
