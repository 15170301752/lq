package Btjf_API.CAPI.CarSeller_P0;

import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by wl on 2016/7/27.
 */
public class MyTestTwo {
    @Test(dependsOnMethods = {"test3"})
    public void test1(){
        Reporter.log("one method is running");
    }
    @Test(dependsOnMethods = {"test3"})
    public void  test2(){
        Reporter.log("two method is running");
    }
    @Test
    public void test3(){
        Reporter.log("assert failed");
//        Assert.assertTrue(false);
    }
    @Test
    public void tes4(){
        Reporter.log("mehtod is skip");
    }
}
