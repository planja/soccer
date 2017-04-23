package infrastructure.service.teams;

import domain.entity.teams.Competition;

import java.io.IOException;
import java.util.List;

/**
 * Created by Никита on 23.04.2017.
 */
public interface ITeamService {

    void loadCompetition(String key) throws IOException;

    List<Competition> getCompetitions();

}
