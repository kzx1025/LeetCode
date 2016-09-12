package exam;

import java.util.Scanner;

/**
 * Created by iceke on 16/9/12.
 */
public class DistanceSum {
    long[] vis=new long[10000090];
    // 判断一个数是否是质数
    public void findshu(int num){
        for (int i=2;i<=num;i++){
            if(vis[i]==0){
                for (long j=(long)i*(long)i;j<=num;j+=i){
                    vis[(int)j]=1;
                }
            }
        }
    }

    public long getVis(int i){
        return vis[i];
    }
    public static void main(String[]args){
        DistanceSum zhiShuDis=new DistanceSum();
        zhiShuDis.findshu(10000000);
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int[] result=new int[num];
        int first=scanner.nextInt();
        result[0] = first;
        for (int i=1;i<num;i++){
            int next=scanner.nextInt();
            result[i]=next;
        }
        long[] distances = new long[num];

        for(int i = 0;i<num;i++){
            int distance = 0;
            for(int j = 0;j<result[i];j++){
                if(zhiShuDis.getVis(j) == 0){
                    distance++;
                }
            }
            distances[i] = distance;
        }

        long totalDistance = 0;
        for(int m =0;m<num;m++){
            for(int n = m;n<num;n++){
                totalDistance+=distances[n]-distances[m];
            }
        }

        System.out.println(totalDistance);


    }
}
