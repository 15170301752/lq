package Btjf_API.CAPI.Data;

import Btjf_API.CAPI.Enums.ExcelNameEnums;
import Btjf_API.CAPI.Utils.ExcelUtil;
import Btjf_API.CAPI.Utils.Log;
import Btjf_API.CAPI.Utils.PublicUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.*;


/**
 * Created by wl on 2016/7/1.
 */
public class DataPro {

//    public static String dataId="data1";
    private String excelName ;
    private DataBase dataBase;
    private PublicUtil publicUtil;
    private static Log log = new Log(DataPro.class);
    private static String dataId = PublicUtil.properties.getProperty("dataId");


    public DataPro(PublicUtil publicUtil,String excelName,DataBase dataBase){
        this.publicUtil = publicUtil;
        this.excelName = excelName;
        this.dataBase = dataBase;

    }
    private static DataPro dataPro = new DataPro(new PublicUtil(),PublicUtil.properties.getProperty("excelName"),new DataBase(new ExcelUtil(),PublicUtil.properties.getProperty("excelName"),PublicUtil.properties.getProperty("sheetName")));
    static  ArrayList<String> list = new ArrayList<String>();

    public static void setList(){
        list.add(dataPro.getExcelName());
    }

    /**
     * 判断是否需要重新读取excel数据
     */
    public static void isReloadData(){
        String newExcelName = dataPro.getPublicUtil().getProp(PublicUtil.EnvConfigPath).getProperty("excelName");
        if(dataPro.getExcelName().equalsIgnoreCase(newExcelName)){
            return;
        }else{
            String newSheetName = dataPro.getPublicUtil().getProp(PublicUtil.EnvConfigPath).getProperty("sheetName");
            dataPro.setExcelName(newExcelName);
            DataBase dataBase_1 =new DataBase(new ExcelUtil(),newExcelName,newSheetName);
            dataPro.setDataBase(dataBase_1);
        }
    }

    @DataProvider(name = "data1")
    public static Object[][] providerMethod(Method method){
        HashMap<String,String> map1= new HashMap<String, String>();
        map1.put("a","a");
        map1.put("b","b");
        map1.put("id","1");
        HashMap<String,String> map2= new HashMap<String, String>();
        map2.put("d","d");
        map2.put("c","c");
        map2.put("dd","dd");
        map2.put("id","2");
        HashMap<String,String> map3= new HashMap<String, String>();
        map3.put("e","d");
        map3.put("f","c");
        map3.put("id","3");
//        Object[][] objects = new Object[3][1];
//        objects[0][0]=map1;
//        objects[1][0]=map2;
//        objects[2][0]=map3;
        Object[][] objects = new Object[][]{{map1},{map2}};
        if(method.getName().equals("A")){
            return objects;
        }else{
            return new Object[][]{{map3}};
        }
    }
//    @DataProvider(name="data2")
//    public static Object[][] providerMethod1(Method method){
//        HashMap<String,String> map1= new HashMap<String, String>();
//        map1.put("h","h");
//        map1.put("i","i");
//        map1.put("id","11");
//        HashMap<String,String> map2= new HashMap<String, String>();
//        map2.put("j","j");
//        map2.put("k","k");
//        map2.put("id","22");
//        if(method.getName().equals("A")){
//            return new Object[][]{{map1}};
//        }else{
//            return new Object[][]{{map2}};
//        }
//    }

    public static void isSetExcelName(Method method){
        String proExcelName = dataPro.getPublicUtil().getProp(PublicUtil.EnvConfigPath).getProperty("excelName");
        String currentExcelName = "";
        for(ExcelNameEnums excelNameEnums: ExcelNameEnums.values()){
            if(method.toString().contains(excelNameEnums.getModleName())){
                currentExcelName = excelNameEnums.getExcelName();
            }
        }
        if(!(proExcelName.equalsIgnoreCase(currentExcelName))){
            dataPro.getPublicUtil().setProperty(PublicUtil.EnvConfigPath,"excelName",currentExcelName);
            list.add(currentExcelName);
        }
    }

