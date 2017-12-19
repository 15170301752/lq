package Btjf_API.CAPI.Enums;

/**
 * Created by wl on 2017/4/26.
 */
public enum  ExcelNameEnums {

    carSeller("CarSeller","BTJF_data"),
    staff("Staff","Staff_data"),
    B2C("B2C","B2C_data"),
    BackStage("BackStage","BackStage_data");

    private String ModleName;
    private String excelName;
    ExcelNameEnums(String ModleName,String excelName){
        this.ModleName = ModleName;
        this.excelName = excelName;
    }

    public String getModleName() {
        return ModleName;
    }

    public String getExcelName() {
        return excelName;
    }


}
