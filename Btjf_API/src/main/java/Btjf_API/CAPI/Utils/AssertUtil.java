package Btjf_API.CAPI.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.*;

/**
 * Created by wl on 2016/7/1.
 */
public class AssertUtil {
    Log log = new Log(AssertUtil.class);
    JsonUtil jsonUtil = new JsonUtil();
    public void assertResult(String method,String id){

    }
    public void strAssert(LinkedHashMap<String,Object> assertMap , JSONObject resultJson){
        Reporter.log("------当前执行的caseID ："+assertMap.get("CaseID")+"   --------");
        log.info("------当前执行的caseID : "+assertMap.get("CaseID")+"   --------");
        assertMap.remove("CaseID");
        Assert.assertNotNull(resultJson);
//        System.out.println(JSONObject.toJSONString(resultJson,SerializerFeature.WriteMapNullValue));
        HashMap<String ,Object> resuleMap = jsonUtil.jsonToMap(resultJson);
        Set<String> keys = assertMap.keySet();
        for(String key : keys){
            if(key.contains("{")){
                sqlParamsAssert(key,assertMap);
            }else if(key.equalsIgnoreCase("asc") || key.equalsIgnoreCase("desc")){
                boolean flag = intSortAssert(key,resuleMap.get(assertMap.get(key)));
                Assert.assertEquals(true,flag);
            }else{
                //String s1 =JSONObject.toJSONString(resultJson.get(key),SerializerFeature.WriteMapNullValue);
                Object obj = resuleMap.get(key);
                if(obj instanceof String){
                    String s1 = (String)obj;
                    if(s1.startsWith("\"")){
                        s1 = s1.substring(1,s1.length()-1);
                    }
                    String s2 = assertMap.get(key).toString();
                    Assert.assertEquals(s1,s2);
                }

            }

        }
    }

    /**
     * 校验排序是否正确，正序和倒叙
     * @param key
     * @param object
     * @return
     */
    public boolean intSortAssert(String key,Object object){
       if(object instanceof List){
           List<String> list= (List)object;
           for(int num=0;num<list.size()-1;num++){
               if(key.equalsIgnoreCase("asc")){
                   if(list.get(num).equalsIgnoreCase("null") || list.get(num+1).equalsIgnoreCase("null")){
                       continue;
                   }else if(Float.parseFloat(list.get(num))>Float.parseFloat(list.get(num+1))){
                       Reporter.log("-----排序校验失败-------");
                       log.error("-------排序校验失败---------");
                       return false;
                   }
               }else if(key.equalsIgnoreCase("desc")){
                   if(list.get(num).equalsIgnoreCase("null") || list.get(num+1).equalsIgnoreCase("null")){
                       continue;
                   }else if(Float.parseFloat(list.get(num))<Float.parseFloat(list.get(num+1))){
                       Reporter.log("-----排序校验失败-------");
                       log.error("-------排序校验失败---------");
                       return false;
                   }
               }
           }
           return true;
       }
        return false;
    }

    /**
     * 校验数据库中的参数值是不是预期的值
     * @param key
     * @param assertMap
     */
    public void sqlParamsAssert(String key ,LinkedHashMap<String,Object> assertMap){
        List<String> value = (List<String>)assertMap.get(key);
        String[] keys = strToArr(key);
        int num =0 ;
        for(String k : keys){
            Assert.assertEquals(value.get(num),k);
            num++;
        }

    }

    /**
     * str的格式为{1,2,3}
     * @param str
     */
    public String[] strToArr(String str){
        str = str.substring(1,str.length()-1);
        if(str.contains(",")){
//        System.out.println(str);
            String[] strs = str.split(",");
            return strs;
        }else{
            String[] strs = new String[1];
            strs[0]= str;
            return strs;
        }

    }

    public static void main(String[] args){
//        String s1 = "{\"isNeedUpdate\":0,\"url\":null,\"bugVersion\":null}";
//        String s2 = "{\"isNeedUpdate\":0,\"url\":null,\"bugVersion\":null}";
//        String s = "{\"code\":1,\"message\":\"成功!\",\"object\":{\"isNeedUpdate\":0,\"url\":null,\"bugVersion\":null},\"map\":{}}";
//        JSONObject jsonObject = JSON.parseObject(s);
//        String sss = JSONObject.toJSONString(jsonObject.get("code"),SerializerFeature.WriteMapNullValue);
//        System.out.println(sss);
////        System.out.println(JSONObject.toJSONString(jsonObject.get("message"), SerializerFeature.WriteMapNullValue));
//        System.out.println(jsonObject.get("message").toString());
//        Assert.assertEquals(s2,s1);
        new AssertUtil().strToArr("{1,2,3}");

    }
}
