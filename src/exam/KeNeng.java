package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by iceke on 17/3/11.
 */
public class KeNeng {

    int baiNum = 0;
    int shiNum = 0;
    int geNum = 0;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String[]> tests = new ArrayList<String[]>();

        for(int i=0;i<n;i++){
            String[] test = new String[3];
            for(int j =0;j<3;j++){
                test[j] = sc.next();
            }
            tests.add(test);
        }

        KeNeng keNeng = new KeNeng();


        for(String[] test:tests){
            System.out.println(keNeng.getPossibility(test));
        }
    }

    public  int getPossibility(String[] test){

        String jia = test[0];
        String beijia = test[1];
        int target = Integer.parseInt(test[2]);

         baiNum = 0;
         shiNum = 0;
         geNum = 0;


        int yJia = 0;

        for(int i =0;i<jia.length();i++){
            char temp = jia.charAt(i);
            if(temp == 'X'){
                if(jia.length()-i == 3){
                    baiNum+=1;
                }else if(jia.length()-i == 2){
                    shiNum+=1;
                }else{
                    geNum+=1;
                }

            }else{
                yJia += Math.pow(10,jia.length()-i-1)*(temp-'0');
            }

        }

        int yBeiJia = 0;


        for(int i =0;i<beijia.length();i++){
            char temp = beijia.charAt(i);
            if(temp == 'X'){
                if(beijia.length()-i == 3){
                    baiNum+=1;
                }else if(beijia.length()-i == 2){
                    shiNum+=1;
                }else{
                    geNum+=1;
                }

            }else{
                yBeiJia += Math.pow(10,beijia.length()-i-1)*(temp-'0');
            }

        }

        /**
        System.out.println(baiNum);
        System.out.println(shiNum);
        System.out.println(geNum);

        System.out.println(yJia);
        System.out.println(yBeiJia);
         **/

        int finalTarget = target- yJia - yBeiJia;
        int sum = 0;
        int result = 0;


        int finalQian = finalTarget/1000;
        int finalBai = (finalTarget-finalQian*1000)/100;
        int finalShi = (finalTarget-finalQian*1000-finalBai*100)/10;
        int finalGe = (finalTarget-finalQian*1000-finalBai*100-finalShi*10);

        if(finalQian >= 2){
            return 0;
        }

        int geSum = 0;
        int a1 = 0;
        int b1 = 0;


        if(geNum == 2){
            for(int i = 1;i<=9;i++){
                for(int j =1;j<=9;j++){
                    if(i+j == finalGe){
                        a1+=1;
                    }else if(i + j == 10+finalGe ){
                        b1 +=1;

                    }
                }
            }
        }else{
            a1=1;
            b1 =1;
        }


        int a2 = 0;
        int b2 = 0;
        int c2 =0;
        int d2 =0;

        if(shiNum == 2){
            for(int i = 1;i<=9;i++){
                for(int j =1;j<=9;j++){
                    if(i+j == finalShi||i+j == finalShi+10){
                        a2+=1;
                    }else if(i+j+1== finalShi||i+j+1 == finalShi+10) {
                        b2 += 1;
                    }
                }
            }
        }else{
            a2=1;
            b2=1;
            c2 =1;
            d2 =1;
        }

        int a3 = 0;
        int b3 =0;
        int c3 = 0;
        if(baiNum == 2){
            for(int i = 1;i<=9;i++){
                for(int j =1;j<=9;j++){
                    if(i+j == finalBai||i+j == finalBai+10){
                        a3+=1;
                    }else if(i+j+1== finalBai||i+j+1 == finalBai+10) {
                        b3 += 1;
                    }
                }
            }
        }else{
            a3=1;
            b3 =1;
            c3=1;
        }


        return a1*a2*a3;

    }






}
