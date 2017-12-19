package Btjf_API.CAPI.Test;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by wl on 2016/12/22.
 */
public class UpdateProp {

    public static void main(String[] args)throws Exception {
//        String path="src/main/java/Btjf_API/CAPI/Test/EnvConfig.properties";
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));
//        StringBuilder sb = new StringBuilder();
//        String ss=null;
//        while ((ss=br.readLine())!=null){
//            System.out.println(ss);
//            sb.append(ss);
//            sb.append("\r\n");
//        }
//        String s=sb.toString();
//        if(sb.toString().contains("EnvPropName=50000")){
//            s = s.replace("EnvPropName=50000","EnvPropName=60000");
//        }
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"utf-8"));
//        bw.write(s);
//        br.close();
//        bw.close();
//        String key = "login1_0_0_0_2";
//        int index = key.lastIndexOf("_");
//        System.out.println(index);
//        String str = key.substring(0,index);
//        System.out.println(str);
//        LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
//        map.put("ab","1");
//        map.put("ac","1");
//        map.put("abc","1");
//        map.put("aa","2");
//        ArrayList<Map.Entry<String,String>> list = new UpdateProp().formateMap(map);
//        ArrayList<String> list = new UpdateProp().formatMap_2(map);
//        System.out.println(list.toString());


    }

    public ArrayList<Map.Entry<String,String>> formateMap(LinkedHashMap<String,String> map){
        ArrayList<Map.Entry<String,String>> list  = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return (o1.getKey().toString().compareTo(o2.getKey()));
            }
        });
        return list;
    }

    public ArrayList<String> formatMap_2(LinkedHashMap<String,String> map){
        ArrayList<String> list = new ArrayList<String>();
        Set<String> keys = map.keySet();
        for(String key :keys){
            list.add(key);
        }
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }
}
