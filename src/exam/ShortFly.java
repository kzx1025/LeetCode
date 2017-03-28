package exam;

import java.util.*;

/**
 * Created by iceke on 17/3/24.
 */
public class ShortFly {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int startCity = sc.nextInt();
        int fogCity = sc.nextInt();



        int G[][] = {{0 ,0 , 0 , 0 , 0, 0,0},
            {0,0, 2,10,5,3,1000},
            {0,1000, 0,12 ,1000,1000,10},
            {0,1000,1000,0,1000,7,1000},
            {0,2,1000,1000,0,2,1000},
            {0,4,1000,1000,1,0,1000},
            {0,3,1000,1,1000,2,0}
        }  ;

        int INF = 1000;


        int[] pre = new int[10];

        dij(pre,G,startCity,fogCity);




    }


    public static void dij(int[] pre,int[][] G,int x ,int y){
        int t =x;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(5)  ;
        int[] dist = new int[10];
        for(int i= 1 ; i <=6 ;i++) dist[i] = 1000 ;
        dist[5] = 0 ;
        while (q.size()!=0) {
            int u = q.poll() ; //q.pop() ;
            for (int i = 1 ; i <= 6 ; i++) {
                if(i != 5 && i!=y && G[u][i] + dist[u] < dist[i]){
                    dist[i] = G[u][i] + dist[u] ;
                    pre[i] = u ;
                    q.offer(i) ;
                }
            }
        }
        System.out.println(dist[x] >= 1000 ?1000:dist[x]) ;
        if(dist[x]>=1000) System.out.println("[]") ;
        else{
            List<Integer> path = new ArrayList<Integer>();
            while (x != 5) {
                path.add(pre[x]) ;
                x =pre[x]  ;
            }
            System.out.print("[5,") ;
            for(int i = path.size() - 2 ;i >=0 ; i--){
                System.out.print(path.get(i)+",") ;

            }
           System.out.println(t+"]") ;
        }
    }

}
