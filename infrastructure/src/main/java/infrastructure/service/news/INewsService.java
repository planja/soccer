package infrastructure.service.news;

import domain.entity.news.Blog;
import domain.entity.user.User;

import java.util.List;

/**
 * Created by ShchykalauM on 10.05.2017.
 */
public interface INewsService {

    Blog createBlog(Blog blog, User user);

    Blog findBlog(Long id);

    List<Blog> findLatestBlog();

    List<Blog> findBlogForReadMore(Long id);

}
