package thirty_forty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iceke on 16/12/15.
 * 相当于组合
 */
public class Combination_Sum_II {
    public static void main(String args[]){

        List<List<Integer>> results = combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5},8);
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
                if(i > floor&&value == candidates[i-1]) continue;//跳过同层楼相同的数字
                current.add(value);
                back_track(results, current, candidates, target - value, i+1);
                //remove the last one
                current.remove(current.size() - 1);
            }
        }
    }
}
