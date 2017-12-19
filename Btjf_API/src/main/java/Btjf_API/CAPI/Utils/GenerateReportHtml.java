package Btjf_API.CAPI.Utils;

import Btjf_API.CAPI.Data.DataPro;
import Btjf_API.CAPI.Enums.ExcelNameEnums;
import Btjf_API.CAPI.Enums.SuiteNameEnums;
import com.beust.jcommander.internal.Lists;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wl on 2016/11/29.
 */
public class GenerateReportHtml {
    private PublicUtil publicUtil = new PublicUtil();
    private ExcelUtil excelUtil = new ExcelUtil();
    private BufferedReader br;
    private String baseHtml ="";
    private String table = "\t<div style=\"height:50px\"></div>\n" +
            "\t<div style=\"color:#FF0000\">\n" +
            "\t\t<p>suiteName</p>\n" +
            "\t</div>\n" +
            "\t<div style=\"width:auto;height:1px;margin:0px auto;padding:0px;background-color:#D5D5D5;overflow:hidden;\"></div>\n" +
            "\t<div style=\"height:20px\"></div>\n" +
            "\t<ul style=\"list-style:none;\">\n" +
            "\t\t<li style=\"float:left;margin-left:10px;font-size:20px;font-weight:bold;height:5px\">测试通过: <span style=\"background-color:green;border:1px black solid; padding:4px 5px ;\">SUCCESSCOUNT</sapn></li>\n" +
            "\t\t<li style=\"float:left;margin-left:30px;font-size:20px;font-weight:bold;height:5px\">测试失败: <span style=\"background-color:red;border:1px black solid;padding:4px 5px ;\">FAILCOUNT</span></li>\n" +
            "\t\t<li style=\"float:left;margin-left:30px;font-size:20px;font-weight:bold;height:5px\">测试忽略: <span style=\"background-color:yellow;border:1px black solid;padding:4px 5px ;\">SKIPCOUNT</span></li>\n" +
            "\t</ul>\n" +
            "\t<div style=\"height:60px\"></div>\n" +
            "\t<div style=\"width:auto;height:1px;margin:0px auto;padding:0px;background-color:#D5D5D5;overflow:hidden;\"></div>\n" +
            "\t<div style=\"height:10px\"></div>\n";

