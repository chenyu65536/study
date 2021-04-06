package com.rain;

import com.sun.tools.internal.jxc.SchemaGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/5/15 4:50 下午
 */
public class Test {

    public static void readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                System.out.println(tempStr.replaceAll("\t",","));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        Thread thread = new Thread();
        thread.interrupt();

        ThreadLocal<Long> a = new ThreadLocal<>();
        a.set(10L);

    }


}
