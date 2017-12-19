package Btjf_API.CAPI.CarSeller;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**
 * Created by wl on 2016/9/21.
 */
public class SanBaoCapi {

    private  String subUrl ="/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private SqlUtil sqlUtil = publicUtil.getSqlHander("carSeller");
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(SanBaoCapi.class);
    private static String loginNum = PublicUtil.prop.getProperty("loginNum");
    GlobalApi globalApi = new GlobalApi();

    //订金宝3.0版本以后，不再使用
    @BeforeClass(description = "检查是否有正在交易中的订金宝订单",enabled = false)
    public void checkDepositStatuscheckDepositStatus(){
        String sql = "select top 1 c.FCarID from t_LoanApply a INNER JOIN t_Member \n" +
                "b ON a.FCustID = b.FMemberID INNER JOIN t_SaleOrder c ON a.FOrderID = c.FOrderID\n" +
                "where b.FMobile='"+loginNum+"' and FLoanID=1 and a.FStatus=3 order by a.FID desc;";
        String carID = sqlUtil.getColumnValue(sql,"FCarID");
        String sql_token = "select top 1 accessToken from t_AuthAccessToken where account='"+loginNum+"' order by id DESC ;";
        String token = sqlUtil.getColumnValue(sql_token,"accessToken");
        if(carID != null){
            globalApi.cancelCarOrder(token,carID);
        }
    }

