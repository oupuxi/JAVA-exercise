package UsualApiDemo;

import java.security.PublicKey;

public class MyToBinaryString {
    public static void main(String[] args) {
        /*

            定义一个方法自己实现toBinaryString方法的效果，将一个十进制整数转成字符串表示的二进制

         */
        int num = 4;
        String binaryString = toBinaryString(num);
        System.out.println(binaryString);
    }

    private static String toBinaryString(int num) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (num == 0) break;
            int remainder = num % 2;
            sb.insert(0,remainder);
            num/=2;
        }
        return sb.toString();
    }

}
