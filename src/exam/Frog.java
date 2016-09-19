package exam;

import java.util.Scanner;

/**
 * Created by iceke on 16/9/18.
 */
public class Frog {

    class TraversedNode{
        public int x;
        public int y;
        public TraversedNode nextNode;
    }

    static int bestp;
    static int bestx;
    static int besty;





    public static void visit(int x, int y, int cost, int n ,int m,int[][] mat,int curp,int[][] stat,int[][] prex,
                             int curx,int[][] prey,int cury) {
        if ((x) >= 0 && (x) <= n && (y) >= 0 && (y) <= m-1 && mat[x][y] == 1){
            int newp = curp - cost;
            if (newp > stat[x][y]) {
                stat[x][y] = newp;
                prex[x][y] = curx;
                prey[x][y] = cury;
                if (newp > bestp) {bestp = newp; bestx = x; besty = y;}
            }
        }
    }

    public static void main(String args[]){
        int[][] grid = new int[8][8];
        grid[0][0]=1; grid[0][1]=0; grid[0][2]=0; grid[0][3]=1;

        grid[1][0]=1; grid[1][1]=1; grid[1][2]=0; grid[1][3]=1;

        grid[2][0]=0; grid[2][1]=1; grid[2][2]=1; grid[2][3]=1;

        grid[3][0]=0; grid[3][1]=0; grid[3][2]=1; grid[3][3]=1;

        int n = 4, m = 4, p = 10;

        int mat[][] = new int[n][m];
        int stat[][] = new int[n][m];
        int prex[][] = new int[n][m];
        int prey[][] = new int[n][m];
        for (int i = 0; i < n; ++i) {
            Scanner scanner = new Scanner(System.in);
            for (int k = 0; k < m; ++k) {

                mat[i][k] = scanner.nextInt();
                prex[i][k] = i;
                prey[i][k] = k;
                stat[i][k] = -1;
            }
        }

        stat[0][0] = p;
        int curp = p, curx = 0, cury = 0;
        while (curp > 0 && (curx != 0 || cury != m-1)) {
             bestp = 0;
            bestx = 0;
            besty = 0;
            visit(curx - 1, cury, 1,n ,m, mat,curp, stat,prex,
             curx,prey,cury);
            visit(curx + 1, cury, 1,n ,m, mat,curp, stat,prex,
                    curx,prey,cury);
            visit(curx, cury + 1, 0,n ,m, mat,curp, stat,prex,
                    curx,prey,cury);
            visit(curx, cury - 1, 3,n ,m, mat,curp, stat,prex,
                    curx,prey,cury);
            curp = bestp;
            curx = bestx;
            cury = besty;
        }
        if (stat[0][m-1] >= 0) {
            int sx[] = new int[m*n];
            int sy[]= new int[m*n];
            int sp = 0;
            int x = 0, y = m-1;
            while (x != 0 || y != 0) {
                sx[sp] = x;
                sy[sp] = y;
                sp++;
                int xx = prex[x][y];
                int yy = prey[x][y];
                x = xx;
                y = yy;
            }
            System.out.print("[0,0]");
            while (sp > 0) {
                sp--;
                x = sx[sp];
                y = sy[sp];
               System.out.print( ",[" + x + "," + y + "]");
            }
            System.out.println();
        } else {
            System.out.print( "Can not escape!" );
        }

    }
}
