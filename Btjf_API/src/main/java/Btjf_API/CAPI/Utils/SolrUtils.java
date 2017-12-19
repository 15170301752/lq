package Btjf_API.CAPI.Utils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/**
 * Created by LEE on 2017/7/28.
 */
public class SolrUtils {
    public  String  EnvConfigPath = "target/classes/EnvConfig.properties";
    public   Properties properties =  new PublicUtil().getProp(EnvConfigPath);
    /**
     * 实际运用的
     * http://192.168.100.141:8983/solr/clues 默认的url
     *@return String 值
     * @param key 查询字段的key值
     * @param cores 核心的值（clues，appCarSearch，appStoreSearch，carBrandAndModel）
     */
    public  String find(String key,String cores){
        Properties prop = new Properties();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(properties.getProperty("EnvPropName")+".properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url="";
        if(cores.equalsIgnoreCase("clues")){
            url=prop.getProperty("solrUrl");

        }else if(cores.equalsIgnoreCase("appCarSearch")){
            url=prop.getProperty("solrUrl2");
        }else if(cores.equalsIgnoreCase("appStoreSearch")){
            url=prop.getProperty("solrUrl3");
        }else if (cores.equalsIgnoreCase("carBrandAndModel")){
            url=prop.getProperty("solrUrl4");
        }else {
            url=prop.getProperty("solrUrl3");
        }
        List<String> values=new ArrayList<String>();
        HttpSolrClient solrServer = new HttpSolrClient(url);
        SolrQuery query = new SolrQuery();
        query.set("q", "*:*");
        try {
            QueryResponse response = solrServer.query(query);
            SolrDocumentList list=response.getResults();
            for (SolrDocument solrDocument:list){
                String value=String.valueOf(solrDocument.get(key));
                values.add(value);
            }
            return  values.get(0);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static void main(String[] args) {
        SolrUtils utils=new SolrUtils();
       String name= utils.find("userName","clues");
        System.out.println(name);
    }
}
