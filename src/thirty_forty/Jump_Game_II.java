package thirty_forty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iceke on 16/12/26.
 */
public class Jump_Game_II {
    public static void main(String args[]) {
        System.out.println(jump(new int[]{5,6,4,4,6,9,4,4}));

    }

    public static int jump(int[] nums) {
        //first method
       /** List<Integer> allAnwsers = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        jumpK(nums, 0, 0, allAnwsers,min);

        for(int answer:allAnwsers){
            if(answer<min){
                min = answer;
            }
        }
        return min;
        **/

        //second method  贪心法
        int length = nums.length;
        int ldist = 0;
        int hdist = 0;
        int minStep = 0;
        if (length == 1) return 0;
        while(ldist<=hdist){
            minStep+=1;
            int lastDist = hdist;
            for(int i = ldist;i<=lastDist;i++){
               int possibleDist = i+nums[i];
                if(possibleDist >= nums.length-1){
                    return minStep;
                }
                if(possibleDist>hdist){
                    hdist = possibleDist;
                }

            }

            ldist = lastDist+1;

        }

        return 0;

    }

    /**
     * 这种解决办法最差运行复杂度较高,而且nums过长会产生爆栈,通过不了leetcode的所有case
     *
     * @param nums
     * @param floor
     * @param step
     * @param answers
     * @param min
     */
    public static void jumpK(int[] nums, int floor, int step, List<Integer> answers,int min) {
        if(answers.size()!=0){
            return;
        }

        if (floor == nums.length - 1) {
            answers.add(step);
        }else if(floor>nums.length - 1){

        }else {
            for (int i = nums[floor]; i >=1 ; i--) {
                step += 1;

                if(step<min) {
                    jumpK(nums, floor + i, step, answers,min);
                }
                step -= 1;

            }
        }

    }
}
