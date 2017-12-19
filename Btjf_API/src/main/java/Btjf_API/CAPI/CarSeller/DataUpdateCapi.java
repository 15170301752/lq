package Btjf_API.CAPI.CarSeller;

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
 * Created by LEE on 2017/3/9.
 */
public class DataUpdateCapi {
    private String subUrl = "/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    //    private SqlUtil sqlUtil = new SqlUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(MineStoreCapi.class);
    private String loginNum = PublicUtil.prop.getProperty("loginNum");
    private String storeOperateUser = PublicUtil.prop.getProperty("storeOperateUser");
    GlobalApi globalApi = new GlobalApi();

    /**
     * 广告图片配置,获取广告图片配置get
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void advertList(LinkedHashMap<String, String> map) throws Exception {

        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/advert/list";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }

    /**
     * 品牌,获取更新的银行列表get
     */
    @Test(description = "品牌,获取更新的银行列表get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bankList(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/bank/list";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }

    /**
     * 103品牌,获取更新的品牌列表get
     */
    @Test(description = "103品牌,获取更新的品牌列表get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void brandList(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/brand/list";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");

    }

    /**
     * 60201:获取更新的品牌列表get
     */
    @Test(description = "60201:获取更新的品牌列表get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void brandList_2_6_0(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/brand/list/2_6_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");

    }

    /**
     * 2.6.3 重构已废弃
     * get119:违章参数信息更新接口
     */
    @Test(description = "get119:违章参数信息更新接口",enabled = false,groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void breakRulesParamInfo(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/breakRules/paramInfo";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }

    /**
     * get121:违章参数信息更新接口(新)
     */
    @Test(description = "get121:违章参数信息更新接口(新)",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)

    public void breakRulesParamInfoNew(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/breakRules/paramInfo/new";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }

    /**
     * get10404:获取是否要热修复更新的版本信息
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bugRepairIsNeedUpdate(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/bugRepairIsNeedUpdate";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }

    /**
     *
     * post10402 更新接口 （失败）
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)

    public void datasUpdate(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/datasUpdate";
        JSONObject resultJson = httpUtil.postRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");

    }

    /**
     *get数据更新测试
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void dataUpdataTest(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/event/data/update";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get修改Host地址
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void hostsUpdate(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/event/hosts/update";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get跳转指定界面
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)

    public void eventJump(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/event/jump";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get版本更新
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void versionUpdate(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/event/version/update";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get103:获取更新的品牌厂商列表
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void factory_2_5_0(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/factory/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get60204:获取更新的品牌厂商列表
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)

    public void factory_2_6_0(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/factory/2_6_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get50201:获取权限接口
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void findAuth_2_3_2(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/findAuth/2_3_2";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get10404:获取是否要html更新的版本信息（失败）
     * @param map
     * @throws Exception
     */
    @Test(description = "获取是否要html更新的版本信息",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)

    public void htmlIsNeedUpdate(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/htmlIsNeedUpdate";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get105:获取最新的版本信息
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)

    public void latestVersion(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/latestVersion";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get101:获取更新的车型列表
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void modelList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/model/list";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get60202:获取更新的车型列表
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)

    public void modelList_2_6_0(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/model/list/2_6_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get95:退款原因获取接口
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void reasonList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/order/refundApply/reason/list";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get119:静态配置表 获取接口地址前缀
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)

    public void prefixURL_2_3_2(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/prefixURL/2_3_2";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get120:地区信息更新接口
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void regionInfo(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/regionInfo";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get118:静态配置表
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void staticConfigList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/staticConfig/list";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get102:获取更新的车款列表
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)

    public void styleList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/style/list";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *get60203:获取更新的车款列表
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void styleList_2_6_0(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/style/list/2_6_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }
    /**
     *post10403:获取是否要更新的版本信息(失败)
     * @param map
     * @throws Exception
     */
    @Test(description = "广告图片配置,获取广告图片配置get",groups = "DataUpdateCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void getVersionUpdate(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/system/data/versionUpdate";
        JSONObject resultJson = httpUtil.postRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("--------------" + methodName + "方法执行已结束-------------");
    }



}
