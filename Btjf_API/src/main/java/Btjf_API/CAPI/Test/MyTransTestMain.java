package Btjf_API.CAPI.Test;

import org.testng.TestNG;

import java.security.MessageDigest;
import java.util.HashMap;

/**
 * Created by wl on 2016/7/6.
 */
public class MyTransTestMain {
    public static void main(String[] args){
//        Boolean bool = true;
//        MyTrans myTrans = new MyTrans();
//        myTrans.setBool(bool);
//        TestNG testNG = new TestNG();
//        testNG.setAnnotationTransformer(myTrans);
//        testNG.setTestClasses(new Class[]{MyTransTest.class});
//        testNG.run();
//    String sign = new MyTransTestMain().generateSign("123456");
//    System.out.println(sign);

    }

    public String generateSign(String str){
        String result = "";
//        String str = "123456e10adc3949ba59abbe56e057f20f883e";

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update((str).getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte b[] = md5.digest();
        int i;
        StringBuffer buf = new StringBuffer("");
        for(int offset=0; offset<b.length; offset++){
            i = b[offset];
            if(i<0){
                i+=256;
            }
            if(i<16){
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }
        result = buf.toString();
//        System.out.println("result = " + result);
        return result;
    }

}
