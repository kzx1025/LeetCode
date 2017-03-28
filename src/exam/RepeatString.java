package exam;

/**
 * Created by iceke on 17/3/7.
 */
public class RepeatString {


    public static void main(String args[]){
        String test = "abcabcabc";
        String test2 = "aaaaabbaaaabb";
        System.out.println(isRepeat(test2));
    }

    private static boolean isRepeat(String value){
        int length = value.length();
        if(length<=1){
            return false;
        }

        int index1 = 0;
        int index2 = 1;
        int index3 = 0;

        char startValue = value.charAt(index1);

        for(;index2<length;index2++){
            if(value.charAt(index2)==startValue){
                int tempIndex = index2;
                for(;tempIndex+index3<length;index3++){
                    if(value.charAt(index3)==value.charAt(tempIndex+index3)){
                        if(index3 == index2){
                            index3 = 0;
                            tempIndex += index2;
                        }

                    }else{
                        index3 = 0;
                        break;
                    }

                }

                if(tempIndex+index3 == length){
                    return true;
                }



            }
        }
        return false;
    }
}
