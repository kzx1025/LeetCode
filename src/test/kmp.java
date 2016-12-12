package test;

import java.util.Arrays;

/**
 * Created by iceke on 16/12/11.
 * KMP算法
 */
public class kmp {

    public static void main(String args[]){
        System.out.println(search("asdasfdgfsfdhkghk","kghddtopkgdto"));

    }

    public static int search(String target,String pattern){
        int[] next = getNext(pattern);
        int totalLength = target.length();
        int patternLength = pattern.length();

        if(patternLength == 0){
            return 0;
        }
        if(patternLength>totalLength){
            return -1;
        }

        for(int i = 0;i<totalLength-patternLength+1;i++){
            int tempI = i;
            for(int j = 0;j<patternLength;j++,tempI++){
                if(target.charAt(tempI)!=pattern.charAt(j)){
                    i+=next[j];
                    break;
                }
                if(j==patternLength-1){
                    return i;
                }

            }

        }
        return -1;

    }

    public static int[] getNext(String b){
        int len=b.length();
        int j=0;

        int next[]=new int[len+1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
        next[0]=next[1]=0;

        for(int i=1;i<len;i++)//i表示字符串的下标，从0开始
        {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
            if(j>0&&b.charAt(i)!=b.charAt(j))j=0;
            if(b.charAt(i)==b.charAt(j))j++;
            next[i+1]=j;
        }

        return next;
    }
}
