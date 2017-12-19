package Btjf_API.CAPI.Test;

import Btjf_API.CAPI.Utils.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.assertj.core.api.Assertions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by wl on 2016/6/19.
 */
public class Test implements Runnable{
    CyclicBarrier cb;
    HashMap<String, Object> headMap;
    public Test(){};
    public Test(CyclicBarrier barrier){
        super();
        this.cb = barrier;
    }
    public void run(){
        try {
            System.out.println("等待集合");
            cb.await();//集合点
            fun();//并发执行fun方
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    public static void main(String[] args)throws Exception{
//        ExecutorService executor = Executors.newFixedThreadPool(2);//创建一个线程池管理，线程数为3
//        CyclicBarrier cb = new CyclicBarrier(1);//num为需要并发的线程数
//        executor.execute(new Thread(new Test(cb)));
       // executor.execute(new Thread(new Test(cb)));
        //executor.execute(new Thread(new Test(cb)));//num为多少，就execute多少个
//        executor.shutdown();
        new Test().fun();
    }
    public void fun()throws Exception{
//        String url="/car-seller-client-interfaces/m/mine/myWallet/withdraw";
        String url="/maintenance-manage-website/thirdpart/hxNotify";
        HttpUtil httpUtil = new HttpUtil();
        HashMap<String, Object> headMap = new HashMap<String, Object>();
        HashMap<String, Object> bodyMap = new HashMap<String, Object>();
//        String afterUrl = "/maintenance-manage-website/thirdpart/hxNotify";
//        headMap.put("deviceCode","245b40dbbc961c91");
//        headMap.put("GPS","30.336137612047892,120.118483669277126");
//        headMap.put("AccessToken","1e0457e8-2068-4aca-aa69-1ae702c989a7");
//        headMap.put("requestToken","18645A7D-B024-4BDC-BE07-638516EA3C45");
        bodyMap.put("order_id","186");
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        System.out.println(resultJson.toString());
        if(resultJson==null){
            System.out.println("返回数据错误");
            Assert.assertNotNull(resultJson);
        }

        System.out.println(resultJson.get("code"));
    }
}