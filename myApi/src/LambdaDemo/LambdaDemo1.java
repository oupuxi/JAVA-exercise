package LambdaDemo;

import java.util.Arrays;

public class LambdaDemo1 {
    public static void main(String[] args) {
        /*
            定义数组并存储一些字符串。利用Arrays中的sort方法进行排序
            要求:
                按照字符中的长度进行排序，短的在前面，长的在后面，
                (暂时不比较字符串里面的内容)
        */
        String[] arr = {"a", "aaaa", "aaa", "aa"};
        /*Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.length()-o2.length();
            }
        });*/
        //Lambda
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(arr));

    }
}
