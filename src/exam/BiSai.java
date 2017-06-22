package exam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iceke on 17/4/26.
 */
public class BiSai {

    public static void main(String args[]){
        List<Integer> zhishu = new ArrayList<Integer>();
        for(int i = 2;i<=50000;i++){
            if(isZhi(i)){
                zhishu.add(i);
            }

        }

        //System.out.println(meetTest(6,zhishu));


    }

    public static boolean isZhi(int num){
        for(int i =2;i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }


    public static int zhiNum(int num,List<Integer> zhishu){
        int n = num, i, k = 0;
        for(i=0;i<zhishu.size();i++) {
            int temp = zhishu.get(i);
            if(temp>n){
                break;
            }
            while (n != i) {
                if (n % temp == 0) {
                    ++k;
                    n = n / temp;
                } else
                    break;
            }
        }
        return k;
    }
}
