package Btjf_API.CAPI.Test;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by wl on 2016/7/6.
 */
public class Data {
    @DataProvider(name="data1")
    public static Object[][] dataMethod1(Method method){
        if(method.getName().equals("E")){
            return new Object[][]{new Object[]{10,100,1000}};
        }else {
            return new Object[][]{new Object[]{20},new Object[]{200}};
        }
    }
    @DataProvider(name="data2")
    public static Object[][] dataMethod2(Method method){
        if(method.getName().equals("test1")){
            return new Object[][]{{100}};
        }else {
            return new Object[][]{{200}};
        }
    }
}
