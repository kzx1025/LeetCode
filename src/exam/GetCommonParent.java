package exam;

import exam.TestTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by iceke on 17/3/23.
 */
public class GetCommonParent {

    public static void main(String args[]){

    }

    private static boolean getPath(TreeNode root,TreeNode target,Queue<TreeNode> nodeQueue){

        if(root == null || target == null){
            return false;
        }

        if(root == target){
            nodeQueue.offer(root);
            return true;
        }

        nodeQueue.offer(root);

        boolean juge = getPath(root.left,target,nodeQueue);


        if(!juge){
            juge = getPath(root.right,target,nodeQueue);
        }

        if(!juge){
            nodeQueue.remove(root);
        }

        return juge;

    }


    public static TreeNode getParent(TreeNode root,TreeNode target1,TreeNode target2){
        if(root == null||target1 == null||target2 ==null){
            return null;
        }

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();

        boolean juge1 = getPath(root,target1,queue1);
        boolean juge2 = getPath(root,target1,queue2);

        if(!juge1 || !juge2){
            return null;
        }


        TreeNode parent = null;
        for(int i = 0;i<queue1.size()&&i<queue2.size();i++){
            TreeNode temp = queue1.poll();
            if(temp == queue2.poll()){
                parent = temp;
            }else{
                break;
            }
        }

        return parent;

    }

}
