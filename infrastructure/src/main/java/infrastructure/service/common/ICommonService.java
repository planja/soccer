package infrastructure.service.common;

import java.io.IOException;

/**
 * Created by Никита on 23.04.2017.
 */
public interface ICommonService {
    String getApiData(String url, String key) throws IOException;
}
