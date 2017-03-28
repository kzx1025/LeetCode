package exam;

import java.util.Arrays;

/**
 * Created by iceke on 17/2/28.
 */
public class QuickSort {
    private static int partition(int data[], int low, int high) {//分治
        int key = data[low];
        while (low < high) {
            while (low < high && data[high] > key)//从右向左
                high--;
            data[low] = data[high];

            while (low < high && data[low] < key)//从左向右
                low++;
            data[high] = data[low];
        }
        data[low] = key;//把轴元素放在轴所在地位置
        return low;//返回轴所在的位置
    }


    public static void quickSort(int[] nums,int low,int high){
        if(low<high){
            int flag = partition(nums,low,high);
            quickSort(nums,low,flag-1);
            quickSort(nums,flag+1,high);
        }
    }


    public static void main(String args[]){
        int[] tests = new int[]{4,3,8,5,2,7,19,6};
        quickSort(tests,0,7);

        for(int test:tests){
            System.out.print(test+" ");

        }
    }


    public static boolean isInDic(String sentence,String[] dics,int start){
        if(start == sentence.length()-1){
            return true;
        }

        for(String dic : dics){
            int dicLength = dic.length();
            int end = start+dicLength;
            if(end>sentence.length()-1){
                continue;
            }

            if(sentence.substring(start,end).equals(dic)){
                return isInDic(sentence,dics,end);
            }
        }

        return false;

    }
}
