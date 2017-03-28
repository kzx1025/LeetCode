package fifty_sixty;

/**
 * Created by iceke on 17/1/10.
 */
public class Jump_Game {
    public static void main(String args[]){
        System.out.println(canJump(new int[]{1,2}));

    }

    public static boolean canJump(int[] nums) {
        int length = nums.length;
        int ldist = 0;
        int hdist = 0;
        if(length==1){
            return true;
        }
        while(ldist<=hdist){
            int lastDist = hdist;
            for(int i = ldist;i<=lastDist;i++){
                int possibleDist = i+nums[i];
                if(possibleDist>=length-1){
                    return true;
                }
                if(possibleDist>hdist){
                    hdist = possibleDist;
                }
            }
            ldist = lastDist+1;
        }

        return false;


    }
}
