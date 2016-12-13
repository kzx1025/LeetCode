package thirty_forty.search_for_a_range;

import java.util.Arrays;

/**
 * Created by iceke on 16/12/13.
 */
public class Solution {

    public static void main(String args[]) {

        int[] nums = {5};
        int target =5;
        System.out.println(Arrays.toString(search(nums, target)));

    }

    public static int[] search(int[] nums,int target){
        if(target>nums[nums.length-1]||target<nums[0]){
            return new int[]{-1,-1};
        }

        int start = searchStart(nums,target);
        return start==-1? new int[]{-1,-1}: new int[]{start,searchEnd(nums,target)};

    }

    public static int searchStart(int[] nums, int target) {
        int prev = 0;
        int after = nums.length-1;
        int start = -1;

        while (prev <= after) {
            int mid = (prev + after) / 2;
            if (nums[mid] < target) {
                prev = mid + 1;
            } else if (nums[mid] > target) {
                after = mid - 1;
            }else{
                start = mid;
                after = mid - 1;

            }
        }

        return start;

    }

    public static int searchEnd(int[] nums, int target){
        int prev = 0;
        int after = nums.length-1;
        int end = -1;

        while (prev <= after) {
            int mid = (prev + after) / 2;
            if (nums[mid] < target) {
                prev = mid + 1;
            } else if (nums[mid] > target) {
                after = mid - 1;
            }else{
                end = mid;
                prev = mid + 1;

            }
        }

        return end;

    }
}
