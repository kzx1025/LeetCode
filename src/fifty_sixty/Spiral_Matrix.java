package fifty_sixty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iceke on 17/1/9.
 */
public class Spiral_Matrix {

    public static void main(String ags[]) {
        int[][] matrix = new int[][]{
               // {1}, {3}, {2}
                   {1, 2, 3,4},
                   { 5, 6, 7,8},

                 { 13,14,15,16 }
               // {111,111,111,111}
        };

        int[][] a = new int[][]{};

        System.out.println(spiralOrder(a));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m==0){
            return new ArrayList<Integer>();
        }
        int n = matrix[0].length;
        int total = m * n;
        List<Integer> results = new ArrayList<Integer>();

        for (int iStart = 0, jStart =0; iStart < m / 2 + 1 && jStart < n / 2 + 1; iStart++) {
           /** if (jStart >= n / 2 + 1) {
                break;
            }**/
            for (int j = jStart; j < n - jStart; j++) {
                if (results.size() < total) {
                    System.out.println(matrix[iStart][j]);
                    results.add(matrix[iStart][j]);
                }
            }
            for (int i = iStart + 1; i < m - iStart; i++) {
                if (results.size() < total) {
                    System.out.println(matrix[i][n - jStart - 1]);
                    results.add(matrix[i][n - jStart - 1]);
                }
            }
            for (int j = jStart + 1; j < n - jStart; j++) {
                if (results.size() < total) {
                    System.out.println(matrix[m - iStart - 1][n - j - 1]);
                    results.add(matrix[m - iStart - 1][n - j - 1]);
                }
            }

            for (int i = iStart + 1; i < m - iStart - 1; i++) {
                if (results.size() < total) {
                    System.out.println(matrix[m - i - 1][jStart]);
                    results.add(matrix[m - i - 1][jStart]);
                }

            }
            jStart += 1;
        }
        return results;

    }
}
