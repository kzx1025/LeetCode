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
        int[] nums = new int[]{0,2,5,7,9,10};

        System.out.println(searchTarget(nums,222));

        Arrays.sort(nums);
        buildTree(nums,0,nums.length-1);
    }

    public static int searchTarget(int[] values,int target){
        int start = 0;
        int end = values.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(values[mid]>target){
                end = mid-1;
            }else if(values[mid]<target){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;

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
