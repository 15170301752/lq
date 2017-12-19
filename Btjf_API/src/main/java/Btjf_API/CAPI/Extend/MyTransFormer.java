package Btjf_API.CAPI.Extend;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Utils.ExcelUtil;
import Btjf_API.CAPI.Utils.PublicUtil;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Parameters;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by wl on 2016/7/6.
 */
public class MyTransFormer implements IAnnotationTransformer {
    private static String dataId = PublicUtil.properties.getProperty("dataId");
    public void transform(ITestAnnotation annotation, Class clazz, Constructor constructor,Method method) {
        ArrayList<String> list = new ArrayList<String>();
        LinkedHashMap<String,LinkedHashMap<String,String>> dataMap = new ExcelUtil().getParamMap(PublicUtil.properties.getProperty("excelName"),PublicUtil.properties.getProperty("sheetName"));
        Set<String> methodSet = dataMap.keySet();
        for(String key:methodSet){
            if(key.contains(method.getName())){
                list.add(key);
            }
        }
        if(dataId.equals("data1")&&method.getName().equals("A")){
            annotation.setDataProvider("data1");
            annotation.setDataProviderClass(DataPro.class);
        }else if(dataId.equals("P0_data_excel")){
            if(list.size()>0){
                annotation.setDataProvider("P0_data_excel");
                annotation.setPriority(1);
                annotation.setDataProviderClass(DataPro.class);
            }else{
                annotation.getDescription();
            }
        }else{
            annotation.setDataProvider("P0_data_excel");
            annotation.setDataProviderClass(DataPro.class);
            System.out.println("data no exist");
        }
    }
}


