package exam;

/**
 * Created by iceke on 16/9/12.
 */
public class AnHei {

    public static long getNumber(long sameValue,long noSameValue,int length){

        if(length == 3){
            return sameValue+noSameValue;
        }else{
            return getNumber(sameValue+noSameValue,2*sameValue+noSameValue,length-1);
        }

    }

    public static void main(String args[]){

        int num =4;
        if(num == 1){
            System.out.println(3);
        }else if(num ==2){
            System.out.println(9);
        }else {
            System.out.println(getNumber(9, 12, num));
        }


    }
}
