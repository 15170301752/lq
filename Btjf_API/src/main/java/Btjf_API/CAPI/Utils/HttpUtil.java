package Btjf_API.CAPI.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Reporter;


import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * Created by wl on 2016/6/18.
 * http请求的工具类
 */
public class HttpUtil {
    private PublicUtil publicUtil = new PublicUtil();
    private CloseableHttpClient httpClient;
    private HttpPost post;
    private HttpGet get;
    private HttpPut put;
//    private HttpDelete delete;
    private HttpEntity entity;
    private UrlEncodedFormEntity urlEntity;
    private JSONObject bodyJson;
    private JSONObject headJson;
    private Properties properties = publicUtil.getProp();
    private String beforeUrl ;
    private Log log = new Log(HttpUtil.class);
    private MyHttpDelete mydelete ;
    /**
     * http的post请求方法,包含请求头和请求体
     * @param url 请求接口的路径
     * @param headMap 请求头map
     * @param bodyMap 请求体map
     * @return  服务器响应的JSON格式的数据
     * @throws Exception
     */
    public JSONObject postRequest(String url,HashMap<String,Object> headMap, HashMap<String,Object> bodyMap) throws Exception{
        beforeUrl = getHttpUrl(url);
        if(beforeUrl.contains("https")){
            httpClient = crateSSLClient();
        }else{
            httpClient = HttpClients.createDefault();
        }
        log.info("请求的接口地址：------"+beforeUrl+fixUrl(url));
        Reporter.log("请求的接口地址：------"+beforeUrl+fixUrl(url));
        post = new HttpPost(beforeUrl+fixUrl(url));
        if(headMap != null){
            headJson  = new JSONObject(headMap);
            log.info("请求head的数据：--------"+headJson.toString());
            Reporter.log("请求head的数据：--------"+headJson.toString());
            addPostHeader(headMap);//添加请求头
        }else {
            log.info("请求head的数据：--------");
            Reporter.log("请求head的数据：--------");
        }
        if(bodyMap != null){
            bodyJson = new JSONObject(getMap(bodyMap));
            log.info("请求body的数据：--------"+bodyJson.toString());
            Reporter.log("请求body的数据：--------"+bodyJson.toString());
        }else {
            log.info("请求head的数据：--------");
            Reporter.log("请求head的数据：--------");
        }
//        ContentType contentType = ContentType.create("application/x-www-form-urlencoded","utf-8");
        ContentType contentType = ContentType.create("application/json","utf-8");
//        log.info(mapToForm(bodyJson.toString()));
//        log.info(bodyJson.toString());
        String s = bodyJson.toString();;
        s = s.replace("\\","");
        s = s.replace("\"data\":\"","\"data\":");
        s = s.replace("}\"}","}}");
        log.info(s);
        entity = new StringEntity(s,contentType);
        post.setEntity(entity);
        CloseableHttpResponse httpResponse = httpClient.execute(post);
        HttpEntity resultEntity =  httpResponse.getEntity();
        String result = EntityUtils.toString(resultEntity);
        return getResultJson(result);
    }

    public HashMap<String,Object> getMap(HashMap<String,Object> bodyMap){
        Set<String> keys = bodyMap.keySet();
        for(String key : keys){
            String value = bodyMap.get(key).toString();
            if(value.contains("=")){
                String[] strs = value.split(",");
                for(String s :strs){

                }


            }
        }
        return bodyMap;
    }

