package Btjf_API.CAPI.CarSeller_P0;

import Btjf_API.CAPI.Utils.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Reporter;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by wl on 2016/12/23.
 */
public class GlobalApi {
    private PublicUtil publicUtil = new PublicUtil();
    private HttpUtil httpUtil = new HttpUtil();
    private SqlUtil sqlUtil = publicUtil.getSqlHander("carSeller");
    private  String subCarUrl ="/car-seller-client-interfaces";
    private Log log = new Log(GlobalApi.class);

    /**
     * 登录接口
     * @param phoneNum
     * @param password
     */
    public void carLogin(String phoneNum,String password){
        LinkedHashMap<String,Object> headMap = new LinkedHashMap<String, Object>();
        LinkedHashMap<String,Object> bodyMap = new LinkedHashMap<String, Object>();
        headMap.put("deviceType","1");
        bodyMap.put("account",phoneNum);
        bodyMap.put("password",password);
        String url = subCarUrl +"/m/system/login";
        try{
            JSONObject resultJson = httpUtil.postForm(url,headMap,bodyMap);
        }catch (Exception e){
            log.error("------------账号: "+phoneNum+" 登录失败------");
            Reporter.log("------------账号: "+phoneNum+" 登录失败------");
        }
    }

    /**
     * 认证审核不通过
     * @param phone
     */
    public void certificationNoPass(String phone){
        String sql1 = "update t_CustCertification set Fstate = 3 from t_CustCertification a INNER JOIN " +
                "t_Member b ON a.FMemberID=b.FMemberID where b.FMobile='"+phone+"' AND a.FState=1;";
        String sql2 = "update t_Member set FCertificationState=3 where Fmobile = '"+phone+"';";
        sqlUtil.updateColumnValue(sql1);
        sqlUtil.updateColumnValue(sql2);
        log.info("车商认证不通过操作成功");
    }

    /**
     * 重新认证审核不通过
     * @param phone
     */
    public void againCertificationNoPass(String phone){
        String sql1 = "update t_CustCertification set Fstate = 3 from t_CustCertification a INNER JOIN " +
                "t_Member b ON a.FMemberID=b.FMemberID where b.FMobile='"+phone+"' AND a.FState=1;";
        String sql2 = "update t_Member set FCertificationState=2 where Fmobile = '"+phone+"';";
        sqlUtil.updateColumnValue(sql1);
        sqlUtil.updateColumnValue(sql2);
        log.info("车商认证不通过操作成功");
    }

    /**
     * 根据车辆ID，sql执行抵押车辆审核不通过
     * @param carID
     */
    public void vinNoPass(String carID){
        String sql ="update t_CarMortgageInventory set FCheckStatus=2,FCheckerID=\n" +
                "(select top 1 FEmpID from t_emp where FPosition=1 and FisAdmin=1 and FIsDisable=0 and FIsLimit=1),\n" +
                "FCheckDate=GETDATE(),FIsInventory=0,FStatus=4 where FCarID="+carID;
        sqlUtil.updateColumnValue(sql);
        log.info("抵押车辆审核失败sql执行成功");
    }

    /**
     * 根据车辆ID或者手机号码，sql执行车辆上架审核不通过
     * @param carID
     */
    public void carNoPass(String carID){
        if(carID.length()==11){
             carID = "select top 1 a.FID from t_CarInfoNew a LEFT JOIN t_Member b ON a.FCustID=b.FMemberID LEFT JOIN t_CarSalesInfo \n" +
                     "c ON a.FID=c.FCarID where b.FMobile='"+carID+"' and c.FSaleStatus=0 and c.FCheckStatus=0 order by a.fid desc";
        }
        carID = sqlUtil.getColumnValue(carID,"FID");
        if(carID==null){log.error("车辆ID为空，发车失败");return ;}
        String sql_1 = "INSERT into t_CarOperationRecord (FCarID,FOperationTime,FOperationBefore,FOperationAfter,FOperationPort,FOperationIdentify,\n" +
                "FOperatorId,FOperatorType,FRemarks,FAddTime,FOperator)\n" +
                "SELECT "+carID+",a.dd,'待审核','审核不通过',2,7,a.FEmpID,1,'车辆图片未满6张',a.dd,a.FUserName from (select top 1 FEmpID,\n" +
                "FUserName,GETDATE() dd from t_emp where FPosition=1 and FisAdmin=1 and FIsDisable=0 and FIsLimit=1) a";

        String sql_2 = "update  t_CarSalesInfo set FCheckStatus=2,FCheckerID=(select top 1 FEmpID from t_emp where FPosition=1 and FisAdmin=1 and FIsDisable=0 and FIsLimit=1),\n" +
                "FCheckDate=GETDATE(),FEffectivePeriod='120',FSourceSiteId=0,FRefreshes=0,FRefresheInterval=0 where FcarID="+carID;
        sqlUtil.updateColumnValue(sql_1);
        sqlUtil.updateColumnValue(sql_2);
        log.info("车辆上架审核不通过sql执行成功");
    }

