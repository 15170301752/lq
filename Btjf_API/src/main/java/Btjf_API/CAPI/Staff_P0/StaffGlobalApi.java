package Btjf_API.CAPI.Staff_P0;

import Btjf_API.CAPI.Utils.Log;
import Btjf_API.CAPI.Utils.PublicUtil;
import Btjf_API.CAPI.Utils.SqlUtil;

/**
 * Created by wl on 2017/4/27.
 */
public class StaffGlobalApi {
     private PublicUtil publicUtil = new PublicUtil();
     private SqlUtil sqlUtil = publicUtil.getSqlHander("xfd");
     private Log log = new Log(StaffGlobalApi.class);


    /**
     * 往消费贷数据库中征信表插入一条征信数据
     * @param empPhone 员工手机号
     */
    public void CreateCredit(String empPhone){
        String sql = "DECLARE @EmpID INT,@DeptID INT,@BranchID INT\n" +
                "SELECT  @EmpID=emp.FID,@DeptID=emp.FDeptID,@BranchID=dept.FBranchID FROM dbo.e_Emp  emp \n" +
                "LEFT JOIN  dbo.e_Base_Dept dept ON emp.FDeptID=dept.FID\n" +
                "WHERE emp.FMobile='"+empPhone+"'\n" +
                "INSERT dbo.x_Loan_SelCredit( FBillTypeID ,FBillNo ,FBillDate ,FCreditSourceID ,\n" +
                "FStatus ,FLoanType ,FIsEmergency ,FPersonID ,FPersonName ,FPersonIDCard ,FPersonMobile ,\n" +
                "FPersonAge ,FPersonSex ,FPersonBannkID ,FPersonAccount ,FPersonArea ,FMateName ,FMateIDCard ,\n" +
                "FMateMobile ,FMateAge ,FMateSex ,FGuarantorName ,FGuarantorIDCard ,FGuarantorMateName ,FGuarantorMateIDCard ,\n" +
                "FCreditCarBrandID ,FCreditCarSeriesID ,FCreditCarModelID ,FCreditCarInfo ,FLoanBankID ,\n" +
                "FBranchID ,FDeptID ,FEmpID ,FCustID ,FCarCount ,FFirstEvaluatePrice ,FRemark ,FBankAdjustTypeID ,\n" +
                "FSelCreditDate ,FBankCredit ,FCourtCredit ,FCreditStatus ,FPoliceCredit ,FBankCreditBak ,FCourtCreditBak ,\n" +
                "FPoliceCreditBak ,FCreditAdvice ,FBlackTypeID ,FAddUserID ,FAddTime ,FCheckDate ,FCheckerID ,FNextCheckerID ,\n" +
                "FNextCheckerLevel ,FCheckedLevel ,FCheckedName ,FCheckedInfo ,FCheckederID ,FIsDeleted ,FModifyUser ,\n" +
                "FModifyTime ,FIsUsed ,FSourceID ,FDepterID ,FDepterName ,FBrancherID ,FBrancherName ,FEmpName ,FDeptName ,\n" +
                "FBranchName ,FSponsorID ,FOrderNumber ,FIsCard)\n" +
                "SELECT FBillTypeID ,FBillNo ,FBillDate ,FCreditSourceID ,FStatus ,FLoanType ,FIsEmergency ,FPersonID ,'素素' ,\n" +
                "FPersonIDCard ,FPersonMobile ,FPersonAge ,FPersonSex ,FPersonBannkID ,FPersonAccount ,FPersonArea ,FMateName ,\n" +
                "FMateIDCard ,FMateMobile ,FMateAge ,FMateSex ,FGuarantorName ,FGuarantorIDCard ,FGuarantorMateName ,FGuarantorMateIDCard ,\n" +
                "FCreditCarBrandID ,FCreditCarSeriesID ,FCreditCarModelID ,FCreditCarInfo ,FLoanBankID ,@BranchID,@DeptID ,\n" +
                "@EmpID , FCustID ,FCarCount ,FFirstEvaluatePrice ,FRemark ,FBankAdjustTypeID ,FSelCreditDate ,FBankCredit ,\n" +
                "FCourtCredit ,FCreditStatus ,FPoliceCredit ,FBankCreditBak ,FCourtCreditBak ,FPoliceCreditBak ,FCreditAdvice ,\n" +
                "FBlackTypeID ,FAddUserID ,GETDATE() ,FCheckDate ,FCheckerID ,FNextCheckerID ,FNextCheckerLevel ,FCheckedLevel ,FCheckedName ,\n" +
                "FCheckedInfo ,FCheckederID ,FIsDeleted ,FModifyUser ,FModifyTime ,0 ,FSourceID ,FDepterID ,FDepterName ,FBrancherID ,\n" +
                "FBrancherName ,FEmpName ,FDeptName ,FBranchName ,FSponsorID ,FOrderNumber ,\n" +
                "FIsCard  FROM (select top 1 * from dbo.x_Loan_SelCredit order by FID desc) aa";
        //消费贷数据库中的征信表插入一条数据
        log.info("往征信表中插入一条数据");
        sqlUtil.updateColumnValue(sql);

    }
    public static void main (String[] args){
        new StaffGlobalApi().CreateCredit("13522222222");
    }


}