    /**
     * 判断需要运行PO和P1的用例
     * @param method
     * @return 该方法的数据
     * @throws Exception
     */
    @DataProvider(name="P0_data_excel")
    public static Object[][] providerMethod1(Method method) throws Exception{
        isSetExcelName(method);
        isReloadData();
        list.add(dataPro.getExcelName());
        Object[][] objects = null;
        if (!(dataId.contains(","))) {
            if (dataId.equalsIgnoreCase("P0")) {
                objects = providerMethod2(method);
                objectsIsNull(objects);
                return objects;
            } else if (dataId.equalsIgnoreCase("P1")) {
                objects = providerMethod3(method);
                objectsIsNull(objects);
                return objects;
            } else {
                objectsIsNull(objects);
                return objects;
            }
        }
        if (dataId.contains(",")) {
            Object[][] object1 = null;
            Object[][] object2 = null;
            String[] dataids = dataId.split(",");
            for (String id : dataids) {
                if (id.equalsIgnoreCase("P0")) {
                    object1 = providerMethod2(method);
                }
                if (id.equalsIgnoreCase("P1")) {
                    object2 = providerMethod3(method);
                }
            }
            objects = ArrayUtils.addAll(object1, object2);
        }
        objectsIsNull(objects);
        return formatObjects(objects);
    }

    /**
     * 对返回的参数objects加一个判断是否为空的校验
     * @param objects
     */
    public static void objectsIsNull(Object[] objects){
        if(objects.length<1){
//            System.out.println("接口的参数在excel中获取不到");
            Reporter.log("接口的参数在excel中获取不到");
            log.error("接口的参数在excel中获取不到");
        }
    }
    /**
     * 运行P0的用例
     * @param method
     * @return
     * @throws Exception
     */
    @DataProvider(name="P0")
    public static Object[][] providerMethod2(Method method) throws Exception{
//        ArrayList<String> list = new ArrayList<String>();
//        LinkedHashMap<String,LinkedHashMap<String,String>> dataMap = new ExcelUtil().getDataMap();
        LinkedHashMap<String,LinkedHashMap<String,String>> dataMap = dataPro.getDataBase().getDataMap("P0");
        ArrayList<String> list = getList_P0(method);
        ArrayList<String> newList = formatList(list,dataMap);
        Object[][] objects = new Object[newList.size()][1];
        for(int i =0;i<newList.size();i++){
            objects[i][0] = dataMap.get(newList.get(i));
        }
        return objects;
    }

    /**
     * 测试数据添加runMode，去掉不需要运行的测试数据
     * @param objects
     * @return
     */
    public static Object[][] formatObjects(Object[][] objects){
        boolean flag = false;
        ArrayList<LinkedHashMap<String,String>> list = new ArrayList<LinkedHashMap<String, String>>();
        for(Object[] object : objects){
            LinkedHashMap<String,String> map = (LinkedHashMap<String,String>)object[0];
            String runMode = map.get("runMode");
            if(runMode != null && !(runMode.equalsIgnoreCase(""))){
                flag = true;
                if(runMode.equalsIgnoreCase("Y") || runMode.equalsIgnoreCase("yes")){
                    list.add(map);
                }
            }
        }
        Object[][] newObjects ;
        if(flag){
            newObjects = new Object[list.size()][1];
            for(int i=0;i<list.size();i++){
                newObjects[i][0] = list.get(i);
            }
            return newObjects;
        }
        return objects;
    }

    public static ArrayList<String> getList_P0(Method method){
        LinkedHashMap<String,LinkedHashMap<String,String>> dataMap = dataPro.getDataBase().getDataMap("P0");
        ArrayList<String> list = new ArrayList<String>();
        Set<String> methodSet = dataMap.keySet();
        for(String key:methodSet){
            if(key.equalsIgnoreCase(method.getName())){
                list.add(key);
            }
//            if(key.contains(method.getName()+"_")){
//                list.add(key);
//            }
        }
        return list;
    }

