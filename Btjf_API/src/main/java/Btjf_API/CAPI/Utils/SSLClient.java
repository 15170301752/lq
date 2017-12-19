package Btjf_API.CAPI.Utils;


import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


/**
 * Created by wl on 2016/6/29.
 * 这个类不用，HttpClient4.3以上版本，不再是这种写法
 */
public class SSLClient extends HttpClientBuilder {
    public SSLClient() throws Exception{
        super();
        SSLContext ctx = SSLContext.getInstance("TLS");
        X509TrustManager tm = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        ctx.init(null,new TrustManager[]{tm},null);
        SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ctx,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

    }

}
