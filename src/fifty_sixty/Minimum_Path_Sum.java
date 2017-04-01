package fifty_sixty;

/**
 * Created by iceke on 17/3/31.
 */
public class Minimum_Path_Sum {
    public static void main(String args[]){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));

    }
    public static int minPathSum(int[][] grid) {
        int hangs = grid.length;
        int rows = grid[0].length;
        int value[][] =new int[hangs][rows];
        value[0][0] = grid[0][0];
        for(int i = 1;i<rows;i++){
            value[0][i] = value[0][i-1]+grid[0][i];
        }

        for(int j = 1;j<hangs;j++){
            value[j][0] =value[j-1][0]+ grid[j][0];
        }
        for(int i = 1;i<hangs;i++){
            for(int j = 1;j<rows;j++){
                value[i][j] = Math.min(value[i-1][j],value[i][j-1])+grid[i][j];
            }
        }

        return value[hangs-1][rows-1];


    }
}
