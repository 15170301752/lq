package Btjf_API.CAPI.Utils;

import org.testng.Reporter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 2016/6/18.
 */
public class SqlUtil {
    private PublicUtil publicUtil = new PublicUtil();
//    private Properties prop = publicUtil.getProp();
    private Log log = new Log(SqlUtil.class);
//    private String driverName = prop.getProperty("driverName");
//    private String userName = prop.getProperty("dbUserName");
//    private String passwd = prop.getProperty("dbPasswd");
    private  Statement statement;
    private  Connection dbConn;
//    private String IpPort =prop.getProperty("dbIp");
//    private String dbName = prop.getProperty("dbName");
    private String driverName;
    private String userName ;
    private String passwd ;
    private String IpPort ;
    private String dbName ;
//    public SqlUtil(){}
    public SqlUtil(String driverName,String userName,String passwd,String IpPort,String dbName){
        this.driverName = driverName;
        this.userName=userName;
        this.passwd = passwd;
        this.IpPort = IpPort;
        this.dbName = dbName;
    }
    public void dbConnction() {
        try{
            Class.forName(driverName);
            String dbURL = "jdbc:sqlserver://"+IpPort+";DatabaseName="+dbName;
//        print(dbURL);
            dbConn = DriverManager.getConnection(dbURL,userName,passwd);
//        设置可滚动的结果集
//        statement = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement = dbConn.createStatement();
//        print("-------------数据库连接成功-----------");
        }catch (Exception e){
            e.printStackTrace();
            log.error("-------------数据库连接失败-----------");
        }
    }

