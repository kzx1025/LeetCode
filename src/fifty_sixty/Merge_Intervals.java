package fifty_sixty;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by iceke on 17/1/10.
 */
public class Merge_Intervals {
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String args[]){

        List<Interval> init = new ArrayList<Interval>();
        init.add(new Interval(1,3));
        init.add(new Interval(2,6));
        init.add(new Interval(8,10));
        init.add(new Interval(15,18));

        List<Interval> results = merge(init);

        for(Interval result: results){
            System.out.print(result.start+","+result.end);

            System.out.print(" ");
        }


    }

    public static List<Interval> merge(List<Interval> intervals) {
        int length = intervals.size();
        List<Interval> results = null;
        List<Interval> tempResults = new ArrayList<Interval>();
        tempResults.add(intervals.get(0));

        for(int i =1;i<length;i++){
            Interval interval = intervals.get(i);
            for(int j =0;j<tempResults.size();j++){
               // if(tempResults)
            }
        }



        for(int i =1;i<length;i++){
            Interval temp = intervals.get(i);
            results = new ArrayList<Interval>(tempResults);
            tempResults.clear();
            for(Interval result:results){
                if(result.start<temp.start){
                    if(result.end<temp.start){
                        tempResults.add(temp);
                        break;
                    }else if(result.end>= temp.start&&result.end <=temp.end){
                        result.end = temp.end;
                    }
                }else if(result.start>=temp.start&&result.start<=temp.end){
                    if(result.end<=temp.end){
                        result.start =temp.start;
                        result.end =temp.end;
                    }else{
                        result.start = temp.start;
                    }

                }else{
                    tempResults.add(temp);
                    break;
                }

            }

            tempResults.addAll(results);

        }

        results = tempResults;
        return results;


    }
}
