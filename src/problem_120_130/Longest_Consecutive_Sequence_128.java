package problem_120_130;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iceke on 17/6/23.
 */
public class Longest_Consecutive_Sequence_128 {
    public static int longestConsecutive(int[] nums) {
        if(nums.length <1){
            return nums.length;
        }

        Map<Integer,Integer> numsMap = new HashMap<Integer,Integer>();
        int maxLength = 0;
        for(int num:nums){
            if(!numsMap.containsKey(num)){
                int left=0,right=0;
                if(numsMap.containsKey(num-1)){
                    left = numsMap.get(num-1);
                }
                if(numsMap.containsKey(num+1)){
                    right = numsMap.get(num+1);
                }

                int sum = left+right+1;
                maxLength = Math.max(maxLength,sum);
                numsMap.put(num,sum);
                numsMap.put(num-left,sum);
                numsMap.put(num+right,sum);
            }else{
                continue;
            }
        }

        return maxLength;

    }

    public static void main(String args[]){
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));



    }
}
