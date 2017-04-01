package fifty_sixty;

import java.util.Arrays;

/**
 * 有障碍的动态规划
 * Created by iceke on 17/3/31.
 */
public class UniquePath2 {
    public static void main(String args[]) {
        int[][] grid = {{0, 1}};
        System.out.println(uniquePathsWithObstacles(grid));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] place = new int[m][n];
        place[0][0] = obstacleGrid[0][0]==1?0:1;

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                place[i][0] = 0;
            } else {
                place[i][0] = place[i-1][0];
            }
        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                place[0][j] = 0;
            } else {
                place[0][j] = place[0][j-1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    place[i][j] = 0;
                } else {
                    place[i][j] = place[i - 1][j] + place[i][j - 1];
                }
            }
        }

        return place[m - 1][n - 1];

    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int hang = obstacleGrid.length;
        int rows = obstacleGrid[0].length;
        int place[] = new int[rows];
        for(int i = 0;i<rows;i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }else {
                place[i] = 1;
            }
        }


        for(int i = 1;i<hang;i++){
            for(int j = 0;j<rows;j++){
                if(obstacleGrid[i][j] == 1){
                    place[j] = 0;
                }else{
                    if(j>0){
                        place[j]+=place[j-1];
                    }
                }
            }
        }

        return place[rows-1];

    }
}
