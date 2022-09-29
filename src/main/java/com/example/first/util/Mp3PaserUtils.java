package com.example.first.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Mp3PaserUtils {


    public static void main(String[] args) throws Exception {
        List<String> fileList =new ArrayList<>();
        fileList.add("vedio\\1.mp3");
        fileList.add("vedio\\2.mp3");
        fileList.add("vedio\\3.mp3");
        create(fileList);
    }

    public static String create(List<String> fileList) throws Exception {
        String path = "vedio\\test1.mp3"; // 输出目录 & 文件名
        String[] ss = new String[fileList.size()];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = fileList.get(i);
        }
        combine(path, ss);
        return path;
    }


    private static boolean combine(String outFile, String[] inFiles) throws Exception {
        File out = new File(outFile);
        File[] files = new File[inFiles.length];
        for (int i = 0; i < files.length; i++) {
            files[i] = new File(inFiles[i]);
        }
        FileOutputStream fos = new FileOutputStream(outFile, true); // 合并其实就是文件的续写,写成true
        for (int i = 0; i < files.length; i++) {
            FileInputStream fis = new FileInputStream(files[i]);
            int len = 0;
            for (byte[] buf = new byte[1024 * 1024]; (len = fis.read(buf)) != -1; ) {
                fos.write(buf, 0, len);
            }
            fis.close();
            files[i].delete();
        }
        fos.close();
        return true;
    }

}
