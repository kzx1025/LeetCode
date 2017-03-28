package exam;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by iceke on 17/3/1.
 */



public class TestTree {

   static class TreeNode {
        public TreeNode(int val){
            this.val = val;
        }
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(2);

        TreeNode left = new TreeNode(1);

        TreeNode right = new TreeNode(3);

        root.left = left;

        root.right = right;

        List<Integer> orderList = new ArrayList<Integer>();
        xianxuOrder(root,orderList);
        System.out.println(orderList);



    }

    public static void  xianxuOrder(TreeNode root,List<Integer> orderList){
        if(root == null){
            return;
        }

        xianxuOrder(root.left,orderList);
        orderList.add(root.val);
        xianxuOrder(root.right,orderList);
    }
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        if(root == null)
            return returnList;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode n = stack.pop();
            returnList.add(n.val);

            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }

        }
        return returnList;
    }

    public static int getDepth(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> counts = new ArrayList<Integer>();
        stack.push(root);
        int count = 0;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            count+=1;

            if(node.right!=null){
                stack.push(node.right);
            }else{
                counts.add(count);
            }

            if(node.left != null){
                stack.push(node.left);

            }else{
                counts.add(count);
            }


        }

        return  counts.get(0);

    }

    public static TreeNode findKey(TreeNode node, int key){
        if(node == null){
            return null;
        }

        if(node.val > key){
           return  findKey(node.left,key);
        }else if(node.val<key){
            return findKey(node.right,key);
        }else{
            return node;
        }

    }


    public static void insertNode(TreeNode node,int key){
        if(node == null){
            return ;
        }
        TreeNode parentNode = null;

        while(node != null){
            parentNode = node;
            if(node.val>key){
                node = node.right;
            }else if(node.val<key){
                node = node.left;
            }else{
                return ;
            }
        }

        if(key<parentNode.val){
            TreeNode x = new TreeNode(key);
            parentNode.left = x;
          //  x.parentNode = parentNode;

        }
    }


    //验证是否为二叉查找树
    //中序遍历加入列表 然后遍历判断是否有序

}
