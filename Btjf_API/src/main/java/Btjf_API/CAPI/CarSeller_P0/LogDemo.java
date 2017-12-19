package Btjf_API.CAPI.CarSeller_P0;

import Btjf_API.CAPI.Utils.Log;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by wl on 2016/6/28.
 */
public class LogDemo {
    private static Log log = new Log(LogDemo.class);
    public static void main(String[] args){
        log.info("hehe");
        log.debug("heihei");
        log.error("haha");
//        String s1 = new String("hehe");
//        String s2= new String("hehe");
//        Boolean b1 = s1 == s2;
//        Boolean b2 = s1.equals(s2);
//        System.out.println(b1);
//        System.out.println(b2);
        String file = "G:\\Btjf_API\\src\\main\\resources.EnvTestConfig";
        ResourceBundle rb = ResourceBundle.getBundle(file);
        System.out.println(rb.getString("name"));
    }

}