    /**
     * 读取resource文件夹中的newBaseHtml文件
     * @return
     */
    private String getBaseHtml(){
        StringBuilder sb;
        File file = new File("src/main/resources/newBaseHtml.txt");
        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
            sb = new StringBuilder();
            String line ;
            while ((line=br.readLine())!=null){
                sb.append(line);
                sb.append("\r\n");
            }
            br.close();
            return sb.toString();
        }catch (Exception e){
            System.out.print(e.getStackTrace());
        }
        return null;
    }

    /**
     * 把文本写入指定的txt文件中
     * @param reStr
     * @throws Exception
     */
    private void writeToFile (String reStr)throws Exception{
        BufferedWriter bw;
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("src/main/resources/demo.txt")),"utf-8"));
        bw.write(reStr);
        bw.close();
    }

    /**
     * 根据操作系统，判断报告的路径
     * @return 返回报告的路径
     */
    public String getRoportUrl(){
        String url = "";
        String platFormName = System.getProperty("os.name");
        if(platFormName.contains("Windows")){
           url = " file:///G:/Btjf_API/target/surefire-reports/html/index.html";
        }else{
            String s1 = "http://192.168.100.158:8080/report/"+PublicUtil.properties.getProperty("JenkinsJobName")+"/";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
            Date date = new Date();
            String s2 = sdf.format(date);
            String s3 = "/index.html";
            url = s1+s2+s3;
        }
//        System.out.println(url);
        return url;
    }

    /**
     * 获取邮件报告中的html文件
     * @return
     */
    public String generateHtml(){
//        LinkedHashMap<String,String> map_url ;
//        LinkedHashMap<String,String> map_name;
//        map_url = excelUtil.getInterfaceUrl(PublicUtil.properties.getProperty("excelName"),0,5);
//        map_name = excelUtil.getInterfaceUrl(PublicUtil.properties.getProperty("excelName"),2,5);
//        Document document;
        baseHtml = getBaseHtml();
//        SAXReader saxReader = new SAXReader();
        String date = publicUtil.getDate("yyyy-MM-dd HH:mm:ss");
        String report_url = getRoportUrl();
        baseHtml = baseHtml.replace("date",date);
        baseHtml = baseHtml.replace("report_url",report_url);
        baseHtml = baseHtml.replace("EnvConfigName",PublicUtil.properties.getProperty("EnvPropName"));
//        System.out.println(baseHtml);
        try{

            LinkedHashMap<String,CaseBean> map = parseRoot();
            baseHtml = tableStr(baseHtml,map);
//            String sum = root.attribute("tests").getText();
//            String failedNum = root.attribute("failures").getText();
//            String skippedNum = root.attribute("skipped").getText();
//            String passNum = Integer.valueOf(sum)-Integer.valueOf(failedNum)-Integer.valueOf(skippedNum)+"";
//            baseHtml = baseHtml.replace("SUCCESSCOUNT",passNum);
//            baseHtml = baseHtml.replace("FAILCOUNT",failedNum);
//            baseHtml = baseHtml.replace("SKIPCOUNT",skippedNum);
//            List<Element> cases = root.elements("testcase");
//            for(Element element:cases){
//                Element failedElement = element.element("failure");
//                Element skippedElement = element.element("skipped");
//                if(failedElement != null || skippedElement != null ){
//                    String caseName = element.attribute("name").getText();
//                    baseHtml = baseHtml +"<tr><td>"+caseName+"</td><td>"+map_name.get(caseName)+"</td><td>"+map_url.get(caseName)+"</td></tr>";
////                    System.out.println(caseName);
//                }
//            }
//            baseHtml = baseHtml + "</tbody></table></body></html>";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("xml文件不存在");
        }
        return baseHtml;
    }

    public static void main(String[] args)throws Exception{
        GenerateReportHtml generateReportHtml = new GenerateReportHtml();
//        String str = generateReportHtml.getBaseHtml();
//        System.out.println(str);
//        String ss = generateReportHtml.generateHtml();
//        System.out.println(ss);
//        generateReportHtml.writeToFile(generateReportHtml.generateHtml());
//        generateReportHtml.parseRoot();
        generateReportHtml.generateHtml();
    }

    /**
     * 解析xml报告，获取不同模块对应的用例个数
     * @return 模块--用例信息
     * @throws Exception
     */
    public LinkedHashMap<String,CaseBean> parseRoot()throws Exception{
        Document document;
        SAXReader saxReader = new SAXReader();
        document = saxReader.read(new File("target/surefire-reports/TEST-TestSuite.xml"));
        Element root = document.getRootElement();
        List<Element> cases = root.elements("testcase");
        List<Element> newCases = formatElementList(cases);
        int passNum = 0;
        int failedNum = 0;
        int sumNum = 0;
//        List<String> list = new ArrayList<String>();
        LinkedHashMap<String,CaseBean> map = new LinkedHashMap<String, CaseBean>();
        for(Element element :newCases){
            Element failedElement = element.element("failure");
            Element skippedElement = element.element("skipped");
            String className = element.attribute("classname").getText();
//            System.out.println(className);
            String[] names = className.split("\\.");
            String suiteName =names[2];
            boolean flag = false;
            if(map.size()<1){
                map.put(suiteName,new CaseBean(sumNum,passNum,failedNum,new ArrayList<String>()));
            }else{
                Set<String> keys = map.keySet();
                for(String key : keys ){
                    if(suiteName.equalsIgnoreCase(key)){
                            flag=true;
                    }
                }
            }
            if(!flag){
                map.put(suiteName,new CaseBean(sumNum,passNum,failedNum,new ArrayList<String>()));
            }
            map.get(suiteName).setSumNum(map.get(suiteName).getSumNum()+1);
            if(failedElement == null && skippedElement == null){
                map.get(suiteName).setPassNum(map.get(suiteName).getPassNum()+1);
            }else if(failedElement != null){
                String caseName = element.attribute("name").getText();
                map.get(suiteName).setFailedNum(map.get(suiteName).getFailedNum()+1);
                List<String> newList = map.get(suiteName).getCaseNames();
                newList.add(caseName);
                map.get(suiteName).setCaseNames(newList);
            }else {
                String caseName = element.attribute("name").getText();
                List<String> newList = map.get(suiteName).getCaseNames();
                newList.add(caseName);
                map.get(suiteName).setCaseNames(newList);
            }

        }
        return map;
    }

    /**
     * 拼接html报告，替换报告中的变量
     * @param baseHtml
     * @param map
     * @return
     */
    public String tableStr(String baseHtml,HashMap<String,CaseBean> map){
        String suiteName = "";
        String excelName = "";
        Set<String> keys = map.keySet();
        for(String key:keys){
            LinkedHashMap<String,String> map_url =null;
            LinkedHashMap<String,String> map_name = null;
            String newTable = table;
            for(SuiteNameEnums suiteNameEnums : SuiteNameEnums.values()){
                if(key.equalsIgnoreCase(suiteNameEnums.getModleName())){
                    suiteName = suiteNameEnums.getSuiteName();
                    break;
                }
            }
            newTable = newTable.replace("suiteName",suiteName);
            newTable = newTable.replace("SUCCESSCOUNT",String.valueOf(map.get(key).getPassNum()));
            newTable = newTable.replace("FAILCOUNT",String.valueOf(map.get(key).getFailedNum()));
            newTable = newTable.replace("SKIPCOUNT",String.valueOf(map.get(key).getSumNum()-map.get(key).getPassNum()-map.get(key).getFailedNum()));
            for(ExcelNameEnums excelNameEnums:ExcelNameEnums.values()){
                if(key.equalsIgnoreCase(excelNameEnums.getModleName())){
                    excelName = excelNameEnums.getExcelName();
                    break;
                }
            }
            map_url = excelUtil.getInterfaceUrl(excelName,0,5);
            map_name = excelUtil.getInterfaceUrl(excelName,2,5);
            if(map.get(key).getCaseNames().size()>0){
                newTable = newTable + "\t<table width=\"100%\" height=\"80\" >\n" +
                        "\t\t<thead align=\"left\">\n" +
                        "\t  \t\t<tr>\n" +
                        "\t  \t\t  <th width=\"18%\">接口方法名</th>\n" +
                        "\t\t\t  <th width=\"32%\">接口名称</th>\n" +
                        "\t  \t\t  <th width=\"50%\">接口路径</th>\n" +
                        "\t  \t\t</tr>\n" +
                        "\t\t</thead>\n" +
                        "\t\t<tbody align=\"left\">";
                for(String caseName : map.get(key).getCaseNames()){
                    newTable = newTable +"<tr><td>"+caseName+"</td><td>"+map_name.get(caseName)+"</td><td>"+map_url.get(caseName)+"</td></tr>";
                }
                newTable = newTable + "</tbody></table>";
            }
            baseHtml = baseHtml + newTable;
        }
        baseHtml = baseHtml + "</body></html>";
        return baseHtml;
    }

    /**
     * 对xml文件中的所有case进行去重，然后保留每个相同case的最后一条记录
     * @param cases
     * @return
     */
    public List<Element> formatElementList (List<Element> cases){
        List<Element> newCases = Lists.newArrayList();
        List<Integer> idList = Lists.newArrayList();
        Map<Integer,Element> map = new HashMap<Integer, Element>();
        for(Element element : cases){
            String className = element.attribute("classname").getText();
            String caseName = element.attribute("name").getText();
            Element skippedElement = element.element("skipped");
            int id = className.hashCode()+caseName.hashCode();
            if(skippedElement == null){
                newCases.add(element);
                idList.add(id);
            }else if(skippedElement != null){
                map.put(id,element);
            }
        }
        for(Integer num : map.keySet()){
            if(!idList.contains(num)){
                newCases.add(map.get(num));
            }
        }
        return newCases;
    }


}

class CaseBean{
    private int sumNum;
    private int passNum;
    private int failedNum;
    private List<String> caseNames;

    public CaseBean(int sumNum,int passNum,int failedNum,List<String> caseNames){
        this.sumNum = sumNum;
        this.passNum = passNum;
        this.failedNum = failedNum;
        this.caseNames = caseNames;
    }

    public int getPassNum() {
        return passNum;
    }

    public int getFailedNum() {
        return failedNum;
    }

    public void setPassNum(int passNum) {
        this.passNum = passNum;
    }

    public void setFailedNum(int failedNum) {
        this.failedNum = failedNum;
    }

    public void setCaseNames(List<String> caseNames) {
        this.caseNames = caseNames;
    }

    public List<String> getCaseNames() {
        return caseNames;
    }

    public int getSumNum() {
        return sumNum;
    }

    public void setSumNum(int sumNum) {
        this.sumNum = sumNum;
    }
}
