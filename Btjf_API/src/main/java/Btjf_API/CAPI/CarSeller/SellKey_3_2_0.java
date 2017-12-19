package Btjf_API.CAPI.CarSeller;

import Btjf_API.CAPI.B2C.*;
import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.AssertUtil;
import Btjf_API.CAPI.Utils.HttpUtil;
import Btjf_API.CAPI.Utils.Log;
import Btjf_API.CAPI.Utils.PublicUtil;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**
 * Created by BT01 on 2017/7/21.
 */
public class SellKey_3_2_0 {
    private String subUrl = "/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private GlobalApi globalApi = new GlobalApi();
    private Log log = new Log(B2C_SalePotCapi.class);
    private String loginNum = PublicUtil.prop.getProperty("loginNum");


    /**
     * 线索管理-卖车主页线索
     *GET/m/sell/car/index
     * 通过
     */
    @Test(description = "线索管理-卖车主页线索", groups = "SellKey_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSellKeyIndex(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/sell/car/index";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    /**
     *线索管理-线索列表
     *GET/m/clue/list/1_1_0_0
     * 通过
     */
    @Test(description = "线索管理-线索列表", groups = "SellKey_3_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSellKeyList(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/clue/list/1_1_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    /**
     *线索管理-线索详情
     *GET/m/clue/detail/1_1_0_0
     * 通过
     */
    @Test(description = "线索管理-线索详情", groups = "SellKey_3_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSellKeyDetail(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/clue/detail/1_1_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "线索管理-收车线索（我的询价记录）", groups = "ClueManageCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSellKeyCollectList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url =subUrl+"/m/clue/collect_clue_list/1_1_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "忽略/回拨", groups = "ClueManageCapi", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSellKeyHandle(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        //先调用询价接口，产生一条询价记录
        if(map.get("CaseID").equalsIgnoreCase("MHDL1") || map.get("CaseID").equalsIgnoreCase("MHDL2")) {
            Thread.sleep(5000);
            globalApi.inquiryApply(loginNum);
        }
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url =subUrl+"/m/clue/handle/1_1_0_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(bodyMap,map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }



}
