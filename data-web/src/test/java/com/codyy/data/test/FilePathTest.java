package com.codyy.data.test;

import java.io.File;
import java.net.URI;

import org.junit.Test;

public class FilePathTest {

    @Test
    public void testFilePath(){
        URI uri = new File("./").toURI();
    }
}