    @Test(description = "商机订金宝,验证订金宝收款人信息",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bDepositValidInfo(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/deposit/validInfo";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "订金宝,订金宝使用验证接口",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bDepositUseLimit(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/deposit/useLimit";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "商机订金宝,订金宝申请",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void bDepositApply(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/business/deposit/apply";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //取消生成的订单
        String carid = bodyMap.get("carID").toString();
        globalApi.cancelCarOrder(headMap.get("accessToken").toString(),carid);
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "订金宝,获取订金宝首页信息",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iDepositIndex(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/deposit/index";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "使用订金宝1,验证订金宝收款人信息",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iDepositNewValidatePayeeInfo(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/deposit/newValidatePayeeInfo";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "订金宝,订金宝使用上限接口",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iDepositUpLimit(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/index/deposit/upLimit";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "使用订金宝2,验证订金宝收款人信息",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iDepositValidInfo(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/deposit/validInfo";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "订金宝,验证订金宝收款人信息",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iDepositValidatePayeeInfo(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/deposit/validatePayeeInfo";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "订金宝,订金宝申请",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iDepositApply(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/deposit/apply";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //卖家确认可交易
        new GlobalApi().sellerConfirmOrder(PublicUtil.prop.getProperty("custNum"),PublicUtil.prop.getProperty("custNum"));
        //买家确认提车
        globalApi.buyerConfirmOrder(PublicUtil.prop.getProperty("loginNum"),PublicUtil.prop.getProperty("loginNum"));
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "订金宝,查询订金宝贷款记录详情（交易中)",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iDepositTradingDetail(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/deposit/trading/detail";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
//        取消生成的订单
//        LinkedHashMap<String,Object> cancleBodyMap = new LinkedHashMap<String, Object>();
//        String fid = bodyMap.get("id").toString();
//        String sql = "select FOrderID from t_SaleOrder where FSellID="+memberId+" ORDER BY FOrderID desc";
//        String orderid = sqlUtil.getColumnValue(sql,"FOrderID");
//        cancleBodyMap.put("orderID",orderid);
//        String url_cancle = subUrl+"/m/mine/order/buyer/cancel";
//        JSONObject resultJson_cancle = httpUtil.postRequest(url_cancle,headMap,cancleBodyMap);
//        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "订金宝,订金宝贷款账单记录详情（待还款）",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iDepositNorepaymentDetail(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/deposit/norepayment/detail";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "贷款记录,订金宝还款",enabled = false,groups = "SanBao", dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iDepositNewRepayDeposit(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/deposit/NewRepayDeposit";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        globalApi.depositAmountReturnPass(PublicUtil.prop.getProperty("loginNum"));
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "订金宝,订金宝贷款账单记录详情",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iDepositRepaymentDetail(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/deposit/repaymented/detail";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "收车宝,查询车商的可用额度+待还款收车宝数量+待确认数量",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iScbIndex(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/index/scb/index";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "收车宝,查询车商的可用额度+待还款收车宝数量+待确认数量_2.6.0",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iScbIndex_2_6_0(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/index/scb/index/2_6_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "收车宝申请验证,收车宝申请验证接口",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iScbApplyValid_2_3_2(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/scb/applyValid/2_3_2";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "收车宝,获取收车宝贷款信息",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iScbInterestAndBail(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/scb/interestAndBail";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "收车宝,收车宝申请",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iScbApply(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/scb/apply";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //等待五秒，等到工作流处理数据
        Thread.sleep(5000);
        //业务员审核不通过
        globalApi.scbNoPass(loginNum);
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "收车宝,收车宝贷款账单记录详情（待还款）",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iScbNorepaymentDetail(LinkedHashMap<String,String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        //插入收车宝待还款数据
        globalApi.scbApplySuccess(loginNum);
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/scb/norepayment/detail";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "收车宝,收车宝贷款选择抵押车辆还款",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iScbRepaymentSelectCar(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/scb/repayment/selectCar";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "收车宝,收车宝还款",groups = "SanBao",dependsOnMethods = {"iScbNorepaymentDetail"},dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iScbNewRepayment(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/scb/NewRepayment";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //收车宝还款审核通过
        globalApi.scbAmountReturnPass(loginNum);
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "收车宝,收车宝赎回记录",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iScbRepaymentRecords(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/scb/repayment/records";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    //已废弃
    @Test(description = "收车宝,收车宝赎回记录详情",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iScbRepaymentRecordDetail(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/scb/repayment/record/detail";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }


    @Test(description = "应收宝,获取应收宝首页信息_2.3.2",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iYsbIndex_2_3_2(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/index/ysb/index/2_3_2";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "应收宝,获取应收宝首页信息_2.6.0",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iYsbIndex_2_6_0(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/index/ysb/index/2_6_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "应收宝,查询费率信息_2.3.2",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iYsbRateInfo_2_3_2(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/ysb/rateInfo/2_3_2";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "应收宝,申请应收宝贷款_2.3.2",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iYsbLoanApply_2_3_2(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/ysb/loanApply/2_3_2";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //应收宝申请，业务员审核不通过
        globalApi.ysbNoPass(PublicUtil.prop.getProperty("loginNum"));
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "应收宝,获取最大红包金额",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iYsbMaxRedPacketMoney_2_3_2(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/ysb/maxRedPacketMoney/2_3_2";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "应收宝,向备胎讨红包",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iYsbApplyRedPacket_2_3_2(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/ysb/applyRedPacket/2_3_2";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //删除红包的申请记录
        String sql = "update t_RedPacket set FIsDelete=1 where FID\n" +
                "=(select top 1 a.FID from t_RedPacket a LEFT JOIN t_Member b ON a.FReceiverID = b.FMemberID \n" +
                "where b.FMobile='"+PublicUtil.prop.getProperty("loginNum")+"' ORDER BY a.FID desc)";
        sqlUtil.updateColumnValue(sql);
        log.info("删除红包记录成功");
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    //2.6.3重构后已废弃
    @Test(description = "应收宝,应收宝贷款详情（审核中、未通过）",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iYsbAuditedDetail_2_3_2(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/ysb/auditedDetail/2_3_2";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }


    //2.6.3重构后，已废弃，现在使用iYsbDetail_2_6_0_1接口
    @Test(description = "应收宝,应收宝贷款详情（待还款）",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iYsbUnRepaymentDetail_2_3_2(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        //生成一笔应收宝待还款订单
        globalApi.ysbApplySuccess(PublicUtil.prop.getProperty("loginNum"));
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/ysb/unRepaymentDetail/2_3_2";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "应车宝-待还款详情接口（审核中-即将逾期-已逾期）",groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iYsbDetail_2_6_0_1(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        //生成一笔应收宝待还款订单
        globalApi.ysbApplySuccess(PublicUtil.prop.getProperty("loginNum"));
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/ysb/detail/2_6_0_1";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }


    @Test(description = "应收宝,应收宝还款",groups = "SanBao", dependsOnMethods = {"iYsbDetail_2_6_0_1"},dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iYsbRepay_2_3_2(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/ysb/repay/2_3_2";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //审核还款通过
        globalApi.ysbAmountReturnPass(PublicUtil.prop.getProperty("loginNum"));
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    //2.6.3重构后，已废弃
    @Test(description = "应收宝,应收宝贷款详情（已还款）",enabled = false,groups = "SanBao",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void iYsbRepaymentDetail_2_3_2(LinkedHashMap<String,String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/index/ysb/repaymentDetail/2_3_2";
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
