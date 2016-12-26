package thirty_forty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iceke on 16/12/20.
 */
public class Permutations_II {
    public static void main(String args[]){
        System.out.println(permuteUnique(new int[]{3,3,0,3}));

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> tempResult = new ArrayList<Integer>();
        //Arrays.sort(nums);
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
                if(sameExist(nums,floor,i)) continue;
                swap(nums,floor,i);
                pailie(results,tempReult,nums,floor+1);
                swap(nums,i,floor);
            }
        }
    }

    private static boolean sameExist(int nums[],int floor,int j){
        boolean flag = false;
        for (int i = floor; i < j ; ++i)
            if (nums[i] == nums[j]) {
                flag = true;
                break;
            }
        return flag;
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
