package twenty_thirty.divide_two_integers;

/**
 * Created by iceke on 16/12/9.
 */
public class Solution {

    public static void main(String args[]){
        System.out.println(divide(-2147483648,-1));
    }



    public static int divide(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && (divisor == 1 || divisor == -1)){
            return divisor == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        //利用位移公式
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        if(dividend == 0){
            return 0;
        }



        boolean isPositive = dividend>0?(divisor>0):(divisor<0);
        long dividendL = dividend;
        long divisorL = divisor;
        dividendL = Math.abs(dividendL);
        divisorL = Math.abs(divisorL);

        long result = 0;
        long mie = 1;
        long d =divisorL;
        while(dividendL>=d){
            d<<=1;
            mie<<=1;
        }
        d>>=1;
        mie>>=1;
        while(d>=divisorL){
            while(dividendL>=d){
                dividendL-=d;
                result+=mie;
            }
            d>>=1;
            mie>>=1;
        }


        return (int)(isPositive?result:-result);

    }
}
