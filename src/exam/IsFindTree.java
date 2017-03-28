package exam;

/**
 * Created by iceke on 17/3/1.
 */
public class IsFindTree {

    class Number {
        boolean flag;
        int num=1;
    }


    class PrintThread1 implements Runnable {
        Number number;

        public PrintThread1(Number number) {
            this.number = number;
        }


        public void run() {
            while (number.num <= 100) {
                synchronized (number) {
                    if (number.flag) {
                        try {
                           Thread.yield();
                        } catch (Exception e) {

                        }

                    } else {
                        System.out.println("输出奇数:" + number.num);
                        number.num++;

                        number.flag = true;
//防止线程再运行，阻塞

                        number.notify();

                    }
                }
            }


        }
    }


    class PrintThread2 implements Runnable {
        Number number;

        public PrintThread2(Number number) {
            this.number = number;
        }


        public void run() {
            while (number.num <= 100) {
                synchronized (number) {
                    if (!number.flag) {
                        try {
                           Thread.yield();
                        } catch (Exception e) {

                        }

                    } else {
                        System.out.println("输出偶数:" + number.num);
                        number.num++;

                        number.flag = false;
//防止线程再运行，阻塞

                        number.notify();

                    }
                }
            }


        }
    }


    public void qu(){
        Number number = new Number();

        PrintThread1 t1 = new PrintThread1(number);
        PrintThread2 t2 = new PrintThread2(number);

        new Thread(t1).start();
        new Thread(t2).start();


    }
    public static void main(String ars[]){
        IsFindTree isFindTree = new IsFindTree();
        isFindTree.qu();


    }



}
