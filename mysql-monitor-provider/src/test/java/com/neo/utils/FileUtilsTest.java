package com.neo.utils;

import static org.junit.Assert.*;

public class FileUtilsTest {

    @org.junit.Test
    public void getFiles() {
        FileUtils.getFiles("/Users/lcc/IdeaProjects/docs");
    }

    @org.junit.Test
    public void readTest() {
        String result = FileUtils.readFileByLines("/Users/lcc/IdeaProjects/docs/doc-netty/95-65-015-编码解码-解码-ByteToMessageDecoder.md");
        System.out.println(result);
    }
}