    /**
     *http的post请求方法,包含请求体
     * @param url 请求接口的路径
     * @param bodyMap 请求体map
     * @return 服务器响应的JSON格式的数据
     * @throws Exception
     */
    public JSONObject postRequest(String url, HashMap<String,Object> bodyMap) throws Exception{
        beforeUrl = getHttpUrl(url);
        if(beforeUrl!=null && beforeUrl.contains("https")){
            httpClient = crateSSLClient();
        }else{
            httpClient = HttpClients.createDefault();
        }
        log.info("请求的接口地址：------"+beforeUrl+url);
        Reporter.log("请求的接口地址：------"+beforeUrl+url);
        post = new HttpPost(beforeUrl+url);
        bodyJson = new JSONObject(bodyMap);
        log.info("请求body的数据：--------"+bodyJson.toString());
        Reporter.log("请求body的数据：--------"+bodyJson.toString());
        ContentType contentType = ContentType.create("application/x-www-form-urlencoded","utf-8");
//        print(mapToForm(bodyJson.toString()));
        entity = new StringEntity(mapToForm(bodyJson.toString()),contentType);
//        System.out.println(entity.getContentType());
        post.setEntity(entity);
        CloseableHttpResponse httpResponse = httpClient.execute(post);
        HttpEntity resultEntity =  httpResponse.getEntity();
        String result = EntityUtils.toString(resultEntity);
        return getResultJson(result);
    }
    public JSONObject postForm (String url,HashMap<String,Object> headMap, HashMap<String,Object> bodyMap) throws Exception{
        beforeUrl = getHttpUrl(url);
        if(beforeUrl.contains("https")){
            httpClient = crateSSLClient();
        }else{
            httpClient = HttpClients.createDefault();
        }
        log.info("请求的接口地址：------"+beforeUrl+url);
        Reporter.log("请求的接口地址：------"+beforeUrl+url);
        post = new HttpPost(beforeUrl+url);
//        post = new HttpPost(url);
        if(headMap!=null){
            headJson  = new JSONObject(headMap);
            log.info("请求head的数据：--------"+headJson.toString());
            Reporter.log("请求head的数据：--------"+headJson.toString());
            addPostHeader(headMap);
        }
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
            bodyJson = new JSONObject(bodyMap);
            log.info("请求body的数据：--------"+bodyJson.toString());
            Reporter.log("请求body的数据：--------"+bodyJson.toString());
            HttpEntity entity = new UrlEncodedFormEntity(formParams,"utf-8");
            print(entity.getContentType().toString());
            post.setEntity(entity);
        }
        CloseableHttpResponse httpResponse = httpClient.execute(post);
        HttpEntity resultEntity =  httpResponse.getEntity();
        String result = EntityUtils.toString(resultEntity);
        return getResultJson(result);
    }

    /**
     * get请求方法
     * @param url 接口的url
     * @return 服务器响应的JSON格式的数据
     * @throws Exception
     */
    public JSONObject getRequest(String url)throws Exception{
        beforeUrl = getHttpUrl(url);
        if(beforeUrl.contains("https")){
            httpClient = crateSSLClient();
        }else{
            httpClient = HttpClients.createDefault();
        }
        log.info("请求的接口地址：------"+beforeUrl+fixUrl(url));
        Reporter.log("请求的接口地址：------"+beforeUrl+fixUrl(url));
        get = new HttpGet(beforeUrl+fixUrl(url));
        CloseableHttpResponse httpResponse = httpClient.execute(get);
        HttpEntity entity = httpResponse.getEntity();
        String reslt = EntityUtils.toString(entity);
        return getResultJson(reslt);
    }

    /**
     * get请求方法，包含请求头
     * @param url
     * @param headMap
     * @return 服务器响应的JSON格式的数据
     * @throws Exception
     */
    public JSONObject getRequest(String url,LinkedHashMap<String,Object> headMap)throws Exception{
        beforeUrl = getHttpUrl(url);
        if(beforeUrl.contains("https")){
            httpClient = crateSSLClient();
        }else{
            httpClient = HttpClients.createDefault();
        }
        log.info("请求的接口地址是：------"+beforeUrl+fixUrl(url));
        Reporter.log("请求的接口地址是：------"+beforeUrl+fixUrl(url));
        get = new HttpGet(beforeUrl+fixUrl(url));
        addGetHeader(headMap);
        headJson  = new JSONObject(headMap);
        log.info("请求head的数据：--------"+headJson.toString());
        Reporter.log("请求head的数据：--------"+headJson.toString());
        CloseableHttpResponse httpResponse = httpClient.execute(get);
        HttpEntity entity = httpResponse.getEntity();
        String reslt = EntityUtils.toString(entity);
        return getResultJson(reslt);
    }

    public JSONObject getRequest(String url ,LinkedHashMap<String,Object> headMap,LinkedHashMap<String,Object> bodyMap) throws Exception{
        beforeUrl = getHttpUrl(url);
        if(beforeUrl.contains("https")){
            httpClient = crateSSLClient();
        }else{
            httpClient = HttpClients.createDefault();
        }
        log.info("请求的接口地址是：------"+beforeUrl+addGetParams(fixUrl(url),bodyMap));
        Reporter.log("请求的接口地址是：------"+beforeUrl+addGetParams(fixUrl(url),bodyMap));
        get = new HttpGet(beforeUrl+addGetParams(fixUrl(url),bodyMap));
        if(headMap !=null){
            headJson  = new JSONObject(headMap);
            log.info("请求head的数据：--------"+headJson.toString());
            Reporter.log("请求head的数据：--------"+headJson.toString());
            addGetHeader(headMap);
        }
//        bodyJson = new JSONObject(bodyMap);
//        log.info("请求body的数据：--------"+bodyJson.toString());
//        Reporter.log("请求body的数据：--------"+bodyJson.toString());
        CloseableHttpResponse httpResponse = httpClient.execute(get);
        HttpEntity entity = httpResponse.getEntity();
        String reslt = EntityUtils.toString(entity);
        return getResultJson(reslt);
    }

    public JSONObject postFile(String url,LinkedHashMap<String,Object> headMap,LinkedHashMap<String,Object> bodyMap)throws Exception{
        beforeUrl = getHttpUrl(url);
        if(beforeUrl.contains("https")){
            httpClient = crateSSLClient();
        }else{
            httpClient = HttpClients.createDefault();
        }
        log.info("请求的接口地址：------"+beforeUrl+fixUrl(url));
        Reporter.log("请求的接口地址：------"+beforeUrl+fixUrl(url));
        post = new HttpPost(beforeUrl+url);
        if(headMap != null){
            headJson  = new JSONObject(headMap);
            log.info("请求head的数据：--------"+headJson.toString());
            Reporter.log("请求head的数据：--------"+headJson.toString());
            addPostHeader(headMap);//添加请求头
        }else {
            log.info("请求head的数据：--------");
            Reporter.log("请求head的数据：--------");
        }
        bodyJson = new JSONObject(bodyMap);
        log.info("请求body的数据：--------"+bodyJson.toString());
        Reporter.log("请求body的数据：--------"+bodyJson.toString());
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setCharset(Charset.forName("utf-8"));
        builder.setContentType(ContentType.MULTIPART_FORM_DATA);
        Set<String> keys = bodyMap.keySet();
        for(String key:keys){
            String value = (String)bodyMap.get(key);
            if(value.contains("jpg") || value.contains("png")||value.contains("mp3")){
                if(value.contains(",")){
                    String[] strFiles = value.split(",");
                    for(String strFile : strFiles){
                        File file = new File("src/main/resources/"+strFile);
                        builder.addPart(key,new FileBody(file));
//                        builder.addBinaryBody(key,file,ContentType.MULTIPART_FORM_DATA,strFile);
                    }
                }else{
                    File file = new File("src/main/resources/"+value);
                    builder.addPart(key,new FileBody(file));
//                    builder.addBinaryBody(key,new File(value));
//                    builder.addBinaryBody(key,file,ContentType.MULTIPART_FORM_DATA,value);
                }
            }else{
//                builder.addTextBody(key,value);
                builder.addTextBody(key,value,ContentType.create("multipart/form-data","utf-8"));
            }
        }
        HttpEntity entity = builder.build();
        print(entity.getContentType().toString());
        post.setEntity(entity);
        CloseableHttpResponse httpResponse = httpClient.execute(post);
        HttpEntity resultEntity =  httpResponse.getEntity();
        String result = EntityUtils.toString(resultEntity);
        return getResultJson(result);
    }

    public JSONObject putRequest(String url,LinkedHashMap<String,Object> headMap,LinkedHashMap<String,Object> bodyMap) throws Exception{
        beforeUrl = getHttpUrl(url);
        if(beforeUrl.contains("https")){
            httpClient = crateSSLClient();
        }else{
            httpClient = HttpClients.createDefault();
        }
        log.info("请求的接口地址：------"+beforeUrl+fixUrl(url));
        Reporter.log("请求的接口地址：------"+beforeUrl+fixUrl(url));
        put = new HttpPut(beforeUrl+fixUrl(url));
        if(headMap != null){
            headJson  = new JSONObject(headMap);
            log.info("请求head的数据：--------"+headJson.toString());
            Reporter.log("请求head的数据：--------"+headJson.toString());
            addPutHeader(headMap);//添加请求头
        }else {
            log.info("请求head的数据：--------");
            Reporter.log("请求head的数据：--------");
        }
        if(bodyMap != null){
            bodyJson = new JSONObject(bodyMap);
            log.info("请求body的数据：--------"+bodyJson.toString());
            Reporter.log("请求body的数据：--------"+bodyJson.toString());
        }else {
            log.info("请求head的数据：--------");
            Reporter.log("请求head的数据：--------");
        }
        ContentType contentType = ContentType.create("application/x-www-form-urlencoded","utf-8");
        log.info(mapToForm(bodyJson.toString()));
        entity = new StringEntity(mapToForm(bodyJson.toString()),contentType);
        put.setEntity(entity);
        log.info(entity.getContentType().toString());
        CloseableHttpResponse httpResponse = httpClient.execute(put);
        HttpEntity resultEntity =  httpResponse.getEntity();
        String result = EntityUtils.toString(resultEntity);
        return getResultJson(result);

    }

    public JSONObject deleteRequest(String url, LinkedHashMap<String, Object> headMap, LinkedHashMap<String, Object> bodyMap) throws Exception {
        beforeUrl = getHttpUrl(url);
        if (beforeUrl.contains("https")) {
            httpClient = crateSSLClient();
        } else {
            httpClient = HttpClients.createDefault();
        }
        log.info("请求的接口地址：------" + beforeUrl + fixUrl(url));
        Reporter.log("请求的接口地址：------" + beforeUrl + fixUrl(url));
        mydelete = new MyHttpDelete(beforeUrl + fixUrl(url));
        addDeleteHeader(headMap);
        headJson = new JSONObject(headMap);
        log.info("请求head的数据：--------" + headJson.toString());
        Reporter.log("请求head的数据：--------" + headJson.toString());
        //   mydelete.setHeader("Accept-Encoding", "gzip, deflate");
        // mydelete.setHeader("Accept-Language", "zh-CN");
        //mydelete.setHeader("Accept", "application/json, application/xml, text/html, text/*, image/*, */*");
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        //nameValuePairs.add(new BasicNameValuePair(" body",bodyMap.toString()));
        Set<String> keys = bodyMap.keySet();
        for (String key : keys) {
            Object obj = bodyMap.get(key);
            if (obj instanceof String[]) {
                for (String s : (String[]) obj) {
                    nameValuePairs.add(new BasicNameValuePair(key, s));
                }
            } else {
                nameValuePairs.add(new BasicNameValuePair(key, (String) obj));
            }
        }
        bodyJson = new JSONObject(bodyMap);
        log.info("请求body的数据：--------" + bodyJson.toString());
        Reporter.log("请求body的数据：--------" + bodyJson.toString());
        //nameValuePairs.add(new BasicNameValuePair("password", "secret"));
        mydelete.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        CloseableHttpResponse httpResponse = httpClient.execute(mydelete);
        HttpEntity resultEntity = httpResponse.getEntity();
        String result = EntityUtils.toString(resultEntity);
        return getResultJson(result);
    }

    public void addDeleteHeader(LinkedHashMap<String, Object> headMap) {
        Set<String> set = headMap.keySet();
        for (String key : set) {
            mydelete.addHeader(key, headMap.get(key).toString());
        }
    }
    /**
     *给post添加请求头信息
     * @param headMap 包含请求头信息的map
     */
    public void addPostHeader(HashMap<String,Object> headMap){
        Set<String> set = headMap.keySet();
        for(String key : set){
            post.addHeader(key,headMap.get(key).toString());
        }
    }
    /**
     *给put添加请求头信息
     * @param headMap 包含请求头信息的map
     */
    public void addPutHeader(HashMap<String,Object> headMap){
        Set<String> set = headMap.keySet();
        for(String key : set){
            put.addHeader(key,headMap.get(key).toString());
        }
    }

    /**
     * 给get添加请求头信息
     * @param headMap 包含请求头信息的map
     */
    public void addGetHeader(LinkedHashMap<String,Object> headMap){
        Set<String> set = headMap.keySet();
        for(String key : set){
            get.addHeader(key,headMap.get(key).toString());
        }
    }

    /**
     * 判断接口url前面是否加了“/”，如果没有加，给它加上
     * @param url 接口url
     * @return
     */
    private String fixUrl(String url){
        if(url.substring(0,1).equals("/")){
            return url;
        }else{
            return "/"+url;
        }
    }

    /**
     *
     * @param afterUrl  接口地址
     * @return 根据传入的接口地址，判断是车商端还是员工端接口
     */
    public String getHttpUrl(String afterUrl){
        String httpUrl = "";
        if(afterUrl.contains("car-seller-client-interfaces")){
            httpUrl =   properties.getProperty("httpICarUrl");
        }else if (afterUrl.contains("staff-client-interfaces")){
            httpUrl =   properties.getProperty("httpStaffUrl");
        }else if(afterUrl.contains("bt-wallet-openapi-website")){
            httpUrl = properties.getProperty("httpBTWalletUrl");
        }else if(afterUrl.contains("personal-client-interface")){
            httpUrl = properties.getProperty("httpPersonalUrl");
        }else if(afterUrl.contains("api")){
            httpUrl = properties.getProperty("httpHzdUrl");
        }else if(afterUrl.contains("/business-logic-foreign")){
            httpUrl = properties.getProperty("httpBackStageUrl");
        }else if(afterUrl.contains("192.168.110")){
            return httpUrl;
        }else {
            log.error("请求的url不存在");
        }
        return httpUrl;
    }

    /**
     *
     * @return 返回一个信任对方证书的https请求的httpClient
     * @throws Exception
     */
    public static CloseableHttpClient crateSSLClient()throws Exception{
        SSLContext sslContexts =  new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        }).build();
        SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(sslContexts);
        return HttpClients.custom().setSSLSocketFactory(ssf).build();
    }

    /**
     *
     * @param url 传入的接口地址
     * @param bodyMap  把参数拼接到url上面
     * @return 返回get请求的url
     */
    public String addGetParams(String url,LinkedHashMap<String,Object> bodyMap){
        if(bodyMap != null){
            url = url+"?";
            Set<String> keys = bodyMap.keySet();
            String s ="";
            for(String key :keys){
                Object value = bodyMap.get(key);
                if(value==null){
                     s = key + "=";
                }else{
                     s = key + "=" + value.toString();
                }
                url =  url + s +"&";
            }
            url = url.substring(0,url.length()-1);
        }
        return url;
    }

    /**
     * 把服务器返回的结果做判断，最终返回一个JSONObject
     * @param result  服务器返回的响应结果字符串
     * @return 返回一个JSONObject
     */
    public JSONObject getResultJson(String result){
        log.info("响应数据：-------"+result);
        Reporter.log("响应数据：-------"+result);
        try{
            return JSONObject.parseObject(result);
        }catch (Exception e){
            log.error("返回的响应数据不是json格式");
            if(result.contains("HTTP Status")){
                String code = result.substring(result.indexOf("HTTP Status"),result.indexOf(" - Request"));
//                String resultJson = "{\"code\":"+"\""+code+"\""+"}";
                log.error("响应的请求状态码是： "+code);
                return null;
            }
            return null;
        }
    }
    public String mapToForm(String jsonStr){
        jsonStr = jsonStr.replace(":","=");
        jsonStr = jsonStr.replace(",","&");
        jsonStr = jsonStr.substring(1,jsonStr.length()-1);
        return jsonStr.replace("\"","");
    }
    public static void main(String[] args) throws Exception{
        LinkedHashMap<String,Object> map = new LinkedHashMap<String, Object>();
        map.put("1",1);
        map.put("2",2);
        JSONObject json = new JSONObject(map);
        String jsonStr = json.toString();
        jsonStr = jsonStr.replace(":","=");
        jsonStr = jsonStr.replace(",","&");
        jsonStr = jsonStr.substring(1,jsonStr.length()-1);
        System.out.println(jsonStr.replace("\"",""));
        System.out.println(json.toString());
//        String s = "{\"2\":2,\"1\":1}";
//        JSONObject nJson = JSON.parseObject(s);
//        System.out.println(nJson);
        //new HttpUtil().postRequest("heh",map);
//        System.out.print(new HttpUtil().getHttpUrl("lll.xx.car-seller-client-interfaces.xxx"));
//        File file = new File("src/main/resources/1.jpg");
//        FileInputStream fis  =  new FileInputStream(file);
//        FileOutputStream fos = new FileOutputStream(new File("src/main/resources/22.jpg"));
//        int num = -1;
//        while ((num=fis.read() )!=-1 ){
//            fos.write(num);
//        }
//        fis.close();
//        fos.close();

    }



    public void print(String s){
        System.out.println(s);
    }

}
