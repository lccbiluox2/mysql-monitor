package com.neo.component;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasicFormatterImplTest {


    public static void main(String[] args) {
        System.out.println(new BasicFormatterImpl()
                .format("select aa,bb,cc,dd from ta1,(select ee,ff,gg from ta2 where ee=ff) ta3 where aa=bb and cc=dd group by dd order by createtime desc limit 3 "));
    }
}