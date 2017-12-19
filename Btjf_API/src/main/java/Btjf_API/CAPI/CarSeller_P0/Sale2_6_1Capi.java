package Btjf_API.CAPI.CarSeller_P0;
import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**@author 李强
 * Created by LEE on 2017/2/22.
 */
public class Sale2_6_1Capi {
    private String subUrl = "/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(Sale2_6_1Capi.class);
    private String carImageID ;
    private GlobalApi globalApi = new GlobalApi();

    @Test(description = "卖车热点", groups = "Sale", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void saleCarHot(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/sell/car/has-unpaid";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }

    @Test(description = "卖车首页", groups = "Sale", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void saleFirstPage(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/sell/car/index";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }

    @Test(description = "询价记录", groups = "Sale", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void askPriceRecord(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/sell/inquiry/record/list";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }

    @Test(description = "询价页面数据获取接口", groups = "Sale", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void dataGetInterface(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/sell/inquiry/index";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "询询价提交接口", groups = "Sale", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void askSubmitInterface(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/sell/inquiry/apply";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("--------------------" + methodName + "方法执行结束----------");
    }

    @Test(description = "询价状态", groups = "Sale", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void askStatusInterface(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/sell/inquiry/status";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("---------------" + methodName + "方法执行已结束-------");

    }

    @Test(description = "销售线索创建接口", groups = "Sale", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void createSalesLeads(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/car/createSaleKey/2_4_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("----------------" + methodName + "方法执行已结束-------");

    }

    @Test(description = "获取未联系和已联系的销售线索列表接口", groups = "Sale", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void salesLeadsList(LinkedHashMap<String, String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/store/saleClue/list";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }

    }

    @Test(description = "发车，上传图片", groups = "Sale", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mCommonFileUpload_2_6_1_0(LinkedHashMap<String, String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/common/file/upload/2_6_1_0";
        JSONObject resultJson = httpUtil.postFile(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        carImageID = resultJson.getString("object");
    }

    @Test(description = "发车接口 2_6_1", groups = "Sale", dependsOnMethods = {"mCommonFileUpload_2_6_1_0"},dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBusinessCarPublish_2_6_1_0(LinkedHashMap<String, String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String[] arr = {carImageID,carImageID,carImageID,carImageID,carImageID,carImageID};
        bodyMap.put("carPhoto",arr);
        String url = subUrl + "/m/business/car/publish/2_6_1_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        //车辆审核不通过
        globalApi.carNoPass(PublicUtil.prop.getProperty("loginNum"));

    }


}
