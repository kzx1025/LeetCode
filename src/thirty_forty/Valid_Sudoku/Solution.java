package thirty_forty.Valid_Sudoku;

/**
 * Created by iceke on 16/12/13.
 */
public class Solution {
    public static void main(String args[]){
        char[][] board = {{'.','.','3'},{'.','1','.'},{'.','2','.'}};
        //System.out.println(isValidSudoku(board));
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                int x = i/3;
                int y = j/3;
                int chunk = x*3+y;
                System.out.println(chunk);

            }
        }

    }
    public static boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int[][] dic3 = new int[rows][rows];
        for(int i = 0;i<rows;i++){
            int[] dic1 = new int[rows];
            int[] dic2 = new int[rows];
            for(int j = 0;j<rows;j++){
                //行
                char value1 = board[i][j];
                if(value1 != '.'){
                    int num = value1- '0' -1;
                    if(dic1[num] == 0){
                        dic1[num] =1;
                    }else{
                        return false;
                    }

                }
                //列
                char value2 = board[j][i];
                if(value2 != '.'){
                    int num = value2- '0' -1;
                    if(dic2[num] == 0){
                        dic2[num] =1;
                    }else{
                        return false;
                    }
                }

                //块
                int x = i/3;
                int y = j/3;
                int chunk = x<<2+y;

                if(value1 !='.'){
                    int num = value1- '0' -1;
                    if(dic3[chunk][num] == 0){
                        dic3[chunk][num] =1;
                    }else{
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
