package exam;

/**
 * Created by iceke on 16/9/13.
 * 老鼠 奶酪 迷宫问题
 */
public class MiGong {

    class TraversedNode{
        public int x;
        public int y;
        public TraversedNode nextNode;
    }

    class Node{
        public int x;
        public int y;
    }

    public int isPath(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;//n行m列
        if (grid[0][0] == 0) return 0;
        if (grid[0][0] == 9) return 1;
        int step = 0;//最短搜索步数
        boolean flag_down_success = true;//下方点非零标志位
        boolean flag_up_success = true;
        boolean flag_left_success = true;
        boolean flag_right_success = true;

        TraversedNode p = null;
        TraversedNode pCheck = null;
        TraversedNode head = null;
        TraversedNode traversedNode = new TraversedNode();

        head = traversedNode;
        p = traversedNode;
        p.nextNode = null;

        int count_node = 0;//同一层节点计数器，更新一次加1，初始值为0
        int num_node = 1;//同一层节点总数量，第一层节点数为1，故初始化count为1

        Node[] node = new Node[n + m];//当前层的所有非零点放在node[]结构体数组中，可证明数组长度不会超过m+n

        for(int q = 0;q<n+m;q++){
            node[q] = new Node();
        }
        Node[] nodeNext = new Node[n + m];//下一层的所有非零点放在node_next[]结构体数组中
        for(int q = 0;q<n+m;q++){
            nodeNext[q] = new Node();
        }
        node[0].x = 0;
        node[0].y = 0;

        while (true) {
            for (int i = 0; i < num_node; i++) {
                if (node[i].x + 1 <= m - 1)//向下搜索子节点
                {
                    if (grid[node[i].x + 1][node[i].y] != 0) {
                        if (grid[node[i].x + 1][node[i].y] == 9)//搜索至终点的条件
                        {
                            step++;
                            System.out.println("最短" + step + "步到达终点");
                            return 1;
                        }
                        pCheck = head;
                        while (pCheck != null)//查询该点是否已经被遍历
                        {
                            if ((pCheck.x == node[i].x + 1) && (pCheck.y == node[i].y)) {
                                pCheck = null;
                                flag_down_success = false;
                            } else {
                                pCheck = pCheck.nextNode;
                            }
                        }
                        if (flag_down_success)//如果是新点，将该点放入已遍历链表，并将该点位置放入下一层即node_next[k]中用于下个周期的搜索
                        {
                            traversedNode = new TraversedNode();
                            traversedNode.x = node[i].x + 1;
                            traversedNode.y = node[i].y;
                            p.nextNode = traversedNode;
                            p = traversedNode;
                            p.nextNode = null;

                            nodeNext[count_node].x = node[i].x + 1;
                            nodeNext[count_node].y = node[i].y;
                            count_node++;
                        }
                        flag_down_success = true;
                    }
                }

                if (node[i].x - 1 >= 0)//向上搜索子节点
                {
                    if (grid[node[i].x - 1][node[i].y] != 0) {
                        if (grid[node[i].x - 1][node[i].y] == 9) {
                            step++;
                            System.out.println("最短" + step + "步到达终点");
                            return 1;
                        }
                        pCheck = head;
                        while (pCheck != null) {
                            if ((pCheck.x == node[i].x - 1) && (pCheck.y == node[i].y)) {
                                pCheck = null;
                                flag_up_success = false;
                            } else {
                                pCheck = pCheck.nextNode;
                            }
                        }
                        if (flag_up_success) {
                            traversedNode = new TraversedNode();
                            traversedNode.x = node[i].x - 1;
                            traversedNode.y = node[i].y;
                            p.nextNode = traversedNode;
                            p = traversedNode;
                            p.nextNode = null;

                            nodeNext[count_node].x = node[i].x - 1;
                            nodeNext[count_node].y = node[i].y;
                            count_node++;
                        }
                        flag_up_success = true;
                    }
                }

                if (node[i].y + 1 <= n - 1)//向右搜索子节点
                {
                    if (grid[node[i].x][node[i].y + 1] != 0) {
                        if (grid[node[i].x][node[i].y + 1] == 9) {
                            step++;
                            System.out.println("最短" + step + "步到达终点");
                            return 1;
                        }
                        pCheck = head;
                        while (pCheck != null) {
                            if ((pCheck.x == node[i].x) && (pCheck.y == node[i].y + 1)) {
                                pCheck = null;
                                flag_right_success = false;
                            } else {
                                pCheck = pCheck.nextNode;
                            }
                        }
                        if (flag_right_success) {
                            traversedNode = new TraversedNode();
                            traversedNode.x = node[i].x;
                            traversedNode.y = node[i].y + 1;
                            p.nextNode = traversedNode;
                            p = traversedNode;
                            p.nextNode = null;

                            nodeNext[count_node].x = node[i].x;
                            nodeNext[count_node].y = node[i].y + 1;
                            count_node++;
                        }
                        flag_right_success = true;
                    }
                }

                if (node[i].y - 1 >= 0)//向左搜索子节点
                {
                    if (grid[node[i].x][node[i].y - 1] != 0) {
                        if (grid[node[i].x][node[i].y - 1] == 9) {
                            step++;
                            System.out.println("最短" + step + "步到达终点");
                            return 1;
                        }
                        pCheck = head;
                        while (pCheck != null) {
                            if ((pCheck.x == node[i].x) && (pCheck.y == node[i].y - 1)) {
                                pCheck = null;
                                flag_left_success = false;
                            } else {
                                pCheck = pCheck.nextNode;
                            }
                        }
                        if (flag_left_success) {
                            traversedNode = new TraversedNode();
                            traversedNode.x = node[i].x;
                            traversedNode.y = node[i].y - 1;
                            p.nextNode = traversedNode;
                            p = traversedNode;
                            p.nextNode = null;

                            nodeNext[count_node].x = node[i].x;
                            nodeNext[count_node].y = node[i].y - 1;
                            count_node++;
                        }
                        flag_left_success = true;
                    }
                }


            }

            if (count_node == 0)//若k＝0则代表该搜索周期内的所有最新点都已走到尽头，无可拓展的子节点，搜索结束，不存在到达9的路径
            {
                System.out.println("不存在到达终点的路径");
                return 0;
            }
            step++;
            num_node = count_node;//若k！＝0则将进行下一个周期的搜索，节点共有k个
            count_node = 0;//将k重置为0
            for (int i = 0; i < num_node; i++)//该循环用于更新节点
            {
                node[i].x = nodeNext[i].x;
                node[i].y = nodeNext[i].y;
                System.out.println("(" + node[i].x + "," + node[i].y + ")  ");//显示该层所有节点，也可以理解为打印该树的结构
            }

        }


    }


