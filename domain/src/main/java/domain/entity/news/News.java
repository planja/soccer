package domain.entity.news;

import domain.entity.user.User;

import javax.persistence.*;

/**
 * Created by ShchykalauM on 10.05.2017.
 */

@Entity
@Table(name = "news")
public class News {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "header_image")
    private byte[] image;

    @Column(name = "html")
    private byte[] html;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "is_blog")
    private Boolean isBlog;

    @Column(name = "main_competition_id")
    private Integer mainCompetitionId;

    @Column(name = "start_news_text")
    private String startNewsText;

    public News() {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getHtml() {
        return html;
    }

    public void setHtml(byte[] html) {
        this.html = html;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
