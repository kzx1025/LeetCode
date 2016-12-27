package fifty_sixty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iceke on 16/12/27.
 * 这一题也是够巧妙的...
 */
public class Maximum_Subarray {
    public static void main(String args[]){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));


    }
    public static int maxSubArray(int[] nums) {

        int length = nums.length;
        if(length == 1){
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
       // List<List<Integer>> subs = new ArrayList<List<Integer>>()
        //findSum(nums,subs,sub,0,0);

       /** for(int i = 0;i<length;i++){
            int sum = 0;
            sum+=nums[i];
            if(sum>max){
                max = sum;
            }
            for(int j = i+1;j<length;j++){
                sum+=nums[j];
                if(sum>max){
                    max = sum;
                }
            }
        }
        **/

        int sum = 0;

        for(int num:nums){
            sum+=num;
            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }

        return max;

    }

}
