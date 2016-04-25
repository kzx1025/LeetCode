package zero_twenty.four_sum_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iceke on 16/4/21.
 */
public class Solution {

    public static void main(String args[]) {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        System.out.println(fourSum(nums, -11));
    }

    //也可以用hashset先存储列表,去掉重复
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int m = 0; m < nums.length; m++) {

            if (m > 0 && nums[m] == nums[m - 1]) {
                continue;
            }

            for (int n = m + 1; n < nums.length; n++) {
                if (n > m + 1 && nums[n] == nums[n - 1]) {
                    continue;
                }
                int left = n + 1;
                int right = nums.length - 1;
                //动态规划！！
                while (left < right) {

                    if (left > n + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    int sum = nums[m] + nums[n] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> tempList = new ArrayList<Integer>();
                        tempList.add(nums[m]);
                        tempList.add(nums[n]);
                        tempList.add(nums[left]);
                        tempList.add(nums[right]);

                        result.add(tempList);

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                }
            }
        }

        return result;

    }

}
