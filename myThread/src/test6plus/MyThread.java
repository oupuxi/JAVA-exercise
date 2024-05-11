package test6plus;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread{
    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        ArrayList<Integer> boxList = new ArrayList<>();
        while (true) {
            synchronized (MyThread.class){
                if (list.size() == 0) {
                    System.out.println(getName()+boxList);
                    Integer max = Collections.max(boxList);
                    int sum = boxList.stream().mapToInt(Integer::intValue).sum();
                    System.out.println("max:"+max);
                    System.out.println("sum:"+sum);
                    break;
                }else {
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    boxList.add(prize);
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
