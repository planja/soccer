package infrastructure.repository.teams;

import domain.entity.teams.Competition;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Никита on 23.04.2017.
 */
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

}