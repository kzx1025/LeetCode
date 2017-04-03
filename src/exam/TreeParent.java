package exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by iceke on 17/4/3.
 */
public class TreeParent {
    class TreeNode {
        TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }
    public static void main(String args[]){
        int total = 1;
        int k =4;
        int d1=10;
        int d2=13;
        int d3 =15;

        int max = 1;
        for(int i = 0;i<k;i++){
            max*=2;

        }
        int[] sortArray = new int[max];

        for(int i =0;i<sortArray.length;i++){
            sortArray[i] = i+1;
        }

        TreeParent tp = new TreeParent();

        TreeNode root = tp.buildSortTree(0,sortArray.length-1,sortArray);
        Queue<Integer> path1 = getPath(root,d1);
        Queue<Integer> path2 = getPath(root,d2);
        Queue<Integer> path3 = getPath(root,d3);

        int result = 0;
        for(int i =0;i<path1.size()&&i<path2.size()&&i<path3.size();i++){
            int a1 = path1.poll();
            int a2 = path2.poll();
            int a3 = path3.poll();
            if(a1==a2&&a1==a3){
                result = a1;
            }else{
                break;
            }
        }

        System.out.println(result);


    }
    public static Queue<Integer> getPath(TreeNode root,int target){
        Queue<Integer> queue = new LinkedList<Integer>();
        if(root == null){
            return queue;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(stack.size()!=0){
            TreeNode temp = stack.pop();

            queue.offer(temp.val);
            if(temp.val == target){
                return queue;
            }
            if(temp.right!=null && temp.val<target){
                stack.push(temp.right);
            }
            if(temp.left!=null && temp.val>target){
                stack.push(temp.left);
            }
        }

        return queue;

    }

    public  TreeNode buildSortTree(int start,int end,int[] sortArray){
        if(start>=end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode temp = new TreeNode(sortArray[mid]);
        temp.left = buildSortTree(start,mid,sortArray);
        temp.right = buildSortTree(mid+1,end,sortArray);
        return temp;

    }

}
