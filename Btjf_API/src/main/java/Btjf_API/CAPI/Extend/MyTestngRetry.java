package Btjf_API.CAPI.Extend;

import Btjf_API.CAPI.Utils.Log;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lee on 2017/8/3.
 */
public class MyTestngRetry implements IRetryAnalyzer{
    private int retryCount = 1;
    private int maxRetryCount = 3;  //尝试重跑最大次数
    private int id = 0;
    private Log log = new Log(MyTestngRetry.class);

    public boolean retry(ITestResult iTestResult) {
        String caseID ="";
        int newId = getId(iTestResult);
        Object[] objects = iTestResult.getParameters();
        if(objects != null && objects.length >0 &&objects[0] instanceof Map){
            Map map = (Map)objects[0];
            caseID = (String)map.get("CaseID");
        }else{
            caseID ="null";
        }
        if(id==0 && retryCount <= maxRetryCount ){
            id = newId;
            run(iTestResult,retryCount,caseID);
            retryCount++;
            return true;
        }else if(id !=0 && id == newId && retryCount <= maxRetryCount ){
            run(iTestResult,retryCount,caseID);
            retryCount++;
            return true;
        }else if(id !=0 && id != newId  ){
            retryCount=1;
            id = newId;
            run(iTestResult,retryCount,caseID);
            retryCount++;
            return true;
        }
//        if(retryCount <= maxRetryCount){
//
//            String message = "  尝试重跑 "+iTestResult.getTestClass().getName()+" 类中 "+iTestResult.getName()+" 方法第 "+retryCount+" 次";
//            log.debug(message);
//            Reporter.log(message);
//            Reporter.setCurrentTestResult(iTestResult);
//            retryCount++;
//            return true;
//        }
        return false;
    }

    /**
     * 通过hashcode，获取每个方法的唯一ID
     * @param iTestResult
     * @return
     */
    private Integer getId(ITestResult iTestResult){
        Integer id = iTestResult.getTestClass().getName().hashCode();
        id = id + iTestResult.getMethod().getMethodName().hashCode();
        id = id + (iTestResult.getParameters() !=null? Arrays.hashCode(iTestResult.getParameters()) : 0);
        return id;
    }

    public void run(ITestResult iTestResult ,int num,String caseID){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = "  尝试重跑 "+iTestResult.getTestClass().getName()+" 类中方法 "+iTestResult.getName()+" 第 "+num+" 次 "+ " ,CaseID为 : "+caseID;
        log.debug(message);
        Reporter.log(message);
        Reporter.setCurrentTestResult(iTestResult);
    }
}
