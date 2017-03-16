package com.codyy.data.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.core.MediaType;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.codyy.data.web.rest.QueryDataRest;
import com.codyy.data.web.utils.ApacheHttpClient;
import com.codyy.data.web.utils.ApiHttpClient;

public class RestTest {

    MockMvc mockMvc;
    String address = "http://localhost:8080/rest/query/data/execute";
    String json = "{\"name\":\"hello\"}";
    
    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(QueryDataRest.class).build();  
    }
    
    @Test
    public void testMock(){
        try {
            mockMvc.perform(  
                    post(address, "json").characterEncoding("UTF-8")  
                            .contentType(MediaType.APPLICATION_JSON)  
                            .content(json.getBytes())).andReturn()  
            .getResponse().getContentAsString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
    @Test
    public void testQueryRestApi(){
         
         IMocksControl control = EasyMock.createControl();
         ApacheHttpClient httpClient = control.createMock(ApacheHttpClient.class);  
         ApiHttpClient.RequestBuilder reqeust = control.createMock(ApiHttpClient.RequestBuilder.class);
         EasyMock.expect(reqeust.executeAsyncString()).andReturn("1");
         EasyMock.replay(httpClient);
    }
}
