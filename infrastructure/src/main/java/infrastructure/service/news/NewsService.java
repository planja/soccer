package infrastructure.service.news;

import domain.entity.news.News;
import domain.entity.user.User;
import infrastructure.repository.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * Created by ShchykalauM on 10.05.2017.
 */
@Service
public class NewsService implements INewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News createNews(News news, User user) {
        news.setUser(user);
        return newsRepository.save(news);

    }

    @Override
    public News findNews(Long id) {
        return newsRepository.findOne(id);
    }
}
