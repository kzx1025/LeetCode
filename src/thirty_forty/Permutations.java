package thirty_forty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by iceke on 16/12/19.
 */
public class Permutations {
    public static void main(String args[]){
        System.out.println(permute(new int[]{1,2,3}));

    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> tempResult = new ArrayList<Integer>();
        pailie(results,tempResult,nums,0);
        //System.out.println(results.size());

        return results;
    }

    public static void pailie(List<List<Integer>> results,List<Integer> tempReult,int[] nums,int floor){

        if(floor>nums.length-1){
           // System.out.println(Arrays.toString(nums));
            for(int num:nums){
                tempReult.add(num);
            }
            results.add(new ArrayList<Integer>(tempReult));
            tempReult.clear();
        }else{
            for(int i = floor;i<nums.length;i++){
                swap(nums,floor,i);
                pailie(results,tempReult,nums,floor+1);
                swap(nums,i,floor);
            }
        }
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
