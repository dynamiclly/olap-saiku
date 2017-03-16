package org.springframework.mock.web;

public class OlapServletContext extends org.springframework.mock.web.MockServletContext{
    
    public void setInitParameter(){
        
        super.setInitParameter("db.url", "jdbc:postgresql://10.5.52.56:5432/codyy_data");
        super.setInitParameter("db.user", "postgres");
        super.setInitParameter("db.password", "postgres");
    
    }

}
