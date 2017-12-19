package Btjf_API.CAPI.Utils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

/**
 * Created by wl on 2016/12/2.
 */
public class SendMail {
    private PublicUtil publicUtil = new PublicUtil();
    private FileUtil fileUtil = new FileUtil();
    private GenerateReportHtml generateReportHtml = new GenerateReportHtml();
    private String filePath = "log/";
    protected static String[] User1 = {"wliang@cheok.com","lq@cheok.com"};//自动定时任务需要发送的人
    protected static String[] ccUser1 = {"test@cheok.com","java@cheok.com","fhc@cheok.com"};
    protected static String[] User2 = {"wliang@cheok.com"};//手动执行时，需要发送的人
    protected static String[] ccUser2 = {"lq@cheok.com","lcc@cheok.com"};
    protected static String[] defaultUser = {"wliang@cheok.com"};//手动执行，如果用例全部成功，只发给我自己
    protected static String[] defaultCcUser = {};//如果用例全部成功，就抄送给测试部
    private static Boolean aBoolean; //用来判断是都存在失败和忽略的用例
    public void  sendTouser(String[] users,String[] ccUsers) throws Exception{
        final Properties props = new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.host","smtp.mxhichina.com");
        props.put("mail.user","test_api@cheok.com");
        props.put("mail.password","Test123456");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty("mail.user");
                String passWord = props.getProperty("mail.password");
                return new javax.mail.PasswordAuthentication(userName,passWord);
            }
        };
        Session mailSession = Session.getInstance(props,authenticator);

        MimeMessage message = new MimeMessage(mailSession);

        InternetAddress from  = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(from);

        //设置收件人
        int num = users.length;
        InternetAddress[] toUsers = new InternetAddress[num];
        for(int i =0 ;i<num ;i++){
            toUsers[i] = new InternetAddress(users[i]);
        }
        message.setRecipients(MimeMessage.RecipientType.TO,toUsers);
        //设置抄送收件人
        int num1 = ccUsers.length;
        InternetAddress[] toCcUsers = new InternetAddress[num1];
        if(num1>0){
            for(int i =0 ;i<num1 ;i++){
                toCcUsers[i] = new InternetAddress(ccUsers[i]);
            }
            message.setRecipients(MimeMessage.RecipientType.CC,toCcUsers);
        }

        message.setSubject("接口测试报告_"+PublicUtil.properties.getProperty("JenkinsJobName"));
//        message.setContent(generateReportHtml.generateHeml(),"text/html;charset=UTF-8");
        Multipart mainPart = new MimeMultipart();
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(generateReportHtml.generateHtml(),"text/html;charset=UTF-8");
        mainPart.addBodyPart(mimeBodyPart);

        //存在附件
        mimeBodyPart = new MimeBodyPart();
        String filePath_1 = filePath +fileUtil.getLogPath();
        File file = new File(filePath_1);
        FileDataSource fds = new FileDataSource(file);
        mimeBodyPart.setDataHandler(new DataHandler(fds));
        mimeBodyPart.setFileName(file.getName());
        mainPart.addBodyPart(mimeBodyPart);

        mimeBodyPart = new MimeBodyPart();
        String filePath_2 = filePath +fileUtil.getRetryLogPath();
        File file_1 = new File(filePath_2);
        FileDataSource fds_2 = new FileDataSource(file_1);
        mimeBodyPart.setDataHandler(new DataHandler(fds_2));
//        mimeBodyPart.setFileName(file_1.getName());
        //解决附件中文名乱码问题
        String fileName=  MimeUtility.encodeText(file_1.getName());
        mimeBodyPart.setFileName(fileName);
        mainPart.addBodyPart(mimeBodyPart);
        //发送邮件
        message.setContent(mainPart);
        Transport.send(message);
        System.out.println("邮件发送成功");

    }

    public void timingSendMail() throws Exception{
        aBoolean=false;
        if(generateReportHtml.generateHtml().contains("</td>")){aBoolean = true;}//判断报告中是否有失败的用例
            String date = publicUtil.getDate("yyyy-MM-dd HH:mm:ss");
//            System.out.println(date);
            int hour = Integer.parseInt(date.substring(11,13));
//        int mins = Integer.parseInt(date.substring(14,16));
        String platFormName = System.getProperty("os.name");
        if(!(platFormName.contains("Windows"))){
            if(hour<=2 ||  hour<15&&hour>=14){
                sendTouser(User1,ccUser1);
            }else{
                if(aBoolean){
                    sendTouser(User2,ccUser2);
                }else{
                    sendTouser(defaultUser,defaultCcUser);
                }
            }
        }else{
//            System.out.println("本机不发送邮件");
            sendTouser(defaultUser,defaultCcUser);
        }

    }
    public static void main(String[] args)throws Exception{
        SendMail sendMail = new SendMail();
//        sendMail.sendTouser(users1,users2);
        sendMail.timingSendMail();
    }
}
