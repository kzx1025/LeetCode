package zero_twenty.three_sum;

import java.util.*;

/**
 * Created by iceke on 15/12/18.
 * <p/>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * <p/>
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class Solution {
    public static void main(String args[]) {
        int[] nums = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int m = 0; m < nums.length; m++) {
            if (nums[m] > 0) {
                break;
            }
            if (m != 0 && nums[m] == nums[m - 1]) {
                continue; // to skip duplicate numbers; e.g [0,0,0,0]
            }
            int left = m + 1;
            int right = nums.length - 1;
            //动态规划！！
            while (left < right) {
                int sum = nums[m] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(nums[m]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    result.add(tempList);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) { // to skip duplicates
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) { // to skip duplicates
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return result;

    }


}
