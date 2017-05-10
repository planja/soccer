package infrastructure.repository.news;

import domain.entity.news.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ShchykalauM on 10.05.2017.
 */
public interface NewsRepository extends JpaRepository<News, Long> {

}