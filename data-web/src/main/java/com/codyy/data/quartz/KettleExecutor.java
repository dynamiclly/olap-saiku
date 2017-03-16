package com.codyy.data.quartz;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  

/**
 * 执行ELT tools kettle 
 * 在服务启动后执行，在job文件中定义有执行间隔
 * @author xinsheng.zhao
 *
 */
public class KettleExecutor {

    private static final Logger log = LoggerFactory.getLogger(KettleExecutor.class);
    /**
     * 
     * @param transFileName
     * @throws KettleException
     */
    public static void callTrans(String transFileName,String[] paramters,String[] values) throws KettleException {  
        EnvUtil.environmentInit();
        KettleEnvironment.init();
        // 转换元对象
        TransMeta transMeta = new TransMeta(transFileName);
        transMeta.setParameterValue("v_date", "syndate");  
        // 转换
        Trans trans = new Trans(transMeta);
        String[] params = {};
        // 执行转换
        trans.execute(params);
        
        // 等待转换执行结束
        trans.waitUntilFinished();
        if (trans.getErrors() > 0 ){
            log.error("KettleExecutor execute callTrans :["+transFileName+" failure ] ");
        }
    }  


    /**
     * 
     * @param transFileName
     * @throws KettleException
     */
    public static void callTransWithParam(String transFileName) throws KettleException {  
 
    }  
    
    /**
     *  
     * @param jobFileName
     * @throws KettleException
     */
    public static void callJob(String jobFileName,String[] paramters,String[] values) throws KettleException {  
       
        

        if (log.isDebugEnabled()){
            log.debug("KettleExecutor execute callJob :["+jobFileName+"]  begin to execute");
        }
         
        try {
            KettleEnvironment.init();
            JobMeta jobMeta = new JobMeta(jobFileName, null);
            Job job = new Job(null, jobMeta);
            //向Job 脚本传递参数，脚本中获取参数值：${参数名}  
            //job.setVariable(null, null);
           // job.setVariable(variableName, variableValue);
            job.start();
            job.waitUntilFinished();
            if (job.getErrors() > 0) {
                log.error("KettleExecutor execute callJob:["+jobFileName+" failure ]");
            }
        } catch (KettleException e) {
            System.out.println(e);
        }
       

        if (log.isDebugEnabled()){
            log.debug("KettleExecutor execute callJob :["+jobFileName+"]  executed end");
        }
 
        
    }  
  
}
