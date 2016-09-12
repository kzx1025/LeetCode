package exam;

/**
 * Created by iceke on 16/9/12.
 */
public class Huiwen {

    public static void main(String args[]){

            int[] data = {1,2,21};

            int i1 = 0;
            int i2 = data.length - 1;
            int head = data[i1];
            int tail = data[i2];
            int result = 0;
            while (i2 > i1) {
                if (head == tail) {
                    i1++;
                    i2--;
                    if (i2 > i1) {
                        head = data[i1];
                        tail = data[i2];
                    }
                } else if (head > tail) {
                    i2--;
                    tail += data[i2];
                    result++;
                } else {
                    i1++;
                    head += data[i1];
                    result++;
                }
            }
            if (head != tail)
                result++;

          System.out.println(result);
        }
    }
