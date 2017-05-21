package webui.viewmodel.news;

import domain.entity.news.News;
import org.apache.commons.codec.binary.Base64;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ShchykalauM on 18.05.2017.
 */
public class NewsViewModel {

    private Long id;

    private String name;

    private String html;

    private Integer mainCompetitionId;

    private Date date;

    private String authorName;

    private boolean mainNews;

    private List<CommentaryViewModel> comments;

    public NewsViewModel() {
    }

    public News toNews() {
        News news = new News();
        news.setId(this.id);
        news.setName(this.name);
        news.setHtml(this.html);
        news.setMainCompetitionId(this.mainCompetitionId);
        news.setMainNews(this.mainNews);
        return news;
    }

    public NewsViewModel(News news) {
        this.id = news.getId();
        this.name = news.getName();
        this.html = news.getHtml();
        this.mainCompetitionId = news.getMainCompetitionId();
        this.date = news.getDate();
        this.authorName = news.getUser() != null ? news.getUser().getName() : "Неизвестен";
        this.mainNews = news.getMainNews();
        this.comments = news.getComments().stream()
                .map(o -> new CommentaryViewModel(o.getId(), o.getUser().getName(), o.getText()
                        , o.getUser().getImage() == null ? null : new Base64().encodeAsString(o.getUser().getImage()), news.getId(), o.getDate())).collect(Collectors.toList());
        this.comments.sort(Comparator.comparing(CommentaryViewModel::getDate));
        Collections.reverse(this.comments);
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

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Integer getMainCompetitionId() {
        return mainCompetitionId;
    }

    public void setMainCompetitionId(Integer mainCompetitionId) {
        this.mainCompetitionId = mainCompetitionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean getMainNews() {
        return mainNews;
    }

    public void setMainNews(boolean mainNews) {
        this.mainNews = mainNews;
    }

    public List<CommentaryViewModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentaryViewModel> comments) {
        this.comments = comments;
    }


}
