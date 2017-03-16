package com.codyy.data.test;


import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.codyy.data.sqlparse.SqlHeper;
import com.google.common.collect.Maps;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring/applicationContext-test.xml"})   
public class MybatisSqlTest {

    @Test
    public void testCall(){
        Assert.notNull("start test","begin to test");
    }
    
    @Test
    public void testGetSql(){
        Map<String,String> map = Maps.newHashMap(); 
        map.put("name", "myname");
        String sql = SqlHeper.getSqlById("count", map);
        System.out.println(sql);
    }
}


