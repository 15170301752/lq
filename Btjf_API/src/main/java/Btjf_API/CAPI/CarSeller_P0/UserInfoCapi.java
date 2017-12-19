package Btjf_API.CAPI.CarSeller_P0;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**
 * Created by LEE on 2017/3/14.
 */
public class UserInfoCapi {
    private String subUrl = "/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(CarInterCapi.class);
    private GlobalApi globalApi = new GlobalApi();

    /**已经废弃
     * GET /m/mine/userinfo/imUpdatePwd/2.3.2

    @Test(description = "10304:环信密码更新",groups = "UserInfoCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void imUpdatePwd_2_3_2(LinkedHashMap<String,String> map) throws  Exception
    {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/userinfo/imUpdatePwd/2.3.2";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }
     */

    /**(被废弃走UPDATE)
     *GET /m/mine/userinfo/info/2_5_0
     */
    @Test(description = "个人资料接口,获取个人资料",groups = "UserInfoCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void info_2_5_0(LinkedHashMap<String,String> map) throws  Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/userinfo/info/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**(失败)
     *PUT /m/mine/userinfo/payPwd/reset

    @Test(description = "支付密码,初始设置支付密码",groups = "UserInfoCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void payPwdReset(LinkedHashMap<String,String> map) throws  Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/userinfo/payPwd/reset";
        JSONObject resultJson = httpUtil.putRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }
     */

    /**
     *GET /m/mine/userinfo/payPwd/sms/verificationCode
     */
    @Test(description = "车商,车商初始支付密码短信验证码接口",groups = "UserInfoCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mSmsVerificationCode(LinkedHashMap<String,String> map) throws  Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/userinfo/payPwd/sms/verificationCode";
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
     *PUT /m/mine/userinfo/payPwd/update
     */
    @Test(description = "支付密码,修改支付密码",groups = "UserInfoCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void payPwdUpdate(LinkedHashMap<String,String> map) throws  Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/userinfo/payPwd/update";
        JSONObject resultJson = httpUtil.putRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     *PUT /m/mine/userinfo/payPwd/update/new
     */
    @Test(description = "支付密码,修改支付密码",groups = "UserInfoCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void updateNew(LinkedHashMap<String,String> map) throws  Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/userinfo/payPwd/update/new";
        JSONObject resultJson = httpUtil.putRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     *GET /m/mine/userinfo/payPwd/voice/verificationCode
     */
    @Test(description = "车商注册,车商初始支付密码获取语音验证码接口",groups = "UserInfoCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void voiceVertificationCode(LinkedHashMap<String,String> map) throws  Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/userinfo/payPwd/voice/verificationCode";
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
     *POST /m/mine/userinfo/update
     */
    @Test(description = "车商信息,车商修改用户信息",groups = "UserInfoCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void userInfoUpdate(LinkedHashMap<String,String> map) throws  Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/userinfo/update";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     *POST /m/mine/userinfo/update_area/2_5_0
     */
    @Test(description = "个人资料修改地区,个人资料修改地区",groups = "UserInfoCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void updateArea_2_5_0(LinkedHashMap<String,String> map) throws  Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/userinfo/update_area/2_5_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     *POST /m/mine/userinfo/update_name/2_5_0
     */
    @Test(description = "个人资料修改姓名,个人资料修改姓名",groups = "UserInfoCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void updateName_2_5_0(LinkedHashMap<String,String> map) throws  Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/userinfo/update_name/2_5_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    /**
     *PUT /m/mine/userinfo/updatePwd
     */
    @Test(description = "车商信息,车商修改密码接口",groups = "UserInfoCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void updatePwd(LinkedHashMap<String,String> map) throws  Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/userinfo/updatePwd";
        JSONObject resultJson = httpUtil.putRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }
}




