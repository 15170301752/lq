package Btjf_API.CAPI.Enums;

/**
 * Created by wl on 2017/5/18.
 */
public enum SuiteNameEnums {
    B2B("CarSeller","B2B"),
    STAFF("Staff","STAFF"),
    B2C("B2C","B2C"),
    BackStage("BackStage","BackStage");

    private String ModleName;
    private String SuiteName;
    SuiteNameEnums(String ModleName,String SuiteName){
        this.ModleName = ModleName;
        this.SuiteName = SuiteName;
    }

    public String getModleName() {
        return ModleName;
    }

    public String getSuiteName() {
        return SuiteName;
    }
}
