package twenty_thirty.Substring_with_Concatenation_of_All_Words;

import java.util.*;

/**
 * Created by iceke on 16/12/12.
 * 因为words中的单词可能有重复，所以要有一个dict来记录一下每个字符串的数目。然后在遍历原字符串的时候，
 * 只需要遍历单词的长度次即可，如"barfoothefoobarman"，因为目标单词的长度为3，所以只需遍历：
 'bar' | 'foo' | 'the' | 'foo' | 'bar' | 'man'
 'arf' | 'oot' | 'hef' | 'oob' | 'arm'
 'rfo' | 'oth' | 'efo' | 'oba' | 'rma'
 在遍历时，需要两个指针，一个用来标记子字符串的开始，另一个用来标记子字符串的结束。
 再用一个dict来记录当前字符串中单词的数量，如果下一个单词不在words中，那么清空该dict，把前指针直接跳到后指针处；
 如果在words中，那么相应的键值要加一，此时如果那个单词的数量超过了目标中的数目，那么前指针要不断后移直到吐出一个那个单词。
 通过前后指针之差是否等于所有目标单词长度之和来判断是否有目标子字符串。
 */
public class Solution {
    public static void main(String args[]) {
        String s = "wordgoodgoodgoodbestword";
        String[] patterns = {"word","good","best","good"};
        System.out.println(findSubstring(s, patterns));

    }


    public static List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        List<Integer> results = new ArrayList<Integer>();
        int wordsNum =words.length;

        Map<String, Integer> originMap = new HashMap<String, Integer>();
        Map<String, Integer> curMap = null;
        for (String word : words) {
            if (originMap.containsKey(word)) {
                int tempValue = originMap.get(word) + 1;
                originMap.put(word, tempValue);
            } else {
                originMap.put(word, 1);
            }

        }

        for(int index = 0;index<wordLength;index+=1){
            int prev = index;
            int after = index;
            curMap = new HashMap<String, Integer>();
            while(after<s.length()-wordLength+1){
                String tempWord = s.substring(after,after+wordLength);
                if (originMap.containsKey(tempWord)) {
                    if (curMap.containsKey(tempWord)) {
                        int num = curMap.get(tempWord) + 1;
                        if(num>originMap.get(tempWord)){
                            prev+=wordLength;
                            after = prev;
                            curMap.clear();
                        }else {
                            curMap.put(tempWord, num);
                            after+=wordLength;
                        }
                    } else {
                        curMap.put(tempWord, 1);
                        after+=wordLength;
                    }

                }else{
                    prev+=wordLength;
                    after = prev;
                    curMap.clear();
                }

                if(curMap.size() == originMap.size()&&(after-prev == wordsNum*wordLength)){
                    results.add(prev);
                    curMap.clear();
                    prev = prev+wordLength;
                    after = prev;
                }


            }


        }

        return results;

    }


    //time limit succeed
    public static List<Integer> findSubstring2(String s, String[] words) {
        //return null;
        List<Integer> results = new ArrayList<Integer>();
        int wordLength = words[0].length();
        Map<String, Integer> originMap = new HashMap<String, Integer>();
        Map<String, Integer> wordsMap = null;
        for (String word : words) {
            if (originMap.containsKey(word)) {
                int tempValue = originMap.get(word) + 1;
                originMap.put(word, tempValue);
            } else {
                originMap.put(word, 1);
            }

        }

        int index = 0;

        while (index < s.length() - words.length * wordLength+1) {
            int tempIndex = index;
            wordsMap = new HashMap<String, Integer>(originMap);
            String tempValue = s.substring(tempIndex, tempIndex + words.length * wordLength);
            for (int i = 0; i < tempValue.length() - wordLength + 1; i += wordLength) {
                String oneWord = tempValue.substring(i, i + wordLength);
                if (wordsMap.containsKey(oneWord)) {
                    int num = wordsMap.get(oneWord) - 1;
                    if (num == 0) {
                        wordsMap.remove(oneWord);
                    } else {
                        wordsMap.put(oneWord, num);
                    }

                } else {
                    break;
                }
            }

            if (wordsMap.size() == 0) {
                results.add(tempIndex);
            } else {
                wordsMap.clear();
            }
            index++;
        }

        return results;

    }


    public static int search(String haystack, String needle) {

        int totalLength = haystack.length();
        int patternLength = needle.length();

        if (patternLength == 0) {
            return 0;
        }
        if (patternLength > totalLength) {
            return -1;
        }

        int[] next = getNext(needle);

        int i = 0, j = 0;

        while (i < totalLength && j < patternLength) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                //不从0开始
                j = next[j];
            }

        }

        /**
         for(int i = 0;i<totalLength-patternLength+1;i++){
         int tempI = i;
         for(int j = 0;j<patternLength;j++,tempI++){
         if(haystack.charAt(tempI)!=needle.charAt(j)){
         i+=next[j+1];
         break;
         }
         if(j==patternLength-1){
         return i;
         }

         }

         }
         **/
        //return -1;
        return j == patternLength ? i - patternLength : -1;

    }

    public static int[] getNext(String b) {
        int len = b.length();
        int j = 0;

        int next[] = new int[len + 1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
        next[0] = next[1] = 0;

        for (int i = 1; i < len; i++)//i表示字符串的下标，从0开始
        {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
            if (j > 0 && b.charAt(i) != b.charAt(j)) j = 0;
            if (b.charAt(i) == b.charAt(j)) j++;
            next[i + 1] = j;
        }

        return next;
    }

}
