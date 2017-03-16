package com.codyy.data.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.saiku.web.rest.resources.Query2Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codyy.data.web.rest.model.QueryRequestJson;
import com.codyy.data.web.rest.model.QueryResponseJson;
import com.codyy.data.web.rest.service.QueryService;
import com.qmino.miredot.annotations.ReturnType;

/**
 * 通过rest Api 地址请求数据
 * @author xinsheng.zhao
 *
 */
@Component
@Path("/query/data")
public class QueryDataRest {

    private static final Logger log = LoggerFactory.getLogger(QueryDataRest.class);
    
    @Autowired
    QueryService queryService;
    
    /**
    *
    * 执行查询 rest handler
    * @summary 按照json请求数据执行查询
    * @param queryRequestJson 为请求对象，约定格式查询
    * @return json 对象，约定格式返回
    */
     @POST
     @Path("/execute")
     @Produces({"application/json" })
     @ReturnType("com.codyy.data.web.rest.model.QueryResponseJson")
     public QueryResponseJson<String> execute(String queryRequestJson ) {
         try {
             
//             if (queryRequestJson == null || StringUtils.isEmpty(queryRequestJson.getName())){
//                 //TODO return queryRequestJson as blank
//             }
//            return  queryService.executeQuery(queryRequestJson);
             return null;
            
         }
         catch (Exception e) {
             log.error("Cannot execute MDX query (" + queryRequestJson.toString() + ")",e);
             String error = ExceptionUtils.getRootCauseMessage(e);
             return new QueryResponseJson<String>(error);
         }
     }
}


