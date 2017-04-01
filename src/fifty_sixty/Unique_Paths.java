package fifty_sixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iceke on 17/3/28.
 */
public class Unique_Paths {

    public static void main(String args[]){
        System.out.println(uniquePaths(4,3));

    }

    public static int uniquePaths(int m, int n) {
        int[][] place = new int[m][n];
        for(int i = 0;i<m;i++){
            place[i][0] = 1;
        }
        for(int i = 0;i<n;i++){
            place[0][i] = 1;
        }

        for(int i =1;i<m;i++){
            for(int j = 1;j<n;j++){
                place[i][j] = place[i-1][j]+place[i][j-1];
            }
        }
        return place[m-1][n-1];
    }
    public static int uniquePaths2(int m, int n) {
        int[] place = new int[n];

        for(int i = 0;i<n;i++){
            place[i] = 1;
        }

        for(int i =1;i<m;i++){
            for(int j = 1;j<n;j++){
                place[j] += place[j-1];
            }
        }
        return place[n-1];
    }


    /**time exceed

    public static int uniquePaths(int m, int n) {
        return tryStep(m,n);

    }

    public static int tryStep(int m,int n){
        if( m == 1 || n==1){
            return 1;
        }else{
            return tryStep(m-1,n)+tryStep(m,n-1);
        }


    }
**/

}
