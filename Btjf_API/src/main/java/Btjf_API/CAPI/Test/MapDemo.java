package Btjf_API.CAPI.Test;

import java.util.LinkedHashMap;

/**
 * Created by wl on 2017/8/24.
 */
public class MapDemo {
    public static void main(String[] args){
        LinkedHashMap<String,Object> map = new LinkedHashMap<String,Object >();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        String s = (String)map.get("4");
        String s1 = (String)map.get("2");
        String s2 = (String)map.get("3");
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        if(s==null){
            System.out.println("666");
        }
    }
}
