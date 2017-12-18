package btjf.com.utils;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by С�� on 2017/6/23.
 */
public class Test {
    public static void main(String [] args)
    {
        // �ռ��˵�������
        String to = "977649632@qq.com";

        // �����˵�������
        String from = "154989417@qq.com";

        // ָ�������ʼ�������Ϊ localhost
        String host = "smtp.exmail.qq.com";

        // ��ȡϵͳ����
        Properties properties = System.getProperties();

        // �����ʼ�������
        properties.setProperty("mail.smtp.host", host);

        // ��ȡĬ��session����
        Session session = Session.getDefaultInstance(properties);

        try{
            // ����Ĭ�ϵ� MimeMessage ����
            MimeMessage message = new MimeMessage(session);

            // Set From: ͷ��ͷ�ֶ�
            message.setFrom(new InternetAddress(from));

            // Set To: ͷ��ͷ�ֶ�
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: ͷ��ͷ�ֶ�
            message.setSubject("This is the Subject Line!");

            // ������Ϣ��
            message.setText("This is actual message");

            // ������Ϣ
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