    /**
     * 取消车辆订单
     * @param phoneOrToken
     * @param carID
     */
    public void cancelCarOrder(String phoneOrToken ,String carID){
        if(phoneOrToken.length()<=11){
            String sql ="select * from t_AuthAccessToken where account = '"+phoneOrToken+"' order by id desc";
            phoneOrToken=sqlUtil.getColumnValue(sql,"accesstoken");
        }
        LinkedHashMap<String,Object> cancleBodyMap = new LinkedHashMap<String, Object>();
        LinkedHashMap<String,Object> cancleheadMap = new LinkedHashMap<String, Object>();
        cancleheadMap.put("AccessToken",phoneOrToken);
        cancleheadMap.put("version","2.5.0");
        String sql = "select FOrderID from t_SaleOrder where FCarID="+carID+" ORDER BY FOrderID desc";
        String orderid = sqlUtil.getColumnValue(sql,"FOrderID");
        cancleBodyMap.put("orderID",orderid);
        String url_cancle = subCarUrl+"/m/mine/order/buyer/cancel";
        try {
            JSONObject resultJson_cancle = httpUtil.postForm(url_cancle,cancleheadMap,cancleBodyMap);
            String code = resultJson_cancle.get("code").toString();
            if(code.equalsIgnoreCase("1")){
                log.info("取消车辆订单成功");
            }else{
                log.info("取消车辆订单失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("取消车辆订单失败");

        }
    }

    /**
     * 根据手机号或者订单号，卖家确认可交易
     * @param phoneOrToken 卖家手机号或者卖家token
     * @param phoneOrOrderID 卖家手机号或者卖家token
     */
    public void sellerConfirmOrder(String phoneOrToken,String phoneOrOrderID){
        if(phoneOrToken.length()<=11){
            String sql ="select * from t_AuthAccessToken where account = '"+phoneOrToken+"' order by id desc";
            phoneOrToken=sqlUtil.getColumnValue(sql,"accesstoken");
        }
        if(phoneOrOrderID.length()==11){
            String sql_1 = "select top 1 FOrderID from t_SaleOrder where FSellID=\n" +
                    "(select FMemberID from t_Member where FMobile='"+phoneOrOrderID+"')order by forderid desc";
            phoneOrOrderID = sqlUtil.getColumnValue(sql_1,"FOrderID");
        }
        String url ="/m/mine/order/seller/confirm";
        String code = opreateCarOrder(url,phoneOrToken,phoneOrOrderID);
        if(code.equalsIgnoreCase("1")){
            log.info("卖家确认车辆订单成功");
        }else{
            log.error("卖家确认车辆订单失败");
        }
    }

    /**
     * 根据手机号或者订单号，买家确认不可交易
     * @param phoneOrToken
     * @param phoneOrOrderID
     */
    public void buyerConfirmOrder(String phoneOrToken,String phoneOrOrderID ){
        if(phoneOrToken.length()<=11){
            String sql ="select * from t_AuthAccessToken where account = '"+phoneOrToken+"' order by id desc";
            phoneOrToken=sqlUtil.getColumnValue(sql,"accesstoken");
        }
        if(phoneOrOrderID.length()==11){
            String sql_1 = "select top 1 FOrderID from t_SaleOrder where FBuyID=\n" +
                    "(select FMemberID from t_Member where FMobile='"+phoneOrOrderID+"')order by forderid desc";
            phoneOrOrderID = sqlUtil.getColumnValue(sql_1,"FOrderID");
        }
        String url = "/m/mine/order/buyer/confirmGetCar";
        String code = opreateCarOrder(url,phoneOrToken,phoneOrOrderID);
        if(code.equalsIgnoreCase("1")){
            log.info("买家确认提车成功");
            Reporter.log("买家确认提车成功");
        }else{
            log.error("买家确认提车失败");
            Reporter.log("买家确认提车失败");
        }
    }

    /**
     * 买/卖家操作订单
     * @param url
     * @param phoneOrToken
     * @param phoneOrOrderID
     * @return
     */
    public String  opreateCarOrder(String url,String phoneOrToken ,String phoneOrOrderID){
        LinkedHashMap<String,Object> BodyMap = new LinkedHashMap<String, Object>();
        LinkedHashMap<String,Object> headMap = new LinkedHashMap<String, Object>();
        headMap.put("AccessToken",phoneOrToken);
        headMap.put("version","2.5.0");
        BodyMap.put("orderID",phoneOrOrderID);
        url = subCarUrl+url;
        try {
            JSONObject resultJson = httpUtil.postForm(url,headMap,BodyMap);
            String code = resultJson.getString("code");
            return code;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("订单操作失败");
        }
        return "-1";
    }

    /**
     * 订金宝还款审核通过
     * @param phoneOrloanID   手机号或者loanID
     */
    public void depositAmountReturnPass(String phoneOrloanID){
        if(phoneOrloanID.length()==11){
            String sql = "select top 1 FID from t_LoanApply a LEFT JOIN t_Member b ON a.FCustID=b.FMemberID \n" +
                    "where b.FMobile='"+phoneOrloanID+"' and a.FLoanID=1 order by fid desc";
            phoneOrloanID = sqlUtil.getColumnValue(sql,"FID");
        }
        String sql_1 = "update t_LoanApply set FCustInInterestAmount=.00 , FCustInSumAmount=1000.00,\n" +
                "FCustInDate=GETDATE(),FCustRepaymentAuditAmount=.00,FCustRepaymentedAmount=1000.00 where Fid="+phoneOrloanID+";";

        String sql_2 = "update t_AmountReturn set FStatus=4,FCustBankID='20101',FCustAccount='234',FAccountID=28,\n" +
                "FBiller=(select top 1 FEmpID from t_emp where FPosition=6 and FisAdmin=1 and FIsDisable=0 and FIsLimit=1),\n" +
                "FCheckLevel=1,\n" +
                "FCheckerID=(select top 1 FEmpID from t_emp where FPosition=6 and FisAdmin=1 and FIsDisable=0 and FIsLimit=1),\n" +
                "FCheckDate=GETDATE(),FIsChecked=0,FCalInterestDays=1,\n" +
                "FCheckLevelName='总部出纳确认',FModifyDate=GETDATE(),FConfirmDate=GETDATE(),FConfirmMoney='666' where FApplyID="+phoneOrloanID+";";

        sqlUtil.updateColumnValue(sql_1);
        sqlUtil.updateColumnValue(sql_2);
        sanBaoAmountAdd(phoneOrloanID);//授信额度增加回去
        log.info("订金宝还款审核通过");
    }

    /**
     * 2.6之前使用的t_Cust表，2.6以后不在维护t_Cust,使用t_CarSellerLoan_CreditInfo
     * 三宝还款审核通过后，授信额度增加回去
     * @param loanID t_laonApply表中的FID
     */
    public void sanBaoAmountAdd(String loanID){
        String sql = "update t_CarSellerLoan_CreditInfo set FSurplusQuota = (a.FSurplusQuota + b.FLoanAmount) ,FOccupyQuota = (a.FOccupyQuota \n" +
                "- b.FLoanAmount) from t_CarSellerLoan_CreditInfo a INNER JOIN t_LoanApply b ON a.FLoanUserID = b.FCustID where b.FID = "+loanID;
        sqlUtil.updateColumnValue(sql);
        log.info("三宝审核通过后，可用授信额度增加成功");
    }

    /**
     * 2.6之前使用的t_Cust表，2.6以后不在维护t_Cust,使用t_CarSellerLoan_CreditInfo
     * 可用授信额度减少（数据库中，插入三宝申请成功时，需要减去授信总额度，和增加以贷款额度）
     * @param loanID t_loanApply表的FID
     */
    public void sanBaoAmountMinus(String loanID){
        String sql = "update t_CarSellerLoan_CreditInfo set FSurplusQuota = (a.FSurplusQuota - b.FLoanAmount) ,FOccupyQuota = (a.FOccupyQuota \n" +
                "+ b.FLoanAmount) from t_CarSellerLoan_CreditInfo a INNER JOIN t_LoanApply b ON a.FLoanUserID = b.FCustID where b.FID = "+loanID;
        sqlUtil.updateColumnValue(sql);
        log.info("插入三宝审核通过数据后，可用授信额度减少操作成功");
    }

    /**
     * 应收宝审核不通过（业务员）
     * @param phoneOrOrderID  手机号或者t_loanApply表中的FID
     */
    public void ysbNoPass(String phoneOrOrderID){
        if(phoneOrOrderID.length()==11){
            String sql ="select top 1 a.FID from t_LoanApply a LEFT JOIN t_Member b ON a.FCustID = b.FMemberID \n" +
                    "where a.FLoanID=3 and a.FStatus=3 and b.FMobile='"+phoneOrOrderID+"' order by FID DESC";
            phoneOrOrderID = sqlUtil.getColumnValue(sql,"FID");
        }
        String sql_1 = "update t_LoanApply set FStatus=5,FCheckDate=GETDATE(),FCheckInfo='业务员审核不通过' where FID="+phoneOrOrderID+";";
        //更新t_loanApply表的审核状态
        sqlUtil.updateColumnValue(sql_1);
        //更新授信额度
        sanBaoAmountAdd(phoneOrOrderID);
        log.info("应收宝业务员审核不通过操作成功");

    }

    /**
     * 插入一条应收宝待还款的订单数据
     * @param phone
     */
    public void ysbApplySuccess(String phone){
        String sql = "select top 1 a.FID from t_LoanApply a LEFT JOIN t_Member b ON a.FCustID =\n" +
                " b.FMemberID where a.FLoanID=3 and a.FStatus=4 and a.FAdvancesDate is \n" +
                "NOT NULL and a.FCustRepayMentedAmount is NULL and b.FMobile='"+phone+"' \n" +
                "order by a.FID desc";
        String fid = sqlUtil.getColumnValue(sql,"FID");
        if(fid!=null){
            log.info("用户存在应收宝待还款订单,不再生成待还款订单数据");
            return;
        }
        String sql_maxID = "update t_MaxID set FID=FID+1 from t_MaxID where FTableName in ('t_LoanApply','t_AmountAdvances');";
        //更新t_MaxID表中t_laonApply , t_AmountAdvances的Maxid
        sqlUtil.updateColumnValue(sql_maxID);
//        获取maxID表中的t_laonApply , t_AmountAdvances的Maxid
        String sql_getID = "select FID from t_MaxID where FTableName in ('t_LoanApply','t_AmountAdvances')\n" +
                "order by case FTableName when 't_LoanApply' then 1 else 2 END;";
        List<String> id_list = sqlUtil.getColumnValueList(sql_getID,"FID");
        String ApplyID = id_list.get(0);
        String advanceID =id_list.get(1);
        String sql_empID = "select top 1 FEmpID from t_EMP WHERE FPosition=1 order by FEmpID desc";
        sql_empID = sqlUtil.getColumnValue(sql_empID,"FEmpID");
        String sql_loanApply = "INSERT INTO t_LoanApply ( FID,FClassTypeID, FBillNo,FLoanID,FDate,FStatus, \n" +
                "FLoanAmount, FAssessAmount, FInRate, FSureInRate,FPoundage, FPeriodID,\n" +
                "FAdvancesDate,FAdvancesBank, FAdvancesAccount,FBrandID,FModelsID,FCustID,\n" +
                "FBiller, FBillDate, FCheckLevel,FCheckDate,FCheckInfo,FChecklevelName,fIsChecked, \n" +
                "FBrandName, FModelsName, FStyleID,FStyleName,FLoanBond,FLoanTerm,FRateID,\n" +
                "FIsNeedPoundage,FOccupyDeposit,FCreditQuota,FSingleQuota,FOccupyQuota,FNoDepositAmount) \n" +
                "select "+ApplyID+",'10004', '2016123650012',  '3', GETDATE(),'4', '10000.00',\n" +
                "'100000.00',  '.0150', '.0150', '15.00', '7',GETDATE(), '20116', '24','33', '18',\n" +
                "b.FMemberID, b.FMemberID, GETDATE(), '40',GETDATE(), '6666', '客服 审核','0',\n" +
                "'奥迪', 'A6L', '24969',' 2016款 TFSI 运动型',.00,7 ,a.FID,0,.00,.00,.00,.00,.00 \n" +
                "from t_CarSellerLoan_Rate a INNER JOIN t_Member b ON a.FLoanUserID=\n" +
                "b.FMemberID where b.FMobile='"+phone+"';";
        String sql_amountAdvances = "INSERT INTO t_AmountAdvances(FID,FClassTypeID, FApplyID, FBillNo,FStatus,\n" +
                "FDate, FSettlementID, FBegDate,FEndDate, FPeriodID, FRate, FAmount,FBankID,\n" +
                "FAccountID, FRemark, FCustID,FMemberID, FBillDate,FCheckerID, FCheckDate, \n" +
                "FIsChecked,FTaskID, FProcessInstanceID, FCheckInfo, FCheckLevelName, FModifyer, FModifyDate) \n" +
                "select "+advanceID+",'10009', "+ApplyID+",'201612300001','4', a.dd, '3', a.dd,a.dd, \n" +
                "'7','.0150', '10000.00','20116', '24', '', a.FMemberID,a.FMemberID,a.dd,\n" +
                ""+sql_empID+", a.dd,'0','', '', '', '', "+sql_empID+", GETDATE() from (select FMemberID,\n" +
                "GETDATE() dd,FMobile  from t_Member) a where a.FMobile='"+phone+"';";

        String sql_upateLoan = "update t_LoanApply set FAmountAdvancesID="+advanceID+" where FID="+ApplyID+";";

        String sql_ARLoan = "INSERT INTO t_ARLoanApply (FLoanApplyId,FCustomer,FCustomerIDCard,\n" +
                "FIsApplyPayment,FCreateTime, FCustID) \n" +
                "VALUES ("+ApplyID+",'这是', '360400197708064460','0',GETDATE(),68647);";
        //t_loanApply插入数据
        sqlUtil.updateColumnValue(sql_loanApply);
        //t_AmountAdvances插入数据
        sqlUtil.updateColumnValue(sql_amountAdvances);
        //更新t_loanApply表中FAmountAdvancesID字段
        sqlUtil.updateColumnValue(sql_upateLoan);
        //t_ARLoanApply插入数据
        sqlUtil.updateColumnValue(sql_ARLoan);
        //更新t_cust表中授信总额度和贷款额度
        sanBaoAmountMinus(ApplyID);

        log.info("插入应收宝待审核数据成功");
    }

    /**
     * 根据手机号或者loanID，审核应收宝还款成功
     * @param phoneOrLoanID
     */
    public void ysbAmountReturnPass(String phoneOrLoanID){
        if(phoneOrLoanID.length()==11){
            String sql = "select top 1 FID from t_LoanApply where FLoanID=3 and FStatus=4 and FCustRepaymentAuditAmount \n" +
                    "IS NOT NULL and FCustRepaymentedAmount IS NULL and FCustID=(select FMemberID from t_Member \n" +
                    "where FMobile='"+phoneOrLoanID+"')  order by FID desc ";
            phoneOrLoanID = sqlUtil.getColumnValue(sql,"FID");
        }
        String sql_loanApply = "update t_LoanApply set FCustInInterestAmount=35.00,FCustInSumAmount=10035,FCustInDate=GETDATE(),\n" +
                "FCustRepaymentAuditAmount=0.00,FCustRepaymentedAmount=10000 where FID="+phoneOrLoanID+";";
        String sql_amountReturn = "update t_AmountReturn set FStatus=4,FCustBankID=20101,FCustAccount='234',FBankID=20116,\n" +
                "FAccountID=28,FCheckLevel=1,FCheckerID=(select top 1 FEmpID from t_emp where FPosition=6 and FisAdmin=1 and FIsDisable=0 and FIsLimit=1),\n" +
                "FCheckDate=GETDATE(),FIsChecked=0,FCheckLevelName='总部出纳确认',FCalInterestDays=1,FModifyDate=GETDATE(),FConfirmDate=GETDATE(),\n" +
                "FConfirmMoney='10000' where FApplyID="+phoneOrLoanID+";";
        //更新t_laonApply表
        sqlUtil.updateColumnValue(sql_loanApply);
        //更新t_AmountReturn表
        sqlUtil.updateColumnValue(sql_amountReturn);
        //更新t_cust表的授信额度
        sanBaoAmountAdd(phoneOrLoanID);
        log.info("应收宝还款审核成功");
    }

    /**
     * 收车宝审核不通过
     * @param phoneOrLoanID 手机号或者loanID
     */
    public void scbNoPass(String phoneOrLoanID){
        log.info("phoneOrLoanID = "+phoneOrLoanID);
        if(phoneOrLoanID.length()==11){
            String sql  = "select top 1 a.FID from t_LoanApply a LEFT JOIN t_Member b ON a.FCustID =" +
                    "b.FMemberID where b.FMobile='"+phoneOrLoanID+"' and a.FLoanID=2 and a.FStatus in (2,3) order by a.FID desc;";
            log.info("------sql = "+sql);
            phoneOrLoanID = sqlUtil.getColumnValue(sql,"FID");
        }
        log.info("------phoneOrLoanID = "+phoneOrLoanID);
        String sql_CarMortgage = "update a set a.FStatus=1 from t_CarMortgageInventory a  where EXISTS(select top 1 \n" +
                "FCarID from t_LoanApplyEntry where FParentID="+phoneOrLoanID+" and a.FCarID=FCarID);";
        String sql_loanApply="update t_LoanApply set FStatus=5,FCheckLevel=10,FCheckerID=a.FEmpID,FCheckDate=GETDATE(),\n" +
                "FCheckInfo='业务员审核不通过',FChecklevelName='业务员审核' from t_Member a INNER JOIN \n" +
                "t_LoanApply b on a.FMemberID=b.FCustID where FID="+phoneOrLoanID+";";
        //更新t_CarMortgageInventory表数据
        sqlUtil.updateColumnValue(sql_CarMortgage);
        //更新t_LoanApply表的数据
        sqlUtil.updateColumnValue(sql_loanApply);
        //更新t_cust表中的授信额度
        sanBaoAmountAdd(phoneOrLoanID);
        log.info("收车宝业务员审核不通过操作成功");

    }

    /**
     * 插入一条应收宝待还款状态的数据
     * @param phone 手机号
     */
    public void scbApplySuccess(String phone){
        String sql = "select top 1 a.FID from t_LoanApplyEntry a INNER JOIN t_LoanApply b ON a.FParentID=b.FID \n" +
                "INNER JOIN t_Member c ON b.FCustID=c.FMemberID where b.FLoanID=2 and b.FStatus=4 AND\n" +
                "b.FAdvancesDate is NOT NULL and b.FCustRepayMentedAmount is NULL \n" +
                "and c.FMobile='"+phone+"' order by a.FID; ";
        String fid = sqlUtil.getColumnValue(sql,"FID");
        if(fid!=null){
            log.info("用户存在收车宝待还款订单,不再生成待还款订单数据");
            return;
        }
        String v_CustID = "select FMemberID from t_Member where FMobile='"+phone+"'";
        String v_carID="select top 1 a.FCarID from t_CarMortgageInventory a INNER JOIN t_CarInfoNew b ON a.FCarID =\n" +
                " b.FID INNER JOIN t_Member c ON b.FCustID=c.FMemberID where c.FMobile='"+phone+"' and a.FStatus=1\n" +
                "order by a.FCarID desc;";
        //获取FCustID 和 FCarID
        v_CustID = sqlUtil.getColumnValue(v_CustID,"FMemberID");
        v_carID  = sqlUtil.getColumnValue(v_carID,"FCarID");
        //未避免scbNoPass方法失败，造成carID为null，加一层判断
        if(v_carID==null){
            log.error("可抵押的车辆ID为null，不能生成收车宝待还款数据");
            return;
        }
        //更新t_MaxId表中 t_loanApply，t_AmountAdvance ，t_AmountIn 的最大ID
        String update_MaxID = "update t_MaxID SET FID=FID+1 where FTableName in ('t_LoanApply','t_AmountAdvances','t_AmountIn')";
        sqlUtil.updateColumnValue(update_MaxID);
        //获取t_MaxId表中 t_loanApply，t_AmountAdvance ，t_AmountIn 的FID
        String sql_getID = "select FID from t_MaxID where FTableName in ('t_LoanApply',\n" +
                "'t_AmountAdvances','t_AmountIn')ORDER BY case FTableName WHEN \n" +
                "'t_LoanApply' then 1WHEN 't_AmountAdvances' THEN 2 ELSE 3 END;";
        List<String> list_id = sqlUtil.getColumnValueList(sql_getID,"FID");
        String v_LoanMaxID = list_id.get(0);
        String v_AdvMaxID = list_id.get(1);
        String v_AInMaxID = list_id.get(2);

        String sql_loanApply = "INSERT INTO t_LoanApply (FID,FClassTypeID,FBillNo,FOrderID,FLoanID,\n" +
                "FDate,FStatus,FLoanAmount,FAssessAmount,FInRate,FSureInRate,FPoundage,\n" +
                "FPeriodID,FSourceID,FSourceUnitID,FAdvancesDate,FAdvancesBank,\n" +
                "FAdvancesAccount,FBrandID,FModelsID,FCustID,FBiller,FBillDate,FCheckLevel,\n" +
                "FCheckerID,FCheckDate,FAmountInID,FAmountAdvancesID,fProcessInstanceID,\n" +
                "fTaskID,fChecklevelName,fIsChecked,FBrandName,FModelsName,FStyleID,\n" +
                "FStyleName,FLoanBond,FLoanTerm,FRateID,FIsNeedPoundage,FOccupyDeposit,\n" +
                "FCreditQuota,FSingleQuota,FOccupyQuota,FNoDepositAmount)\n" +
                "select "+v_LoanMaxID+",'10004','201701030014','0','2',a.dd,'4','20000.00',\n" +
                "'369000.00', '.0110', '.0110', '15.00', '60', '0', '0',a.dd,\n" +
                "'20116','24','33','18',"+v_CustID+","+v_CustID+",a.dd,'50',a.FEmpID,\n" +
                "a.dd,'','','','','总部审核','0','奥迪','A6L','24969','2016款 TFSI 运动型',\n" +
                "'.00',60,b.FID,0,.00,.00,.00,.00,.00 from (select top 1 FEMpID,GETDATE()dd \n" +
                "from t_Emp where FPosition= 5 and FisAdmin=1 and FIsDisable=0 and FIsLimit=1)a,\n" +
                "(select FID from t_CarSellerLoan_Rate where FLoanUserID="+v_CustID+") b;;";

        String sql_loanEntry = "INSERT INTO t_LoanApplyEntry (FParentID,FCarID,FAssessAmount,FCanLoanAmount,\n" +
                "FLoanAmount,FOutInterestAmount,FInRate,FPoundage,FBegDate,FLoanBond,FStatus) \n" +
                "VALUES( "+v_LoanMaxID+","+v_carID+",'15.89','110000.00','20000.00','.00','.0110','15.00',\n" +
                "GETDATE(),'.00',0)";
        String sql_update_carMorage = "UPDATE t_CarMortgageInventory SET FStatus=0 where FCarID="+v_carID+";";

        String sql_amountAdvances = "INSERT INTO t_AmountAdvances (FID,FClassTypeID,FApplyID,FBillNo,FStatus,FDate,\n" +
                "FSettlementID,FBegDate,FPeriodID,FRate,FAmount,FBankID,FAccountID,FRemark,\n" +
                "FCustID,FMemberID,FBillDate,FCheckerID,FCheckDate,FIsChecked,FTaskID,\n" +
                "FProcessInstanceID,FCheckInfo,FCheckLevelName,FModifyer,FModifyDate)\n" +
                "SELECT "+v_AdvMaxID+",'10009',"+v_LoanMaxID+",'201701030001','4',a.dd,'3',a.dd,'60','.0110',\n" +
                "'20000.00','20116','24','',"+v_CustID+","+v_CustID+",a.dd,a.FEmpID,a.dd,'0','', '', '', '',\n" +
                "a.FEmpID, a.dd from (select top 1 FEmpID,GETDATE()dd from t_emp where FPosition= \n" +
                "6 and FisAdmin=1 and FIsDisable=0 and FIsLimit=1)a;";

        String sql_amountIn = "INSERT INTO t_AmountIn (FID,FClassTypeID,FApplyID,FBillNo,\n" +
                "FStatus,FSourceID,FSourceUnitID,FSettlementID,FPeriodID,\n" +
                "FAmount,FBankID,FAccountID,FMemberID,FCustID,FIsChecked,\n" +
                "FModifyer,FModifyDate,FSourceStatus) \n" +
                "SELECT "+v_AInMaxID+",'10007',"+v_LoanMaxID+",'201701030001','1','0','0','3',\n" +
                "'60','20000.00','20116','24',"+v_CustID+","+v_CustID+",'0',a.FEmpID,GETDATE(),\n" +
                "'1' from(select top 1 FEmpID from t_emp where FPosition= 6 and \n" +
                "FisAdmin=1 and FIsDisable=0 and FIsLimit=1)a ;";

        String sql_update_loanApply = "update t_LoanApply set FAmountInID="+v_AInMaxID+",FAmountAdvancesID="+v_AdvMaxID+" where FID="+v_LoanMaxID;
        //t_loanApply表中插入一条收车宝贷款数据
        sqlUtil.updateColumnValue(sql_loanApply);
        //t_loanEntry表中插入一条收车宝和抵押车相关的数据
        sqlUtil.updateColumnValue(sql_loanEntry);
        //更新t_CarMortgageInventory表中抵押车的数据
        sqlUtil.updateColumnValue(sql_update_carMorage);
        //t_AmountAdvances表中插入垫款数据
        sqlUtil.updateColumnValue(sql_amountAdvances);
        //t_AmountIn表中插入一条收车宝数据
        sqlUtil.updateColumnValue(sql_amountIn);
        //更新t_loanApply表中的数据
        sqlUtil.updateColumnValue(sql_update_loanApply);
        //更新t_CarSellerLoan_CreditInfo表中的授信额度
        sanBaoAmountMinus(v_LoanMaxID);
        log.info("插入收车宝待还款数据成功");

    }

    /**
     * 应收宝还款审核成功
     * @param phoneOrLoanID  手机号或者t_laonapply表中的FID
     */
    public void scbAmountReturnPass(String phoneOrLoanID){
        if(phoneOrLoanID.length()==11){
            String sql = "select top 1 FID from t_LoanApply where FLoanID=2 and FStatus=4 and FCustRepaymentAuditAmount \n" +
                    "IS NOT NULL and FCustRepaymentedAmount IS NULL and FCustID=(select FMemberID from t_Member \n" +
                    "where FMobile='"+phoneOrLoanID+"')  order by FID desc ";
            phoneOrLoanID = sqlUtil.getColumnValue(sql,"FID");
        }
        String v_caiwuID = "select top 1 FEmpID from t_emp where FPosition= 6 and FisAdmin=1 and FIsDisable=0 and FIsLimit=1";
        v_caiwuID = sqlUtil.getColumnValue(v_caiwuID,"FEmpID");
        String v_carID = "select top 1 FCarID from t_LoanApplyEntry where FParentID="+phoneOrLoanID;
        v_carID = sqlUtil.getColumnValue(v_carID,"FCarID");
        String update_loanApply = "update t_LoanApply set FCustInInterestAmount=7,FCustInSumAmount=20007,FCustInDate=GETDATE(),\n" +
                "FCustRepaymentAuditAmount=0,FCustRepaymentedAmount=20000 where FID="+phoneOrLoanID;
        String update_AmountReturn = "update t_AmountReturn set FStatus=4,FCustBankID='20101',FCustAccount='234',FAccountID=28,\n" +
                "FBiller="+v_caiwuID+",FCheckLevel=1,FCheckerID="+v_caiwuID+",FCheckDate=GETDATE(),FIsChecked=0,\n" +
                "FCheckLevelName='总部出纳确认',FModifyDate=GETDATE(),FConfirmDate=GETDATE(),FCalInterestDays=1,FConfirmMoney=10000\n" +
                "where FApplyID="+phoneOrLoanID;
        String update_CarMortgage = "update t_CarMortgageInventory set FStatus=1 where FCarID="+v_carID+";";
        String update_LoanApplyEntry = "update t_LoanApplyEntry set FCustInSumAmount=20007,FCustInDate=" +
                "GETDATE(),FCustInInterestAmount=7 where FParentID="+phoneOrLoanID;
        //更新t_loanApply表数据
        sqlUtil.updateColumnValue(update_loanApply);
        //更新t_loanApplyEntry 表的数据
        sqlUtil.updateColumnValue(update_LoanApplyEntry);
        //更新t_AmountReturn表中的数据
        sqlUtil.updateColumnValue(update_AmountReturn);
        //更新t_CarMortgageInventory表中的质押车辆状态
        sqlUtil.updateColumnValue(update_CarMortgage);
        //更新t_cust表中的授信额度
        sanBaoAmountAdd(phoneOrLoanID);

    }

    /**
     * 解绑银行卡
     * @param phone
     */
    public void removeBankCard(String phone){
        String update_sql = "update t_CustAccount set FIsDelete=1,FIsBind=0 from t_CustAccount a LEFT JOIN t_Member \n" +
                "b ON a.FCustID = b.FMemberID where a.FIsDelete=0 and a.FValidate=1 and a.FIsBind=1 and b.FMobile='"+phone+"'";
        sqlUtil.updateColumnValue(update_sql);
        log.info("银行卡解绑成功");
    }

    /**
     * 绑定银行卡(为用户绑定新的银行卡，或者为未绑定过的用户绑定银行卡)
     * @param phone
     */
    public void addBankCard_1(String phone){
        String sql = "select FIdCard From t_Member where FMobile='"+phone+"';";
        String FIdCard = sqlUtil.getColumnValue(sql,"FIdCard");
        String FAccout= DESUtil.encrypt("6212261202027499890",DESUtil.getKeyString());
        String Fname = DESUtil.encrypt("自动化用户",DESUtil.getKeyString());
        String bankInsertSql="INSERT into t_CustAccount(FCustID,FAccount,FBankID,\n" +
                "FBankName,FBankInfo,FName,FIsDelete,FIsRecharge,\n" +
                "FIsGetCash,FIsBind,FValidate,FAddUser,FAddTime,\n" +
                "FModifyUser,FModifyTime,FIdCard,FProvinceName,FProvinceCode,\n" +
                "FCityName,FCityCode,FCityId,FProvinceId) \n" +
                "VALUES((select FMemberID from t_Member where FMobile='"+phone+"'),'"+FAccout+"',20101,\n" +
                "'中国工商银行','中国工商银行股份有限公司杭州祥符支行','"+Fname+"',0,1,\n" +
                "1,1,1,3102,GETDATE(),\n" +
                "3102,GETDATE(),'"+FIdCard+"','浙江','330000',\n" +
                "'杭州市','330100',348,30)";
        sqlUtil.updateColumnValue(bankInsertSql);
        log.info("绑定银行卡成功");
    }

    /**
     * 通过update数据，把解绑的银行卡状态改为已绑定
     * @param phone 用户手机号，解绑状态的银行卡号
     */
    public void addBankCard_2(String phone,String bankCard){
        String FAccout= DESUtil.encrypt(bankCard,DESUtil.getKeyString());
        String sql_bankFID = "select FID from t_CustAccount a LEFT JOIN t_Member b ON a.FCustID = b.FMemberID where b.FMobile='"+phone+"' and a.FAccount='"+FAccout+"'";
        String bankFID = sqlUtil.getColumnValue(sql_bankFID,"FID");
        if(bankFID==null){log.error("需要操作的银行卡没有绑定过，不能update为绑定状态"); return;}
        String sql = "select FAccount from t_CustAccount a LEFT JOIN t_Member b ON a.FCustID = b.FMemberID where b.FMobile='"+phone+"' and FIsDelete=0";
        String bankAccount = sqlUtil.getColumnValue(sql,"FAccount");
        if(bankAccount!=null && !(bankAccount.equalsIgnoreCase(FAccout))){log.error("当前用户存在已绑定的其他银行卡，不能把需要操作的银行卡update为绑定状态");return;}
        String sql_addBank="update t_CustAccount set FIsDelete=0,FIsBind=1 from t_CustAccount a LEFT JOIN \n" +
                "t_Member b ON a.FCustID = b.FMemberID where b.FMobile='"+phone+"' and \n" +
                "a.FAccount='"+FAccout+"'";
        sqlUtil.updateColumnValue(sql_addBank);
        log.info("绑定银行卡成功");
    }

    /**
     * 通过update数据，绑定的银行卡设为待验证状态
     * @param phone 用户手机号，用户绑定或者解绑状态下的银行卡号
     */
    public void verifyBank(String phone,String bankCard){
        String FAccout= DESUtil.encrypt(bankCard,DESUtil.getKeyString());
        String sql_bankFID = "select FID from t_CustAccount a LEFT JOIN t_Member b ON a.FCustID = b.FMemberID where b.FMobile='"+phone+"' and a.FAccount='"+FAccout+"'";
        String bankFID = sqlUtil.getColumnValue(sql_bankFID,"FID");
        if(bankFID==null){log.error("需要操作的银行卡没有绑定过，不能update为待验证状态"); return;}
        String sql = "select FAccount from t_CustAccount a LEFT JOIN t_Member b ON a.FCustID = b.FMemberID where b.FMobile='"+phone+"' and FIsDelete=0";
        String bankAccount = sqlUtil.getColumnValue(sql,"FAccount");
        if(bankAccount!=null && !(bankAccount.equalsIgnoreCase(FAccout))){log.error("当前用户存在已绑定的其他银行卡，不能把需要操作的银行卡update为待验证状态");return;}
        String sql_addBank="update t_CustAccount set FIsDelete=0,FIsBind=1 ,FValidate=3 from t_CustAccount a LEFT JOIN \n" +
                "t_Member b ON a.FCustID = b.FMemberID where b.FMobile='18503082657' and \n" +
                "a.FAccount='"+FAccout+"'";
        sqlUtil.updateColumnValue(sql_addBank);
        log.info("银行卡状态为待验证状态设置成功");
    }

    /**
     * 充值单审核不通过
     * @param phoneOrFid  手机号码或者充值单的FID(t_BailIn表中的FID)
     */
    public void BailInNoPass(String phoneOrFid){
        if(phoneOrFid.length()==11){
            String sql_FID = "select top 1 a.FID  from t_BailIn a LEFT JOIN t_Member b ON a.FCustID = b.FMemberID \n" +
                    " where b.FMobile='"+phoneOrFid+"' and a.FStatus=1 order by a.FID desc";
            phoneOrFid = sqlUtil.getColumnValue(sql_FID,"FID");
        }
        if(phoneOrFid==null){log.error("需要审核的充值单FID不存在"); return;}
        String sql = "update t_BailIn set FStatus=5,FSettlementID=3,FBankID=20116,FAccountID=28,\n" +
                "FCheckLevel=1,FCheckerID=a.FEmpID,FCheckDate=GETDATE(),FIsChecked=0,\n" +
                "FCheckLevelName='总部出纳审核',FModifyer=a.FEmpID,FModifyDate=GETDATE(),\n" +
                "FIsOnline=0 from t_Emp a where a.FPosition= 6 and a.FisAdmin=1 and \n" +
                "a.FIsDisable=0 and a.FIsLimit=1 and FID="+phoneOrFid;
        sqlUtil.updateColumnValue(sql);
        log.info("充值审核不通过操作成功");
    }

    /**
     * 提现单审核不通过
     * @param phone 手机号码
     */
    public void BailOutNoPass(String phone){
        String sql_FID = "select top 1 a.FID from t_BailOut a LEFT JOIN t_Member b ON a.FCustID = b.FMemberID \n" +
                "where b.FMobile='"+phone+"' and a.FStatus=3 order by a.FID DESC";
        String FID = sqlUtil.getColumnValue(sql_FID,"FID");
        if(FID == null){log.error("需要审核的提现单FID不存在");return;}
        String sql_amount = "select top 1 FAmount from t_BailOut where FID = "+FID+";";
        String amount = sqlUtil.getColumnValue(sql_amount,"FAmount");
        String sql_update_BailOut = "update t_BailOut set FOutDate=GETDATE(),FStatus=5,FPayStatus=4,FIsOpen=0 ,\n" +
                "FCheckerID=a.FEmpID,FCheckDate= GETDATE() from t_Emp a where a.FPosition=8 and FID = "+FID;
        String sql_update_wallet = "update t_User_Wallet set FTotalFrozenAmount=(FTotalFrozenAmount-"+amount+"),FReflectFrozenAmount=(FReflectFrozenAmount-"+amount+")\n" +
                "from t_User_Wallet a INNER JOIN t_Member b ON a.FMemberID = b.FMemberID where b.FMobile='"+phone+"';";
        sqlUtil.updateColumnValue(sql_update_BailOut);
        sqlUtil.updateColumnValue(sql_update_wallet);
        log.info("提现单审核不通过，操作成功");
    }

    /**
     * 把车辆设置为上架状态
     * @param phoneOrCarID 手机号或者车辆ID
     */
    public void carToSellUp(String phoneOrCarID){
        if(phoneOrCarID.length()==11){
            String sql = "select top 1 a.FCarID,a.FSaleStatus from t_CarSalesInfo a INNER JOIN t_CarInfoNew b ON a.FCarID = b.FID INNER JOIN\n" +
                    "t_Member c ON b.FCustID = c.FMemberID where c.FMobile='"+phoneOrCarID+"' AND a.FIsDelete=0 and b.FIsDelete=0 \n" +
                    "order by a.FCarID DESC;";
            phoneOrCarID = sqlUtil.getColumnValue(sql,"FCarID");
        }
        String sql_1 = "select FSaleStatus from t_CarSalesInfo where FIsDelete=0 and FCarID="+phoneOrCarID+";";
        String status = sqlUtil.getColumnValue(sql_1,"FSaleStatus");
        if(status!=null && Integer.parseInt(status) != 1){
            String sql_update = "update t_CarSalesInfo set FSaleStatus=1 where FCarID = "+phoneOrCarID+";";
            sqlUtil.updateColumnValue(sql_update);
        }
        log.info("车辆上架设置成功");
    }

    /**
     * 把车辆设置为下架状态
     * @param phoneOrCarID 手机号或者车辆ID
     */
    public void carToSellDown(String phoneOrCarID){
        if(phoneOrCarID.length()==11){
            String sql = "select top 1 a.FCarID,a.FSaleStatus from t_CarSalesInfo a INNER JOIN t_CarInfoNew b ON a.FCarID = b.FID INNER JOIN\n" +
                    "t_Member c ON b.FCustID = c.FMemberID where c.FMobile='"+phoneOrCarID+"' AND a.FIsDelete=0 and b.FIsDelete=0 \n" +
                    "order by a.FCarID DESC;";
            phoneOrCarID = sqlUtil.getColumnValue(sql,"FCarID");
        }
        String sql_1 = "select FSaleStatus from t_CarSalesInfo where FIsDelete=0 and FCarID="+phoneOrCarID+";";
        String status = sqlUtil.getColumnValue(sql_1,"FSaleStatus");
        if(status!=null && Integer.parseInt(status) == 1){
            String sql_update = "update t_CarSalesInfo set FSaleStatus=0 where FCarID = "+phoneOrCarID+";";
            sqlUtil.updateColumnValue(sql_update);
        }
        log.info("车辆下架设置成功");
    }

    /**
     * 设置店铺审核通过
     * @param phone 用户手机号
     */
    public void setStorePass(String phone){
        String sql = "select top 1 FEmpID from t_emp where FPosition=1 and FisAdmin=1 and FIsDisable=0 and FIsLimit=1";
        String empID = sqlUtil.getColumnValue(sql,"FEmpID");
        String sql_store1 = "update T_Store set FCheckerStatus=1 from T_Store a INNER JOIN t_Member\n" +
                " b ON a.FCustID = b.FMemberID where b.FMobile='"+phone+"';";
        String sql_store2 = "UPDATE T_StoreCheck set FCheckerStatus=1,FCheckerID=207,FCheckDate=GETDATE()\n" +
                "where FID=(select top 1 a.FID from T_StoreCheck a INNER JOIN t_Member b ON a.FCustID = b.FMemberID where \n" +
                "b.FMobile='"+phone+"' order by a.FID desc);";
        //更改T_Store表中的状态
        sqlUtil.updateColumnValue(sql_store1);
        //更改T_StoreCheck表中的状态
        sqlUtil.updateColumnValue(sql_store2);
        log.info("update店铺审核通过成功");
    }

    /**
     * 设置店铺审核不通过
     * @param phone 用户手机号
     */
    public void setStoreNoPass(String phone){
        String sql = "select top 1 FEmpID from t_emp where FPosition=1 and FisAdmin=1 and FIsDisable=0 and FIsLimit=1";
        String empID = sqlUtil.getColumnValue(sql,"FEmpID");
        String sql_store1 = "update T_Store set FCheckerStatus=2 from T_Store a INNER JOIN t_Member\n" +
                " b ON a.FCustID = b.FMemberID where b.FMobile='"+phone+";";
        String sql_store2 = "UPDATE T_StoreCheck set FCheckerStatus=2,FCheckerID="+empID+",FCheckDate=GETDATE()\n" +
                ", FCheckReason='店铺图片信息不符' from T_StoreCheck a INNER JOIN t_Member b ON a.FCustID = b.FMemberID where \n" +
                "b.FMobile='"+phone+"' order by a.FID desc;";
        //更改T_Store表中的状态
        sqlUtil.updateColumnValue(sql_store1);
        //更改T_StoreCheck表中的状态
        sqlUtil.updateColumnValue(sql_store2);
        log.info("update店铺审核通过成功");
    }

    /**
     * 插入一条车辆浏览记录
     * @param phone 手机号
     */
    public void insertViewRecord(String phone){
        //如果车商存在浏览记录，就不插入一条浏览记录数据
        String sql ="select top 1 FID from t_CarHistory a INNER JOIN t_Member b ON a.FCustID=b.FMemberID where a.FIsDelete=0 and b.FMobile='"+phone+"';";
        String FID = sqlUtil.getColumnValue(sql,"FID");
        if(FID != null){log.info("浏览记录不为空，不插入数据");return;}
        String sql_carID = " select top 1 a.FCarID from t_CarSalesInfo a where a.FSaleStatus=1 and a.FCheckStatus=1\n" +
                "and a.FIsDelete=0 and NOT EXISTS (select b.FCarID from t_CarHistory b INNER JOIN \n" +
                "t_Member c ON b.FCustID = c.FMemberID where c.FMobile='"+phone+"' and a.FCarID = b.FCarID )\n" +
                "order by a.FCarID DESC;";
        String carID = sqlUtil.getColumnValue(sql_carID,"FCarID");
        String sql_insertCar = "INSERT INTO AK_Data_test.dbo.t_CarHistory (FCustID,FCarID,FHistoryDate,FIsDelete)\n" +
                "select a.FMemberID,"+carID+",GETDATE(),0 from t_Member a where a.FMobile='"+phone+"';";
        String sql_parentID =  "select top 1 FID from t_CarHistory a INNER JOIN t_Member \n" +
                "b ON a.FCustID = b.FMemberID where b.FMobile='"+phone+"' order by FID DESC;";
        //t_CarHistory插入数据
        sqlUtil.updateColumnValue(sql_insertCar);
        String parentID = sqlUtil.getColumnValue(sql_parentID,"FID");
        String sql_insertEntry = "INSERT INTO AK_Data_test.dbo.t_CarHistoryEntry (FCarHistoryID,FAddDate)\n" +
                "VALUES("+parentID+",GETDATE());";
        //t_CarHistoryEntry插入数据
        sqlUtil.updateColumnValue(sql_insertEntry);
    }

    /**
     * 征信查询设置为驳回
     * @param phoneOrFId  手机号或者征信查询表中的FID
     */
    public void setCreditNoPass(String phoneOrFId){
        if(phoneOrFId.length()==11){
            String sql = "select top 1 a.FID from t_SelCredit a INNER JOIN t_Member b ON a.FInquirerID = b.FMemberID where a.FStatus=1 and b.FMobile='"+phoneOrFId+"';";
            phoneOrFId = sqlUtil.getColumnValue(sql,"FID");
        }
            String sql = "update t_SelCredit set FStatus=0 where FID="+phoneOrFId+";";
            //设置驳回
            sqlUtil.updateColumnValue(sql);
            log.info("征信查询驳回操作成功");

    }

    /**
     * 审核为客户经理
     * @param custPhone 车商手机号
     * @param phone 客户经理手机号
     */
    public  void  validation_Manager(String custPhone,String  phone){
        if(custPhone==null||custPhone.equals("")||phone==null||phone.equals(""))
        {log.error("用户ID为空,或者电话号码为空");
            return ;
        }
        String sql="UPDATE t_Member set FMainMemberID=(SELECT  FMainMemberID from t_Member WHERE FMobile='"+custPhone+"'),FEmpID=(\n" +
                "SELECT  FEmpID from t_Member WHERE FMobile='"+custPhone+"'),FMemberType='1',FCertificationIdentity='4',\n" +
                "FCertificationState='2',FIsAllowSelCredit='1' WHERE  FMobile='"+phone+"';";
        sqlUtil.updateColumnValue(sql);
        log.info("审核为客服经理");

    }

    public static void main(String[] args){
        GlobalApi  globalApi = new GlobalApi();
//        new GlobalApi().carLogin("17455413214","123456");
//        new GlobalApi().ysbNoPass("17455413214","9492");
//        new GlobalApi().sanBaoAmountMinus("17455413214","9496");
//        new GlobalApi().sanBaoAmountAdd("17455413214","9499");
//        new GlobalApi().ysbApplySuccess("17455413214");
//        globalApi.scbNoPass("9635");
//        globalApi.scbApplySuccess("17455413214");
//        globalApi.verifyBank("17455413214","6212261202033369209");
//        globalApi.BailOutNoPass("17455413214");
//        globalApi.addBankCard_1("18503082657");
//        globalApi.removeBankCard("18503082657");
//        globalApi.scbAmountReturnPass("9756");

//        globalApi.ysbApplySuccess("17455413214");
//        globalApi.sanBaoAmountMinus("9854");
//        globalApi.scbApplySuccess("17455413214");
//        globalApi.scbNoPass("9869");

//        globalApi.sanBaoAmountMinus("9870");
//        globalApi.ysbNoPass("9933");
//        globalApi.setStorePass("17429256245");
//        globalApi.insertViewRecord("17414382583");

//        globalApi.scbNoPass("17455413214");
//        globalApi.sanBaoAmountMinus("10660");
//        globalApi.carLogin("17455413214","123456");

//        globalApi.storeNoPass("17455413214");

//        globalApi.BailOutNoPass("17455413214");
//        globalApi.ysbNoPass("18503082657");
//        globalApi.ysbNoPass("18503082657");

        globalApi.ysbApplySuccess("13800000008");
    }
    public void print(String str){
        System.out.println(str);
    }



}
