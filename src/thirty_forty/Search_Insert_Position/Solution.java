package thirty_forty.Search_Insert_Position;

/**
 * Created by iceke on 16/12/13.
 */
public class Solution {
    public static void main(String args[]){
        int[] nums = {0,2};
        System.out.println(searchInsert(nums,1));
    }


    public static int searchInsert(int[] nums, int target) {
        int prev =0 ;
        int after = nums.length-1;
        int mid = 0;
        while(prev<=after){
            mid = (prev+after)/2;
            if(nums[mid]>target){
                after = mid -1;
            }else if(nums[mid]<target){
                prev = mid +1;
            }else{
                return mid;
            }
        }

        return prev<=after?prev+1:after+1;

    }
}
