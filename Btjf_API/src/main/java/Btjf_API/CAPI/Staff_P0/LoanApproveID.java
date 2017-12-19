package Btjf_API.CAPI.Staff_P0;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.AssertUtil;
import Btjf_API.CAPI.Utils.HttpUtil;
import Btjf_API.CAPI.Utils.Log;
import Btjf_API.CAPI.Utils.PublicUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;



/**
 * Created by wl on 2017/4/27.
 */
public class LoanApproveID {
    private String subUrl = "/api";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private StaffGlobalApi staffGlobalApi = new StaffGlobalApi();
    private Log log = new Log(LoanApproveID.class);
    private String empPhone = "18800000001";
    private String TempApplyId = "";

    @Test(description = "核准单缓存接口", groups = "LoanApproveID",dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void LoanApproveCache(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        //新建征信单
        staffGlobalApi.CreateCredit(empPhone);
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/LoanApply/AddApplyInCache";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        TempApplyId = resultJson.getString("object");
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(description = "核准单缓存接口", groups = "LoanApproveID",dependsOnMethods = {"LoanApproveCache"},dataProvider = "P0_data_excel", dataProviderClass = DataPro.class)
    public void LoanApproveApply(LinkedHashMap<String, String> map) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        bodyMap.put("TempApplyId",TempApplyId);
        String url = subUrl + "/LoanApply/AddLoanApply";
        JSONObject resultJson = httpUtil.postForm(url, headMap, bodyMap);
        LinkedHashMap<String, Object> assertMap = publicUtil.getAssertMap(map);
        if (!(assertMap == null)) {
            assertUtil.strAssert(assertMap, resultJson);
        } else {
            Assert.assertTrue(false);
        }
    }












}
