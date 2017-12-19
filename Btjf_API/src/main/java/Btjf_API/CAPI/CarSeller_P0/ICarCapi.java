package Btjf_API.CAPI.CarSeller_P0;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**
 * Created by wl on 2016/8/15.
 */
//@Listeners({org.uncommons.reportng.HTMLReporter.class})
public class ICarCapi {
    private  String subUrl ="/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(ICarCapi.class);
    private GlobalApi globalApi = new GlobalApi();


    @Test(description = "语音验证码接口",groups = "register",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void voiceVerificationCode(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = new LinkedHashMap<String,Object>();
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/system/register/voice/verificationCode";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "注册短信验证码接口",groups = "register",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void smsVerificationCode(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("------------开始执行"+methodName+"方法----------");
        LinkedHashMap<String,Object> headMap = new LinkedHashMap<String,Object>();
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/system/register/sms/verificationCode";
        //Thread.sleep(60000);//60秒内不能重复发送
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

//    @Test(description = "车商注册接口",groups = "register",dependsOnMethods = {"smsVerificationCode"},dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    @Test(description = "车商注册接口",groups = "register",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void register(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = new LinkedHashMap<String,Object>();
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
//        LinkedHashMap<String,Object> smsMap = new LinkedHashMap<String, Object>();
//        smsMap.put("mobile",bodyMap1.get("mobile"));
//        String smsUrl = subUrl +"/m/system/register/sms/verificationCode";
//        JSONObject smsResult = httpUtil.getRequest(smsUrl,headMap,smsMap);
//        LinkedHashMap<String,Object> bodyMap2 = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/system/register";
//        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        JSONObject resultJson = httpUtil.postRequest(url,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

//    @Test(description = "车商绑定deviceToken接口",dependsOnMethods = {"logins"},groups = "login",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    @Test(description = "车商绑定deviceToken接口",groups = "login",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bindDeviceToken(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/system/bindDeviceToken";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

//    @Test(description = "车商登录接口",dependsOnMethods = {"register"},groups = "login",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    @Test(description = "车商登录接口",groups = "login",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void logins(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/system/login";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

//    @Test(description = "登陆后返回用户权限接口",dependsOnMethods = {"bindDeviceToken"},groups = "login",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    @Test(description = "登陆后返回用户权限接口",groups = "login",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void login_2_3_2(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/system/login/2_3_2";
        JSONObject resultJson = httpUtil.postRequest(url,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

//    @Test(description = "车商退出登录接口",groups = "login",dependsOnMethods = {"login_2_3_2"},dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    @Test(description = "车商退出登录接口",groups = "login",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void logout(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/system/logout";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "认证申请接口2.4.0",groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void accComplete_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/account/complete/2_4_0";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //认证审核不通过
        globalApi.certificationNoPass(publicUtil.getDataMapPhone(map,"registerNum"));
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "认证申请接口2.5.0",groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void accComplete_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/account/complete/2_5_0";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //认证审核不通过
        globalApi.certificationNoPass(publicUtil.getDataMapPhone(map,"registerNum"));
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "重新认证接口,2.4.0",groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void cerAgain_2_4_1(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/certification/again/2_4_1";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //认证审核不通过
        globalApi.againCertificationNoPass(publicUtil.getDataMapPhone(map,"registerNum"));
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "重新认证接口,2.5.0",groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void cerAgain_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
//        globalApi.carLogin(PublicUtil.prop.getProperty("custNum"),"123456");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/certification/again/2_5_0";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //认证审核不通过
        globalApi.againCertificationNoPass(publicUtil.getDataMapPhone(map,"registerNum"));
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "获取验证码接口.2.4.1",groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void smsVerificationCode_2_4_1(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/certification/sms/verificationCode/2_4_1";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

//    @Test(description = "短信验证码验证接口.2.4.1",dependsOnMethods = {"smsVerificationCode_2_4_1"},groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    @Test(description = "短信验证码验证接口.2.4.1",groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void cerCheckMessage_2_4_1(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/certification/CheckMessage/2_4_1";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "认证,认证申请接口.2.4.1",groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void cerComplete_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/certification/complete/2_4_0";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //认证审核不通过
        globalApi.certificationNoPass(publicUtil.getDataMapPhone(map,"registerNum"));
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "查征信入口的认证接口.2.5.0",groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void cerComplete_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/certification/complete/2_5_0";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //认证审核不通过
        globalApi.certificationNoPass(publicUtil.getDataMapPhone(map,"registerNum"));
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "(获取审核通过订单)身份认证信息接口.2.4.1",groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void cerInfo_2_4_1(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/certification/info/2_4_1";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "是否开启重新认证接口",groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void cerMessageSwitch_2_4_1(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/certification/MessageSwitch/2_4_1";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "认证未通过,认证未通过信息查询接口",groups = "certification",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void cerUnPastSearch_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/certification/unPastSearch/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "首页,获取广告轮播图接口",groups = "index",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void indexAdvertPicture(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/index/advertisementPicture";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "首页,获取用户信息以及业务经理信息",groups = "index",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void Index(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/index/index";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车商重置密码,车商重置密码获取语音验证码接口",groups = "login",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void resetPwdVoiceVerificationCode(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/system/resetPwd/voice/verificationCode";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车商重置密码,车商重置密码获取短信验证码接口",groups = "login",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void resetPwdSmsVerificationCode(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Thread.sleep(60000);
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/system/resetPwd/sms/verificationCode";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

//    @Test(description = "车商重置密码,车商重置密码接口",dependsOnMethods = {"resetPwdSmsVerificationCode"},groups = "login",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    @Test(description = "车商重置密码,车商重置密码接口",groups = "login",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void resetPwd(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/system/resetPwd";
        JSONObject resultJson = httpUtil.putRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("-------------"+methodName+"方法执行已结束-------------");
    }

}
