package Btjf_API.CAPI.CarSeller_P0;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**
 * Created by wl on 2017/1/4.
 */
public class MyWalletCapi {
    private  String subUrl ="/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(MyWalletCapi.class);
    private String loginNum = PublicUtil.prop.getProperty("loginNum");
    private String unBankUser = PublicUtil.prop.getProperty("unBankUser");
    private String realBankCard = PublicUtil.prop.getProperty("realBankCard");
    GlobalApi globalApi = new GlobalApi();

    @Test(description = "我的钱包-可用代金券列表,可用代金券列表接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletAbleCoupon(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/ableCoupon";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "银行卡详情接口,我的钱包-银行卡详情,银行卡详情接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletBankCardDetail_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/bankCardDetail/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "输入卡号获取开户银行、城市接口（并进行三元验证）",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletNewGetBankCardInfo_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/new/getBankCardInfo/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "获取支行信息,根据银行卡信息以及开户城市获取开户支行接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletNewFindSubBankCardInfo_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/new/findSubBankCardInfo/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "绑定银行卡,绑定银行卡接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletNewAddBankCard_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/new/addBankCard/2_4_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //解绑银行卡
        globalApi.removeBankCard(unBankUser);
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "银行卡列表,银行卡列表",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletNewDrawIndex_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/myWallet/new/drawIndex/2_4_0";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "我的钱包-不可用代金券列表,不可用代金券列表接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletDisableCoupon(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/disableCoupon";
        JSONObject resultJson = httpUtil.getRequest(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "我的钱包-钱包首页,钱包首页接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletIndex(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/myWallet/index";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "银行卡解绑,银行卡解绑",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletNewUnbindBankCard_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        //绑定银行卡
        globalApi.addBankCard_2(unBankUser,"6212261202033369209");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/new/unbindBankCard/2_4_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "银行卡保存,银行卡保存",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletNewSaveBankCard_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/new/saveBankCard/2_4_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "老数据-验证银行卡,老数据-验证银行卡接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletNewVerifyBankCard_2_4_0(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        //把银行卡置为待验证状态
        globalApi.verifyBank(unBankUser,realBankCard);
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/new/verifyBankCard/2_4_0";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "我的钱包-充值首页,充值首页接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletPayIndex(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/myWallet/payIndex";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "我的钱包-充值首页,充值首页接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletPayIndex_2_5_1(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/myWallet/payIndex/2_5_1";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "我的钱包-线下充值,线下充值接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletOfflinePay(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/offlinePay";
        JSONObject resultJson = httpUtil.postFile(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //审核充值不通过
        globalApi.BailInNoPass(loginNum);
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "我的钱包-支付,支付接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletPay(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/pay";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "支付失败或取消状态回调,支付失败或取消状态回调接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletPayMoneyNotSuccess(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/payMoneyNotSuccess";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "我的钱包-提现详情,提现详情接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletWithdrawDetail(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        String url = subUrl +"/m/mine/myWallet/withdrawDetail";
        JSONObject resultJson = httpUtil.getRequest(url,headMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }

    @Test(description = "我的钱包-提现接口,提现接口",groups = "MyWallet",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void myWalletWithdraw(LinkedHashMap<String,String> map) throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/mine/myWallet/withdraw";
        JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        LinkedHashMap<String,Object> assertMap = publicUtil.getAssertMap(map);
        if(!(assertMap == null)){
            assertUtil.strAssert(assertMap,resultJson);
        }else{
            Assert.assertTrue(false);
        }
        //提现单审核不通过
        globalApi.BailOutNoPass(loginNum);
        log.info("--------------"+methodName+"方法执行已结束-------------");
    }














}
