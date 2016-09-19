package exam;

/**
 * Created by iceke on 16/8/2.
 */
public class LiMing {

    public static int getResult(int[] position,int[][] value){
        int hang = position[0];
        int lie = position[1];

       // int length = lie/
        return 0;

    }

    public static void main(String args[]){
        int[] position = {2,2};
        int[][] value = {{3,3,3,2},{3,2,3,3},{3,3,3,2},{2,3,2,3}};
        int result = getResult(position,value);
        System.out.println(result);

        int countx = 0;
        int x = 254;
        while(x>0){
            countx++;
            x= x&(x-1);
        }
        System.out.println(x);


        int[] balls = new int[13];
        int num = 12;

        int i =4;

        while(num >0){


            if(balls[i] == 0) {
                balls[i] = 1;
                num -= 1;
                System.out.println(i);
            }
            i=(i+num)%12;

        }





    }
}
