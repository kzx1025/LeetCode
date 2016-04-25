package zero_twenty.container_with_most_water;

/**
 * Created by iceke on 15/12/9.
 */
public class Solution {

    public static int maxArea(int[] height) {
        int max = 0;

        if(height == null || height.length<2){
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        while(left<right){
            max = Math.max(max,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }


    public static void main(String args[]){
        int[] height = {4,1,2,3};
        System.out.println(maxArea(height));
    }
}
