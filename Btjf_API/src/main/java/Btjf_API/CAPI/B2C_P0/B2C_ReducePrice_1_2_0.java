package Btjf_API.CAPI.B2C_P0;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.AssertUtil;
import Btjf_API.CAPI.Utils.HttpUtil;
import Btjf_API.CAPI.Utils.Log;
import Btjf_API.CAPI.Utils.PublicUtil;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**
 * Created by wl on 2017/7/20.
 */
public class B2C_ReducePrice_1_2_0 {
    private String subUrl = "/personal-client-interface";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(B2C_ReducePrice_1_2_0.class);
    @Test(description = "B2C降价-买车详情接口", groups = "B2C_ReducePrice_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mCardetail(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/car/detail/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "B2C降价-验证码获取接口", groups = "B2C_ReducePrice_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mCodeSms(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/common/code/sms/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-----------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "B2C降价-降价提交接口", groups = "B2C_ReducePrice_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mNoticeConfig(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/depreciate/notice/config/1_1_0_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "B2C降价-降价提醒列表", groups = "B2C_ReducePrice_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mDepreciateNoticeList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/depreciate/notice/list/1_1_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "删除降价提醒接口",groups = "B2C_ReducePrice_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void depreciateNoticeDel(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/depreciate/notice/del/1_1_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(bodyMap,map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "车辆是否已收藏接口", groups = "B2C_ReducePrice_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void carCollectStatus(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/car/collect/status/1_1_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "个人中心首页", groups = "B2C_ReducePrice_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mMineIndexStatistics(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl + "/m/mine/index/statistics/1_1_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }





}