    /**
     * 测试数据添加runMode，去掉不需要运行的测试数据
     * @param list
     * @param dataMap
     * @return
     */
    private static ArrayList<String>  formatList(ArrayList<String> list,LinkedHashMap<String,LinkedHashMap<String,String>> dataMap){
        boolean noRunFlag = false;
        boolean runFlag = false;
        String runMode ;
        for(String key : list){
            runMode = dataMap.get(key).get("runMode");
           if(runMode != null && !(runMode.equalsIgnoreCase(""))){
               if(runMode.equalsIgnoreCase("N")){
                   noRunFlag = true;
               }else if(runMode.equalsIgnoreCase("Y")){
                   runFlag = true;
               }
           }
        }
        if(runFlag){
            ArrayList<String> newList = new ArrayList<String>();
            for(String s : list){
                runMode = dataMap.get(s).get("runMode");
                if(runMode != null){
                    if(runMode.equalsIgnoreCase("Y") || runMode.equalsIgnoreCase("yes")){
                        newList.add(s);
                    }
                }
            }
            return newList;
        }else if(noRunFlag){
            ArrayList<String> newList = new ArrayList<String>();
            for(String s : list){
                runMode = dataMap.get(s).get("runMode");
                if(runMode != null){
                    if(runMode.equalsIgnoreCase("N") || runMode.equalsIgnoreCase("no")){
                        continue;
                    }else {
                        newList.add(s);
                    }
                }else{
                    newList.add(s);
                }
            }
            return newList;
        }
        return list;
    }

    /**
     * 运行P1的测试用例
     * @param method
     * @return
     * @throws Exception
     */
    @DataProvider(name = "P1")
    public static Object[][] providerMethod3(Method method) throws Exception {
//        ArrayList<String> list2 = new ArrayList<String>();
        LinkedHashMap<String, LinkedHashMap<String, String>> dataMap = dataPro.getDataBase().getDataMap("P1");
        ArrayList<String> list2 = getList_P1(method);
        ArrayList<String> newList = formatList(list2,dataMap);
        Object[][] objects = new Object[newList.size()][1];
        for (int i = 0; i < newList.size(); i++) {
            objects[i][0] = dataMap.get(newList.get(i));
        }
        return objects;
    }

    public static ArrayList<String> getList_P1(Method method){
        ArrayList<String> list2 = new ArrayList<String>();
        LinkedHashMap<String, LinkedHashMap<String, String>> dataMap = dataPro.getDataBase().getDataMap("P1");
        Set<String> methodSet = dataMap.keySet();
        for (String key : methodSet) {
            int index = key.lastIndexOf("_");
            if(index==-1){continue;}
            String str = key.substring(0,index);
            if (str.equalsIgnoreCase(method.getName())) {
                list2.add(key);
            }
        }
        return list2;
    }

    @DataProvider(name = "debugData")
    public static Object[][] providerDebugData(Method method){
        LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
        Properties headProp = dataPro.getPublicUtil().getProp("src/main/java/Btjf_API/CAPI/Data/debugData_head.properties");
        Properties bodyProp = dataPro.getPublicUtil().getProp("src/main/java/Btjf_API/CAPI/Data/debugData_body.properties");
        String headParams = dataPro.getPublicUtil().propTOString(headProp);
        String bodyParams = dataPro.getPublicUtil().propTOString(bodyProp);
        map.put("CaseID","debugData");
        map.put("headParams",headParams);
        map.put("bodyParams",bodyParams);
        map.put("Assert","code=1");
        Object[][] objects = new Object[1][1];
        objects[0][0]=map;
        return objects;
    }


    public static void main(String[] args){
//        String dataId = "data1";
//        MyTransFormer myTransFormer = new MyTransFormer();
//        myTransFormer.setDataId(dataId);
//        TestNG testNG = new TestNG();
//        testNG.setAnnotationTransformer(myTransFormer);
//        testNG.setTestClasses(new Class[]{DataPro.class});
//        testNG.run();
    }
    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public PublicUtil getPublicUtil() {
        return publicUtil;
    }

    public DataBase getDataBase() {

        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

}
