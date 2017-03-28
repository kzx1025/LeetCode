package exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by iceke on 17/3/25.
 */
public class Zhi {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        Set<Integer> zhiSet = new HashSet<Integer>();

        for(int i = 2;i<=1000;i++){
            if(isZhi(i)){
                zhiSet.add(i);
            }

        }

        int result = 0;
        for(int value:zhiSet){
            if(value<sum&&(zhiSet.contains(sum-value))){
                result++;
            }
        }

        if((float)result/2-(int)(result/2)==0){
            System.out.println( result/2);
        }else{
            System.out.println( result/2+1);
        }



    }

    public static boolean isZhi(int num){
        for(int i =2;i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
