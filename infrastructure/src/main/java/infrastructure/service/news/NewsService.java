package infrastructure.service.news;

import domain.entity.news.Blog;
import domain.entity.user.User;
import infrastructure.repository.news.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ShchykalauM on 10.05.2017.
 */
@Service
public class NewsService implements INewsService {

    private final BlogRepository blogRepository;

    @Autowired
    public NewsService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
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
}
