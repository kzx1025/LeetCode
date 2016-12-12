package twenty_thirty.Next_Permutation;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by iceke on 16/12/12.
 */
public class Solution {

    public static void main(String args[]){
        int[] nums = {2,1};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {

        int length = nums.length;
        if (length == 0 || length==1) {
            return;

        }

        int x = -1;
        for(int i =length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                x = i-1;
                break;
            }
        }
        if(x == -1){
            Arrays.sort(nums);
            return;
        }

        //开始操作
        int temp = nums[x+1];
        nums[x+1] = nums[x];
        nums[x] = temp;

        int max = x+1+(length-(x+1))/2;
        for(int i = x+1;i<max;i++){
            int tmp = nums[i];
            int dui = length-1-(i-(x+1));
            nums[i] = nums[dui];
            nums[dui] = tmp;
        }

        System.out.println(Arrays.toString(nums));

    }
}
