package Btjf_API.CAPI.API_4S;

import Btjf_API.CAPI.Utils.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.LinkedHashMap;

/**
 * Created by wl on 2016/9/29.
 */
public class Demo {
    HttpUtil httpUtil = new HttpUtil();
    public void reportBuy()throws Exception{
        String url = "http://192.168.100.141:6090/maintenance-record-query-open-api-website/4s/report/buy";
        LinkedHashMap<String,Object> headMap = new LinkedHashMap<String, Object>();
        LinkedHashMap<String,Object> bodyMap = new LinkedHashMap<String, Object>();
        headMap.put("Api_4s_Version","1.0");
        headMap.put("Authorization_Token","5c848b40bad8476abbd184b92d9bf8cd");
        bodyMap.put("brandId","59");
        bodyMap.put("vin","123456789Q12W34E4");
        bodyMap.put("engineNum","123456");
        bodyMap.put("orderId","1008602");
        bodyMap.put("notifyUrl","http://192.168.100.141:9070/business-third-notice-service/carinfoquery/btCallBack");
        bodyMap.put("image","1.jpg");
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        System.out.println(resultJson.toString());
    }

    public static void main(String[] args)throws Exception{
        new Demo().reportBuy();
    }
}
