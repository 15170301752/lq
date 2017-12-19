package Btjf_API.CAPI.Extend;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.*;

/**
 * Created by wl on 2017/8/4.
 */
public class TestngListener extends TestListenerAdapter {

    /**
     * 重跑后，方法次数去重
     * @param testContext
     */
    @Override
    public void onFinish(ITestContext testContext) {
        List<ITestResult> removeList = new ArrayList<ITestResult>();
        Set<Integer> passIds = new HashSet<Integer>();
        for(ITestResult iTestResult : testContext.getPassedTests().getAllResults()){
            int id = getId(iTestResult);
//            if(passIds.contains(id)){
//                removeList.add(iTestResult);
//            }
            passIds.add(getId(iTestResult));
        }
        Set<Integer> failedIds = new HashSet<Integer>();
        for(ITestResult iTestResult: testContext.getFailedTests().getAllResults()){
            int id = getId(iTestResult);
            if(failedIds.contains(id) || passIds.contains(id)){
                removeList.add(iTestResult);
            }else{
                failedIds.add(id);
            }
        }
        Set<Integer> skipIds = new HashSet<Integer>();
        for(ITestResult iTestResult : testContext.getSkippedTests().getAllResults()){
            int id = getId(iTestResult);
            if(skipIds.contains(id) || failedIds.contains(id) || passIds.contains(id)){
                removeList.add(iTestResult);
            }else{
                skipIds.add(id);
            }
        }

        for(Iterator<ITestResult> iterator = testContext.getFailedTests().getAllResults().iterator();iterator.hasNext();){
            ITestResult iTestResult = iterator.next();
            if(removeList.contains(iTestResult)){
                iterator.remove();
            }
        }

        for(Iterator<ITestResult> iterator = testContext.getSkippedTests().getAllResults().iterator();iterator.hasNext();){
            ITestResult iTestResult = iterator.next();
            if(removeList.contains(iTestResult)){
                iterator.remove();
            }
        }


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
}
