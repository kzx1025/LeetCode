package test;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * Created by iceke on 16/4/27.
 */
public class GuiBin {
    public static void main(String args[]) {
        int[] test = {1,3,4,2,7,9,6,0};
        System.out.println(Arrays.toString(sort(test,0,test.length-1)));

    }

    private static int[] sort(int nums[], int low, int high) {
        int mid =(low + high) / 2;
        if (low < high) {
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            mergeSort(nums, low, mid, high);
        }
        return nums;
    }

    private static void mergeSort(int nums[], int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int m = 0;
        while (i <= mid && j <= high) {
            if(nums[i]<nums[j]){
                temp[m++] = nums[i++];
            }else{
                temp[m++] = nums[j++];
            }
        }

        while(i<=mid){
            temp[m++] = nums[i++];
        }
        while(j<=high){
            temp[m++] = nums[j++];
        }

        for(int p = 0; p<temp.length;p++){
            nums[low+p] = temp[p];
        }

    }


}
