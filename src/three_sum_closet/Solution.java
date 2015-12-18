package three_sum_closet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iceke on 15/12/18.
 */
public class Solution {
    //TODO unfinished by kzx
    public int threeSumClosest(int[] nums, int target) {
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

        return 0;

    }
}
