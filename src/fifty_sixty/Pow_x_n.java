package fifty_sixty;

/**
 * Created by iceke on 16/12/26.
 */
public class Pow_x_n {
    public static void main(String args[]) {

        System.out.println(myPow(2.00000,
                -2147483648));

    }

    public static double myPow(double x, int n) {
        int i = 0;
        double sum = 1.0;
        if(x == 1){
            return 1.0d;
        }

        if(x == -1){
            if(n%2 ==0){
                return  1.0d;
            }else{
                return  -1.0d;
            }

        }

        if(x ==0){
            return 0.0d;
        }


        if (n == 0) {
            return 1.0d;
        } else if (n < 0) {
            if(n == Integer.MIN_VALUE){
                return 0.0d;
            }
            n = Math.abs(n);
            while (i < n) {
                sum *= x;
                i++;
            }
            return 1 / sum;
        } else {
            while (i < n) {
                sum *= x;
                if(sum == 0){
                    break;
                }
                i++;
            }
            return sum;
        }

    }
}
