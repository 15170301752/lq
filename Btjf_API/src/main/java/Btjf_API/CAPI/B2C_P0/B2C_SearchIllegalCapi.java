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
 * 备胎好车B2C接口之查违章
 * Created by LEE on 2017/3/20.
 */
public class B2C_SearchIllegalCapi {
    private String subUrl = "/personal-client-interface";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(B2C_SearchIllegalCapi.class);


    /**
     * GET
     *语音验证码接口
     * @param map
     * @throws Exception
     */
    @Test(description = "语音验证码接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void voiceVerificationCode(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/common/code/voice/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     * get/m/common/code/sms/1_0_0_0
     *短信验证码接口
     * @param map
     * @throws Exception
     */
    @Test(description = "短信验证码接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void smsverificationCode(LinkedHashMap<String, String> map) throws Exception {
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
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     * POST/m/system/login/1_0_0_0
     *登陆接口
     * @param map
     * @throws Exception
     */
    @Test(description = "登陆接口", groups = "B2C_SearchIllegalCapi",dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void login1_0_0_0(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/login/1_0_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    /**
     * POST/m/system/binddevicetoken/1_0_0_0
     *绑定deviceToken接口
     * @param map
     * @throws Exception
     */
    @Test(description = "绑定deviceToken接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void binddevicetoken1_0_0_0(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/binddevicetoken/1_0_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");

    }

    /**
     * /m/service/evaluate/history/1_0_0_0
     *GET估价历史列表接口
     * @param map
     * @throws Exception
     */
    @Test(description = "GET估价历史列表接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void evaluateHistory(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/evaluate/history/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     * /m/service/evaluate/query/1_0_0_0
     *GET价格评估查询接口
     * @param map
     * @throws Exception
     */
    @Test(description = "价格评估查询接口,价格评估查询接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void evaluateQuery(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/evaluate/query/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     * /m/service/evaluate/query/result/1_0_0_0
     *GET估价结果接口
     * @param map
     * @throws Exception
     */
    @Test(description = "GET估价结果接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void evaluateQueryResult(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/evaluate/query/result/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     * GET/m/service/breakrules/query/validate/1_0_0_0
     *违章查询验证接口
     * @param map
     * @throws Exception
     */
    @Test(description = "违章查询验证接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void queryValidate(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/breakrules/query/validate/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     * GET/m/service/breakrules/query/1_0_0_0
     *获取违章查询接口
     * @param map
     * @throws Exception
     */
    @Test(description = "获取违章查询接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void breakrulesQuery(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/breakrules/query/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     * GET/m/service/breakrules/query/result/1_0_0_0
     *违章查询结果接口
     * @param map
     * @throws Exception
     */
    @Test(description = "违章查询结果接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void breakrulesQueryResult(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/breakrules/query/result/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     * GET/m/service/breakrules/history/list/1_0_0_0
     *获取查询历史列表接口
     * @param map
     * @throws Exception
     */
    @Test(description = "获取查询历史列表接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void breakrulesHistoryList(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/breakrules/history/list/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "删除历史接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void breakrulesHistoryDelete(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/breakrules/history/delete/1_0_0_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }









}
