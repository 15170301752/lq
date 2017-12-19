package Btjf_API.CAPI.CarSeller_P0;

import Btjf_API.CAPI.Utils.Log;
import Btjf_API.CAPI.Utils.PublicUtil;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * Created by wl on 2017/1/5.
 */
public class ICarSuite {
    private PublicUtil publicUtil = new PublicUtil();
    private Log log = new Log(ICarSuite.class);
    @BeforeSuite
    @Parameters({"excelName","sheetName"})
    public void initLogin(String excelName,String sheetName){
        publicUtil.setProperty(PublicUtil.EnvConfigPath,"excelName",excelName);
        publicUtil.setProperty(PublicUtil.EnvConfigPath,"sheetName",sheetName);
        log.info("---------执行beforeSuite方法---------------");
        //初始化properties中的所有账号
        publicUtil.initPorperties();
        //初始化所有用户的token
        publicUtil.initLogin();
        log.info("---------beforeSuite方法执行结束-------------");
    }
}
