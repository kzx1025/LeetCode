package exam;

/**
 * Created by iceke on 17/3/1.
 */
import exam.TestTree.TreeNode;
public class FindMaxLength {

    public static void main(String args[]){

    }

    public static int getMaxPath(TreeNode root,int[] max){
        if(root == null){
            return 0;
        }

        int leftNum = getMaxPath(root.left,max);
        int rightNum = getMaxPath(root.right,max);

        max[0] = Math.max(max[0],Math.max(root.val+leftNum,root.val+rightNum));

        return Math.max(0,Math.max(leftNum,rightNum))+root.val;
    }
}
