package Btjf_API.CAPI.Data;

import Btjf_API.CAPI.Utils.ExcelUtil;
import Btjf_API.CAPI.Utils.Log;

import java.util.LinkedHashMap;

/**
 * Created by wl on 2016/8/22.
 */
public class DataBase {
    private  LinkedHashMap<String ,LinkedHashMap<String,String>> P1_map = new LinkedHashMap<String, LinkedHashMap<String, String>>();
    private  LinkedHashMap<String ,LinkedHashMap<String,String>> P0_map = new LinkedHashMap<String, LinkedHashMap<String, String>>();
//    private  LinkedHashMap<String ,LinkedHashMap<String,String>> dataMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
//    public  static String loginNum = "13900000001";
//    private  String unCerUser = "";   //未认证用户手机号
//    private  String cerFailedUser = "";  //认证失败用户手机号
//    private  String storeID = "";   //已开通的店铺ID
//    public  String noVinCarID ="1418";  // 未上传行驶证车辆的ID
    private Log log = new Log(DataBase.class);
    public DataBase(){}
    public DataBase(ExcelUtil excelUtil,String excelName,String sheetName) {
        if(sheetName.contains(",")){
            String[] sheetNames = sheetName.split(",");
            for(String s : sheetNames){
                LinkedHashMap<String ,LinkedHashMap<String,String>> map = excelUtil.getParamMap(excelName,s);
                if(s.contains("P1_data")){
                    P1_map.putAll(map);
                }else {
                    P0_map.putAll(map);
                }
            }
        }else{
            if(sheetName.contains("P1_data")){
                P1_map = excelUtil.getParamMap(excelName,sheetName);
            }else{
                P0_map = excelUtil.getParamMap(excelName,sheetName);
            }
        }
    }
    public LinkedHashMap<String ,LinkedHashMap<String,String>> getDataMap(String data_flag){
        if(data_flag.equalsIgnoreCase("P0")){
            return P0_map;
        }else if(data_flag.equalsIgnoreCase("P1")){
            return P1_map;
        }else{
            log.error("传入的data标记不存在");
        }
        return  P0_map;
    }
}
