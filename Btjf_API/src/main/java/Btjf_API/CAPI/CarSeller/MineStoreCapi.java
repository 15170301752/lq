package Btjf_API.CAPI.CarSeller;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**
 * Created by wl on 2017/1/11.
 */
public class MineStoreCapi {
    private  String subUrl ="/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
//    private SqlUtil sqlUtil = new SqlUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(MineStoreCapi.class);
    private String loginNum = PublicUtil.prop.getProperty("loginNum");
    private String storeOperateUser = PublicUtil.prop.getProperty("storeOperateUser");
    private String storeOperateManager = PublicUtil.prop.getProperty("storeOperateManager");
    GlobalApi globalApi = new GlobalApi();

    @Test(description = "在售车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bStoreCarSellList_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/store/car/sell-list/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "已售车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bStoreCarSoldList_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/store/car/sold-list/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "已售车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bStoreDetail(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/store/detail";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "已售车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bStoreDetail_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/store/detail/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "获取个人主页详情",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bStorePerson_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/store/person/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "搜索店铺列表接口,搜索店铺列表接口",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bStoreSearch_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/store/search/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "根据关键词搜店铺接口,根据关键词搜店铺接口",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bStoreSearchStats_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/store/search/stats/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "根据关键词搜店铺接口,根据关键词搜店铺接口",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bStoreSearchStats_2_5_2(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/store/search/stats/2_5_2";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取品牌选择列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreBrandList_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/brand/list/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取品牌选择列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreBrandSelectList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/brand/selectlist";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "根据销售线索联系客户",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreCallSeller_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/callSeller/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取审核中车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreCarAuditList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/car/auditList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "在售车辆,车辆下架",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreCarDown(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        //把用户相关车辆设置为在售状态
        globalApi.carToSellUp(storeOperateUser);
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/car/down";
        JSONObject resultJson = httpUtil.putRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取已下架车辆车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreCarDownList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/car/downList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取审核未通过车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreCarNotPassList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/car/notPassList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取在售车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreCarSaleList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/car/saleList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "设为已售",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreCarSellSuccess_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        //把车辆改为上架状态
        globalApi.carToSellUp(storeOperateUser);
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/car/sell-success/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取已售车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreCarSoldList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/car/soldList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "在售车辆,车辆上架",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreCarUp(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        //把用户相关车辆设置为下架状态
        globalApi.carToSellDown(storeOperateUser);
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/car/up";
        JSONObject resultJson = httpUtil.putRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "别人查看店铺主页",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreCode_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/code/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺资料详情接口,店铺资料详情",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreDetail_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/store/detail/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,更新店铺资料",enabled = false ,groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreEdit(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/edit";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //店铺审核通过
        globalApi.setStorePass(publicUtil.getDataMapPhone(map,"storeOperateUser"));
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺资料提交接口,店铺资料提交接口",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreEdit_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/edit/2_5_0";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //店铺审核通过
        globalApi.setStorePass(publicUtil.getDataMapPhone(map,"storeOperateUser"));
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺认证",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreIdentity_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/identity/2_4_0";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //认证审核不通过
        globalApi.certificationNoPass(publicUtil.getDataMapPhone(map,"registerNum"));
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺认证详情",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreIdentityDetail_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/identity/detail/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取店铺管理首页",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreIndex(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/store/index";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "我的店铺,我的店铺接口",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreIndex_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/store/index/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取店铺资料",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreInformation(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/store/information";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,主营车型添加",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreMainModelAdd(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/mainModel/add";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,主营车型删除",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreMainModelDelete(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/mainModel/delete";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取主营车型列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreMainModelList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/store/mainModel/list";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "开通店铺接口,开通店铺接口(本质认证)（店铺）",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreOpen_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/open/2_5_0";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //认证审核不通过
        globalApi.certificationNoPass(publicUtil.getDataMapPhone(map,"registerNum"));
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店招图片接口,店招图片接口",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStorePhoto_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/store/photo/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "校验发车",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreReleaseVerify_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/release/verify/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "已联系销售线索列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreSaleClueCalled_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/saleClue/called/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "已联系销售线索列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreSaleClueNoCalled_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/saleClue/noCalled/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取已下架车辆车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreSellDownList_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/sell/down-list/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取已售车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreSellSoldList_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/sell/sold-list/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理,获取在售车辆列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreSellUpList_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/sell/up-list/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "获取销售线索详情",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreSelleDetail_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/selleDetail/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "客户经理解除关系",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreStaffLeave_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        new PublicUtil().initManager();
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/store/staff/leave/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺二维码",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreStoreCode_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/store/storeCode/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "跳到车商主页",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreStoreCode_2_5_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/storecode/2_5_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理-人员管理,添加人员",groups = "MineStore",dependsOnMethods = {"mStoreStaffLeave_2_4_0"},dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreUserAdd(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/user/add";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //操作认证为该车上的客户经理(车商手机号，客户经理手机号)
        globalApi.validation_Manager(storeOperateUser,storeOperateManager);
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理-人员管理,删除人员",groups = "MineStore",dependsOnMethods = {"mStoreUserAdd"},dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreUserDelete(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/store/user/delete";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "人员管理,身份列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreUserIdentityList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/store/user/identityList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "店铺管理-人员管理,获取人员列表",groups = "MineStore",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mStoreUserUserList(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/store/user/userList";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }












}
