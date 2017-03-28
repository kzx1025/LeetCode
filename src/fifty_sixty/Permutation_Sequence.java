package fifty_sixty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iceke on 17/3/27.
 */
public class Permutation_Sequence {

    public static void main(String args[]){
        int n = 4;
        for(int i =1 ;i<= 24;i++) {
            System.out.println(getPermutation(n, i));
        }

    }

    public static String getPermutation(int n, int k) {


        StringBuilder sb = new StringBuilder();
        int possibles = 1;
        List<Character> data = new ArrayList<Character>();
        for(int i = 1;i<=n;i++){
            data.add((char)(i+48));
        }

        for(int i =1;i<=n;i++){
            possibles*=i;
        }


        int totalLength = n;
        int index =0;
        while(sb.length()<totalLength){
             int ceng = possibles/n;
            index = (k-1) / ceng;
            sb.append(data.get(index));
            data.remove(index);
            possibles = ceng;
            n=n-1;
            k-=(index*(possibles));
        }

        return sb.toString();

    }

    public static void permutation(char[] a, int floor, List<String> list, int k){
        if(floor == a.length-1){
            StringBuilder sb = new StringBuilder();
            for(char c:a){
                sb.append(c);
            }
            System.out.println(sb.toString());

            list.add(sb.toString());

        }else{
            for(int i = floor;i<a.length;i++){
                swap(a,i,floor);
                 permutation(a,floor+1,list,k);
                swap(a,i,floor);
            }
        }

    }

    public static void swap(char[] a,int start,int end){
        char temp = a[start];
        a[start] = a[end];
        a[end] = temp;

    }
}
