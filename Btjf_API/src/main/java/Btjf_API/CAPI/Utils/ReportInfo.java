package Btjf_API.CAPI.Utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Reporter;

import java.util.*;

/**
 * Created by wl on 2017/9/8.
 */
public class ReportInfo {
//    private String Url = "http://192.168.110.65:8080/report/getReportData.do";
    private String Url = "http://192.168.100.158:6070/Report/report/getReportData.do";
    private GenerateReportHtml generateReportHtml = new GenerateReportHtml();
    private FileUtil fileUtil = new FileUtil();
    private CloseableHttpClient httpClient;
    private HttpPost post;

    /**
     * 生成报告信息的json数组
     * @return
     */
    private JSONArray getReportData(){
        String report_url = generateReportHtml.getRoportUrl();
        JSONArray jsonArray = new JSONArray();
        int num = 0;
        try {
            LinkedHashMap<String,CaseBean> dataMap = generateReportHtml.parseRoot();
            for(String suiteName : dataMap.keySet()){
                JSONObject jsonObject = new JSONObject();
                JSONObject json = new JSONObject();
                CaseBean caseBean = dataMap.get(suiteName);
                json.put("pass",caseBean.getPassNum());
                json.put("skip",caseBean.getSumNum()-caseBean.getPassNum()-caseBean.getFailedNum());
                json.put("fail",caseBean.getFailedNum());
                if(num==0){
                    json.put("url",report_url);
                    json.put("logurl",fileUtil.getRetryLogPath());
                }
                jsonObject.put(suiteName,json);
                jsonArray.add(jsonObject);
                num++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public void sendReportInfo(){
        JSONArray jsonArray = getReportData();
        LinkedHashMap<String,Object> bodyMap = new LinkedHashMap<String, Object>();
        bodyMap.put("source",jsonArray.toString());
        bodyMap.put("evn",PublicUtil.properties.getProperty("JenkinsJobName"));
        try {
            postForm(Url,bodyMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String postForm (String url ,HashMap<String,Object> bodyMap) throws Exception{
        httpClient = HttpClients.createDefault();
        post = new HttpPost(url);
        if(bodyMap != null){
            List formParams = new ArrayList();
            Set<String> keys = bodyMap.keySet();
            for(String key : keys){
                Object obj = bodyMap.get(key);
                if(obj instanceof Object[]){
                    Object[] objects = (Object[])obj;
                    for(Object s : objects){
                        formParams.add(new BasicNameValuePair(key,String.valueOf(s)));
                    }
                }else{
                    formParams.add(new BasicNameValuePair(key,(String)obj));
                }
            }
            HttpEntity entity = new UrlEncodedFormEntity(formParams,"utf-8");
            post.setEntity(entity);
        }
        CloseableHttpResponse httpResponse = httpClient.execute(post);
        HttpEntity resultEntity =  httpResponse.getEntity();
        String result = EntityUtils.toString(resultEntity);
        return result;
    }
    public static void main(String[] args){
        new ReportInfo().sendReportInfo();
    }
}
