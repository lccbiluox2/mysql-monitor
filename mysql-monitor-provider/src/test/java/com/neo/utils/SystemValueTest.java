package com.neo.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class SystemValueTest {

    @Test
    public void get(){
        // getSystemProperties();
        String aa = SystemValue.getCustomProperties("MYSQL_HOME");
        System.out.println(aa.toString());
    }

}