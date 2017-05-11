package webui.viewmodel.news;

import domain.entity.news.News;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by ShchykalauM on 10.05.2017.
 */
public class NewsViewModel {

    private Long id;

    private String name;

    private String image;

    private String html;

    private Boolean isBlog;

    private Integer mainCompetitionId;

    private String startNewsText;

    public NewsViewModel() {
    }

    public News toNews() {
        News news = new News();
        news.setId(id);
        news.setName(name);
        news.setImage(image == null ? null : new Base64().decode(image));
        news.setBlog(isBlog);
        news.setHtml(html == null ? null : new Base64().decode(html));
        news.setMainCompetitionId(mainCompetitionId);
        news.setStartNewsText(startNewsText);
        return news;
    }

    public NewsViewModel(News news) {
        this.id = news.getId();
        this.name = news.getName();
        this.image = news.getImage() == null ? null : new Base64().encodeAsString(news.getImage());
        this.html = news.getHtml() == null ? null : new Base64().encodeAsString(news.getHtml());
        this.isBlog = news.getBlog();
        this.mainCompetitionId = news.getMainCompetitionId();
        this.startNewsText = news.getStartNewsText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Boolean getBlog() {
        return isBlog;
    }

    public void setBlog(Boolean blog) {
        isBlog = blog;
    }

    public Integer getMainCompetitionId() {
        return mainCompetitionId;
    }

    public void setMainCompetitionId(Integer mainCompetitionId) {
        this.mainCompetitionId = mainCompetitionId;
    }

    public String getStartNewsText() {
        return startNewsText;
    }

    public void setStartNewsText(String startNewsText) {
        this.startNewsText = startNewsText;
    }
}
