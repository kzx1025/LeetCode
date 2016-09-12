package exam;

import java.util.*;

/**
 * Created by iceke on 16/3/18.
 */
public class Solution {
    public static void main(String args[]){
        Map<Integer,List<Integer>> keymap = new HashMap<Integer,List<Integer>>();
        List k1 = new ArrayList<Integer>();
        k1 = Arrays.asList(1,4);
        List k2 = new ArrayList<Integer>();
        k2 =Arrays.asList(1,2,3,7);
        List k3 = new ArrayList<Integer>();
        int[] num3 = {5,6};
        k3 =Arrays.asList(5,6);
        List k4 = new ArrayList<Integer>();
        int[] num4 = {1,7,0};
        k4 =Arrays.asList(1,7,0);
        List k5 = new ArrayList<Integer>();
        int[] num5 = {1,3,4,5,7,9};
        k5 =Arrays.asList(1,3,4,5,7,9);
        List k6 = new ArrayList<Integer>();
        int[] num6 = {2};
        k6 =Arrays.asList(2);
        List k7 = new ArrayList<Integer>();
        int[] num7 = {1,4,7};
        k7 =Arrays.asList(1,4,7);

        keymap.put(1,k1);
        keymap.put(2,k2);
        keymap.put(3,k3);
        keymap.put(4,k4);
        keymap.put(5,k5);
        keymap.put(6,k6);
        keymap.put(7,k7);

        int K = 3;
        int N = 50;


        List<List<Integer>> result= new ArrayList<List<Integer>>();

        int[][] test = {{3,1},{1,4,5},{1,5,6,7}};
        for(int i = 0;i<K;i++){
            Set<Integer> all = new HashSet<Integer>();
            List<Integer> a = new ArrayList<Integer>();
          a = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
            all.addAll(a);
            for(int j =0;j<test[i].length;j++){
               List<Integer> tempList = keymap.get(test[i][j]);
                Set<Integer> tempSet = new HashSet<Integer>();
                tempSet.addAll(tempList);
                all = intersectionSet(all,tempSet);
            }
            List<Integer> tList = new ArrayList<Integer>();
            tList.addAll(all);
            result.add(tList);
        }

        int sum = 0;
        for(int i = 0;i<K;i++){
            for(int j = 0;j<result.get(i).size();j++){
                int origin = (int) (result.get(i).get(j)/Math.pow(10,(double)K));
                int mudi = (int)(N/Math.pow(10,(double)K));
                if(origin< mudi){


                }


            }
        }








    }

    public static Set intersectionSet(Set setA, Set setB) {
        Set intersectionSet = new HashSet();
        Iterator iterA = setA.iterator();
        while (iterA.hasNext()) {
            Object tempInner = iterA.next();
            if (setB.contains(tempInner)) {
                intersectionSet.add(tempInner);
            }
        }
        return intersectionSet;
    }
}
