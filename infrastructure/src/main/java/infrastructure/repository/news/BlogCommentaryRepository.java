package infrastructure.repository.news;

import domain.entity.news.BlogCommentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Никита on 21.05.2017.
 */
public interface BlogCommentaryRepository extends JpaRepository<BlogCommentary, Long> {
    @Modifying
    @Query("DELETE FROM BlogCommentary r WHERE r.id = :id")
    void deleteBlogCommentary(@Param("id") Long id);

}
