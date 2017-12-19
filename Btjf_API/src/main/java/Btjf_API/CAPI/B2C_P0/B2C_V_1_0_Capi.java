package Btjf_API.CAPI.B2C_P0;

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
 * 备胎好车B2C接口类1
 * Created by LEE on 2017/3/20.
 */
public class B2C_V_1_0_Capi {

    private String subUrl = "/personal-client-interface";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(B2C_V_1_0_Capi.class);

    /**
     *GET /m/index/approvalorder/detail/1_0_0_0
     * 扫码地址
     * @param map
     * @throws Exception
     */
    @Test(description = "扫码地址", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void iApprovalorderDetail(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/approvalorder/detail/1_0_0_0";
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
     * post /m/index/approvalorder/confirm/1_0_0_0
     * 贷款单确认接口
     * @param map
     * @throws Exception
     */
    @Test(description = "贷款单确认接口", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void iApprovalorderConfirm(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/index/approvalorder/confirm/1_0_0_0";
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
    * 贷款单核实接口
    * POST /m/index/approvalorder/check/1_0_0_0
    */
    @Test(description = "贷款单核实接口", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void  iApprovalorderCheck(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/index/approvalorder/check/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }
    /**
     * 这个接口在swagger中没找到
     * get/m/service/repayment/approvalorder/isbind/1_0_0_0
     * 是否关联核准单
     * @param map
     * @throws Exception
     */
    @Test(description = "是否关联核准单", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void rApprovalorderIsbind(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/repayment/approvalorder/isbind/1_0_0_0";
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
     * GET/m/service/repayment/waitrepayment/list/1_0_0_0
     * 待还款账单数据列表接口
     * @param map
     * @throws Exception
     */
    @Test(description = "待还款账单数据列表接口", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void rWaitrepaymentList(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/repayment/waitrepayment/list/1_0_0_0";
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
     * GET/m/service/repayment/repaymented/list/1_0_0_0
     * 已还款账单数据列表接口
     * @param map
     * @throws Exception
     */
    @Test(description = "已还款账单数据列表接口", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void rRepaymentedList(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/repayment/repaymented/list/1_0_0_0";
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
     * post/m/service/repayment/payment/order/1_0_0_0
     * 支付下单
     * @param map
     * @throws Exception
     */
    @Test(description = " 支付下单", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void rPaymentOrder(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/service/repayment/payment/order/1_0_0_0";
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
     * GET /m/service/cashier/payment/info/1_0_0_0
     * 收银台支付信息接口
     * @param map
     * @throws Exception
     */
    @Test(description = "收银台支付信息接口", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void sCashierPaymentInfo(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/cashier/payment/info/1_0_0_0";
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
     * GET/m/service/repayment/repayment/card/info/1_0_0_0
     * 还款卡查询接口
     * @param map
     * @throws Exception
     */
    @Test(description = "还款卡查询接口", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void rRepaymentCardInfo(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/repayment/repayment/card/info/1_0_0_0";
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
     * GET/m/service/repayment/card/isbind/1_0_0_0
     * 是否有还款卡
     * @param map
     * @throws Exception
     */
    @Test(description = "是否有还款卡", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void rCardIsbind(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/common/code/voice/verificationCode/1_0_0_9";
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
     * POST /m/service/cashier/payment/pay/1_0_0_0
     * 确认支付接口
     * @param map
     * @throws Exception
     */
    @Test(description = "确认支付接口", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void cashierPaymentPay(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/service/cashier/payment/pay/1_0_0_0";
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
     * post/m/service/repayment/approvalorder/confirms/1_0_0_0
     * 贷款单确认接口
     * @param map
     * @throws Exception
     */
    @Test(description = "贷款单确认接口", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void approvalorderConfirms(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/service/repayment/approvalorder/confirms/1_0_0_0";
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
     * get /m/service/repayment/approvalorder/list/1_0_0_0
     * 贷款单查询接口
     * @param map
     * @throws Exception
     */
    @Test(description = "贷款单查询接口", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void approvalorderList(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/repayment/approvalorder/list/1_0_0_0";
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
     * POST/m/mine/bankcard/bind/1_0_0_0
     * 绑定还款卡接口
     * @param map
     * @throws Exception
     */
    @Test(description = "绑定还款卡接口", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void bankcardBind(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/bankcard/bind/1_0_0_0";
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
     * POST/m/mine/bankcard/bind/firststep/1_0_0_0
     * 绑定银行卡第一步
     * @param map
     * @throws Exception
     */
    @Test(description = "绑定银行卡第一步", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void bindFirststep(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/bankcard/bind/firststep/1_0_0_0";
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
     * POST/m/mine/bankcard/bind/next/1_0_0_0
     * 绑定银行卡数据验证
     * @param map
     * @throws Exception
     */
    @Test(description = "绑定银行卡数据验证", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void bindNext(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/mine/bankcard/bind/next/1_0_0_0";
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
     * get/m/common/bank/list/1_0_0_0
     * 支持银行列表
     * @param map
     * @throws Exception
     */
    @Test(description = "支持银行列表", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void bankList1_0_0_0(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/common/bank/list/1_0_0_0";
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
     * GET/m/common/bank/branch/list/1_0_0_0
     * 获取系统支持的还款银行支行的列表
     * @param map
     * @throws Exception
     */
    @Test(description = "获取系统支持的还款银行支行的列表", groups = "B2CV1", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void branchList(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/common/bank/branch/list/1_0_0_0";
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
