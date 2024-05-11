package test1;

public class MyThread extends Thread{
    static int ticket=5;
    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (ticket == 0) {
                    break;
                }else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket--;
                    System.out.println(getName() + "在卖票，还剩下" + ticket + "张票!!!");

                }
            }
        }

    }
}
