package Btjf_API.CAPI.CarSeller;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**
 * Created by wl on 2016/8/27.
 */
public class CarInterCapi {
    private  String subUrl ="/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(CarInterCapi.class);
    private GlobalApi globalApi = new GlobalApi();

    //2.6.3重构后已废弃
    @Test(description = "筛选数量接口,筛选数量统计2_4_0",enabled = false,groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carNum_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/car/carNum/2_4_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "筛选数量接口,筛选数量统计2_5_0",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carNum_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/car/carNum/2_5_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车辆详情-详细配置",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carConfigDetail_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/car/configDetail/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "根据销售线索联系客户",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carCreateSaleKey_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/car/createSaleKey/2_4_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车辆,查询车辆详情",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carDetail(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/car/detail";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    //2.6.3重构后已废弃
    @Test(description = "车辆,查询车辆详情2_4_0",enabled = false,groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carDetail_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/car/detail/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车辆,查询车辆详情2_5_0",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carDetail_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/car/detail/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "发布车辆,发布车辆新接口2_4_0",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carPublish_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
//        new GlobalApi().carLogin(PublicUtil.prop.getProperty("loginNum"),"123456");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/car/publish/2_4_0";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //车辆审核不通过
        globalApi.carNoPass(PublicUtil.prop.getProperty("loginNum"));
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车辆,查询车辆详情2_5_0",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carSearch_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/car/search/2_5_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "搜索品牌车型接口,搜索品牌车型接口2.5.0",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carSearchStats_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/car/search/stats/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    //2.6.3重构后，方法废弃
    @Test(description = "车辆,查询车商的可抵押车辆列表",enabled = false,groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void cCarCapableMortgageList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/common/cust/car/capableMortgageList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车辆,获取车辆的系统评估价",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carEvaluate(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/common/cust/car/evaluate";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "商机订金宝专用,获取车辆的系统评估价",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carEvaluateForDeposit(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/common/cust/car/evaluateForDeposit";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    //2.6.3重构后已废弃
    @Test(description = "车辆,查询车商的待补全车辆列表",enabled = false,groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carIncompleteList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/common/cust/car/incompleteList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车辆,查询车商的售卖车辆列表",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carSellList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/common/cust/car/sellList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车辆,查询我的抵押车辆列表",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carCapableAndMortgagedList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/car/capableAndMortgagedList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车辆,查询我的的可抵押车辆列表",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mCarCapableMortgageList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/car/capableMortgageList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车辆,补全车辆信息",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carComplete(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/car/complete";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        globalApi.vinNoPass(bodyMap.get("carID").toString());  //提交审核后，执行sql，审核不通过
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "可抵押车辆列表,可抵押车辆列表接口",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carMortgageAable(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/car/mortgage/able";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "已抵押车辆列表,已抵押车辆列表接口",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carMortgageAlready(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/car/mortgage/already";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "查询审核中车辆列表,查询车商的审核中车辆列表",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carMortgageCheckingCarsList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/car/mortgage/checkingCarsList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "抵押库车辆详情,抵押库车辆详情接口",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carMortgageDetail(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/car/mortgage/Detail";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "查询待补全车辆列表,查询车商的待补全车辆列表",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carMortgageIncompleteCarsList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/car/mortgage/incompleteCarsList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "抵押车库主界面,主界面接口",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carMortgageIndex(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        String url = subUrl +"/m/mine/car/mortgage/index";
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "查询未通过车辆列表,查询车商的未通过车辆列表",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carMortgageNopassCarsList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        String url = subUrl +"/m/mine/car/mortgage/nopassCarsList";
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "查询待盘库车辆列表,查询车商的待盘库车辆列表",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carMortgageWaitInventoryCarsList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        String url = subUrl +"/m/mine/car/mortgage/waitInventoryCarsList";
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "车辆,查询我的所有在售车辆信息",groups = "car",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void carSellAll(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        String url = subUrl +"/m/mine/car/sell/all";
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }






}
