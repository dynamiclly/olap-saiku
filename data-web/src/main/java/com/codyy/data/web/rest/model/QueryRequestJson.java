package com.codyy.data.web.rest.model;

/**
 * 请求查询的json model
 * @author  xinsheng.zhao
 *
 */
public class QueryRequestJson {

     String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "QueryRequestJson:{name:"+name+"}";
    }
}
