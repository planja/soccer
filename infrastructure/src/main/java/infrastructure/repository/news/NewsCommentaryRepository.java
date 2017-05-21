package infrastructure.repository.news;

import domain.entity.news.NewsCommentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Никита on 21.05.2017.
 */
public interface NewsCommentaryRepository extends JpaRepository<NewsCommentary, Long> {
    @Modifying
    @Query("DELETE FROM NewsCommentary r WHERE r.id = :id")
    void deleteNewsCommentary(@Param("id") Long id);

}
