package com.ruoyi.ruoyiforts.controller;

import org.springframework.stereotype.Component;

import java.io.File;

public class TestTask {

    public static void main(String[] args) {
        File file = new File("E:\\haha");  //  /Users是路径名
        delete(file);
    }

    public static void delete(File f) {
        //数组指向文件夹中的文件和文件夹
        File[] fi = f.listFiles();
        //遍历文件和文件夹
        for (File file : fi) {
            //如果是文件夹，递归查找
            if (file.isDirectory())
                delete(file);
            else if (file.isFile()) {
                //是文件的话，把文件名放到一个字符串中
                String filename = file.getName();
                //如果是“class”后缀文件，返回一个boolean型的值
                if (filename.endsWith("ok")) {
                    System.out.println("成功删除：：" + file.getName());
                    file.delete();
                }
            }
        }
    }


}
