package thirty_forty;

/**
 * Created by iceke on 16/12/15.
 */
public class First_Missing_Positive {
    public static void main(String args[]){
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1,2}));

    }

    //too smart....利用下标
    public static int firstMissingPositive(int[] nums) {

        for(int i =0;i<nums.length;){
            if(nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length) i++;
            else if(nums[nums[i]-1] != nums[i]) swap(nums, i, nums[i]-1);
            else i++;
        }

        for(int i =0 ;i<nums.length;++i){
            if(nums[i]!=i+1){
                return  i+1;
            }

        }
        return nums.length+1;
    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
