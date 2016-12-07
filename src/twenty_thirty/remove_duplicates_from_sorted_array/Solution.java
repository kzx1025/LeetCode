package twenty_thirty.remove_duplicates_from_sorted_array;

/**
 * Created by iceke on 16/12/7.
 */
public class Solution {
    //题目意思没懂..
    public static void main(String args[]){
        int[] nums={1,1,1};
        System.out.println(removeDuplicates(nums));

    }
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }else{
                nums[count] = nums[i];
                count++;
            }
        }
        return count;

    }
}
