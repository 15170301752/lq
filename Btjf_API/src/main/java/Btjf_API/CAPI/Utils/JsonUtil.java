package Btjf_API.CAPI.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beust.jcommander.internal.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wl on 2017/7/21.
 */
public class JsonUtil {
    public HashMap<String,Object> formatMap(HashMap<String,Object> map){
        HashMap<String,Object> mapp = new HashMap<String, Object>();
        boolean ff = false; //判断是否需要继续递归
        for(String key : map.keySet()){
            Object obj = map.get(key);
            if(obj instanceof String){
                String value = (String)obj;
                boolean flag = isJson(value);
                boolean flag1 =isJsonArray(value);
                if(flag){
                    jsonToSubmap(JSON.parseObject(value),mapp);
                    ff = true;
                }else if(flag1){
                    JSONArray jsonArray = JSON.parseArray(value);
                    List<String> arrayList = JSON.parseArray(jsonArray.toJSONString(),String.class);
                    boolean flag3 = false;
                    if(jsonArray.size()==0){
                        flag3=true;
                    }
                    for(String s:arrayList){
                        if(isJson(s)){
                            ff=true;
                            jsonToSubmap(JSON.parseObject(s),mapp);
                        }else{
                            flag3=true;
                        }
                    }
                    if(flag3){
//                        mapp.put(key,map.get(key));
                        mapp= fullMap(mapp,key,String.valueOf(map.get(key)));
                    }
                }else{
//                    mapp.put(key,map.get(key));
                    mapp= fullMap(mapp,key,String.valueOf(map.get(key)));
                }
            }else{
                mapp.put(key,map.get(key));
            }
        }
        if(ff){
            mapp = formatMap(mapp);
        }
        return mapp;
    }


    public HashMap<String,Object> jsonToSubmap(JSONObject jsonObject, HashMap<String,Object> hashMap){
        HashMap<String,Object> map = JSON.parseObject(JSONObject.toJSONString(jsonObject, SerializerFeature.WriteMapNullValue), new TypeReference<HashMap<String,Object>>(){});
        for(String key:map.keySet()){
//            hashMap.put(key,map.get(key));
            String s = String.valueOf(map.get(key));
            hashMap = fullMap(hashMap,key,s);
        }
        return hashMap;
    }

    /**
     * 判断这个key，是否已经存在，如果存在就把多个值放进list，存进map中
     * @param map
     * @param key
     * @param value
     * @return
     */
    public HashMap<String,Object> fullMap(HashMap<String,Object> map,String  key ,String value){
        Object obj = map.get(key);
        if(obj==null){
            map.put(key,value);
            return map;
        }else if(obj instanceof String){
            List<String> list = Lists.newArrayList();
            list.add((String)obj);
            list.add(value);
            map.put(key,list);
            return map;
        }else if(obj instanceof List){
            ((List) obj).add(value);
            map.put(key,obj);
            return map;
        }
        return map;
    }

    public  boolean isJson(String s ){
        try{
            if(s.equalsIgnoreCase("") || s.equalsIgnoreCase("null") || s==null){
                return false;
            }
            JSONObject json = JSON.parseObject(s);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    public boolean isJsonArray(String s){
        try{
            if(s.equalsIgnoreCase("") || s.equalsIgnoreCase("null") || s==null){return false;}
            JSONArray jsonArray = JSON.parseArray(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public HashMap<String,Object> jsonToMap(JSONObject jsonObject){
        HashMap<String,Object> map = new HashMap<String, Object>();
        HashMap<String,Object> map1 = jsonToSubmap(jsonObject,map);
        map1 = formatMap(map1);
        return map1;
    }
}
