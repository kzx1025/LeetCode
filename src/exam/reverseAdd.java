package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by iceke on 17/3/24.
 */
public class reverseAdd {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        String[] values = value.split(",");
        int a = Integer.parseInt(values[0]);
        int b = Integer.parseInt(values[1]);

        if((a<1||a>7000)||(b<1||b>7000)){
            System.out.println(-1);
        }

        reverseAdd reverseAdd = new reverseAdd();

        int result = reverseAdd.reverseAdd(a,b);
        System.out.println(result);



    }

    public int reverseAdd(int a,int b){
        int newA = 0;
        int newB = 0;
        while(a>0){
            int temp = a%10;
            newA = newA*10+temp;
            a = a/10;
        }

        while(b>0){
            int temp = b%10;
            newB = newB*10+temp;
            b = b/10;
        }

        return newA+newB;


    }
}
