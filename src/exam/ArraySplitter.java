package exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by iceke on 17/3/7.
 */
public class ArraySplitter {
    public static void main(String[] args) {
        ArraySplitter splitter = new ArraySplitter();
        int[] m = {2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7};
        int[] m2 = {1,1, 1, 1, 1, 1, 1};

        System.out.println(splitter.split(m2));


    }

    public boolean split(int[] array) {
        if (array.length < 7) {
            return false;
        }
        HashMap<Integer, Integer> sumIndexes = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sumIndexes.put(sum, i);
            sum += array[i];
        }
        sumIndexes.put(sum, array.length);
        double maxSumEach = ((double) (sum - getMinSum(array))) / 4;
        double minSumEach = ((double) (sum - getMaxSum(array))) / 4;

        int sum1 = 0;
        for (int i = 0; i < array.length; i++) {
            sum1 += array[i];
            if (sum1 > maxSumEach)
                return false;
            if (sum1 >= minSumEach && sum1 <= maxSumEach) {
                int index1 = i + 1;
                if (sumIndexes.containsKey(sum1 * 2 + array[index1])) {
                    int index2 = sumIndexes.get(sum1 * 2 + array[index1]);
                    if (sumIndexes.containsKey(sum1 * 3 + array[index1] + array[index2])) {
                        int index3 = sumIndexes.get(sum1 * 3 + array[index1] + array[index2]);
                        if (array[index1] + array[index2] + array[index3] + sum1 * 4 == sum) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int getMinSum(int[] array) {

        Set<Integer> indexes = new HashSet<Integer>();

        int index = 0;
        int sum = 0;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min && !indexes.contains(i)) {
                min = array[i];
                index = i;
            }
        }
        sum += min;
        indexes.add(index);

        min = array[0];
        index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min && !indexes.contains(i)) {
                min = array[i];
                index = i;
            }
        }
        sum += min;
        indexes.add(index);

        min = array[0];
        index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min && !indexes.contains(i)) {
                min = array[i];
                index = i;
            }
        }

        sum += min;
        indexes.add(index);

        return sum;


    }


    public int getMaxSum(int[] array) {

        Set<Integer> indexes = new HashSet<Integer>();

        int index = 0;
        int sum = 0;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max && !indexes.contains(i)) {
                max = array[i];
                index = i;
            }
        }
        sum += max;
        indexes.add(index);

        max = array[0];
        index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max && !indexes.contains(i)) {
                max = array[i];
                index = i;
            }
        }
        sum += max;
        indexes.add(index);

        max = array[0];
        index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < max && !indexes.contains(i)) {
                max = array[i];
                index = i;
            }
        }

        sum += max;
        indexes.add(index);

        return sum;

    }

}
