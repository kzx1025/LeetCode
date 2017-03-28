package exam;


import java.util.Arrays;

/**
 * Created by iceke on 17/3/1.
 */
public class BuildFindTree {
    static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String args[]) {
        int[] nums = new int[]{1,3,5,2,4,7,0};

        Arrays.sort(nums);
        buildTree(nums,0,nums.length-1);
    }



    public static TreeNode buildTree(int[] sortedArray, int start, int end) {
        if(start>end){
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode temp = new TreeNode(sortedArray[mid]);

        temp.left = buildTree(sortedArray,start,mid-1);
        temp.right = buildTree(sortedArray,mid+1,end);

        return temp;

    }
}
