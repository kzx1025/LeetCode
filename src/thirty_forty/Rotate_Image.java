package thirty_forty;

import java.util.Arrays;

/**
 * Created by iceke on 16/12/26.
 */
public class Rotate_Image {
    public static void main(String args[]){
        int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(a);
        System.out.println(a);

    }

    //注意界限
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i =0;i<length/2;i++){
            for(int j = 0 ;j<length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-i-1][j];
                matrix[length-i-1][j] = temp;
            }
        }

        for(int i =0;i<length;i++){
            for(int j = 0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


    }
}