    public static void main(String args[]){

        int[][] grid = new int[8][8];
        grid[0][0]=1; grid[0][1]=1; grid[0][2]=0; grid[0][3]=0; grid[0][4]=0; grid[0][5]=0; grid[0][6]=0; grid[0][7]=1;

        grid[1][0]=1; grid[1][1]=1; grid[1][2]=1; grid[1][3]=1; grid[1][4]=1; grid[1][5]=1; grid[1][6]=1; grid[1][7]=1;

        grid[2][0]=1; grid[2][1]=0; grid[2][2]=0; grid[2][3]=0; grid[2][4]=1; grid[2][5]=0; grid[2][6]=0; grid[2][7]=1;

        grid[3][0]=1; grid[3][1]=1; grid[3][2]=1; grid[3][3]=0; grid[3][4]=1; grid[3][5]=0; grid[3][6]=0; grid[3][7]=1;

        grid[4][0]=0; grid[4][1]=1; grid[4][2]=0; grid[4][3]=0; grid[4][4]=1; grid[4][5]=1; grid[4][6]=1; grid[4][7]=1;

        grid[5][0]=0; grid[5][1]=1; grid[5][2]=0; grid[5][3]=0; grid[5][4]=0; grid[5][5]=0; grid[5][6]=0; grid[5][7]=1;

        grid[6][0]=0; grid[6][1]=1; grid[6][2]=0; grid[6][3]=9; grid[6][4]=1; grid[6][5]=1; grid[6][6]=1; grid[6][7]=1;

        grid[7][0]=0; grid[7][1]=1; grid[7][2]=1; grid[7][3]=1; grid[7][4]=0; grid[7][5]=0; grid[7][6]=1; grid[7][7]=0;
        MiGong miGong = new MiGong();
        System.out.println(miGong.isPath(grid));

    }

}
