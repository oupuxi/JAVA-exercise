package com.nwpu.doudizhu1;

import java.util.ArrayList;

public class PokerGame {
    //牌盒
    //♥3 ♣3
    static ArrayList<String> list = new ArrayList<>();
    //准备牌
    //静态代码块
    //特点：随着类的加载而在加载的，而且只执行一次。用于执行类级别的初始化操作，而不是对象级别的.想在构造方法中使用静态代码块中的成员，你可以将这些成员定义为静态的类变量或方法，然后通过类名或对象引用来访问它们。但是，直接在构造方法中访问静态代码块中的成员是不可能的。
    static {
        // "♦", "♣", "♥", "♠"
        // "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for (String c : color) {
            //c依次表示每一种花色
            for (String n : number) {
                //n 依次表示每一个数字
                list.add(c+n);
            }
        }
        list.add("小王");
        list.add("大王");
    }

    public PokerGame() {
        System.out.println(list);

        //洗牌

        //发牌

        //看牌


    }
}
