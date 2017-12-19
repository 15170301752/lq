package Btjf_API.CAPI.B2C;

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
 * Created by wl on 2017/8/22.
 */
public class B2C_1_4_0 {
    private String subUrl = "/personal-client-interface";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(B2C_CarBargain_1_2_0.class);
    B2C_GlobalApi b2C_globalApi = new B2C_GlobalApi();
    private String b2cMobile = PublicUtil.prop.getProperty("b2cmobile");

    @Test(description = "买车列表接口", groups = "B2C_CarBargain_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBusinessCarSearch(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/car/search/1_0_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap,bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "意见反馈菜单接口", groups = "B2C_CarBargain_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mMineFeedbackMenu(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/feedback/menu/1_4_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap,bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "意见反馈提交接口", groups = "B2C_CarBargain_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mMineFeedbackSuggest(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/feedback/suggest/1_4_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap,bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "购车意向列表接口", groups = "B2C_CarBargain_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mMineBuycarIntentionList(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/buycar_intention/list/1_4_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap,bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "求购意向提交接口", groups = "B2C_CarBargain_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBusinessBuycarIntentionApply(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        if(map.get("CaseID").equalsIgnoreCase("MBBA10")){
            //发送验证码
            b2C_globalApi.getCode(b2cMobile);
        }else if(map.get("CaseID").equalsIgnoreCase("MBBA1")){
            //删除购车记录
            b2C_globalApi.deleteBuycarIntentionData(b2cMobile);
        }
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/buycar_intention/apply/1_4_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap,bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }








}
