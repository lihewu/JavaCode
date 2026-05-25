public class ThreadDemo {
    /**
     * 方法一:继承Thread类
     */
    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(" extends Thread ");
        }
    }

    /**
     * 方法二:继承Runnable接口
     */
    class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(" implements Runnable ");
        }
    }
}

//import java.util.Random;
//public class ThreadDemo {
//    private static class MyThread extends Thread {
//        @Override
//        public void run() {
//            Random random = new Random();
//            while (true) {
//                //打印线程名称
//
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    //随机停⽌运⾏0-9秒
//                    Thread.sleep(random.nextInt(10));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        MyThread t1 = new MyThread();
//        t1.start();
//        Random random = new Random();
//        while (true) {
//            //打印线程名称
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(random.nextInt(10));
//            } catch (InterruptedException e) {
//                //随机停⽌运⾏0-9秒
//
//                e.printStackTrace();
//            }
//        }
//    }
//}