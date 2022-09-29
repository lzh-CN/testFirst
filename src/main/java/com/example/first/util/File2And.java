package com.example.first.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

class File2And {

    public void and() throws Exception {

        List<BufferedInputStream> fileList = new ArrayList<>();


        BufferedInputStream file = new BufferedInputStream(new FileInputStream("vedio\\1.mp3")); //路径格式：D://java//1.MP3
        BufferedInputStream files = new BufferedInputStream(new FileInputStream("vedio\\2.mp3"));
        fileList.add(file);
        fileList.add(files);
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("vedio\\out.mp3"));

        for (BufferedInputStream bufferedInputStream : fileList) {
            byte[] byt = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(byt)) != -1) {
                out.write(byt, 0, byt.length);
                out.flush();
            }
            bufferedInputStream.close();
        }

        out.close();

    }

    public static void main(String[] args) throws Exception {

        new File2And().and();

    }

}
