package test6;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread {
    ArrayList<Integer> list;
    public MyThread(ArrayList<Integer> list) {
        this.list=list;
    }
    ArrayList<Integer>list1=new ArrayList<>();
    ArrayList<Integer>list2=new ArrayList<>();

    @Override
    public void run() {
        while (true){
            synchronized (MyThread.class){
                if (list.size()==0){
                    if (getName().equals("抽奖箱1")){
                        System.out.println("抽奖箱1"+list1);
                    }else {
                        System.out.println("抽奖箱2"+list2);
                    }
                    break;
                }else{
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    if (getName().equals("抽奖箱1")){
                        list1.add(prize);
                    }else {
                        list2.add(prize);
                    }
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
