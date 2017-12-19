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
 * Created by wl on 2017/7/20.
 */
public class B2C_CarBargain_1_2_0 {
    private String subUrl = "/personal-client-interface";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(B2C_CarBargain_1_2_0.class);

    @Test(description = "未登录用户砍价判断", groups = "B2C_CarBargain_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBusinessCarUserCheckBargain(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/bargain/checkBargain/1_1_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap,bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);

        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "砍价提交接口", groups = "B2C_CarBargain_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBusinessCarUserAddBargain(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/bargain/addBargain/1_1_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap,bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "车辆是否砍价接口", groups = "B2C_CarBargain_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBusinessBargainCarDetail(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/car/detail/1_0_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap,bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "砍价记录查询", groups = "B2C_CarBargain_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mMineCollectionCarBargainList(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/bargain/bargainList/1_1_0_0";
        JSONObject resultJson = httpUtil.getRequest(url, headMap,bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "删除砍价", groups = "B2C_CarBargain_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mMineCollectionCarUserDelBargain(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/bargain/delBargain/1_1_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap,bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(bodyMap,map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }

    @Test(description = "验证码判断", groups = "B2C_CarBargain_1_2_0", dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void mBusinessCarUserCheckBargainCode(LinkedHashMap<String, String> map)throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/business/bargain/checkBargainCode/1_1_0_0";
        JSONObject resultJson = httpUtil.postForm(url, headMap,bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(bodyMap,map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
        log.info("------------------" + methodName + "方法已经执行结束-----------");
    }



}