    public String getColumnValue(String sql,String key){
        dbConnction();
        //print(sql);
        String columnValue= null;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            columnValue = null;
            while(resultSet.next()){
                columnValue  = resultSet.getString(formatSqlKey(key));
    //            print(columnValue);
                if(columnValue==null){
                    continue;
                }else {
                    return columnValue;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error(publicUtil.getStackTrace(e.getStackTrace()));
            Reporter.log(publicUtil.getStackTrace(e.getStackTrace()));
        }
        return columnValue;
    }

    public List<String> getColumnsList(String sql,String key){
        dbConnction();
        //print(sql);
        List<String> list = new ArrayList<String>();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String[] keys = keyArr(formatSqlKey(key));
                for(int i=1;i<=keys.length;i++){
                   Object obj = resultSet.getObject(i);
                   if(String.valueOf(obj).equalsIgnoreCase("false")){
                       list.add("0");
                   }else if(String.valueOf(obj).equalsIgnoreCase("true")){
                       list.add("1");
                   }else{
                       list.add(String.valueOf(obj));
                   }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error(publicUtil.getStackTrace(e.getStackTrace()));
            Reporter.log(publicUtil.getStackTrace(e.getStackTrace()));
        }
        return list;
    }

    public List<String> getColumnValueList(String sql,String key){
        dbConnction();
        //print(sql);
        List<String> list = new ArrayList<String>();
        String columnValue= null;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            columnValue = null;
            while(resultSet.next()){
                columnValue  = resultSet.getString(formatSqlKey(key));
                //            print(columnValue);
                if(columnValue==null){
                    continue;
                }else {
                    list.add(columnValue);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error(publicUtil.getStackTrace(e.getStackTrace()));
            Reporter.log(publicUtil.getStackTrace(e.getStackTrace()));
        }
        return list;
    }

    public String formatSqlKey(String sqlKey){
        sqlKey = sqlKey.trim();
        if(sqlKey.toUpperCase().contains("TOP")){
            int startIndex = sqlKey.lastIndexOf(" ");
            sqlKey = sqlKey.substring(startIndex+1,sqlKey.length());
        }
        if(sqlKey.contains(".")){
            int startIndex = sqlKey.indexOf(".");
            sqlKey= sqlKey.substring(startIndex+1,sqlKey.length());
        }
        return sqlKey;
    }

    public String[] keyArr(String s){
        if(s.contains(",")){
            String[] keys = s.split(",");
            return keys;
        }else {
            String[] keys = new String[1];
            keys[0]=s;
            return keys;
        }


    }
    /**
     * update、insert 数据，调用该方法
     * @param sql
     */
    public void updateColumnValue(String sql){
        dbConnction();
        int status=0;
        try{
            status = statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            log.error(publicUtil.getStackTrace(e.getStackTrace()));
            Reporter.log(publicUtil.getStackTrace(e.getStackTrace()));
        }
        if(status>0){
            log.info("sql = "+sql);
            log.info("数据update/insert成功");
        }else{
            log.info("sql = "+sql);
            log.error("数据update/insert成功成功");
        }
    }

    /**
     * 调用用户注册存储过程
     * @param phoneNum
     */
    public void execRegisterPro(String phoneNum) {
        dbConnction();
        try{
            CallableStatement callableStatement = dbConn.prepareCall("{call P_TestRegister(?,?)}");
            callableStatement.setString(1,phoneNum);
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.execute();
            log.info("-----用户注册存储过程执行成功-----");
        }catch (Exception e){
            e.printStackTrace();
            log.error("-----用户注册存储过程执行失败-----");
        }
    }

    /**
     * 调用认证授信存储过程
     * @param userName
     * @param phoneNum
     * @param idCard
     * @param shopName
     */
    public void execCreditCustPro(String userName,String phoneNum,String idCard,String shopName){
        dbConnction();
        try{
            CallableStatement callableStatement = dbConn.prepareCall("{call P_TestUserAdd(?,?,?,?,?)}");
            callableStatement.setString(1,userName);
            callableStatement.setString(2,phoneNum);
            callableStatement.setString(3,idCard);
            callableStatement.setString(4,"");
            callableStatement.setString(5,shopName);
            callableStatement.execute();
            log.info("------授信用户存储过程执行成功-----");
        }catch (Exception e){
            e.printStackTrace();
            log.error("------授信用户存储过程执行失败-----");
        }

    }

    /**
     * 调用认证未授信存储过程
     * @param phoneNum
     * @param userName
     * @param idCard
     */
    public void execCustPro(String phoneNum,String userName,String idCard){
        dbConnction();
        try {
            CallableStatement callableStatement = dbConn.prepareCall("{call P_TestCust(?,?,?)}");
            callableStatement.setString(1,phoneNum);
            callableStatement.setString(2,userName);
            callableStatement.setString(3,idCard);
            callableStatement.execute();
            log.info("------认证未授信用户存储过程执行成功-----");
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("------认证未授信用户存储过程执行失败-----");
        }

    }

    /**
     * 调用发布不可抵押车辆的存储过程
     * @param phoneNum
     * @return 返回车辆ID
     */
    public String  execTestAddCar(String phoneNum){
        dbConnction();
        String FCarID ;
        try {
            CallableStatement callableStatement = dbConn.prepareCall("{call P_TestAddCar(?,?)}");
            callableStatement.setString(1,phoneNum);
            callableStatement.registerOutParameter(2,Types.VARCHAR);
            callableStatement.execute();
            FCarID = callableStatement.getString(2);
//            print(FCarID);
            log.info("------发布不可抵押车辆存储过程执行成功-----");
            return FCarID;
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("------发布不可抵押车辆存储过程执行失败-----");
        }
        return null;
    }

    /**
     * 调用发布可抵押车辆的存储过程
     * @param phoneNum
     * @return 返回车辆ID
     */
    public String execTestAddVinCar(String phoneNum){
        dbConnction();
        String FCarID;
        try {
            CallableStatement callableStatement = dbConn.prepareCall("{call P_TestAddVinCar(?,?)}");
            callableStatement.setString(1,phoneNum);
            callableStatement.registerOutParameter(2,Types.VARCHAR);
            callableStatement.execute();
            FCarID = callableStatement.getString(2);
//            print(FCarID);
            log.info("------发布可抵押车辆存储过程执行成功-----");
            return FCarID;
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("------发布可抵押车辆存储过程执行失败-----");
        }
        return null;
    }

    /**
     * 生成客户经理账号
     * @param name  客户经理姓名
     * @param phoneNum 客户经理手机号
     * @param idCard 身份证
     * @param mainPhoneNum 相关车商手机号
     * @return 客户经理手机号
     */
    public String execTestManager(String name,String phoneNum,String idCard,String mainPhoneNum){
        dbConnction();
        try {
            CallableStatement callableStatement = dbConn.prepareCall("{call P_TestManagerCertification(?,?,?,?,?)}");
            callableStatement.setString(1,name);
            callableStatement.setString(2,phoneNum);
            callableStatement.setString(3,idCard);
            callableStatement.setString(4,"");
            callableStatement.setString(5,mainPhoneNum);
            callableStatement.execute();
            log.info("------客户经理存储过程执行成功-----");
            return phoneNum;
        } catch (SQLException e) {
            e.printStackTrace();
            print("------客户经理存储过程执行失败-----");
        }
        return "-1";
    }
    public static void main(String[] args)throws Exception{
//        String sql ="select top 5 FDeviceToken from t_LoginMemberLog where FMemberID=(select FMemberID from t_Member where FMobile='13800000008')ORDER BY FID desc";
//        String value = new SqlUtil().getColumnValue(sql,"FDeviceToken");
//        String sql = "select top 1 c.FCode,m.FMemberID, c.FMobile from t_Code c LEFT JOIN t_Member m on c.FMobile = m.FMobile\n" +
//                "where m.FMemberID = 3297 order by c.FID desc";
//        String value = new SqlUtil().getColumnValue(sql,"FCode");
//        System.out.println(value);
//        print(s);
//        SqlUtil sqlUtil = new SqlUtil();
//        sqlUtil.execRegisterPro("13988886677");
//        sqlUtil.execCreditCustPro("测试测测","13988885544","36040019911012","店铺名称");
//        sqlUtil.execCustPro("13988885543","测试测测测","360400199110122127");
//        sqlUtil.execTestManager("王客户经理","13988885539","360400199110122128","69051");
//        sqlUtil.execRegisterPro("13800000097");
//        sqlUtil.execCreditCustPro("王兄阿","13800000094","330360198802161254","我的店铺");
//        sqlUtil.execCustPro("13800000082","王兄三","330360198802161284");
//        String s = sqlUtil.execTestAddVinCar("13800000013");
//        System.out.println(s);
//        String sql = "select a.FcarID from t_CarSalesInfo a LEFT JOIN t_CarInfoNew b ON a.FCarID=  b.fid  where a.FCheckStatus=0 and b.FCustID=(select FMemberID from t_Member where FMobile='13800000113')";
//        List<String> list = sqlUtil.getColumnValueList(sql,"FCarID");
//        for (String s :list){
//            GlobalApi globalApi = new GlobalApi();
//            globalApi.storeNoPass(s);
//        }
//        sqlUtil.execCreditCustPro("自动化用户","17442524519","360400197708064460","自动化店铺");
//        new PublicUtil().getSqlHander("carSeller").execTestAddVinCar("15170301752");
        String sql = "select top 1 FID,FIsDelete from t_CarInfoNew order by FID desc;";
        String key = "top 1 FID,FIsDelete";
        new PublicUtil().getSqlHander("carSeller").getColumnsList(sql,key);
    }
    public static void print(String s){
        System.out.println(s);
    }
}
