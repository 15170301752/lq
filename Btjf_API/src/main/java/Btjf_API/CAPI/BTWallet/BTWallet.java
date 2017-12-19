package Btjf_API.CAPI.BTWallet;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
//
/**
 * Created by wl on 2017/3/1.
 */
public class BTWallet {
    private  String subUrl ="/bt-wallet-openapi-website";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
//    private SqlUtil sqlUtil = new SqlUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(BTWallet.class);
    @Test(description = "托管用户新增",groups = "btWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void wManageduserAdd(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/btwallet/manageduser/add";
        JSONObject resultJson = httpUtil.postRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }



}
