package com.codyy.data.test;

import org.junit.Test;

import mondrian.rolap.agg.AggregationManager;

public class MondrianCacheTest {

    
    @Test
    public void testClearCache(){
       //AggregationManager.instance().getCacheControl(null).flushSchemaCache();
        AggregationManager.instance().getCacheCellReader();
        //getCacheControl(null).flushSchemaCache();
       // AggregationManager.instance().getCacheControl(null).flushSchemaCache();
//        mondrian.rolap.RolapSchema.clearCache();     
        //使用 connection manager clear cache
    }
}
