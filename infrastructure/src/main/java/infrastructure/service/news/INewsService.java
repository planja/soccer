package infrastructure.service.news;

import domain.entity.news.News;
import domain.entity.user.User;

import java.security.Principal;

/**
 * Created by ShchykalauM on 10.05.2017.
 */
public interface INewsService {

    News createNews(News news, User user);

    News findNews(Long id);

}
