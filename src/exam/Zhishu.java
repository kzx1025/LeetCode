package exam;

import java.util.Scanner;

/**
 * Created by iceke on 16/9/11.
 */
public class Zhishu {
    int[] vis = new int[1005];

    public void findShu(int num){

        for(int i =2;i<=num;i++){
            if(vis[i] ==0 ){
                for(int j = i*i;j<=num;j+=i){
                    vis[j] = 1;
                }
            }
        }

    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Zhishu zhishu = new Zhishu();
        zhishu.findShu(1001);
        int ans = 0;
        for(int i =2;i<=n/2;i++){
            if(zhishu.vis[i]==0&&zhishu.vis[n-i]==0){
                ans ++;

            }
        }


        System.out.println(ans);

    }
}
