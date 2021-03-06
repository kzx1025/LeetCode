package thirty_forty.Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**List<List<Integer>>
 * Created by iceke on 16/12/13.
 *
 * 回溯法
 */
public class Solution {

    public static void main(String args[]){

        List<List<Integer>> results = combinationSum(new int[]{1,2,3},4);
        System.out.println(results);


    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);
        back_track(results,current,candidates,target,0);
        return results;
    }


    public static void back_track(List<List<Integer>> results,List<Integer> current,int[] candidates,int target,int floor){
       // System.out.println(current);
        if(target == 0){
            results.add(new ArrayList<Integer>(current));
        }else if(target<0){
            return;
        }else {

            for (int i = floor; i < candidates.length; i++) {
                int value = candidates[i];
                current.add(value);
                back_track(results, current, candidates, target - value, i);
                //remove the last one
                current.remove(current.size() - 1);
            }
        }
    }

}
