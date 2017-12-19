package Btjf_API.CAPI.B2C;

import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;

import java.util.LinkedHashMap;

/**
 * Created by wl on 2016/12/23.
 */
public class B2C_GlobalApi {
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
//    private SqlUtil sqlUtil = publicUtil.getSqlHander("carSeller");
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
              if(resultJson.get("message").equals("不可重复获取验证码")){
                  Thread.sleep(60000);
                  getCode(mobile);
              }
          }

        /**
         * 删除订阅窗口
         * @param mobile
         */

      public  void  deleteSubsript(String mobile){
          B2C_hander.updateColumnValue("UPDATE c_Subscription SET FStatus=1 WHERE FMobile= '"+mobile+"';");
      }

    /**
     * 删除购车意向的记录
     * @param mobile
     */
      public void deleteBuycarIntentionData(String mobile){
          log.info("--------删除购车意向记录---------");
          String sql_1 = "update c_BuyIntention_CarInfo set FIsDelete=1 from c_BuyIntention_CarInfo a INNER JOIN c_BuyIntention_Record b ON a.FParentID = b.FID \n" +
                  "INNER JOIN c_Member c ON b.FUserID = c.FUserID where c.FMobile='"+mobile+"' and b.FIsDelete=0;";
          String sql_2 = "update c_BuyIntention_Record set FIsDelete=1 from c_BuyIntention_Record a INNER JOIN c_Member b ON a.FUserID = b.FUserID\n" +
                  "where b.FMobile='"+mobile+"' and a.FIsDelete=0 ;";
          //删除子表
          B2C_hander.updateColumnValue(sql_1);
          //删除c_BuyIntention_Record
          B2C_hander.updateColumnValue(sql_2);
      }

      public static void main(String[] args) throws Exception{
          new B2C_GlobalApi().deleteBuycarIntentionData("13800000008");
      }


}
