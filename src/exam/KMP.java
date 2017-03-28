package exam;

/**
 * Created by iceke on 17/3/8.
 */
public class KMP {

    public static void main(String args[]) {
        String value = "BBC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABDds";

        System.out.println(getMatchIndex(value,pattern));

    }

    private static int getMatchIndex(String value, String pattern) {

        int[] next = getNext(pattern);
        int vLength = value.length();
        int pLength = pattern.length();

        int vIndex = 0;
        int pIndex = 0;
        for (; vIndex < vLength; ) {
            if (pIndex == -1 || value.charAt(vIndex) == pattern.charAt(pIndex)) {
                vIndex++;
                pIndex++;

            } else {
                pIndex = next[pIndex];

            }

            if (pIndex == pLength) {
                return vIndex - pIndex;
            }


        }

        return -1;

    }

    private static int[] getNext(String pattern) {
        int length = pattern.length();

        int[] next = new int[length];
        next[0] = -1;

        int k = -1;
        int i = 0;

        while (i < length - 1) {
            if (k == -1 || pattern.charAt(i) == pattern.charAt(k)) {
                i++;
                k++;

                next[i] = k;
            } else {
                k = next[k];
            }

        }

        return next;


    }



}
