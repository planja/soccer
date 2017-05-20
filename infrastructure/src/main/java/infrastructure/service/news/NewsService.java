package infrastructure.service.news;

import domain.entity.news.Blog;
import domain.entity.news.News;
import domain.entity.user.User;
import infrastructure.repository.news.BlogRepository;
import infrastructure.repository.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by ShchykalauM on 10.05.2017.
 */
@Service
public class NewsService implements INewsService {

    private final BlogRepository blogRepository;

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(BlogRepository blogRepository, NewsRepository newsRepository) {
        this.blogRepository = blogRepository;
        this.newsRepository = newsRepository;
    }

    public Blog createBlog(Blog blog, User user) {
        blog.setUser(user);
        blog.setDate(new Date());
        return blogRepository.save(blog);

    }

    @Override
    public Blog findBlog(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public List<Blog> findLatestBlog() {
        Page<Blog> blogs = blogRepository.findAll(new PageRequest(0, 10, Sort.Direction.DESC, "id"));
        return blogs.getContent();
    }

    @Override
    public List<Blog> findBlogForReadMore(Long id) {
        Page<Blog> blogs = blogRepository.findAll(new PageRequest(0, 10, Sort.Direction.DESC, "id"));
        List<Blog> result = blogs.getContent().stream()
                .filter(o -> !Objects.equals(o.getId(), id)).collect(Collectors.toList());
        int size = result.size();
        return size >= 4 ? result.subList(0, 4) : result.subList(0, size);
    }

    @Override
    public List<Blog> findAllBlogs() {
        return blogRepository.findAll();
    }


    @Override
    public News createNews(News news, User user) {
        news.setUser(user);
        news.setDate(new Date());
        return newsRepository.save(news);
    }

    @Override
    public News findNews(Long id) {
        return newsRepository.findOne(id);
    }

    @Override
    public List<News> findLatestNews() {
        List<News> news = newsRepository.findAll();
        List<News> mainNews = news.stream().filter(News::getMainNews).collect(Collectors.toList());
        List<News> otherNews = news.stream().filter(o -> !o.getMainNews()).collect(Collectors.toList());
        Collections.reverse(mainNews);
        Collections.reverse(otherNews);
        int mainNewsSize = mainNews.size();
        mainNews = mainNewsSize >= 4 ? mainNews.subList(0, 4) : mainNews.subList(0, mainNewsSize);
        int otherNewsSize = otherNews.size();
        otherNews = otherNewsSize >= 20 ? otherNews.subList(0, 20) : otherNews.subList(0, otherNewsSize);
        mainNews.addAll(otherNews);
        return mainNews;
    }
}
