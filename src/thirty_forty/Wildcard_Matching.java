package thirty_forty;

/**
 * Created by iceke on 16/12/17.
 * https://segmentfault.com/a/1190000003786247
 */
public class Wildcard_Matching {
    public static void main(String args[]){



    }

    public static boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        int j =0;
        int starIndex = -1;
        int starPointer = 0;
        for(int i =0;i<sLength;){
            if(j<pLength&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='?')){
                i++;
                j++;
            }else if(j<pLength&&p.charAt(j) == '*'){
                starIndex = j;
                j++;
                starPointer = i;

            }else if(starIndex != -1){
                j = starIndex+1;
                starPointer++;
                i = starPointer;
            }else{
                return false;
            }

        }

        while(j<pLength&&p.charAt(j)=='*'){
            j++;
        }

        return j==pLength;

    }
}
