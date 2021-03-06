package Btjf_API.CAPI.B2C_P0;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**
 * Created by BT01 on 2017/7/20.
 */
public class B2C_Subscription_1_2_0 {
    private B2C_GlobalApi globalApi=new B2C_GlobalApi();
    private String subUrl = "/personal-client-interface";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(B2C_SalePotCapi.class);
    private String mobile = PublicUtil.prop.getProperty("b2cmobile");


    /**
     * 订阅窗口接口
     *POST/m/business/subscription/submit/1_1_0_0
     * 通过
     */
    @Test(description = "订阅窗口接口", groups = "B2C_Subscription_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSubscriptionSubmit(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        globalApi.deleteSubsript(mobile);
        if(assertMap.get("CaseID").equals("MSSB7")){
            globalApi.getCode(mobile);
        }
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/subscription/submit/1_1_0_0";

        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);

        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    /**
     * 我的订阅列表
     *GET/m/mine/subscription/list/1_1_0_0
     * 通过
     */
    @Test(description = "我的订阅列表", groups = "B2C_Subscription_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSubscriptionList(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/subscription/list/1_1_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "我的订阅详情接口",groups = "B2C_Subscription_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSubscriptionDetail(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/subscription/detail/1_1_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    /**
     * 删除订阅接口
     *POST/m/mine/subscription/delete/1_1_0_0
     * 通过
     */
    @Test(description = "删除订阅接口", groups = "B2C_Subscription_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSubscriptionDelete(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/subscription/delete/1_1_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }
}
