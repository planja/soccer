package infrastructure.service.news;

import domain.entity.news.News;
import infrastructure.repository.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void createNews(News news) {
        newsRepository.save(news);

    }

}
