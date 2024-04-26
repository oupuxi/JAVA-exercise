package com.nwpu.myIOTest3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        /*
        需求：写一个登陆小案例。

        步骤：
            将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
            保存格式为:username=zhangsan&password=123
            让用户键盘录入用户名和密码
                    比较用户录入的和正确的用户名密码是否一致
            如果一致则打印登陆成功
                    如果不一致则打印登陆失败
        */
        BufferedReader br = new BufferedReader(new FileReader("myIO\\src\\com\\nwpu\\myIOTest3\\userInfo.txt"));
        String line = br.readLine();
        br.close();
        System.out.println(line);
        String[] userInfo = line.split("&");
        String[] arr1 = userInfo[0].split("=");
        String[] arr2 = userInfo[1].split("=");
        String rightUserName = arr1[1];
        String rightPassword = arr2[1];

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String userName = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        if (rightUserName.equals(userName)&&rightPassword.equals(password)){
            System.out.println("登录成功");

        }else {
            System.out.println("登录失败");
        }

    }
}
