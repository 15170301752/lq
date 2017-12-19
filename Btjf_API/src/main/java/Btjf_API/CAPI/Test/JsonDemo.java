package Btjf_API.CAPI.Test;

import Btjf_API.CAPI.Utils.JsonUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wl on 2017/7/21.
 */
public class JsonDemo {

    public static void main(String[] args){
        JsonDemo jsonDemo = new JsonDemo();
        String s = "{\n" +
                "    \"code\": 1,\n" +
                "    \"message\": \"成功!\",\n" +
                "    \"object\": {\n" +
                "        \"photo\": [\n" +
                "            \"http://192.168.100.142/PUBLIC/CAR_IMAGE/2017-05-27/aed87388-e649-461a-bae7-5d0981e087a4.jpg\"\n" +
                "        ],\n" +
                "        \"bargainStatus\": 0,\n" +
                "        \"isOverBargainLimit\": 0,\n" +
                "        \"custPhoto\": null,\n" +
                "        \"custAddress\": \"123\"\n" +
                "    },\n" +
                "    \"map\": {\n" +
                "        \"shareInfo\": \"\"\n" +
                "    },\n" +
                "    \"handelEntity\": null\n" +
                "}";
        String s2=" {\n" +
                "            \"photo\": \"http://192.168.100.142/PUBLIC/CAR_IMAGE/2017-08-07/014a9b59-5717-4a04-8f3b-2fc2fcb5e120.jpg\",\n" +
                "            \"brandName\": \"奥迪\",\n" +
                "            \"modelName\": \"A3(进口)\",\n" +
                "            \"styleName\": \"2014款 Limousine 40 TFSI S line 舒适型\",\n" +
                "            \"firstRegDate\": 1441814400000,\n" +
                "            \"price\": 250000,\n" +
                "            \"carId\": 80000,\n" +
                "            \"kmNum\": 10000,\n" +
                "            \"publishTime\": null,\n" +
                "            \"isNewCar\": 0,\n" +
                "            \"isSold\": 0,\n" +
                "            \"themeName\": \"一手好车\",\n" +
                "            \"themeColor\": \"#4bbe9f\",\n" +
                "            \"ownerType\": 1,\n" +
                "            \"ownerTypeName\": null,\n" +
                "            \"provinceID\": 28,\n" +
                "            \"provinceName\": \"新疆\",\n" +
                "            \"cityID\": 316,\n" +
                "            \"cityName\": \"阿克苏\"\n" +
                "        }";
        JSONObject jsonObject = JSON.parseObject(s2);
        System.out.println(jsonObject.toString());
        HashMap<String,Object> hashMap = new JsonUtil().jsonToMap(jsonObject);
        System.out.println(hashMap.toString());


    }


}
