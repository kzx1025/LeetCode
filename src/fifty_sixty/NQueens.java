package fifty_sixty;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by iceke on 17/3/11.
 */
public class NQueens {
    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        if(n<=0)
            return res;

        int [] columnVal = new int[n];

        DFS_helper(n,res,0,columnVal);
        return res;
    }

    public static void DFS_helper(int nQueens, ArrayList<String[]> res, int row, int[] columnVal){
        if(row == nQueens){
            String[] unit = new String[nQueens];
            for(int i = 0; i < nQueens; i++){
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < nQueens; j++){
                    if(j == columnVal[i])
                        s.append("Q");
                    else
                        s.append(".");
                }

                unit[i] = s.toString();
            }

            res.add(unit);
        }else{
            for(int i = 0; i < nQueens; i++){
                columnVal[row] = i;//(row,columnVal[row)==>(row,i)

                if(isValid(row,columnVal))
                    DFS_helper(nQueens, res, row+1, columnVal);
            }
        }
    }

    public static boolean isValid(int row, int [] columnVal){
        for(int i = 0; i < row; i++){
            if(columnVal[row] == columnVal[i]
                    ||Math.abs(columnVal[row]-columnVal[i]) == row-i)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {

        ArrayList<String[]> results = solveNQueens(8);
        for(String[] result: results){
            System.out.println(Arrays.deepToString(result));

        }


    }

}
