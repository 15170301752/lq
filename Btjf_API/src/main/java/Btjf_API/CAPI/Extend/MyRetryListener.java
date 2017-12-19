package Btjf_API.CAPI.Extend;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by wl on 2017/8/3.
 */
public class MyRetryListener implements IAnnotationTransformer{

    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        IRetryAnalyzer retryAnalyzer = iTestAnnotation.getRetryAnalyzer();
        if(retryAnalyzer == null){
            iTestAnnotation.setRetryAnalyzer(MyTestngRetry.class);

        }
    }
}
