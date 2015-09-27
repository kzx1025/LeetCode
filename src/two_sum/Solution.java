package two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by iceke on 15/9/27.
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.

  The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class Solution {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int start = input.indexOf("{");
        int end = input.indexOf("}");
        String dataStrings[] = input.substring(start+1, end).split(", ");
        int nums[]= new int[dataStrings.length];
        int i = 0;
        for(String dataString:dataStrings){
            nums[i] = Integer.parseInt(dataString);
            i++;
        }
        int target = Integer.parseInt(input.substring(input.lastIndexOf("=")+1));
        int[] result =twoSum4(nums, target);

        System.out.println("index1="+result[0]+", index2="+result[1]);
    }

    /**
     * the most stupid forget to add check
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int twoSum[] = {1,2};
        int i,j = 0;
        for(i = 0; i<nums.length;i++){
            for(j = i+1; j<nums.length;j++){
                if(nums[i]+nums[j]==target&&i!=j){
                    twoSum[0]=i+1;
                    twoSum[1]=j+1;
                    return twoSum;
                }
            }
        }
        return twoSum;


    }

    /**
     * use sort but can not use this method,because we need indexes
     */
    public static int[] twoSum2(int[] nums, int target){
        int twoSum[] = new int[2];
        if(nums.length < 2 || nums == null){
            return null;
        }
        Arrays.sort(nums); //first sort (TimSort)
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            if(nums[i]+nums[j] == target){
                twoSum[0] = i+1;
                twoSum[1] = j+1;
                return twoSum;
            }else if(nums[i]+nums[j] < target){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }

    /**
     * used hashmap,index-value,can find a word quickly
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target){
        int twoSum[] = new int[2];
        if(nums.length < 2 || nums == null){
            return null;
        }
        Map<Integer,Integer> numMap = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            numMap.put(nums[i],i);
        }

        for(int i = 0;i<nums.length;i++){
            if(numMap.containsKey(target-nums[i])){
                int j = numMap.get(target-nums[i]);
                if(i!=j){
                    twoSum[0] = i+1;
                    twoSum[1] = j+1;
                    return twoSum;
                }

            }
        }


        return null;

    }

    public static int[] twoSum4(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer,Integer> numMap = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
                numMap.put(nums[i], i);
        }
        int[] clone_num = nums.clone();
        Arrays.sort(clone_num);
        for(int i =0;i<clone_num.length;i++){
            if(Arrays.binarySearch(clone_num, target-clone_num[i])>0){
                result[0] = numMap.get(clone_num[i])+1;
                for(int j =0;j<nums.length;j++){
                    if(nums[j] == target-clone_num[i] && j!= result[0]-1){
                        result[1] = j+1;
                        if(result[0] > result[1]){
                            int temp = result[1];
                            result[1] = result[0];
                            result[0] = temp;
                        }
                        return result;
                    }

                }
            }
        }
        return null;

    }
}
