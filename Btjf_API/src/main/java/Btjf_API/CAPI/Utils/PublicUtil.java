package Btjf_API.CAPI.Utils;



import Btjf_API.CAPI.CarSeller.GlobalApi;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wl on 2016/6/18.
 */
public class PublicUtil {
    public static String  EnvConfigPath = "target/classes/EnvConfig.properties";
    public static Properties properties =  new PublicUtil().getProp(EnvConfigPath);
    private static String path;
    public static Properties prop =new PublicUtil().getProp();
    private  FileInputStream fis =null;
//    private Log log = new Log(PublicUtil.class);
    public void mapToString(HashMap<String,Object> map){
        Set<String> set = map.keySet();
        for(String key :set){
            print(key);
            print(map.get(key).toString());
        }
    }
    public Properties getProp(String path){
        Properties properties = new Properties();
        try {
            fis = new FileInputStream(path);
            properties.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }

    public Properties getProp(){
        String EnvPropFile = properties.getProperty("EnvPropName");
        String EnvPath = "src/main/resources/"+EnvPropFile+".properties";
        path = EnvPath;
        Properties prop = getProp(EnvPath);
        return prop;
    }

    int flag1 = 0;
    String phoneNum = null;
    /**
     * 对接口的数据进行格式化，把随机函数替换成随机数值
     * @param
     * @return  把数据中的随机函数替换成值，在返回datamap
     * @throws Exception
     */
    public LinkedHashMap<String ,LinkedHashMap<String,String>> fomatDataMap(LinkedHashMap<String ,LinkedHashMap<String,String>> map){

//        String phoneNum = null;
        String ranNum = null;
        LinkedHashMap<String,String> dataMap = null;
        String regex1 = "(?i)(\\[)(phonenum)(\\w*)(])";
        Pattern pattern1 = Pattern.compile(regex1);
        Set<String> mapKeys = map.keySet();
        for(String mapKey : mapKeys ){
            int flag2 = 0;
            dataMap = map.get(mapKey);
            Set<String> keys = dataMap.keySet();
            for(String key :keys){
                String values = dataMap.get(key);
                if(values.toUpperCase().contains("PHONENUM")){
                    if(flag1==0){
                        int startIndex = values.toUpperCase().indexOf("[PHONENUM")+"[PHONENUM".length();
                        String numValue =values.toUpperCase().substring(startIndex,values.indexOf("]"));
                        int num = Integer.parseInt(numValue.trim());
                        phoneNum  =getRanNum(num);
                        Matcher matcher = pattern1.matcher(values);
                        while(matcher.find()){
                            values = values.replaceAll(regex1,phoneNum);
                        }
//                    System.out.println(values);
                        dataMap.put(key,values);
                        map.put(mapKey,dataMap);
                        flag1++;
                    }else{
                        Matcher matcher = pattern1.matcher(values);
                        while(matcher.find()){
                            values = values.replaceAll(regex1,phoneNum);
                        }
                        dataMap.put(key,values);
                        map.put(mapKey,dataMap);
                    }
                }else if(values.toUpperCase().contains("RANNUM")){
                        if(flag2==0 && values.toUpperCase().contains("[RANNUM11]")){
                            ranNum = getRanNum(11);
                            flag2++;
                        }else if( values.toUpperCase().contains("[RANNUM5]")){
                            String ranNum_1 = getRanNum(5);
                            values = values.replace("[rannum5]",ranNum_1);
                        }else if(values.toUpperCase().contains("[RANNUM4]")){
                            String ranNum_2 = getRanNum(4);
                            values = values.replace("[rannum4]",ranNum_2);
                        }
                        if(ranNum !=null){
                            values = values.replace("[rannum11]",ranNum);
                        }
                    dataMap.put(key,values);
                    map.put(mapKey,dataMap);
                }else{
                    values = varOfInstance(values);
                    dataMap.put(key,values);
                    map.put(mapKey,dataMap);
                }
            }
        }

            return map;
    }

    /**
     * 替换execl中变量名为properties文件中的key的变量值(比如ranNum11，longDate不属于properties是不能被替换的)
     * @param values
     * @return
     */
    public String varOfInstance(String values){
        Set<Object> propKeys = prop.keySet();
        if(values.contains("[") && values.contains("]")){
            for(Object obj : propKeys){
                String key = obj.toString();
                if(values.contains(key)){
                    values = values.replace("["+key+"]",getProperty(prop,key));
                    if(!(values.contains("[") && values.contains("]"))){return values;}
                }
            }
        }
        return values;
    }

    /**
     * 初始化properties中的所有账号数据
     */
    public void initPorperties(){
        initRegisterNum();
        initUnbankUser();
        initLoginNum();
        initVinCarID();
        initCustUser();
        initNoVinCarID();
        initStoreUser();
        initManager();
    }

    public void initLogin(){
        GlobalApi globalApi = new GlobalApi();
        String password = "123456";
        globalApi.carLogin(prop.getProperty("loginNum"),password);
        globalApi.carLogin(prop.getProperty("registerNum"),password);
        globalApi.carLogin(prop.getProperty("custNum"),password);
        globalApi.carLogin(prop.getProperty("unBankUser"),password);
        globalApi.carLogin(prop.getProperty("storeOperateUser"),password);
        globalApi.carLogin(prop.getProperty("storeOperateManager"),password);
    }
    /**
     * 初始化注册用户账号
     * @throws Exception
     */
    public void initRegisterNum() {
        if(isExistUser(prop.getProperty("registerNum"))){
            String phoneNum = getRanNum(11);
            getSqlHander("carSeller").execRegisterPro(phoneNum);
            prop.setProperty("registerNum",phoneNum);
            setProperty(path,"registerNum",phoneNum);
//            new GlobalApi().carLogin(prop.getProperty("registerNum"),"123456");
        }
    }
    /**
     * 初始化授信并绑定银行卡用户
     * @throws Exception
     */
    public void initLoginNum(){
        if(isExistUser(prop.getProperty("loginNum"))){
            String phoneNum = getRanNum(11);
            String FIdCard=getRanIdCard();
            getSqlHander("carSeller").execCreditCustPro("自动化用户",phoneNum,FIdCard,"自动化店铺");
            String FAccout=DESUtil.encrypt("621226120202749"+getRanNum(4),DESUtil.getKeyString());
            String Fname = DESUtil.encrypt("自动化用户",DESUtil.getKeyString());
            String bankInsertSql="INSERT into t_CustAccount(FCustID,FAccount,FBankID,\n" +
                    "FBankName,FBankInfo,FName,FIsDelete,FIsRecharge,\n" +
                    "FIsGetCash,FIsBind,FValidate,FAddUser,FAddTime,\n" +
                    "FModifyUser,FModifyTime,FIdCard,FProvinceName,FProvinceCode,\n" +
                    "FCityName,FCityCode,FCityId,FProvinceId) \n" +
                    "VALUES((select FMemberID from t_Member where FMobile='"+phoneNum+"'),'"+FAccout+"',20101,\n" +
                    "'中国工商银行','中国工商银行股份有限公司杭州祥符支行','"+Fname+"',0,1,\n" +
                    "1,1,1,3102,GETDATE(),\n" +
                    "3102,GETDATE(),'"+FIdCard+"','浙江','330000',\n" +
                    "'杭州市','330100',348,30)";
            getSqlHander(bankInsertSql).updateColumnValue(bankInsertSql);
            prop.setProperty("loginNum",phoneNum);
            setProperty(path,"loginNum",phoneNum);
//            new GlobalApi().carLogin(prop.getProperty("loginNum"),"123456");
        }
//        initVinCarID();


    }

    /**
     * 初始化操作店铺的用户
     */
    public void initStoreUser(){
        SqlUtil sqlUtil = getSqlHander("carSeller");
        String sql_custID = "select FMemberID from t_Member where FCertificationIdentity=3 and FMobile='"+prop.getProperty("storeOperateUser")+"';";
        String fid = sqlUtil.getColumnValue(sql_custID,"FMemberID");
        String sql_carID = "select top 1 a.FCarID,a.FSaleStatus from t_CarSalesInfo a INNER JOIN t_CarInfoNew b ON a.FCarID = b.FID INNER JOIN\n" +
                "t_Member c ON b.FCustID = c.FMemberID where c.FMobile='"+prop.getProperty("storeOperateUser")+"' AND a.FIsDelete=0 and b.FIsDelete=0 \n" +
                "order by a.FCarID DESC;";
        String carID = sqlUtil.getColumnValue(sql_carID,"FCarID");
        if(fid==null){
            String phoneNum = getRanNum(11);
            sqlUtil.execCustPro(phoneNum,"自动化店铺操作用户",getRanIdCard());
            prop.setProperty("storeOperateUser",phoneNum);
            setProperty(path,"storeOperateUser",phoneNum);
        }
        if(carID==null){
            carID = sqlUtil.execTestAddVinCar(prop.getProperty("storeOperateUser"));
        }
    }

    /**
     * 初始化认证授信未绑定银行卡用户
     * @throws Exception
     */
    public void initUnbankUser(){
        SqlUtil sqlUtil = getSqlHander("carSeller");
        if(isExistUnBankUser(prop.getProperty("unBankUser"))){
            String phoneNum = getRanNum(11);
            sqlUtil.execCreditCustPro(getProperty(prop,"realName"),phoneNum,prop.getProperty("realIdCard"),"自动化店铺");
            prop.setProperty("unBankUser",phoneNum);
            setProperty(path,"unBankUser",phoneNum);
//            new GlobalApi().carLogin(prop.getProperty("unBankUser"),"123456");
        }else{  //判断这个用户是否绑定了银行卡，如果绑定了就解绑
            String sql = "select FIsDelete from t_CustAccount a LEFT JOIN t_Member b ON a.FCustID = " +
                    "b.FMemberID where a.FIsDelete=0 and a.FValidate=1 and a.FIsBind=1 and b.FMobile='"+prop.getProperty("unBankUser")+"'";
            String isDelete = sqlUtil.getColumnValue(sql,"FIsDelete");
            if(isDelete!=null && isDelete.equalsIgnoreCase("0")){
                new GlobalApi().removeBankCard(prop.getProperty("unBankUser"));
            }
        }
    }

    /**
     * 初始化认证未授信用户,同时给这个用户初始化一辆车
     */
    public void initCustUser(){
        if(isExistUser(prop.getProperty("custNum"))){
            String phoneNum = getRanNum(11);
            getSqlHander("carSeller").execCustPro(phoneNum,"自动化重新认证",getRanIdCard());
            prop.setProperty("custNum",phoneNum);
            setProperty(path,"custNum",phoneNum);
//            new GlobalApi().carLogin(prop.getProperty("custNum"),"123456");
        }
        if(isExistCar(prop.getProperty("custNum"),prop.getProperty("custCarID"))){
            String carID = getSqlHander("carSeller").execTestAddCar(prop.getProperty("custNum"));
            prop.setProperty("custCarID",carID);
            setProperty(path,"custCarID",carID);
        }
    }

    /**
     * 初始化不可抵押车辆，如果不存在，就生成不可抵押车辆，并把车辆ID写入properties文件中
     */
    public void initNoVinCarID(){
        if(isExistCar(prop.getProperty("loginNum"),prop.getProperty("noVinCarID"))){
            String carID = getSqlHander("carSeller").execTestAddCar(prop.getProperty("loginNum"));
            prop.setProperty("noVinCarID",carID);
            setProperty(path,"noVinCarID",carID);
        }
    }

    /**
     * 初始化可抵押车辆，如果不存在，就生成可抵押车辆，并把车辆ID写入properties文件中
     */
    public void initVinCarID(){
        if(isExistCar(prop.getProperty("loginNum"),prop.getProperty("vinCarID"))){
            String carID = getSqlHander("carSeller").execTestAddVinCar(prop.getProperty("loginNum"));
            prop.setProperty("vinCarID",carID);
            setProperty(path,"vinCarID",carID);
        }
        String sql = "select FStatus from t_CarMortgageInventory where FCarID="+prop.getProperty("vinCarID")+";";
        String status = getSqlHander(sql).getColumnValue(sql,"FStatus");
        if(!(status.equalsIgnoreCase("1"))){
            String update_sql = "update t_CarMortgageInventory set FStatus=1 where FCarID="+prop.getProperty("vinCarID")+";";
            getSqlHander(update_sql).updateColumnValue(update_sql);
        }
    }

    public void initManager(){
        if(isExistUser(prop.getProperty("storeOperateManager"))){
            String storeOperateManager = getRanNum(11);
            String fidCard=getRanIdCard();
            getSqlHander("carSeller").execTestManager("自动化客户经理",storeOperateManager,fidCard,prop.getProperty("storeOperateUser"));
            prop.setProperty("storeOperateManager",storeOperateManager);
            setProperty(path,"storeOperateManager",storeOperateManager);
        }else{
            String sql_Identity = "select FCertificationIdentity from t_Member where FMobile='"+prop.getProperty("storeOperateManager")+"';";
            String Identity_status = getSqlHander(sql_Identity).getColumnValue(sql_Identity,"FCertificationIdentity");
            if(!(Identity_status.equals("4"))){
                new GlobalApi().validation_Manager(prop.getProperty("storeOperateUser"),prop.getProperty("storeOperateManager"));
            }
        }

}

    /**
     * 根据传入的key、value，修改properties当前key的以前值改为value
     * @param propPath properties文件的路径
     * @param key
     * @param value
     */
    public void setProperty(String propPath,String key,String value){
        StringBuilder sb = new StringBuilder();
        String s = readFile(propPath);
        String[] lines = s.split("\r\n");
        for(String line : lines){
            if(line.contains(key)){
                line = key+"="+value;
            }
            sb.append(line);
            sb.append("\r\n");
        }
        writeFile(propPath,sb.toString());
    }

    /**
     * 获取peoperties配置中key对应的的中文
     * @param prop
     * @param key
     * @return
     */
    public static String getProperty(Properties prop,String key){
        String value = null;
        try {
            value = prop.getProperty(new String(key.getBytes("UTF-8"),"ISO8859_1"));
            return new String(value.getBytes("ISO8859_1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 判断用户是否存在,不存在返回true，存在返回false
     * @param num
     * @return
     */
    public boolean isExistUser(String num){
        String sql = "select FMemberID from t_member where FMobile='"+num+"'";
        String value = getSqlHander(sql).getColumnValue(sql,"FMemberID");
        boolean falg = value==null?true:false;
        return falg;
    }

    /**
     * 判断properties配置文件中的UnBankUser的身份证是否是指定的身份证号码，如果不是，就修改成该身份证的手机号
     * @param num
     * @return
     */
    public boolean isExistUnBankUser(String num){
        String id = "36042919910817211X";
        SqlUtil sqlUtil = getSqlHander("carSeller");
        String sql_1 = "select * from t_Member where FIdCard='36042919910817211X'";
        String fid = sqlUtil.getColumnValue(sql_1,"FMemberID");
        String phone = sqlUtil.getColumnValue(sql_1,"FMobile");
        String sql = "select FIdCard from t_member where FMobile='"+num+"'";
        String idCarD = sqlUtil.getColumnValue(sql,"FIdCard");
        if( fid==null){
            return true;
        }else{
            if(idCarD!=null && idCarD.equalsIgnoreCase(id)){
                return false;
            }else{
                prop.setProperty("unBankUser",phone);
                setProperty(path,"unBankUser",phone);
                return false;
            }
        }
    }

    /**
     * 判断这个carid是否存在，不存在返回true，存在返回false
     * @param carid
     * @return
     */
    public boolean isExistCar(String phone,String carid){
        String sql = "select a.FID from t_CarInfoNew a LEFT JOIN t_CarSalesInfo b on a.FID=b.FCarID \n" +
                "where a.FCustID=(select FMemberID from t_Member where FMobile='"+phone+"') \n" +
                "and a.FID="+carid+" and b.FSaleStatus=1 and b.FIsDelete=0";
        String value = getSqlHander(sql).getColumnValue(sql,"FID");
        boolean flag = value==null?true:false;
        return flag;
    }


    public LinkedHashMap<String, Object> getBodyMap(LinkedHashMap<String,String> dataMap) throws Exception{
        LinkedHashMap<String,Object > bodyMap = new LinkedHashMap<String, Object>();
        bodyMap = getParamValueMap(dataMap,bodyMap,"bodyParams");
        return bodyMap;
//        return getParamValueMap(getParamMap(dataMap,"bodyParams"));
    }
    public LinkedHashMap<String, Object> getHeadMap(LinkedHashMap<String,String> dataMap) throws Exception{
        LinkedHashMap<String,Object > bodyMap = new LinkedHashMap<String, Object>();
        bodyMap = getParamValueMap(dataMap,bodyMap,"headParams");
        if(properties.getProperty("EnvPropName").equalsIgnoreCase("EnvTrainConfig")){
            bodyMap.put("currentev","train");
        }
        return bodyMap;
//        return getParamValueMap(getParamMap(dataMap,"headParams"));
    }
    public LinkedHashMap<String, Object> getAssertMap(LinkedHashMap<String,String> dataMap) throws Exception{
        LinkedHashMap<String,Object > assertMap = new LinkedHashMap<String, Object>();
        assertMap = getParamValueMap(dataMap,assertMap,"Assert");
        assertMap.put("CaseID",dataMap.get("CaseID"));
         return assertMap;
//        return getParamValueMap(getParamMap(dataMap,"Assert"));
    }

    /**
     *替换断言map中使用到的请求体中的参数值
     * @param bodyMap 请求体map
     * @param dataMap 数据源map
     * @return
     * @throws Exception
     */
    public LinkedHashMap<String, Object> getAssertMap(LinkedHashMap<String,Object> bodyMap,LinkedHashMap<String,String> dataMap) throws Exception{
        LinkedHashMap<String,Object > assertMap = new LinkedHashMap<String, Object>();
        String assertStr = dataMap.get("Assert");
        for(String key : bodyMap.keySet()){
            if(assertStr.contains("["+key+"]")){
                assertStr = assertStr.replace("["+key+"]",(String)bodyMap.get(key));
            }
        }
        dataMap.put("Assert",assertStr);
        assertMap = getParamValueMap(dataMap,assertMap,"Assert");
        assertMap.put("CaseID",dataMap.get("CaseID"));
        return assertMap;
//        return getParamValueMap(getParamMap(dataMap,"Assert"));
    }

    /**
     * 返回指定key的Map
     * @param dataMap  数据源Map
     * @param key 数据源中指定的key
     * @return
     */
    public LinkedHashMap<String ,Object> getParamMap(LinkedHashMap <String,String> dataMap,String key){
        LinkedHashMap<String ,Object> map  = new LinkedHashMap<String, Object>();
        String params = dataMap.get(key);
        if(params == null){return null ;}
        String [] values = params.split("\n");
        for(int i=0;i<values.length;i++){
            String paramStr = values[i];
            if(!(paramStr.contains("="))){continue;}
            String[] s = paramStr.trim().split("=",2);
            String paramkey  = s[0].trim();
            String paramValue =s[1].trim();
            map.put(paramkey,paramValue);
        }
        return map;
    }

    /**
     * 对map中的变量进行赋值
     * @param map 参数Map，例：请求头map或者请求提map
     * @return 返回变量赋值后的参数map
     */
    public LinkedHashMap<String,Object> getParamValueMap(LinkedHashMap<String,Object> map){
        Set<String> keys = map.keySet();
        for(String key:keys){
            key  = initMapKeyParam(key,map.get(key).toString());
            String value = initMapValueParam(map.get(key).toString());
            map.put(key,value);
        }
        return map;
    }

    /**
     * 获取方法数据源中的请求的用户号码，如果号码错误或者为空，就取propties文件中key对应的手机号码
     * @param dataMap 方法数据源
     * @param propKey propties配置文件中的key
     * @return 返回手机号码
     */
    public String getDataMapPhone(LinkedHashMap<String,String> dataMap,String propKey){
        LinkedHashMap<String,Object> map = getParamMap(dataMap,"headParams");
        Object obj = map.get("accessToken");
        String phone = obj.toString();
        if(phone.length()>11){
            String sql = "select account from t_AuthAccessToken where accessToken = '"+phone+"'";
            phone = getSqlHander(sql).getColumnValue(sql,"account");
        }
        if(phone==null || phone.length()<11){
            phone = prop.getProperty(propKey);
        }
        return phone;
    }
    /**
     * 对key中存在的变量进行赋值
     * @param key 字符串
     * @param value 字符串
     * @return 返回变量赋值后的字符串
     */
    public String initMapKeyParam(String key,String value){
        if(key.toUpperCase().contains("ACCESSTOKEN") && value != null && value.length() ==11){
            String sql = "select accesstoken from t_AuthAccessToken where account = '"+value+"' order by id desc;";
            key = getSqlHander(sql).getColumnValue(sql,"accesstoken");
            if(key !=null){
               key.trim();
            }
        }
        return key;
    }

    /**
     * 对value中存在的变量进行赋值
     * @param value 字符串
     * @return 返回变量赋值后的字符串
     */
    public String initMapValueParam(String value){
        if(value.toUpperCase().contains("FROM") || value.toUpperCase().contains("WHERE")){
            if(value.toUpperCase().contains("RANNUM")){
                value = getNumValue(value);
            }
            String sqlKey = value.substring(value.toUpperCase().indexOf("SELECT")+"SELECT".length(),value.toUpperCase().indexOf("FROM")).trim();
            value = getSqlHander(sqlKey).getColumnValue(value,sqlKey);
        }else if(value.toUpperCase().contains("RANNUM")){
            value = getNumValue(value);
        }else if(value.toUpperCase().contains("LONGDATE")){
            value = String.valueOf(getLongDate(value));
        }
        return value;
    }

    /**
     * 替换Map中的变量，并返回key对应的map
     * @param dataMap
     * @param bodyMap
     * @param key
     * @return
     * @throws Exception
     */
    public LinkedHashMap<String,Object > getParamValueMap(LinkedHashMap<String,String> dataMap,LinkedHashMap<String,Object > bodyMap,String key)throws Exception{
        String values = dataMap.get(key);
        if(values == null){return  bodyMap;}
//        Reporter.log("------当前执行的caseID"+dataMap.get("CaseID")+"--------");
//        log.info("------当前执行的caseID"+dataMap.get("CaseID")+"--------");
        String[] valueArr = values.split("\n");
        for(int i =0 ;i < valueArr.length; i++){
            String valueParam = valueArr[i];
            if(!(valueParam.contains("="))){continue;}
            String[] s = valueParam.trim().split("=",2);
            String paramKey = s[0].trim();
            String value = s[1].trim();
            if(value.toUpperCase().contains("FROM") || value.toUpperCase().contains("WHERE")){
                if(value.toUpperCase().contains("RANNUM")){
                    value = getNumValue(value);
                }
                String sqlKey = value.substring(value.toUpperCase().indexOf("SELECT")+"SELECT".length(),value.toUpperCase().indexOf("FROM")).trim();
                if(value.contains(":")){
                    String value_sql = getFormatSql(value);
                    String sqlValue = getSqlHander(value).getColumnValue(value_sql,sqlKey);
                    value = value.replace(value_sql,sqlValue);
//                    bodyMap.put(paramKey,value);
                    bodyMap = formatBodyMap(bodyMap,paramKey,value);
                }else{
                    if(paramKey.contains("{")){
                        List<String> list = getSqlHander(value).getColumnsList(value,sqlKey);
//                        bodyMap.put(paramKey,list);
                        bodyMap = formatBodyMap(bodyMap,paramKey,list);
                    }else{
                        String sqlValue = getSqlHander(value).getColumnValue(value,sqlKey);
//                        bodyMap.put(paramKey,sqlValue);
                        bodyMap = formatBodyMap(bodyMap,paramKey,sqlValue);
                    }

                }

            }
//                else if(value.toUpperCase().contains("RANNUM")){
//                    value = getNumValue(value);
//                    bodyMap.put(paramKey,value);
//                }
            else if(paramKey.toUpperCase().contains("ACCESSTOKEN") && value != null && value.length() ==11 ){
                    String sql = "select * from t_AuthAccessToken where account = '"+value+"' order by id desc";
                String sqlValue = getSqlHander(sql).getColumnValue(sql,"accesstoken");
                if(sqlValue !=null){
//                    bodyMap.put(paramKey,sqlValue.trim());
                    bodyMap = formatBodyMap(bodyMap,paramKey,sqlValue.trim());
                }else{
//                    bodyMap.put(paramKey,sqlValue);
                    bodyMap = formatBodyMap(bodyMap,paramKey,sqlValue);
                }
            }else if(value.toUpperCase().contains("LONGDATE")){
                value = String.valueOf(getLongDate(value));
//                bodyMap.put(paramKey,value);
                bodyMap = formatBodyMap(bodyMap,paramKey,value);
            }else{
//                bodyMap.put(paramKey,value);
                bodyMap = formatBodyMap(bodyMap,paramKey,value);
            }
        }
        return bodyMap;
    }

    /**
     * 解决相同参数名的问题，相同参数名的值保存成数组存进map中
     * @param bodyMap
     * @param key
     * @param value
     * @return
     */
    public LinkedHashMap<String,Object > formatBodyMap(LinkedHashMap<String,Object > bodyMap,String key,Object value){
        Object obj = bodyMap.get(key);
        if(obj==null){
            bodyMap.put(key,value);
            return bodyMap;
        }else{
            if(obj instanceof String){
                List<Object> list = new ArrayList<Object>();
                list.add(obj);
                list.add(value);
                Object[] strs = list.toArray();
                bodyMap.put(key,strs);
                return bodyMap;
            }else if(obj instanceof Object[]){
                List<Object> list = Arrays.asList(obj);
                list.add(value);
                bodyMap.put(key,list.toArray());
                return bodyMap;
            }
        }
        return bodyMap;
    }

    private String getFormatSql(String sql){
        int startIndex = sql.toUpperCase().indexOf("SELECT");
        sql = sql.substring(startIndex,sql.length()-1);
        int endIndex = sql.indexOf(",");
        sql = sql.substring(0,endIndex);
        return sql;
    }

    private int flag = 0;
    private String num = null;//获取一个随机手机号码
    public String getNumValue(String value){
        if(flag ==0){
            num = getRanNum(11);
            value = value.replace("[rannum11]",num);
            flag++;
        }else{
            value = value.replace("[rannum11]",num);
        }
        return value;
    }

    /**
     * 获取N天后的时间戳 或者 2017年04月的时间戳
     * @param str 例如：[longDate7] / 17 ，分别获取到7 / 17 天后的时间戳
     * @return 返回时间戳
     */
    public long getLongDate(String str){
        long longDate;
        if(str.contains("Y")){
            longDate = getYearLongDate(str);
        }else{
            int i ;
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                i = Integer.parseInt(str.substring(str.indexOf("[longDateY")+"[longDateY".length(),str.length()-1));
            }
//        System.out.println(i);
//        System.out.println(System.currentTimeMillis()+i*24*60*60*1000);
            longDate = System.currentTimeMillis()+i*24*60*60*1000;
        }
        return longDate;
//        Date date  = new Date(System.currentTimeMillis()+i*24*60*60*1000);
    }

    /**
     * 年月转为毫秒数
     * @param value 如：longDateY201704
     * @return
     */
    public long getYearLongDate(String value) {
        String str = value.substring(value.indexOf("[longDateY")+"[longDateY".length(),value.length()-1);
//        print(str);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        long millionSeconds = System.currentTimeMillis(); //初始化为当前时间的毫秒数
        try{
            millionSeconds = sdf.parse(str).getTime();//毫秒
        }catch (Exception e){
//            log.error("日期转换为时间戳失败");
            getStackTrace(e.getStackTrace());
        }
//        print(millionSeconds+"");
        return millionSeconds;
        //毫秒转成日期
//        Calendar c = Calendar.getInstance();
////        Long l = 1491035220000L;
//        c.setTimeInMillis(millionSeconds);
//        Date date = c.getTime();
//        System.out.println(sdf.format(date));


    }

    /**
     * 根据传入的i，来确定需要生成几位的字符串
     * @param i 需要生成几位随机数,目前这个只能是11或者4
     * @return 返回随机数字符串，返回的11位号码，是不存在的系统用户号码
     * @throws Exception
     */
    public String getRanNum(int i) {
        String beforeNum = "174";
        int num = 0;
        if(i==11){
            num = new Random().nextInt(89999998)+10000000;
            String value = null;
            try{
              value = getSqlHander("carSeller").getColumnValue("select FMemberID  from t_Member where Fmobile='"+beforeNum+num+"'","FMemeberID");
            }catch (Exception e){
                e.printStackTrace();
            }
            if(value != null){
                getRanNum(i);
            }
            return beforeNum+num;
        }else if (i == 4){
            num = new Random().nextInt(8999)+1000;
            return String.valueOf(num);
        }else if(i==5){
            num = new Random().nextInt(89999)+10000;
            return String.valueOf(num);
        }
        return  null;
    }

    /**
     * 生成一个身份证(后四位数随机生成)
     * @return 返回一个身份证号码
     */
    public String getRanIdCard(){
        String idCard = "3604001977080";
        int ranNum  = new Random().nextInt(88888)+11111;
//        print(ranNum+"");
        idCard = idCard+String.valueOf(ranNum);
        String sql = "select FMemberID from t_Member where FIdcard='"+idCard+"'";
        String value = getSqlHander(sql).getColumnValue(sql,"FMemberID");
        if(value!=null){
            getRanIdCard();
        }
        print(idCard);
        return  idCard;
    }

    /**
     * 返回指定格式的时间
     * @param str 例如："yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public String getDate(String str){
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        Date date = new Date();
        return  sdf.format(date);
    }

    /**
     * 取log文件夹中，最后生成的且不为空的全部日志的路径
     * @return 返回邮件中日志的路径
     */
//    public String getLogPath(){
//        return new FileTest().getLogPath();
//    }

    /**
     * 取log文件夹中，最后生成的且不为空的失败重跑的日志路径
     * @return
     */
    public String getRetryLogPath(){
        File file =new File("log/");
        File[] files = file.listFiles();
        long longDate=0;
        File nFile = null;
        for (File f : files){
            if(f.length()==0){continue;}
//            System.out.print(f.getName()+"    ");
//            System.out.println(f.lastModified());
            if(longDate<f.lastModified() && f.getName().contains("重跑")){
                longDate = f.lastModified();
                nFile = f;
            }
        }
//        print(nFile.getName());
        return nFile.getName();
    }

    /**
     * 文本读写，每行读取，手动加上换行(windows换行)，返回String
     * @param path 文件路径
     * @return
     */
    public String readFile(String path){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));
            String ss=null;
            while ((ss=br.readLine())!=null){
//                System.out.println(ss);
                sb.append(ss);
                sb.append("\r\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 文本写入
     * @param path 文件路径
     * @param str  需要写入的内容
     */
    public void writeFile(String path,String str){
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"utf-8"));
            bw.write(str);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断需要连哪个数据库
     * @param sql sql语句或者字符串b2c标识，包含c_的就连接B2C数据库，如果字符串是b2c，也连接数据库，其他默认连接车商数据库
     * @return
     */
    public SqlUtil getSqlHander(String sql){
        SqlUtil sqlUtil= null;
        if(sql.contains("c_")){
            sqlUtil = new SqlUtil(prop.getProperty("driverName"),prop.getProperty("b2cUserName"),
                    prop.getProperty("b2cPasswd"),prop.getProperty("dbIp"),prop.getProperty("b2cDbName"));
        }else if(sql.contains("x_")){
            sqlUtil = new SqlUtil(prop.getProperty("driverName"),prop.getProperty("xfdUserName"),
                    prop.getProperty("xfdPasswd"),prop.getProperty("dbIp"),prop.getProperty("xfdDbName"));
        }else{
                if(sql.equalsIgnoreCase("b2c")){
                    sqlUtil = new SqlUtil(prop.getProperty("driverName"),prop.getProperty("b2cUserName"),
                            prop.getProperty("b2cPasswd"),prop.getProperty("dbIp"),prop.getProperty("b2cDbName"));
                }else if (sql.equalsIgnoreCase("xfd")){
                    sqlUtil = new SqlUtil(prop.getProperty("driverName"),prop.getProperty("xfdUserName"),
                            prop.getProperty("xfdPasswd"),prop.getProperty("dbIp"),prop.getProperty("xfdDbName"));
                }else{
                    sqlUtil = new SqlUtil(prop.getProperty("driverName"),prop.getProperty("dbUserName"),
                            prop.getProperty("dbPasswd"),prop.getProperty("dbIp"),prop.getProperty("dbName"));
                }
        }
        return sqlUtil;
    }

    public static void main(String[] args)throws Exception{
//        LinkedHashMap<String,Object> map = new LinkedHashMap<String, Object>();
//        map.put("1",1);
//        map.put("2",2);
//        map.put("a","b");
//        new PublicUtil().mapToString(map);
//        String path = "target/classes/EnvConfig.properties";
//        Properties properties = new Properties();
//        FileInputStream fis = new FileInputStream(path);
//        properties.load(fis);
//        System.out.print(properties.getProperty("Name"));
//        String s = "select    FBillNo   from t_code where xxx";
//        String sub = s.substring(s.toUpperCase().indexOf("SELECT")+"select".length(),s.toUpperCase().indexOf("FROM")).trim();
//        System.out.println(sub);
//        System.out.print(new PublicUtil().getRanNum(11));
//        String value = "xxx[Rannumxxx11]yyy[raNnumxxxx11]";
////        int startIndex = value.toUpperCase().indexOf("RANNUM")+"RANNUM".length();
//////        System.out.println(startIndex);
////        String s =value.substring(startIndex,value.indexOf("]"));
////        System.out.println(s);
////        String oldString = value.substring(value.indexOf("["),value.indexOf("]")+1);
////        System.out.println(oldString);
////        value = value.toUpperCase().replace(oldString.toUpperCase(),s);
//        String regex = "(?i)(\\[)(rannum)(\\w*)(])";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(value);
//        while(matcher.find()){
//            value = value.replaceAll(regex,"11");
//        }
//        System.out.println(value);

//        String num = "13800098876";
//        String value = "accessToken=[loginNum]\nversion=2.5.0";
//        value  = value.replace("[loginNum]",dataBase.loginNum);
//        System.out.println(value);
//        long l = new PublicUtil().getLongDate("lo7");
//        System.out.println(l);
//        String jsonString  = "{\"a\":{\"b\":{\"c\":{\"d\":\"abcd\"},\"f\":{\"g\":[\"abfg\",\"abfg2\"]}}}}";
//        BigDecimal bd  = new BigDecimal("3.0E7");
//        String str = bd.toPlainString();
//        System.out.println(Double.toString(30000000));

//        System.out.print(new PublicUtil().getLogPath());


//        System.out.println(prop.getProperty("loginNum"));
//        new PublicUtil().isExistUser("13800000091");
//         new PublicUtil().isExistCar(prop.getProperty("custNum"),prop.getProperty("custCarID"));
//        new PublicUtil().initRegisterNum();
//        new PublicUtil().initCustUser();
//        new PublicUtil().getRanIdCard();
//        new PublicUtil().isExistUnBankUser("18503082657");
//        String str = "sdfjk[custNum]fdgdfgfdg[vinCarID]hjhjhj[custNum]hjh";
//        String ss = new PublicUtil().varOfInstance(str);
//        System.out.println(ss);
//        new PublicUtil().initStoreUser();
//        new PublicUtil().initManager();

//        new PublicUtil().initPorperties();


//        new PublicUtil().getLogPath();
        PublicUtil publicUtil = new PublicUtil();
        publicUtil.initLogin();
//        publicUtil.initPorperties();
    }




    public void print(String s){
        System.out.println(s);
    }

    /**
     * 获取异常信息字符串
     * @param arr
     * @return
     */
    public String getStackTrace(StackTraceElement[] arr){
        String ss = null;
        for(StackTraceElement s : arr){
            ss = ss+s+"\r\n";
        }
        return ss;
    }

    public LinkedHashMap<String,String> propToMap(Properties prop,LinkedHashMap<String,String> map){
        Set<Object> propKeys = prop.keySet();
        for(Object obj : propKeys){
            String key = (String)obj;
            map.put(key,(String)prop.get(key));
        }
        return map;
    }

    public String propTOString(Properties prop){
        StringBuilder sb = new StringBuilder();
        Set<Object> propKeys = prop.keySet();
        for(Object obj : propKeys){
            String key = (String)obj;
            sb.append(key+"="+(String)prop.get(key));
            sb.append("\n");
        }
        sb.delete(sb.length()-1,sb.length());
        return sb.toString();
    }



}


