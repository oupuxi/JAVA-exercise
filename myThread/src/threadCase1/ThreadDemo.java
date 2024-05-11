package threadCase1;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
         * 多线程的第一种启动方式：
         *   1. 自己定义一个类继承Thread
         *   2. 重写run方法
         *   3. 创建子类的对象，并启动线程
         * */
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.setName("线程1");
        myThread2.setName("线程2");
        myThread1.start();
        myThread2.start();

    }
}
