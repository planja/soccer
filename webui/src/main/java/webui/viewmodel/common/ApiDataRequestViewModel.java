package webui.viewmodel.common;

/**
 * Created by Никита on 23.04.2017.
 */
public class ApiDataRequestViewModel {

    private String url;

    private String key;

    public ApiDataRequestViewModel() {
    }

    public ApiDataRequestViewModel(String url, String key) {
        this.url = url;
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
