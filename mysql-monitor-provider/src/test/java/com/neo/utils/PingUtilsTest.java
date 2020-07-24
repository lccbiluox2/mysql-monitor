package com.neo.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class PingUtilsTest {

    @Test
    public void isHostConnectableTest(){
        System.out.println(PingUtils.isHostConnectable("192.168.30.226",13306));
        System.out.println(PingUtils.isHostConnectable("localhost",3306));
    }
}