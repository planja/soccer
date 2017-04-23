package infrastructure.service.common;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Никита on 23.04.2017.
 */

@Service
public class CommonService implements ICommonService {

    @Override
    public String getApiData(String url, String key) throws IOException {
        DefaultHttpClient httpclient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("x-crowdscores-api-key", key);
        HttpResponse httpResponse = httpclient.execute(httpGet);
        return IOUtils.toString(httpResponse.getEntity().getContent());
    }
}
