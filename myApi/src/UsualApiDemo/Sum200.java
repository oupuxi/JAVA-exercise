package UsualApiDemo;

import java.util.ArrayList;
import java.util.Scanner;

public class Sum200 {
    public static void main(String[] args) {
        /*
            键盘录入一些1~10日之间的整数，并添加到集合中。直到集合中所有数据和超过200为止。
        */
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");

        while (true) {
            String numStr = sc.nextLine();
            int num = Integer.parseInt(numStr);
            if (num < 1 || num > 100) {
                System.out.println("当前数字不在1~100的范围当中，请重新输入");
                continue;
            }
            list.add(num);
            int sum = getSum(list);
            if (sum >= 200) {
                System.out.println("集合中所有的数据和已经满足要求，和为" + sum);
                break;
            }
        }


    }

    private static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;


    }
}
