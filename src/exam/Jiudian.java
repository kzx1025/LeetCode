package exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by iceke on 16/9/27.
 */
public class Jiudian {

    public static int cost(int[] prices,int money){

        Arrays.sort(prices);
        int cishu = 0;

        int yue = money;


        int j = prices.length-1;
        for(int i = prices.length-1;i>=0;i--){

            while(true){
                 yue = yue-prices[i];
                cishu++;
                if(yue < 0){
                    cishu --;
                    yue+=prices[i];
                    break;
                }
            }

            if(i == 0 && yue!=0){
                if(j==0){
                    break;
                }
                i = j-1;
                yue = money;
                cishu = 0;
            }
        }



        return cishu == 0?-1:cishu;

    }

    public static void main(String args[]){
        int[] price = {995,4,3};
        int money = 5;
        System.out.println(cost(price,money));

    }
}