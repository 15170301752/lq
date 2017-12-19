package Btjf_API.CAPI.Test;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by wl on 2016/7/6.
 */
public class MyTrans implements IAnnotationTransformer {
    private Boolean bool;
    public MyTrans(){};
    public void setBool(Boolean bool){
        this.bool = bool;
    }
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod){
        System.out.println("MyTrans   :"+testMethod);
        if(testMethod.getName().contains("test1") && bool){
            annotation.setInvocationCount(5);
            annotation.setDataProvider("data1");
        }else{
            annotation.setDataProvider("data2");
        }

    }
}
