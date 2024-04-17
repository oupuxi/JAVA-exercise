package com.nwpu.doudizhu1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;


public class PokerGame {
    //牌盒
    //♥3 ♣3
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    //准备牌
    //静态代码块
    //特点：随着类的加载而在加载的，而且只执行一次。用于执行类级别的初始化操作，而不是对象级别的.想在构造方法中使用静态代码块中的成员，你可以将这些成员定义为静态的类变量或方法，然后通过类名或对象引用来访问它们。但是，直接在构造方法中访问静态代码块中的成员是不可能的。
    static {
        // "♦", "♣", "♥", "♠"
        // "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        /*for (String c : color) {
            //c依次表示每一种花色
            for (String n : number) {
                //n 依次表示每一个数字
                list.add(c + n);
            }
        }
        list.add("小王");
        list.add("大王");*/
        //编号
        int serialNumber = 1;
        for (String n : number) {
            for (String c : color) {
                hm.put(serialNumber, c + n);
                list.add(serialNumber++);

            }
            hm.put(serialNumber, "小王");
            list.add(serialNumber);
            serialNumber++;
            hm.put(serialNumber, "大王");
            list.add(serialNumber);

        }
    }



    public PokerGame() {

            //洗牌
            Collections.shuffle(list);

            //发牌
            TreeSet<Integer> lord = new TreeSet<>();
            TreeSet<Integer> player1 = new TreeSet<>();
            TreeSet<Integer> player2 = new TreeSet<>();
            TreeSet<Integer> player3 = new TreeSet<>();

            //前三张地主牌
            for (int i = 0; i < list.size(); i++) {
                int serialNumber = list.get(i);
                if (i <= 2) {
                    lord.add(serialNumber);

                }
                if (i % 3 == 0) {
                    player1.add(serialNumber);
                } else if (i % 3 == 1) {
                    player2.add(serialNumber);
                } else {
                    player3.add(serialNumber);
                }
            }


            //看牌
            lookPoker("底牌", lord);
            lookPoker("钢脑壳", player1);
            lookPoker("大帅比", player2);
            lookPoker("蛋筒", player3);


        }

        private void lookPoker (String name,TreeSet<Integer>ts){
            System.out.print(name + ": ");
            for (int serialNumber : ts) {
                String poker = hm.get(serialNumber);
                System.out.print(poker+" ");
            }
            System.out.println();
        }
    }
