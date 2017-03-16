package com.codyy.data.test;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;



public class GuavaTest {

    
    @Test
    public void testStringJoiner(){
        String [] args = {"a","b","c","d"};
        Assert.assertEquals(Joiner.on(",").join(args),"a,b,c,d");
    }
    
    @Test
    public void testQuatoStringJoiner(){
        String [] args = {"a,b","c,d"};
        Assert.assertEquals(Joiner.on(",").join(args),"a,b,c,d");
    }
}
