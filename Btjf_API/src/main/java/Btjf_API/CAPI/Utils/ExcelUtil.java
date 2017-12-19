package Btjf_API.CAPI.Utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wl on 2016/7/7.
 */
public class ExcelUtil {
//    private static String path="src/main/resources/";
    private static String InterfaceSheetName="接口列表";
//    private static Log log = new Log(ExcelUtil.class);
    private static PublicUtil publicUtil = new PublicUtil();

    public static void main(String[] args)throws Exception{
//        LinkedHashMap<String ,LinkedHashMap<String,String>> dataMap = new ExcelUtil().getParamMap();
//        System.out.println("heheh");
//        System.out.println("heheh");
//        LinkedHashMap<String,LinkedHashMap<String,String>> map = new ExcelUtil().getParamMap();
//        LinkedHashMap<String,String>map1 = map.get("C");
//        Set<String> set = map1.keySet();
//        for(String s:set){
//            System.out.println(s+" = "+map1 .get(s));
//        }
        new ExcelUtil().getParamMap("B2C_data","P0_data");
        new ExcelUtil().getParamMap("B2C_data","P1_data");
        //IdentityHashMap是无序的
//        IdentityHashMap<ExcelBean,String> map = new IdentityHashMap<ExcelBean, String>();
//        map.put(new ExcelBean("a"),"1");
//        map.put(new ExcelBean("a"),"2");
//        map.put(new ExcelBean("a"),"3");
//        map.put(new ExcelBean("a"),"4");
//        map.put(new ExcelBean("a"),"5");
//        Set<ExcelBean> set = map.keySet();
//        for(ExcelBean s:set){
//            System.out.println(s.getName()+" = "+map.get(s));
//        }
        ExcelUtil excelUtil = new ExcelUtil();
        LinkedHashMap<String,String> map_url = new LinkedHashMap<String, String>();
        LinkedHashMap<String,String> map_name = new LinkedHashMap<String, String>();
        map_url = excelUtil.getInterfaceUrl("",0,5);
        map_name = excelUtil.getInterfaceUrl("",2,5);
        System.out.println(map_url.get("accComplete_2_4_0"));
        System.out.println(map_name.get("accComplete_2_4_0"));


    }
    public XSSFSheet getSheet(String excelName,String sheetName){
        String path="src/main/resources/";
        path = path + excelName+".xlsx";
        FileInputStream fis = null;
        XSSFWorkbook wb = null;
        try {
            fis = new FileInputStream(new File(path));
            wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            new Log(ExcelUtil.class).error("excel文件不存在");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        XSSFSheet sheet = wb.getSheet(sheetName);
        return sheet;
    }
    public LinkedHashMap<String ,LinkedHashMap<String,String>>  getParamMap(String excelName,String sheetName){
        XSSFSheet sheet = getSheet(excelName,sheetName);
        LinkedHashMap<String ,LinkedHashMap<String,String>> rowMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
        if(sheet==null){return rowMap;}
        String methodName = null;
//        print("最后一个row的rowNum为："+sheet.getLastRowNum());
       for(int rowNum=1;rowNum<=sheet.getLastRowNum();rowNum++){
            LinkedHashMap<String,String> cellMap = new LinkedHashMap<String, String>();;
            XSSFRow row = sheet.getRow(rowNum);
            if(row==null){continue;}
//            print("最后一个cell的cellNum为："+row.getLastCellNum());
            for(int cellNum=0;cellNum<=row.getLastCellNum();cellNum++){
                XSSFCell cell = row.getCell(cellNum);
                if(cell==null){continue;}
                  cell.setCellType(1);
                if(cell.getColumnIndex()==0){
                    methodName = cell.getStringCellValue();
                }
                getMap(cell,cellMap);
//                print(cell.getStringCellValue());
            }
            rowMap.put(methodName,cellMap);
            methodName = "";
        }
        return publicUtil.fomatDataMap(rowMap);
    }
    public void print(String s){
        System.out.println(s);
    }
    public void printMap(Map map){
        LinkedHashMap<String,Object> map1 = null;
        Set<String> set = map.keySet();
        for(String s :set){
            Object obj = map.get(s);
            if(obj instanceof LinkedHashMap){
                map1 = (LinkedHashMap<String, Object>) obj;
                printMap(map1);
            }
            print("("+s+" = "+obj.toString()+")");
        }
    }
    public void getMap(XSSFCell cell,LinkedHashMap<String,String> cellMap){
        String cellValue = cell.getStringCellValue();
//        if(cell.getColumnIndex()==1){
//            cellMap.put("CaseID",cellValue);
//        }
//        if(cellValue.contains("=")){
//            String[] strArr = cellValue.split("=",2);
//            cellMap.put(strArr[0],strArr[1]);
//        }
        int cellNum = cell.getColumnIndex();
        switch (cellNum){
            case 1:
                cellMap.put("CaseID",cellValue);
                break;
            case 2:
                cellMap.put("headParams",cellValue);
                break;
            case 3:
                cellMap.put("bodyParams",cellValue);
                break;
            case 4:
                cellMap.put("Assert",cellValue);
                break;
            case 5:
                cellMap.put("runMode",cellValue);
            default:
//                log.error("cell不存在");//
                break;
        }
    }

    /**
     * 返回接口方法名：接口路径的map
     * @return
     */
    public LinkedHashMap<String,String> getInterfaceUrl(String excelname,int x ,int y){
        LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
        XSSFSheet sheet = getSheet(excelname,InterfaceSheetName);
        String methodName = "";
        String interfaceUrl = "";
        for(int rowNum =2;rowNum<sheet.getLastRowNum();rowNum++){
            XSSFRow row = sheet.getRow(rowNum);
            if(row == null){continue;}
            XSSFCell cellUrl = row.getCell(x);
            if (cellUrl==null){continue;}
            cellUrl.setCellType(1);
            XSSFCell cellName = row.getCell(y);
            if(cellName==null){continue;}
            cellName.setCellType(1);
            map.put(cellName.getStringCellValue(),cellUrl.getStringCellValue());
        }
        return map;
    }

}

class ExcelBean{
    private static String methodName;
    ExcelBean(String methodName){
        this.methodName = methodName;
    }
    public String getName(){
        return this.methodName;
    }


    public  void fun(){
        LinkedHashMap<String ,LinkedHashMap<String,String>> rowMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
        LinkedHashMap<String,String> cellMap = new LinkedHashMap<String, String>();
        for(int x=1;x<5;x++){
            for(int y=10;y<14;y++){
                cellMap.put(String.valueOf(y),String.valueOf(y*10));
            }
            rowMap.put(x+"",cellMap);
            cellMap.clear();
        }
    }
}
