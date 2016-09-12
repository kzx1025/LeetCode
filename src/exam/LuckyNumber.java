package exam;

/**
 * Created by iceke on 16/9/5.
 */
public class LuckyNumber {
    static int[] dic= new int[100000];
    static  int[] map={0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4};
    public static long get10Sum(int num){
        int tempNum = num;
        long sum =0;
        while(tempNum != 0){
            int a = tempNum%10;
            tempNum = tempNum/10;
            sum += a;
        }
        return sum;
    }

    public static long get2Sum(int num){
       /** int  c2=0;
        int d=num&0xFFFFF;
        for (int k=0;k<5;k++){
            c2+=map[d&0x000F];
            d=d>>4;
        }
        long sum = c2;
        return sum;**/
        int i =0;
        int[] a =new int[50];
        int r= 0;
        long sum = 0;
        do{
            if(num%2==1){
                r=1;
            }
            else {
                r=0;
            }
            a[i]=r;
            sum+=a[i];
            num=num/2;
            i++;
        }while(num>0);
        return sum;
    }

    public static boolean isNumEqual(int a){
        if(dic[a] == 1){
            return true;
        }else if(dic[a] == -1){
            return false;
        }else {
            if (get2Sum(a) == get10Sum(a)) {
                dic[a] = 1;
                return true;
            } else {
                dic[a] = -1;
                return false;
            }
        }
    }
    public static void main(String args[]) {
        /**Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            Scanner n = new Scanner(System.in);
            nums.add(n.nextInt());
        }
        long start = System.currentTimeMillis();
        for (int a : nums) {
            int sum = 0;
            while (a >= 0) {
                if (isNumEqual(a)) {
                    sum++;
                }
                a--;
            }

            System.out.println(sum);

        }
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start));**/
        long start= System.currentTimeMillis();
        for (int k=0;k<10000;k++) {
            for (int i = 0; i < 100000; i++) {
                isNumEqual(i);
            }
        }
        long end=System.currentTimeMillis();
        System.out.println((end-start)/1000);
    }

}
