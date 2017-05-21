package webui.viewmodel.news;

import domain.entity.news.BlogCommentary;
import domain.entity.news.NewsCommentary;
import org.apache.commons.codec.binary.Base64;

import java.util.Date;

/**
 * Created by Никита on 21.05.2017.
 */
public class CommentaryViewModel {

    private Long id;

    private String userName;

    private String text;

    private String userImage;

    private Long newsId;

    private Date date;

    public CommentaryViewModel() {
    }

    public CommentaryViewModel(Long id, String userName, String text, String userImage, Long newsId, Date date) {
        this.id = id;
        this.userName = userName;
        this.text = text;
        this.userImage = userImage;
        this.newsId = newsId;
        this.date = date;

    }

    public CommentaryViewModel(NewsCommentary newsCommentary) {
        this.id = newsCommentary.getId();
        this.userName = newsCommentary.getUser().getName();
        this.text = newsCommentary.getText();
        this.userImage = newsCommentary.getUser().getImage() == null ? null : new Base64().encodeAsString(newsCommentary.getUser().getImage());
        this.newsId = newsCommentary.getNews().getId();
        this.date = newsCommentary.getDate();
    }

    public CommentaryViewModel(BlogCommentary blogCommentary) {
        this.id = blogCommentary.getId();
        this.userName = blogCommentary.getUser().getName();
        this.text = blogCommentary.getText();
        this.userImage = blogCommentary.getUser().getImage() == null ? null : new Base64().encodeAsString(blogCommentary.getUser().getImage());
        this.newsId = blogCommentary.getBlog().getId();
        this.date = blogCommentary.getDate();
    }


    public NewsCommentary toNewsCommentary() {
        NewsCommentary newsCommentary = new NewsCommentary();
        newsCommentary.setText(this.text);
        newsCommentary.setDate(new Date());
        return newsCommentary;
    }

    public BlogCommentary toBlogCommentary() {
        BlogCommentary blogCommentary = new BlogCommentary();
        blogCommentary.setText(this.text);
        blogCommentary.setDate(new Date());
        return blogCommentary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
