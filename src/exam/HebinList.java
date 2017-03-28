package exam;

import java.util.*;

/**
 * Created by iceke on 17/3/2.
 */
public class HebinList {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }


    public static void main(String ags[]){
        System.out.println(trasFormWord("Aabb"));
    }


    public static String trasFormWord(String sen){

    final String sq = sen;
    int len = sen.length();

    //int[] dic = new int[len];

    Map<String,Integer> map = new HashMap<String,Integer>();

    //put in map
    for(int i =0;i<len;i++) {
        String temp = sen.substring(i, i + 1);
        if (!map.containsKey(temp)) {
            map.put(temp, 1);
        } else {
            int count = map.get(temp);
            map.put(temp, count + 1);

        }
    }

        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>();
        list.addAll(map.entrySet());

        //也可以TreeMap

        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){

            public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2){
                if(e2.getValue().equals(e1.getValue())){
                    return sq.indexOf(e1.getKey()) - sq.indexOf(e2.getKey());
                }else{
                    return e2.getValue() - e1.getValue();
                }


            }
        });


        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> e:list){
            String key = e.getKey();
            int times = map.get(key);
            for(int j = 0;j<times;j++){
                sb.append(key);
            }
        }

        return sb.toString();


    }




















    public static ListNode mergeTwo(ListNode n1,ListNode n2){
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(n1!=null||n2!=null){
            if(n1!=null&&n2!=null){
                if(n1.val<n2.val){
                    p.next = n1;
                    n1 = n1.next;
                }else{
                    p.next = n2;
                    n2 = n2.next;
                }
                p = p.next;
            }else if(n2 ==null){
                p.next = n1;
                break;
            }else if(n1 == null){
                p.next = n2;
                break;
            }
        }
        return head.next;
    }
}
