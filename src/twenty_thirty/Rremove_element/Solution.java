package twenty_thirty.Rremove_element;

/**
 * Created by iceke on 16/12/8.
 */
public class Solution {
    public static void main(String args[]){
        int[] nums={1,1,1,2,3,4};
        System.out.println(removeElement(nums,1));

    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int count = 0;
        for(int i = 0;i<len;i++){
            if(nums[i]==val){

            }else{
                nums[count]=nums[i];
                count+=1;
            }

        }
        return count;

    }

}
