package exam;

/**
 * Created by iceke on 16/9/11.
 */
public class Boli {

    public static void main(String args[]){
        int d = 100;
        int e= 2;
        int f[][]=new int[101][];
        int i,j,k;
        for(i=0;i<=d;i++)
            f[i]=new int[e+1];
        for(i=0;i<=d;i++)
            f[i][1]=i;
        for(i=0;i<=e;i++)
            f[0][e]=0;
        for(i=1;i<=e;i++)
        {
            for(j=1;j<=d;j++)
            {
                int tmp;
                int min_test=0x7FFFFFFF;
                for(k=1;k<=j;k++)
                {
                    tmp=f[j-k][i]+1>f[k-1][i-1]+1?f[j-k][i]+1:f[k-1][i-1]+1;
                    if(tmp>min_test)
                        min_test=tmp;
                }
                f[j][i]=min_test;
            }
        }
      System.out.println(f[d][e]);
    }

}
