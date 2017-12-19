package Btjf_API.CAPI.B2C_P0;

import Btjf_API.CAPI.Utils.PublicUtil;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * Created by wl on 2017/4/21.
 */
public class B2cSuite {
    private PublicUtil publicUtil = new PublicUtil();

    @BeforeSuite
    @Parameters({"excelName","sheetName"})
    public void Init(String excelName,String sheetName){
        publicUtil.setProperty(PublicUtil.EnvConfigPath,"excelName",excelName);
        publicUtil.setProperty(PublicUtil.EnvConfigPath,"sheetName",sheetName);
    }
}
