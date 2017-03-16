package com.codyy.data.test;

import java.io.InputStream;
import java.net.URL;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
public class KettleTransformFileTest {

    String transformFile = "";
    
    
   @Test
    public void testTransformWithParam()  {
        try {   
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL url = classLoader.getResource("com/codyy/data/test/mysql_postgresql_saiku_log.ktr");
            System.out.println(url.getFile());
            
            KettleEnvironment.init();   
            TransMeta transMeta = new TransMeta(url.getFile());   
            Trans trans = new Trans(transMeta);   
            //此处为输入的参数，也可以通过参数传进方法中 
//              source.database.type=POSTGRESQL
//              source.database.server=10.5.52.56
//              source.database.port=5432
//              source.database.access=Native
//             source.database.name=postgresql
//            source.database.username=username
//            source.database.password=password
            
            String [] s = {"我是参数1","我是参数2"}; 
            trans.prepareExecution(s);   
            trans.startThreads();   
            trans.waitUntilFinished();   
            if (trans.getErrors() != 0) {   
                System.out.println("Error");   
            }   
        } catch (KettleException e) {   
            e.printStackTrace();   
        }  
    }
    
    
    
    //@Test
    public void testTransform()  {
        try {   
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL url = classLoader.getResource("com/codyy/data/test/mysql_postgresql_saiku_log.ktr");
            System.out.println(url.getFile());
            
            KettleEnvironment.init();   
            TransMeta transMeta = new TransMeta(url.getFile());   
            Trans trans = new Trans(transMeta);   
            //此处为输入的参数，也可以通过参数传进方法中 
            String [] s = {"我是参数1","我是参数2"}; 
            trans.prepareExecution(s);   
            trans.startThreads();   
            trans.waitUntilFinished();   
            if (trans.getErrors() != 0) {   
                System.out.println("Error");   
            }   
        } catch (KettleException e) {   
            e.printStackTrace();   
        }  
    }
    
    
   @Test
    public void testJobFile(){
       
        try {   
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                URL url = classLoader.getResource("com/codyy/data/test/inserttest.kjb");
                System.out.println(url.getFile());
                KettleEnvironment.init();   
                
                JobMeta jobMeta = new JobMeta();   
                jobMeta.setFilename("D:\\source\\codyy-data\\data-web\\src\\test\\java\\com\\codyy\\data\\test\\inserttest.kjb");
                Job job = new Job(null, jobMeta);  
                //向Job 脚本传递参数，脚本中获取参数值：${参数名}   
                //job.setVariable(paraname, paravalue);   
                 job.start();   
                 job.waitUntilFinished();   
                 if (job.getErrors() > 0) {   
                     throw new Exception("There are errors during job exception!(执行job发生异常)");  
                 }   
            } catch (Exception e) {   
               e.printStackTrace();
            }   
    }
    
  //@Test
    public void testTransformFile(){
       
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL url = classLoader.getResource("com/codyy/data/test/oracle_to_postgresql_base_area.ktr");
            System.out.println(url.getFile());
            
            KettleEnvironment.init();
            EnvUtil.environmentInit();
            TransMeta transMeta = new TransMeta("D:\\source\\codyy-data\\data-web\\src\\test\\java\\com\\codyy\\data\\test\\inserttest.kjb");
            Trans trans = new Trans(transMeta);
            trans.execute(null); // 使用参数可以替代
            trans.waitUntilFinished();
            if ( trans.getErrors() > 0 )
            {
                throw new RuntimeException( "执行mock kettle transform 文件报错" );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
    
     //@Test
    public void testFilePath(){
//      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//      InputStream is = classLoader.getResourceAsStream("com/codyy/data/test/mysql_postgresql_saiku_log.ktr");
        InputStream mockIs = EasyMock.createMock(InputStream.class);
        Assert.assertNotEquals(mockIs, null);
    }
    
}
