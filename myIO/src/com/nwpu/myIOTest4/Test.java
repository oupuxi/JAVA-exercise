package com.nwpu.myIOTest4;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        /*
        需求：写一个登陆小案例（添加锁定账号功能）

        步骤：
        	将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
        	保存格式为:username=zhangsan&password=123&count=0
        	让用户键盘录入用户名和密码
        	比较用户录入的和正确的用户名密码是否一致
        	如果一致则打印登陆成功
        	如果不一致则打印登陆失败，连续输错三次被锁定

        */
        BufferedReader br=new BufferedReader(new FileReader("myIO\\src\\com\\nwpu\\myIOTest4\\userInfo.txt"));
        String line = br.readLine();
        br.close();
        String[] userInfo = line.split("&");
        String[] arr1 = userInfo[0].split("=");
        String[] arr2 = userInfo[1].split("=");
        String[] arr3 = userInfo[2].split("=");

        String rightUserName=arr1[1];
        String rightPassword=arr2[1];
        int count=Integer.parseInt(arr3[1]);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号");
        String userName = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        while (true) {
            if (rightUserName.equals(userName)&&rightPassword.equals(password)&&count<3){
                System.out.println("登录成功");
                writeInfo("userName="+rightUserName+"&password="+rightPassword+"&count=0");
                break;
            }else {
                count++;
                if (count<3){
                    System.out.println("登录失败，还剩下"+(3-count)+"次机会");
                }else {
                    System.out.println("用户账户被锁定");
                    break;
                }
            }
            writeInfo("userName="+rightUserName+"&password="+rightPassword+"&count="+count);
        }

    }

    private static void writeInfo(String content)throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("myIO\\src\\com\\nwpu\\myIOTest4\\userInfo.txt"));
        bw.write(content);
        bw.close();
    }
}
