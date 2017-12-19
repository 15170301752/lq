package Btjf_API.CAPI.Test;

import Btjf_API.CAPI.Utils.Log;
import com.beust.jcommander.internal.Lists;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wl on 2017/7/25.
 */
public class TestDemo {
    private FileTest fileTest = new FileTest();
    private Log log = new Log(TestDemo.class);

private   int i =0;
    public static void main(String[] args){
        TestDemo testDemo = new TestDemo();
//        System.out.println("");
//        if(1>2 && isValid()){
//            System.out.println("");
//        }
//     new TestDemo().getNum();
//    new TestDemo().getStr();
//new TestDemo().isValids();
//        String s = "validationCode=select TOP 1 FCode from t_code where FMobile='[ranNum11]';";
//        int x = s.indexOf("FMobile='");
//        String ss=s.substring(s.indexOf("FMobile='")+"FMobile=".length(),s.indexOf("';"));
//        List<String> list1 = Lists.newArrayList();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        list1.add("4");
//        List<String> list2 = Lists.newArrayList();
//        list2.add("a");
//        list2.add("b");
//        list2.add("c");
//        System.out.println(list1.toString());
//        list1=list2;
//        System.out.println(list1.toString());
        String s = "9990000.00";
        String s1 = "8880000.00";
        float f = Float.parseFloat(s);
        float f1 = Float.parseFloat(s1);
        System.out.println(f>f1);



    }
    public boolean isValids(){
        i=++i;
        if(i==0){
            return false;
        }else{

        }
        return true;
    }


    public String getStr(){
        String s= "";
        setStr(s);
        return s;
    }
    public void setStr(String ss){
        ss="hehe";
    }


    public static boolean isValid(int i){
        int num =  1/i;
        return true;
    }
    public void hehe(int i){
        try{
            if(isValid(i)){
                System.out.println("1111111");
            }
        }catch (Exception e){
            System.out.println("Exception");
            hehe(1);
        }
        System.out.println("done done done");
    }
    public int getNum(){
        hehe(0);
        return 1;
    }
}

