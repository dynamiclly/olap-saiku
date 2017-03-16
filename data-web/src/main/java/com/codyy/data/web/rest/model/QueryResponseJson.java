package com.codyy.data.web.rest.model;

/**
 * 查询结果返回 对象
 * @author  xinsheng.zhao
 *
 */
public class QueryResponseJson<T> {

    private String message;
    private int status;//0 sucess 1 failure
    private T result;
    
    
//    status: 0, //0 成功 1失败     
//    message: “抽取成功”，  
//    result:  {}

    
    public QueryResponseJson (String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public T getResult() {
        return result;
    }
    public void setResult(T result) {
        this.result = result;
    }
    
}
