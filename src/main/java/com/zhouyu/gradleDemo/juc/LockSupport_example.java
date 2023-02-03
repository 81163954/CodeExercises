package com.zhouyu.gradleDemo.juc;

public class LockSupport_example {
//    public static void main(String[] args) throws InterruptedException {
//
//        List<Integer> list = new LinkedList<>();
//        Thread t1 = null,t2 = null;
//
//        t2 = new Thread(() -> {
//            System.out.println("t2 start..");
//                LockSupport.park();
//            System.out.println("t2 end..");
//            LockSupport.unpark(t1);//当前版本会报错
//        }, "t2");
//        t1 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                list.add(i);
//                System.out.println("t1: add " + i);
//                if (list.size() == 5) {
//                    LockSupport.unpark(t2);
//                    LockSupport.park();
//                }
//                //这里不sleep可能会出问题，因为thread1只是去unpark(t2)，但是自己没有停止，
//                //解决方法：t1运行到size=5时park(t1)，unpark(t2),t2运行完再unpark(t1)
////                try {
////                    TimeUnit.SECONDS.sleep(1);
////                } catch (InterruptedException e) {
////                    throw new RuntimeException(e);
////                }
//            }
//        }, "t1");
//
//        t2.start();
//        TimeUnit.SECONDS.sleep(1);
//        t1.start();
//    }
}
