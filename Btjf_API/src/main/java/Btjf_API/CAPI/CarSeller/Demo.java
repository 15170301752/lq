package Btjf_API.CAPI.CarSeller;

import Btjf_API.CAPI.Utils.HttpUtil;
import Btjf_API.CAPI.Utils.Log;
import Btjf_API.CAPI.Utils.PublicUtil;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by wl on 2016/6/18.
 */
public class Demo {
    public static HashMap<String,Object> headMap;
    public static HashMap<String,Object> bodyMap;
    public static HttpUtil httpUtil = new HttpUtil();
    public static PublicUtil publicUtil = new PublicUtil();
    Log log = new Log(Demo.class);
    @Test
    public void run() throws Exception{
        String name = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("--------------开始执行"+name+"方法-------------");
//        System.out.println(name);
        headMap = new HashMap<String, Object>();
        bodyMap = new HashMap<String, Object>();
        String afterUrl = "/car-seller-client-interfaces/m/index/scb/index";
        headMap.put("deviceCode","0B5A3248-764F-49C6-8ED9-205C365D449E");
        headMap.put("GPS","30.336137612047892,120.118483669277126");
        headMap.put("AccessToken","d0bf19ef-2a19-4ad0-b30a-c6b73be8e5ed");
        headMap.put("requestToken","18645A7D-B024-4BDC-BE07-638516EA3C44");
        //bodyMap.put("","");
        JSONObject  resultJson = httpUtil.postRequest(afterUrl,headMap,bodyMap);
        if(resultJson==null){
            System.out.println("返回数据错误");
            Assert.assertNotNull(resultJson);
        }
//        System.out.println(resultJson.toString());

    }



}
