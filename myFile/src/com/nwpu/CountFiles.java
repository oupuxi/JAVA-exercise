package com.nwpu;

import com.sun.jdi.Value;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountFiles {
    public static void main(String[] args) throws IOException {
        /*
            需求：统计一个文件夹中每种文件的个数并打印。（考虑子文件夹）
         */
        File file = new File("myFile\\aaa");
        HashMap<String,Integer> hm=getCount(file);
        System.out.println(hm);
    }

    private static HashMap<String, Integer> getCount(File src) {
        HashMap<String, Integer> hm = new HashMap<>();
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()){
                String name = file.getName();
                String[] arr = name.split("\\.");
                if(arr.length>=2){
                    String endName = arr[arr.length - 1];
                    if(hm.containsKey(endName)){
                        int count = hm.get(endName);
                        count++;
                        hm.put(endName,count);
                    }else {
                        hm.put(endName,1);
                    }
                }
            }else {
                HashMap<String, Integer> sonMap = getCount(file);
                //法一
                /*Set<Map.Entry<String, Integer>> entries = sonMap.entrySet();
                for (Map.Entry<String, Integer> entry : entries) {
                    String key = entry.getKey();
                    int value = entry.getValue();
                    if(hm.containsKey(key)){
                        int count = hm.get(key);
                        count+=value;
                        hm.put(key,count);
                    }else {
                        hm.put(key,value);
                    }
                }*/
                //法二，getOrDefault()如果 key 存在于 Map 中，则返回该键对应的值；如果 key 不存在，则返回 defaultValue。
                sonMap.forEach((key, Value)->hm.put(key,hm.getOrDefault(key,0)+Value));

            }
        }
        return hm;
    }

}
