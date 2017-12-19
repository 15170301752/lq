package Btjf_API.CAPI.Test;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Extend.MyMethodInterceptor;
import Btjf_API.CAPI.Utils.PublicUtil;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import sun.awt.image.ImageWatched;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

/**
 * 这个类不要动！是作为动态xml文档的默认xml
 * Created by wl on 2016/7/7.
 */
//@Listeners({MyMethodInterceptor.class})
public class MyTest {
//这个类不要动！是作为动态xml文档的默认xml
//    @BeforeSuite
//    public void bSuite(){
//        System.out.println("------开始执行test BeforeSuite-------");
//        System.out.println("------执行结束test BeforeSuite-------");
//    }
//
//    @AfterSuite
//    public void aSuite(){
//        System.out.println("------开始执行test AfterSuite-------");
//        System.out.println("------执行结束test AfterSuite-------");
//    }
//
//    @BeforeClass
//    public void bClass(){
//        System.out.println("------开始执行test BeforeClass-------");
//        System.out.println("------执行结束test BeforeClass-------");
//    }
//
//    @AfterClass
//    public void aClass(){
//        System.out.println("------开始执行test AfterClass-------");
//        System.out.println("------执行结束test AfterClass-------");
//    }
//
//    @BeforeMethod


//    @Test(description = "ceshi",groups = "test",dataProvider = "data1",dataProviderClass = Data.class)
//    public void E(int num1,int num2,int num3) throws Exception{
//        System.out.println("------开始执行test E-------");
//        System.out.println(num1);
//        System.out.println(num2);
//        System.out.println(num3);
//        System.out.println("------执行结束test E------");
//    }
//
//    @Test(description = "ceshi",groups = "test",dependsOnMethods = {"E"},dataProvider = "data1",dataProviderClass = Data.class)
//    public void B(int num){
//        System.out.println("------开始执行test B-------");
//        System.out.println(num);
//        System.out.println("------执行结束test B------");
//    }
//    @Test(enabled = false)
//    public void F(){
//        System.out.println("------执行结束test F------");
//        System.out.println("------执行结束test F------");
////        Reporter.log("断言失败");
////        Assert.assertTrue(false);
//    }
//    @Test(dependsOnMethods = {"F"})
//    public void D(){
//        Reporter.log("断言失败");
//        Assert.assertTrue(false);
//    }
//
//    @Test(dependsOnMethods = {"D"})
//    public void G(){
//        System.out.println();
//    }
//    @Test
//    @Parameters({"name","mobile"})
//    public void A(String name,String mobile){
//        System.out.println("------name:"+name+"-------");
//        System.out.println("------mobile:"+mobile+"------");
//    }
}
