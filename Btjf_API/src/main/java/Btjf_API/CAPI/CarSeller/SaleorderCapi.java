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
 *
 * 此类中的接口需要走流程。
 * 需要有买家订单，卖家同交易的订单，买家申请退款的订单，和买家卖家交易过的订单记录
 * Created by LEE on 2017/4/14.
 */
public class SaleorderCapi {
    private String subUrl = "/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(SaleorderCapi.class);
    private GlobalApi globalApi = new GlobalApi();
    private String loginNum = PublicUtil.prop.getProperty("loginNum");

    /**
     *  POST m/business/deposit/apply
     *买家申请预约看车（为了走流程额外添加的接口）
     */
    @Test(priority =0, description = "买家申请预约看车（为了走流程额外添加的接口）",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void appointmentSeeCar(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/deposit/apply";
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
    * 订单,买方取消订单
   * POST/m/mine/order/buyer/cancel
    * (通过，注意买家必须存在订单方可取消)
   */
   @Test(priority =1,description = "订单,买方取消订单",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class,dependsOnMethods="appointmentSeeCar")
   public void mBuyerCancel(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/order/buyer/cancel";
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
     *  POST m/business/deposit/apply
     *买家申请预约看车（为了走流程额外添加的接口）
     */
//    @Test(priority =2,description = "买家申请预约看车（为了走流程额外添加的接口）",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
//    public void appointmentSeeCar2(LinkedHashMap<String, String> map)throws Exception{
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//        log.info("----------------开始执行" + methodName + "方法--------------");
//        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
//        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
//        String url = subUrl + "/m/business/deposit/apply";
//        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
//        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
//        if (!(assertMap == null)) {
//            assertUtil.strAssert(assertMap, resultJson);
//        } else {
//            Assert.assertTrue(false);
//        }
//        log.info("------------------" + methodName + "方法已经执行结束-----------");
//    }

    /**
     * POST/m/mine/order/seller/refuse
     * 订单,卖方拒绝交易
     * （通过，必须有订单才可以）
     */
    @Test(priority =3,description = "订单,卖方拒绝交易",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class,dependsOnMethods="appointmentSeeCar")
    public void mOrderSellerRefuse(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/order/seller/refuse";
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
     *  POST m/business/deposit/apply
     *买家申请预约看车（为了走流程额外添加的接口）
     */
//    @Test(priority =4,description = "买家申请预约看车（为了走流程额外添加的接口）",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
//    public void appointmentSeeCar3(LinkedHashMap<String, String> map)throws Exception{
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//        log.info("----------------开始执行" + methodName + "方法--------------");
//        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
//        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
//        String url = subUrl + "/m/business/deposit/apply";
//        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
//        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
//        if (!(assertMap == null)) {
//            assertUtil.strAssert(assertMap, resultJson);
//        } else {
//            Assert.assertTrue(false);
//        }
//        log.info("------------------" + methodName + "方法已经执行结束-----------");
//    }
    /**
     * 订单,卖方确认订单
     * POST /m/mine/order/seller/confirm
     * (通过，买家必须有交易状态为交易中的订单)
     */
    @Test(priority=5,description = "订单,卖方确认订单",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class,dependsOnMethods ="appointmentSeeCar")
    public void  mOrderSellerConfirm(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/order/seller/confirm";
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
     * 订单-退款单,买方退款申请
     *POST /m/mine/order/refundApply/buyer/apply
     * （通过，注意如果超过交易期限就无法通过会提示已经超过退款申请期限，而且必须存在交易状态为成功的订单）
     * type=1和0 两种情况
     */
    @Test(priority =6,description = "订单-退款单,买方退款申请",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void  mBuyerApply(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/order/refundApply/buyer/apply";
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
     *订单-退款单,卖方拒绝退款
     *  POST/m/mine/order/refundApply/seller/refuse
     *  (通过，用户必须存在申请退款的订单)
     *
     */
    @Test(priority =7,description = "订单-退款单,卖方拒绝退款",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void  mRefundApplySellerRefuse(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/order/refundApply/seller/refuse";
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
     * POST/m/mine/order/refundApply/buyer/update
     * 订单-退款单,买方修改退款申请
     * (通过，买家必须存在被卖家拒绝退款申请的订单)
     */
    @Test(priority =8,description = "订单-退款单,买方修改退款申请",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void  mRefundApplyBuyerUpdate(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/order/refundApply/buyer/update";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)){
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    /**
     *  GET/m/mine/order/refundApply/reason/list
     *  退款原因接口
     *  (成功，必须存在状态为买家申请退款的订单)
     */
    @Test(priority=9,description = "退款原因接口",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mRefundApplyReasonList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/order/refundApply/reason/list";
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
     *  POST/m/mine/order/refundApply/seller/agree
     *  订单-退款单,卖方同意退款
     *  (通过，买必须存在正在申请退款的订单)
     *
     */
    @Test(priority=10,description = "订单-退款单,卖方同意退款",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void  RefundApplySellerAgree(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/order/refundApply/seller/agree";
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
     *  POST m/business/deposit/apply
     *买家申请预约看车（为了走流程额外添加的接口）
     */
//    @Test(priority=11,description = "买家申请预约看车（为了走流程额外添加的接口）",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
//    public void appointmentSeeCar4(LinkedHashMap<String, String> map)throws Exception{
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//        log.info("----------------开始执行" + methodName + "方法--------------");
//        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
//        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
//        String url = subUrl + "/m/business/deposit/apply";
//        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
//        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
//        if (!(assertMap == null)) {
//            assertUtil.strAssert(assertMap, resultJson);
//        } else {
//            Assert.assertTrue(false);
//        }
//        log.info("------------------" + methodName + "方法已经执行结束-----------");
//    }
    /**
     * 订单,卖方确认订单
     * POST /m/mine/order/seller/confirm
     * (通过，买家必须有交易状态为交易中的订单)
     */
//    @Test(priority=12,description = "订单,卖方确认订单",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class,dependsOnMethods ="appointmentSeeCar")
//    public void  mOrderSellerConfirm(LinkedHashMap<String, String> map)throws Exception{
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//        log.info("----------------开始执行" + methodName + "方法--------------");
//        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
//        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
//        String url = subUrl + "/m/mine/order/seller/confirm";
//        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
//        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
//        if (!(assertMap == null)) {
//            assertUtil.strAssert(assertMap, resultJson);
//        } else {
//            Assert.assertTrue(false);
//        }
//        log.info("------------------" + methodName + "方法已经执行结束-----------");
//    }
    /**
     * 订单,买方确认提车
     * POST/m/mine/order/buyer/confirmGetCar
     * （通过，买家必须有订单，并且订单必须是成交状态）
     */
    @Test(priority=13,description = "订单,买方确认提车",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class,dependsOnMethods = {"mOrderSellerConfirm"})
    public void  mBuyerConfirmGetCar(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/order/buyer/confirmGetCar";
        JSONObject resultJson = httpUtil.postFile(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    /**
     * 订单-退款单,查询退款详情（买方）
     * GET/m/mine/order/refundApply/buyer/detail
     * （通过，买方存在交易状态为申请退款的买车的订单）
     */
    @Test(priority=14,description = "订单-退款单,查询退款详情（买方）",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void  mRefundApplyBuyerDetail(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/order/refundApply/buyer/detail";
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
     * 订单-退款协商,查询退款协商列表
     * GET/m/mine/order/refundApply/entryList
     * （通过）
     * Caused by: java.lang.NumberFormatException: For input string: "201704180003"
     */
    @Test(priority=15,description = "订单-退款协商,查询退款协商列表",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public  void mRefundApplyEntryList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/order/refundApply/entryList";
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
     *  GET/m/mine/order/refundApply/seller/detail
     *订单-退款单,查询退款详情（卖方）
     *（通过）
     */
    @Test(priority=16,description = "订单-退款单,查询退款详情（卖方）",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void  mRefundApplySellerDetail(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/order/refundApply/seller/detail";
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
     * GET/m/mine/order/buyer/detail
     * 订单,查询订单详情(买方)
     * （通过，必须存在未删除的订单记录）
     */
    @Test(priority=17,description = "订单,查询订单详情(买方)",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mBuyerDetail(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/order/buyer/detail";
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
     * 订单,查询买方订单列表
     * GET/m/mine/order/buyer/list
     * （通过，orderStatus三个选择 0 ，1 ，2）
     */
    @Test(priority=18,description = "订单,查询买方订单列表",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void  mBuyerList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/order/buyer/list";
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
     * 订单,查询订单详情(卖方)
     * GET/m/mine/order/seller/detail
     * （通过）
     */
    @Test(priority=19,description = "订单,查询订单详情(卖方)",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void  mOrderSellerDetail(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/order/seller/detail";
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
     * GET /m/mine/order/seller/list
     * 订单,查询卖方订单列表
     * (通过，分为，0，1，2，必须有未删除的订单)
     */
    @Test(priority=20,description = "订单,查询卖方订单列表",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void   mOrderSellerList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/order/seller/list";
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
     * 订单,买方删除订单
     * DELETE /m/mine/order/buyer/delete
     * （通过）
     */
    @Test(priority=21,description = "订单,买方删除订单",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void  mBuyerDelete(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/order/buyer/delete";
        JSONObject resultJson = httpUtil.deleteRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    /**
     * 订单,卖方删除订单
     * DELETE /m/mine/order/seller/delete
     * （成功deleteReuest请求方法搞定）
     * /m/mine/order/seller/delete
     */
    @Test(priority=22,description = "订单,卖方删除订单",groups = "SaleorderCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void mOrderSellerDelete(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/order/seller/delete";
        JSONObject resultJson = httpUtil.deleteRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }
}

