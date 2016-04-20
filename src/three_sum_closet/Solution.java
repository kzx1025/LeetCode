package three_sum_closet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iceke on 15/12/18.
 */
public class Solution {
    //TODO unfinished by kzx

    public static void main(String args[]) {
        int[] nums = {0,2,1,-3};
        int result = threeSumClosest(nums,1);
        System.out.println(result);

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int needTarget = 0;
        for (int m = 0; m < nums.length; m++) {

            int left = m + 1;
            int right = nums.length - 1;
            //动态规划！！
            while (left < right) {
                int sum = nums[m] + nums[left] + nums[right];
                int gap = Math.abs(sum-target);
                if(gap<minGap){
                    minGap = gap;
                    needTarget = sum;
                }

                if (sum-target == 0) {
                    return target;
                } else if (sum-target < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return needTarget;

    }
}
