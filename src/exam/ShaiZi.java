package exam;

import java.util.*;

/**
 * Created by iceke on 17/3/24.
 */
public class ShaiZi {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        int length = value.length();
        Map<Character,Integer> wayDic = new HashMap<Character,Integer>();
        for(int i =0;i<length;i++){
            char tempChar = value.charAt(i);
            if(wayDic.containsKey(tempChar)){
                int cishu = wayDic.get(tempChar);
                cishu+=1;
                wayDic.put(tempChar,cishu);
            }else{
                wayDic.put(tempChar,1);
            }

        }

        int LNum = 0;
        if(wayDic.containsKey('L')){
            int num  = wayDic.get('L');
            LNum = num%4;
        }

        int RNum = 0;
        if(wayDic.containsKey('R')){
            int num  = wayDic.get('R');
            RNum = num%4;
        }

        int FNum = 0;
        if(wayDic.containsKey('F')){
            int num  = wayDic.get('F');
            FNum = num%4;
        }

        int BNum = 0;
        if(wayDic.containsKey('B')){
            int num  = wayDic.get('B');
            BNum = num%4;
        }

        int ANum = 0;
        if(wayDic.containsKey('A')){
            int num  = wayDic.get('A');
            ANum = num%4;
        }


        int CNum = 0;
        if(wayDic.containsKey('C')){
            int num  = wayDic.get('C');
            CNum = num%4;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<LNum;i++){
            sb.append('L');
        }
        for(int i = 0;i<RNum;i++){
            sb.append('R');
        }
        for(int i = 0;i<FNum;i++){
            sb.append('F');
        }
        for(int i = 0;i<BNum;i++){
            sb.append('B');
        }
        for(int i = 0;i<ANum;i++){
            sb.append('A');
        }
        for(int i = 0;i<CNum;i++){
            sb.append('C');
        }

        String finalValue = sb.toString();


        String result = "123456";

        for(int i = 0;i<finalValue.length();i++){
            char temp = finalValue.charAt(i);
            result = changeXulie(result,temp+"");
        }

        System.out.println(result);



    }

    public  char getFanWay(char a){
        if(a== 'L'){
            return 'R';
        }else if(a == 'R'){
            return 'L';
        }else if(a == 'F'){
            return 'B';
        }else if(a == 'B' ){
            return 'F';
        }else if(a == 'A'){
            return 'C';
        }else if(a == 'C'){
            return 'C';
        }else{
            return ' ';
        }
    }

    public static String changeXulie(String init,String way){
        char[] result = new char[6];
        //左1右2前3后4上5下6
        if(way.equals("L")){
            //左
            result[0] = init.charAt(4);
            result[1] = init.charAt(5);
            result[2] = init.charAt(2);
            result[3] = init.charAt(3);
            result[4] = init.charAt(1);
            result[5] = init.charAt(0);
        }else if(way.equals("R")){
            //右
            result[0] = init.charAt(5);
            result[1] = init.charAt(4);
            result[2] = init.charAt(2);
            result[3] = init.charAt(3);
            result[4] = init.charAt(0);
            result[5] = init.charAt(1);

        }else if(way.equals("F")){
            //前
            result[0] = init.charAt(0);
            result[1] = init.charAt(1);
            result[2] = init.charAt(4);
            result[3] = init.charAt(5);
            result[4] = init.charAt(3);
            result[5] = init.charAt(2);


        }else if(way.equals("B")){
            //后
            result[0] = init.charAt(0);
            result[1] = init.charAt(1);
            result[2] = init.charAt(5);
            result[3] = init.charAt(4);
            result[4] = init.charAt(2);
            result[5] = init.charAt(3);

        }else if(way.equals("A")){
            //逆
            result[0] = init.charAt(3);
            result[1] = init.charAt(2);
            result[2] = init.charAt(0);
            result[3] = init.charAt(1);
            result[4] = init.charAt(4);
            result[5] = init.charAt(5);

        }else if(way.equals("C")){
            //顺
            result[0] = init.charAt(2);
            result[1] = init.charAt(3);
            result[2] = init.charAt(1);
            result[3] = init.charAt(0);
            result[4] = init.charAt(4);
            result[5] = init.charAt(5);
        }

        StringBuilder sb = new StringBuilder();
        for(char a :result){
            sb.append(a);
        }

        return sb.toString();
    }
}
