package thirty_forty;

/**
 * Created by iceke on 16/12/16.
 */
public class Trapping_Rain_Water {

    public static void main(String args[]) {
        System.out.println(trap(new int[]{9,6,8,8,5,6,3}));

    }

    public static int trap(int[] height) {
        int n = height.length;
        int sum=0;
        int maxHeight = 0;
        int maxleft=0, maxright=0;
        for(int i =0 ;i<n;i++){
            if(height[i]>=height[maxHeight]){
                maxHeight = i;
            }

        }

        maxleft = 0;
        for(int i =1;i<maxHeight;i++){
            if(height[i]<height[maxleft]){
                sum+=height[maxleft]-height[i];
            }else{
                maxleft = i;
            }

        }

        maxright = n-1;
        for(int i = n-2;i>=maxHeight;i--){
            if(height[i]<height[maxright]){
                sum+=height[maxright]-height[i];
            }else{
                maxright = i;
            }
        }

        return sum;

       /** int length = height.length;
        if(length<=2){
            return 0;
        }

        int sum = 0;


        //height[length] = 0

        int start = 0;
        int end = 0;
        boolean firstXiaPo = true;
        boolean xiapo =false;
        int poTime = 0;
        int tempEnd = 0;
        for (int i = 0; i < length; ) {
            int value = height[i];
            if ( i + 1 < length&&value > height[i + 1]) {

                if (poTime % 2 == 0) {
                    if (firstXiaPo) {
                        start = i;
                        firstXiaPo = false;
                        poTime += 1;
                    }
                    i++;
                } else if (poTime % 2 == 1 && !xiapo) {
                    //终点处的高度必须要高于起始点
                    if(height[i]>=height[tempEnd]){
                        tempEnd = i;
                    }
                    if(height[i]>=height[start]) {
                        end = i;
                        firstXiaPo = true;
                        poTime += 1;
                        sum += calculate(height, start, end);
                    }

                }else {
                    i++;
                }
                xiapo = true;

            }else if (i+1 == length){
                if(tempEnd>start&&height[i]<height[tempEnd]){
                    end = tempEnd;
                }else {
                    end = length - 1;
                }
                sum += calculate(height, start, end);
                i++;
            }else {
                i++;
                xiapo = false;
            }
        }


        return sum;
        **/
    }

    public static int calculate(int[] height, int start, int end) {
        int finalHeight = height[start]>height[end]?height[end]:height[start];
        int totalSum = finalHeight*(end-start-1);
        int unuseSum =0;
        for(int i =start+1;i<end;i++){
            if(height[i]>finalHeight){
                unuseSum+=finalHeight;
            }else {
                unuseSum += height[i];
            }
        }

        return totalSum-unuseSum;

    }
}
