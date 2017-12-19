package Btjf_API.CAPI.B2C_P0;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.AssertUtil;
import Btjf_API.CAPI.Utils.HttpUtil;
import Btjf_API.CAPI.Utils.Log;
import Btjf_API.CAPI.Utils.PublicUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.LinkedHashMap;

/**
 * B2C接口之B2C销售线索&分期购车&浏览记录
 * Created by LEE on 2017/3/24.
 */
public class B2C_SalePotCapi {
    private String subUrl = "/personal-client-interface";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(B2C_SalePotCapi.class);
    /**
     * 申请分期购车(服务，分期购车)
     *POST/m/service/car/dividestage/apply/1_0_0_0
     * 通过
     */
    @Test(description = "申请分期购车(服务，分期购车)", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mServiceDividestageApplay(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/service/dividestage/apply/1_0_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }
    /**
     *申请分期购车(车辆详情页，分期购车)
     * post/m/business/car/dividestage/apply/1_0_0_0
     * （已解决）
     */
    @Test(description = "申请分期购车(车辆详情页，分期购车)", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBusinessDividestageApply(LinkedHashMap<String, String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/dividestage/apply/1_0_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    /**
     *分期购车接口查看我的消费意向（分期购）列表
     *get/m/business/car/dividestage/applyrecord/1_0_0_0
     * （接口地址有错误修改后可通过）
     */
    @Test(description = "分期购车接口查看我的消费意向（分期购）列表", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBusinessDividestageApplyrecord(LinkedHashMap<String, String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/dividestage/applyrecord/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }
    /**
     * 分期购车接口获取详情
     *GET/m/business/car/dividestage/applydetail/1_0_0_0
     * (接口地址错误修改地址后可通过)
     */
    @Test(description = "分期购车接口获取详情", groups = "B2CSC",dependsOnMethods = "mBusinessDividestageApply",dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBusinessDividestageApplydetail(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/dividestage/applydetail/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }
    /**
     * 推荐相关车源
     *get/m/business/car/dividestage/recommendCar/1_0_0_0
     * (已通过)
     */
    @Test(description = "推荐相关车源", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBusinessDividestageRecommendCar(LinkedHashMap<String, String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/dividestage/recommendcar/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }
    /**
     * 销售线索创建接口
     *post/m/service/salekey/apply/1_0_0_0
     * (接口地址有误修改后可通过测试)
     */
    @Test(description = " 销售线索创建接口", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSalekeyApply(LinkedHashMap<String, String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/salekey/apply/1_0_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }
    /**
     *获取销售线索列表
     *get/m/service/salekey/search/1_0_0_0
     * （接口地址有误改变接口地址可通过）
     */
    @Test(description = "获取销售线索列表", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSalekeySearch(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/main/salekey/list/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }
    /**
     * 删除销售线索
     *POST/m/service/salekey/delete/1_0_0_0
     * (接口地址改变修改过后可通过 注意必须有联系记录方可通过)
     */
    @Test(description = "删除销售线索", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mSalekeyDelete(LinkedHashMap<String, String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/main/salekey/delete/1_0_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }
    /**
     * 收藏车辆
     *POST/m/mine/collection/car/collect/1_0_0_0
     * (接口地址改变修改过后可通过 注意一定要传入未收藏过的车ID)
     */
    @Test(description = "收藏车辆", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mCollectionCarCollect(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/collect/car/1_0_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }
    /**
     * 获取我的车辆收藏记录
     *GET/m/mine/collection/car/list/1_0_0_0
     * （已通过后又出现问题）
     */
    @Test(description = "获取我的车辆收藏记录", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mCollectionCarList(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/collection/car/list/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }
    /**
     * 取消收藏车辆
     *post/m/mine/collection/car/cancel/1_0_0_0
     * (接口地址改变修改过后可通过 注意必须依赖mCollectionCarCollect方法的运行)
     */
    @Test(description = "取消收藏车辆", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class,dependsOnMethods ="mCollectionCarCollect")
    public void mCollectionCarCancel(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/collect/car/cancel/1_0_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    /**
     * 浏览记录列表
     *get/m/mine/browse/list/1_0_0_0
     * (通过)
     */
    @Test(description = "浏览记录列表", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBrowseList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/browse/list/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }
    /**
     * 删除浏览记录
     *POST/m/mine/browse/delete/1_0_0_0
     */
    @Test(description = "删除浏览记录", groups = "B2CSC", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBrowseDelete(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/browse/delete/1_0_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

}
