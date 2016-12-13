package thirty_forty.Search_in_Rotated_Sorted_Array;

/**
 * Created by iceke on 16/12/12.
 */
public class Solution {

    public static void main(String args[]){
        int[] nums = {3,1};
        System.out.println(search(nums,2));
    }


    public static int search(int[] nums, int target) {
        //找出分界值

        int middleIndex = -1;
        int length = nums.length;
        if(length == 0){
            return -1;
        }

        int prev = 0;
        int after = length-1;
        //找出对称轴
        while(prev<=after){
            int mid = prev+(after-prev)/2;
            if(nums[mid]>nums[after]){
                prev=mid+1;
            }else{
                after = mid-1;
            }
        }

        if(length == 1){
            return nums[0]==target?0:-1;
        }


        int res1 = binearySearch(nums,0,prev,target);

        return res1!=-1?res1:binearySearch(nums,prev,length,target);

    }

    public static int binearySearch(int[] nums,int start,int end, int target){

        if(start == end){
            return nums[start]==target?start:-1;
        }else if(start>end){
            return -1;
        }
        int prev = start;
        int length= end-start;
        int after = end;
        if(target>nums[end-1]||target<nums[start]){
            return -1;
        }
        while(prev<after){
            int temp = prev+(after-prev)/2;
            if(target<nums[temp]){
                after = temp;
            }else if(target>nums[temp]){
                prev = temp+1;
            }else{
                return temp;
            }
        }

        return -1;
    }
}
