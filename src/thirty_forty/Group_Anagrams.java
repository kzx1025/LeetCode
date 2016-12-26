package thirty_forty;

import java.util.*;

/**
 * Created by iceke on 16/12/26.
 */
public class Group_Anagrams {

    public static void main(String args[]) {

        System.out.println(groupAnagrams(new String[]{"a", ""}));

    }

    //用数组太容易发生冲突了 还是用key妥协
    public static List<List<String>> groupAnagrams(String[] strs) {

        int length = strs.length;
        Map<String,List<String>> dics = new HashMap<String,List<String>>();
        for (int i = 0; i < length; i++) {
            char[] value = strs[i].toCharArray();
            Arrays.sort(value);

            String key = String.valueOf(value);



            if (dics.get(key) == null) {
                List<String> links = new ArrayList<String>();
                links.add(strs[i]);
                dics.put( key, links);
            } else {
                List<String> links = dics.get(key);
                links.add(strs[i]);
            }
        }

        List<List<String>> results = new ArrayList<List<String>>();
        for (String key:dics.keySet()) {
            results.add(dics.get(key));
        }

        return results;

    }
}
