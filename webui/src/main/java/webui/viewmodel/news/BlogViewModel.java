package webui.viewmodel.news;

import domain.entity.news.Blog;
import org.apache.commons.codec.binary.Base64;

import java.util.Date;

/**
 * Created by ShchykalauM on 10.05.2017.
 */
public class BlogViewModel {

    private Long id;

    private String name;

    private String image;

    private String html;

    private Integer mainCompetitionId;

    private String startNewsText;

    private Date date;

    private String authorName;

    public BlogViewModel() {
    }

    public Blog toNews() {
        Blog blog = new Blog();
        blog.setId(id);
        blog.setName(name);
        blog.setImage(image == null ? null : new Base64().decode(image));
        blog.setHtml(html);
        blog.setMainCompetitionId(mainCompetitionId);
        blog.setStartNewsText(startNewsText);
        return blog;
    }

    public BlogViewModel(Blog blog) {
        this.id = blog.getId();
        this.name = blog.getName();
        this.image = blog.getImage() == null ? null : new Base64().encodeAsString(blog.getImage());
        this.html = blog.getHtml();
        this.mainCompetitionId = blog.getMainCompetitionId();
        this.startNewsText = blog.getStartNewsText();
        this.date = blog.getDate();
        this.authorName = blog.getUser().getName();
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
}
