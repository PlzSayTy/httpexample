
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetExample {
    static String url = "http://speller.yandex.net/services/spellservice";
    public static void main(String[] args){
        CloseableHttpResponse closeableHttpResponse = null;
        try{
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url + "/checkText?text=я+пешу+текст+для+дамашниго+зоданея");
            closeableHttpResponse = closeableHttpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(closeableHttpResponse.getEntity()));
        }catch (Exception e){
            System.out.println(e);
        }finally {
            try{
                closeableHttpResponse.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
