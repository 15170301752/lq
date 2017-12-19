package Btjf_API.CAPI.B2C_P0;

import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by wl on 2016/12/23.
 */
public class B2C_GlobalApi {
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private SqlUtil sqlUtil = publicUtil.getSqlHander("carSeller");
    private  String subUrl ="/personal-client-interface";
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(B2C_GlobalApi.class);
    private SqlUtil B2C_hander = publicUtil.getSqlHander("c_ ");

    /**
     * 获得B2C的验证码
     * @param mobile
     * @throws Exception
     */
  public void  getCode(String mobile) throws Exception{

          LinkedHashMap<String, Object> headMap = new LinkedHashMap<String, Object>();
          LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<String, Object>();
          headMap.put("version","1.2.2.0");
          bodyMap.put("mobile",mobile);
          bodyMap.put("useType","8");
          String url = subUrl + "/m/common/code/sms/1_0_0_0";
          JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);


      }

    /**
     * 删除订阅窗口
     * @param mobile
     */

      public  void  deleteSubsript(String mobile){
          B2C_hander.updateColumnValue("UPDATE c_Subscription SET FStatus=1 WHERE FMobile= '"+mobile+"';");
      }



}
