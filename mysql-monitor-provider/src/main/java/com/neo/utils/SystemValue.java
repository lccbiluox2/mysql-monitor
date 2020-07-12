package com.neo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SystemValue {
    /**
     * 使用System获取系统相关的值
     */
    public static void getSystemProperties() {
        Properties pp = System.getProperties();
        java.util.Enumeration en = pp.propertyNames();
        while (en.hasMoreElements()) {
            String nextE = (String) en.nextElement();
            System.out.print(nextE + "=" + pp.getProperty(nextE));
        }
    }

    public static String getCustomProperties(String key) {
        Map<String,String> map = getEnv();
        return map.get(key);
    }

    public static Map getEnv() {
        Map<String,String> map = new HashMap();
        Process p = null;
        Runtime r = Runtime.getRuntime();
        String OS = System.getProperty("os.name").toLowerCase();
        try {
            if (OS.indexOf("windows 9") > -1) {
                p = r.exec("command.com /c set");
            } else if ((OS.indexOf("nt") > -1)
                    || (OS.indexOf("windows 20") > -1)
                    || (OS.indexOf("windows xp") > -1)) {
                p = r.exec("cmd.exe /c set");
            } else {
                // Unix
                p = r.exec("env");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(p
                    .getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split("=");
                if(2  <= str.length ){
                    map.put(str[0], str[1]);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return map;
    }


}