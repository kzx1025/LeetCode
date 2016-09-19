package exam;

import java.util.*;

/**
 * Created by iceke on 16/9/18.
 */
public class Huffman {
    public static void main(String args[]){
        Map<String,List<Character>> dic = new HashMap<String,List<Character>>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //input = "00011001111010101101110110011";

        int table_num = Integer.parseInt(sc.nextLine());
        int maxLength = 0;
        for(int i = 0;i<table_num;i++){
            String line = sc.nextLine();
            String[] text = line.split(" ");
            List<Character> temp= new ArrayList<Character>();
            temp.add(text[0].toCharArray()[0]);
            if(dic.containsKey(text[1])){
                List oldList = dic.get(text[1]);
                oldList.add(text[0].toCharArray()[0]);
                dic.put(text[1],oldList);
            }else {
                dic.put(text[1], temp);
            }
            if(text[1].length()>maxLength){
                maxLength = text[1].length();
            }
        }

       // String input = "00011001111010101101110110011";//neteasegame
        List<String> results = new ArrayList<String>();
        results.add("");
        String firstCode = "";
        while(input.length()!=0){
            if(input.length()>=1){
                firstCode+=input.substring(0,1);
                input = input.substring(1);
            }
            if(firstCode.length() == maxLength){
                List<Character> values = null;
                boolean inDic = true;
                if(dic.containsKey(firstCode)){
                   values = dic.get(firstCode);
                }else{
                    values = dic.get("*");
                    inDic = false;
                }
                List<String> newResults = new ArrayList<String>();
                for(String result:results){
                    if(result.equals("netease")){
                        int l =1;
                    }
                    if(!inDic){//不在字典中
                        List<Character> newValues = new ArrayList<Character>();
                        for(char value:values){
                            if(!result.contains(Character.toString(value))){
                                newValues.add(value);
                            }
                        }
                        for(char value:newValues) {
                            //if(!inDic&&!result.contains(Character.toString(value))||inDic) {
                            String tempResult = result;
                            tempResult += value;
                            // System.out.println(tempResult);
                            newResults.add(tempResult);

                        }

                    }else{
                        for(char value:values) {
                            //if(!inDic&&!result.contains(Character.toString(value))||inDic) {
                            String tempResult = result;
                            tempResult += value;
                            // System.out.println(tempResult);
                            newResults.add(tempResult);

                        }
                    }

                }
                results = newResults;
                firstCode = "";
            }
            if(dic.containsKey(firstCode)){
                List<Character> values = dic.get(firstCode);
                List<String> newResults = new ArrayList<String>();
                for(String result:results){
                    for(char value:values) {
                        String tempResult = result;
                        tempResult += value;
                       // System.out.println(tempResult);
                        newResults.add(tempResult);
                    }
                }
                results = newResults;
                firstCode = "";

            }
        }
        Collections.sort(results);

        for(String result : results){
            System.out.println(result);
        }

    }
}
