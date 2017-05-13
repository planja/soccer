package infrastructure.repository.news;

import domain.entity.news.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ShchykalauM on 10.05.2017.
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {

}