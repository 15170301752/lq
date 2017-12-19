package Btjf_API.CAPI.Utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

/**
 * Created by LEE on 2017/4/18.
 */
public class MyHttpDelete extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "DELETE";

    public MyHttpDelete() {
        super();
    }

    public String getMethod() {
        return METHOD_NAME;
    }

    @Override
    public void setEntity(HttpEntity entity) {
        super.setEntity(entity);
    }

    @Override
    public boolean expectContinue() {
        return super.expectContinue();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public MyHttpDelete(final String uri) {
        super();
        setURI(URI.create(uri));
    }
    public MyHttpDelete(final URI uri) {
        super();
        setURI(uri);
    }

}

