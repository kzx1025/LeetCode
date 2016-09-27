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


        for(int i = prices.length-1;i>=0;i--){

            while(true){
                 money = money-prices[i];
                cishu++;
                if(money < 0){
                    cishu --;
                    money+=prices[i];
                    break;
                }


            }
        }

        return cishu == 0?-1:cishu;

    }

    public static void main(String args[]){
        int[] price = {300,700,1000};
        int money = 1000;
        System.out.println(cost(price,money));

    }
}