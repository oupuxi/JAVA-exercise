package threadCase2;

public class TheadDemo {
    public static void main(String[] args) {
        /*实现步骤

                - 定义一个类MyRunnable实现Runnable接口
                - 在MyRunnable类中重写run()方法
                - 创建MyRunnable类的对象
                - 创建Thread类的对象，把MyRunnable对象作为构造方法的参数
                - 启动线程*/
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
