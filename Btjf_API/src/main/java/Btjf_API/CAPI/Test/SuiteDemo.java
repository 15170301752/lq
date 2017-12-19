package Btjf_API.CAPI.Test;


import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.AssertUtil;
import Btjf_API.CAPI.Utils.HttpUtil;
import Btjf_API.CAPI.Utils.PublicUtil;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**
 * Created by wl on 2017/4/21.
 */
public class SuiteDemo {
    private  String subUrl ="/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();


    @Test(enabled = true)
    public void test1(){
        publicUtil.setProperty(PublicUtil.EnvConfigPath,"excelName","BTJF_data");
        publicUtil.setProperty(PublicUtil.EnvConfigPath,"sheetName","P0_data,BTWallet_P0,2.6.1_P0_data");
    }
    @Test(description = "语音验证码接口",groups = "register",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void voiceVerificationCode(LinkedHashMap<String,String> map) throws Exception{
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
    }



    @Test(enabled = true)
    public void test2(){
        publicUtil.setProperty(PublicUtil.EnvConfigPath,"excelName","B2C_data");
        publicUtil.setProperty(PublicUtil.EnvConfigPath,"sheetName","P0_data,P1_data");
    }

    @Test(enabled = true,description = "短信验证码接口", groups = "B2C_SearchIllegalCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void smsverificationCode(LinkedHashMap<String, String> map) throws Exception {
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
    }
}
