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
 * Created by LEE on 2017/3/30.
 */
public class AboutHistoryCapi {
    private String subUrl = "/car-seller-client-interfaces";
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private AssertUtil assertUtil = new AssertUtil();
    private Log log = new Log(AboutHistoryCapi.class);
    private GlobalApi globalApi = new GlobalApi();
    private String loginNum = PublicUtil.prop.getProperty("loginNum");

    /**
     *POST/m/service/breakRules/history/delete
     * @param map
     * @throws Exception
     * recordId=[88317]
     *  请求参数recordId查询记录id,字段名:recordIdInteger[]
     *   /m/service/breakRules/history/delete
     *   (通过)
     */
    @Test(description = "删除历史接口,删除历史接口",groups = "AboutHistoryCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void sBreakRulesHistoryDelete(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行" + methodName + "方法--------------");
        LinkedHashMap<String, Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String, Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl + "/m/service/breakRules/history/delete";
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
     *GET/m/service/breakRules/history/list
     * @param map
     * @throws Exception
     * currentPage=0
     * pageSize=6
     * （ 通过）
     */
    @Test(description = "查询历史列表接口,获取查询历史列表接口",groups = "AboutHistoryCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void sBreakRulesHistoryList(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/breakRules/history/list";
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
     *GET/m/service/breakRules/query
     * @param map
     * @throws Exception
     *   请求参数EIN发动机号,字段名:EIN String
     *      请求参数cityName城市名,字段名:cityName String
     *      请求参数carPlateNum车牌号（拼好的整个拍照）,字段名:carPlateNum,必填String
     *     请求参数VIN车辆识别码,字段名:VIN String
     *     请求参数cityCode城市简码,字段名:cityCode,必填String
     *      /m/service/breakRules/query
     *      （通过）
     */
    @Test(description = "违章查询接口,获取违章查询接口",groups = "AboutHistoryCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void sBreakRulesQuery(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/breakRules/query";
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
     *GET/m/service/breakRules/query/result
     * @param map
     * @throws Exception
     *  recordId查询记录id,字段名:recordId Integer
     *  （通过）
     */
    @Test(description = "违章查询结果接口,违章查询结果接口",groups = "AboutHistoryCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void sBreakRulesQueryResult(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/breakRules/query/result";
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
     *GET/m/service/breakRules/query/validate
     * @param map
     * @throws Exception
     *  VIN	032309
     *  carPlateNum	浙F5136E
     *  EIN
     *    请求参数VIN车辆识别码,字段名:VIN String
     *    请求参数EIN发动机号,字段名:EIN String
     *    请求参数carPlateNum车牌号,字段名:carPlateNum,必填String
     *    (通过)
     */
    @Test(description = "违章查询验证接口,违章查询验证接口",groups = "AboutHistoryCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void sBreakRulesQueryValidate(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/breakRules/query/validate";
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
     *GET/m/service/evaluate/history
     * @param map
     * @throws Exception
     *
     * currentPage=0-抓包数据
     * pageSize=10-抓包数据
     * （通过）
     */
    @Test(description = "估价历史列表接口,估价历史列表接口",groups = "AboutHistoryCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void sEvaluateHistory(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/evaluate/history";
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
     *GET/m/service/evaluate/query
     * @param map
     * @throws Exception
     *
     * brandID品牌ID,字段名:brandID，必填Integer                       36-抓包数据
     * 请求参数modelID型号ID,字段名:modelID，必填Integer                588
     *  请求参数mileage行驶里程（公里）,字段名:mileage，必填Integer     20000
     *  请求参数cityID城市ID,字段名:cityID，必填Integer                 1
     *  请求参数styleID车款ID,字段名:styleID，必填Integer               800001021
     *  请求参数provinceID省份ID,字段名:provinceID，必填Integer              1
     *  请求参数firstRegDate上牌时间,字段名:firstRegDate，必填Long       1454256000000
     *  （通过）
     */
    @Test(description = "价格评估查询接口,价格评估查询接口",groups = "AboutHistoryCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void sEvaluateQuery(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/evaluate/query";
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
     *GET/m/service/evaluate/query/result
     * @param map
     * @throws Exception
     *  recordId=326444  int类型
     *  (通过)
     */
    @Test(description = "估价结果接口,估价结果接口",groups = "AboutHistoryCapi",dataProvider = "P0_data_excel",dataProviderClass = DataPro.class)
    public void sEvaluateQueryResult(LinkedHashMap<String, String> map)throws Exception{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("----------------开始执行"+methodName+"方法--------------");
        LinkedHashMap<String,Object> headMap = publicUtil.getHeadMap(map);
        LinkedHashMap<String,Object> bodyMap = publicUtil.getBodyMap(map);
        String url = subUrl +"/m/service/evaluate/query/result";
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
