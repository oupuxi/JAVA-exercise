public class MyParseInt {
    public static void main(String[] args) {
        /*
            自己实现parseInt方法的效果，将字符串形式的数据转成整数。
            要求:
            字符串中只能是数字不能有其他字符最少一位，
            最多10位日不能开头
        */
        String str = "123";
        if (!str.matches("^[1-9][0-9]{0,9}$")) {
            System.out.println("数据格式有误");
        } else {
            int number = 0;
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i) - '0';
                number = number * 10 + c;
            }
            System.out.println(number);
            System.out.println(number+1);
        }


    }


}
