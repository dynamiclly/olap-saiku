package com.codyy.data.test;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.saiku.olap.query2.ThinQuery;

import com.alibaba.fastjson.JSON;

public class QueryJsonTest {

    private String json = "";
    
    @Before
    public void setUp(){
        json = "{\"name\": \"B143D080-5ADF-CC36-A5B1-CBDD1BD3A4F5\"," + "\n" + 
                "   \"queryModel\": {" + "\n" + 
                "       \"axes\": {" + "\n" + 
                "           \"FILTER\": {" + "\n" + 
                "               \"mdx\": null," + "\n" + 
                "               \"filters\": []," + "\n" + 
                "               \"sortOrder\": null," + "\n" + 
                "               \"sortEvaluationLiteral\": null," + "\n" + 
                "               \"hierarchizeMode\": null," + "\n" + 
                "               \"location\": \"FILTER\"," + "\n" + 
                "               \"hierarchies\": []," + "\n" + 
                "               \"nonEmpty\": false," + "\n" + 
                "               \"name\": \"FILTER\"," + "\n" + 
                "               \"aggregators\": []" + "\n" + 
                "           }," + "\n" + 
                "           \"COLUMNS\": {" + "\n" + 
                "               \"mdx\": null," + "\n" + 
                "               \"filters\": []," + "\n" + 
                "               \"sortOrder\": null," + "\n" + 
                "               \"sortEvaluationLiteral\": null," + "\n" + 
                "               \"hierarchizeMode\": null," + "\n" + 
                "               \"location\": \"COLUMNS\"," + "\n" + 
                "               \"hierarchies\": []," + "\n" + 
                "               \"nonEmpty\": true," + "\n" + 
                "               \"name\": \"COLUMNS\"," + "\n" + 
                "               \"aggregators\": []" + "\n" + 
                "           }," + "\n" + 
                "           \"ROWS\": {" + "\n" + 
                "               \"mdx\": null," + "\n" + 
                "               \"filters\": []," + "\n" + 
                "               \"sortOrder\": null," + "\n" + 
                "               \"sortEvaluationLiteral\": null," + "\n" + 
                "               \"hierarchizeMode\": null," + "\n" + 
                "               \"location\": \"ROWS\"," + "\n" + 
                "               \"hierarchies\": [{" + "\n" + 
                "                   \"name\": \"[product].[h_product]\"," + "\n" + 
                "                   \"levels\": {" + "\n" + 
                "                       \"product type\": {" + "\n" + 
                "                           \"name\": \"product type\"" + "\n" + 
                "                       }" + "\n" + 
                "                   }," + "\n" + 
                "                   \"cmembers\": {" + "\n" + 
                "                       " + "\n" + 
                "                   }" + "\n" + 
                "               }]," + "\n" + 
                "               \"nonEmpty\": true," + "\n" + 
                "               \"name\": \"ROWS\"," + "\n" + 
                "               \"aggregators\": []" + "\n" + 
                "           }" + "\n" + 
                "       }," + "\n" + 
                "       \"visualTotals\": false," + "\n" + 
                "       \"visualTotalsPattern\": null," + "\n" + 
                "       \"lowestLevelsOnly\": false," + "\n" + 
                "       \"details\": {" + "\n" + 
                "           \"axis\": \"COLUMNS\"," + "\n" + 
                "           \"location\": \"BOTTOM\"," + "\n" + 
                "           \"measures\": [{" + "\n" + 
                "               \"name\": \"sales amount\"," + "\n" + 
                "               \"type\": \"EXACT\"" + "\n" + 
                "           }]" + "\n" + 
                "       }," + "\n" + 
                "       \"calculatedMeasures\": []," + "\n" + 
                "       \"calculatedMembers\": []" + "\n" + 
                "   }," + "\n" + 
                "   \"queryType\": \"OLAP\"," + "\n" + 
                "   \"type\": \"QUERYMODEL\"," + "\n" + 
                "   \"cube\": {" + "\n" + 
                "       \"uniqueName\": \"[mondrian_source].[Sauce Dallas schema].[Sauce Dallas schema].[Sales]\"," + "\n" + 
                "       \"name\": \"Sales\"," + "\n" + 
                "       \"connection\": \"mondrian_source\"," + "\n" + 
                "       \"catalog\": \"Sauce Dallas schema\"," + "\n" + 
                "       \"schema\": \"Sauce Dallas schema\"," + "\n" + 
                "       \"caption\": null," + "\n" + 
                "       \"visible\": false" + "\n" + 
                "   }," + "\n" + 
                "   \"mdx\": null," + "\n" + 
                "   \"parameters\": {" + "\n" + 
                "       " + "\n" + 
                "   }," + "\n" + 
                "   \"plugins\": {" + "\n" + 
                "       " + "\n" + 
                "   }," + "\n" + 
                "   \"properties\": {" + "\n" + 
                "       \"saiku.olap.query.automatic_execution\": true," + "\n" + 
                "       \"saiku.olap.query.nonempty\": true," + "\n" + 
                "       \"saiku" + "\n" + 
                ".olap.query.nonempty.rows\": true," + "\n" + 
                "       \"saiku.olap.query.nonempty.columns\": true," + "\n" + 
                "       \"saiku.ui.render.mode\": \"table\"," + "\n" + 
                "       \"saiku.olap.query.filter\": true," + "\n" + 
                "       \"saiku.olap.result.formatter\": \"flattened\"," + "\n" + 
                "       \"org.saiku.query.explain\": true," + "\n" + 
                "       \"saiku.olap.query.drillthrough\": true," + "\n" + 
                "       \"org.saiku.connection.scenario\": false" + "\n" + 
                "   }," + "\n" + 
                "   \"metadata\": {" + "\n" + 
                "       " + "\n" + 
                "   }," + "\n" + 
                "   \"parameterResolvedMdx\": null" + "\n" + 
                "}";
    }
    
//    @Test
    public void testRequestJson(){
        try {
            ThinQuery query= JSON.parseObject(json, ThinQuery.class);
            Assert.assertNull(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
    
    @Test
    public void testWrapThinkQueryJson(){
        String thinkJson = "{\"name\":\"DCA01787-955D-D205-B0BE-A0BA03A22434\",\"queryModel\":{\"axes\":{\"FILTER\":{\"mdx\":null,\"filters\":\n" +
                "[],\"sortOrder\":null,\"sortEvaluationLiteral\":null,\"hierarchizeMode\":null,\"location\":\"FILTER\",\"hierarchies\"\n" + 
                ":[],\"nonEmpty\":false,\"aggregators\":[]},\"COLUMNS\":{\"mdx\":null,\"filters\":[],\"sortOrder\":null,\"sortEvaluationLiteral\"\n" + 
                ":null,\"hierarchizeMode\":null,\"location\":\"COLUMNS\",\"hierarchies\":[{\"name\":\"[customers dimension].[h_region\n" + 
                "]\",\"levels\":{\"continent\":{\"name\":\"continent\"}},\"cmembers\":{}}],\"nonEmpty\":true,\"aggregators\":[]},\"ROWS\"\n" + 
                ":{\"mdx\":null,\"filters\":[],\"sortOrder\":null,\"sortEvaluationLiteral\":null,\"hierarchizeMode\":null,\"location\"\n" + 
                ":\"ROWS\",\"hierarchies\":[{\"name\":\"[product].[h_product]\",\"levels\":{\"product type\":{\"name\":\"product type\"\n" + 
                "}},\"cmembers\":{}}],\"nonEmpty\":true,\"aggregators\":[]}},\"visualTotals\":false,\"visualTotalsPattern\":null\n" + 
                ",\"lowestLevelsOnly\":false,\"details\":{\"axis\":\"COLUMNS\",\"location\":\"BOTTOM\",\"measures\":[{\"name\":\"sales\n" + 
                " amount\",\"type\":\"EXACT\"}]},\"calculatedMeasures\":[],\"calculatedMembers\":[]},\"queryType\":\"OLAP\",\"type\"\n" + 
                ":\"QUERYMODEL\",\"cube\":{\"uniqueName\":\"[mondrian_source].[Sauce Dallas schema].[Sauce Dallas schema].[Sales\n" + 
                "]\",\"name\":\"Sales\",\"connection\":\"mondrian_source\",\"catalog\":\"Sauce Dallas schema\",\"schema\":\"Sauce Dallas\n" + 
                " schema\",\"caption\":null,\"visible\":false},\"mdx\":null,\"parameters\":{},\"plugins\":{},\"properties\":{\"saiku\n" + 
                ".olap.query.automatic_execution\":true,\"saiku.olap.query.nonempty\":true,\"saiku.olap.query.nonempty.rows\"\n" + 
                ":true,\"saiku.olap.query.nonempty.columns\":true,\"saiku.ui.render.mode\":\"table\",\"saiku.olap.query.filter\"\n" + 
                ":true,\"saiku.olap.result.formatter\":\"flattened\",\"org.saiku.query.explain\":true,\"saiku.olap.query.drillthrough\"\n" + 
                ":true,\"org.saiku.connection.scenario\":false},\"metadata\":{}}";
         
        try {
//            ThinQuery query  = mapper.readValue(thinkJson, ThinQuery.class);
            ThinQuery query= JSON.parseObject(thinkJson, ThinQuery.class); 
//            Assert.assertNull(query);
            System.out.println("type:"+query.getType());
            System.out.println("cube:"+ query.getCube());
            System.out.println("mdx : "+  query.getMdx());
            System.out.println("name:"+query.getName());
            
            System.out.println(query.getProperties());
            
            
//            if (tq.getProperties().containsKey("saiku.olap.result.formatter")) {
//                return execute(tq, tq.getProperties().get("saiku.olap.result.formatter").toString());
//            }
//            return execute(tq, "");
//            
//            
//            try {
//
//                Long start = (new Date()).getTime();
//                log.debug("Query Start");
//                CellSet cellSet = executeInternalQuery(tq);
//                log.debug("Query End");
//                String runId = "RUN#:" + ID_GENERATOR.get();
//                Long exec = (new Date()).getTime();
//
//                CellDataSet result = OlapResultSetUtil.cellSet2Matrix(cellSet, formatter);
//                Long format = (new Date()).getTime();
//
//                if (ThinQuery.Type.QUERYMODEL.equals(tq.getType()) && formatter instanceof FlattenedCellSetFormatter && tq.hasAggregators()) {
//                    calculateTotals(tq, result, cellSet, formatter);
//                }
//                Long totals = (new Date()).getTime();
//                log.info(runId + "\tSize: " + result.getWidth() + "/" + result.getHeight() + "\tExecute:\t" + (exec - start)
//                        + "ms\tFormat:\t" + (format - exec) + "ms\tTotals:\t" + (totals - format) + "ms\t Total: " + (totals - start) + "ms");
//
//                result.setRuntime(new Double(format - start).intValue());
//                return result;
//            } catch (Exception | Error e) {
//                throw new SaikuServiceException("Can't execute query: " + tq.getName(), e);
//            }
//                    
        
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
