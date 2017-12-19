package Btjf_API.CAPI.Test;

import Btjf_API.CAPI.Extend.MyRetryListener;
import Btjf_API.CAPI.Extend.MyTestngRetry;
import Btjf_API.CAPI.Extend.MyTransFormer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by wl on 2016/7/6.
 */
@Listeners({MyRetryListener.class})
public class MyTransTest {
//    @Test(dataProvider = "data2",dataProviderClass = Btjf_API.CAPI.Test.Data.class)
//    public void test1(int i){
//        System.out.println("---------------test1-----------"+i);
//    }
//    @Test(dataProvider = "data1",dataProviderClass = Btjf_API.CAPI.Test.Data.class)
//    public void test2(int i){
//        System.out.println("-----------------test2---------"+i);
//    }
//    @DataProvider(name="data1")
//    public Object[][] dataMethod1(Method method){
//        if(method.getName().equals("test1")){
//            return new Object[][]{{10}};
//        }else {
//            return new Object[][]{{20}};
//        }
//    }
//    @DataProvider(name="data2")
//    public Object[][] dataMethod2(Method method){
//        if(method.getName().equals("test1")){
//            return new Object[][]{{100}};
//        }else {
//            return new Object[][]{{200}};
//        }
//    }
int num =1;
    @Test
    public void testA(){
        String s = ""+num;
        num++;
        Assert.assertEquals(s,"3");
    }
    @Test
    public void testB(){
        Assert.assertEquals("2","3");
    }


}
