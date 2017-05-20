package domain.entity.news;

import domain.entity.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ShchykalauM on 18.05.2017.
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

    @Column(name = "html")
    private String html;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "main_competition_id")
    private Integer mainCompetitionId;

    @Column(name = "date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "is_main_news")
    private Boolean isMainNews;

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

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Boolean getMainNews() {
        return isMainNews;
    }

    public void setMainNews(Boolean mainNews) {
        isMainNews = mainNews;
    }
}
