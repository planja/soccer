package infrastructure.service.teams;

import domain.entity.teams.Competition;
import infrastructure.repository.teams.CompetitionRepository;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Никита on 23.04.2017.
 */
@Service
public class TeamService implements ITeamService {

    private final CompetitionRepository competitionRepository;

    @Autowired
    public TeamService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public List<Competition> getCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public void loadCompetition(String key) throws IOException {

        List<Long> badCompetition = Arrays.asList((long) 338);

        DefaultHttpClient httpclient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet("https://api.crowdscores.com/v1/competitions");
        httpGet.addHeader("x-crowdscores-api-key", key);
        HttpResponse httpResponse = httpclient.execute(httpGet);
        String html = IOUtils.toString(httpResponse.getEntity().getContent());
        JSONArray jsonArray = new JSONArray(html);
        List<Competition> competitionList = new ArrayList<>();
        jsonArray.forEach(o -> {
            JSONObject jsonObject = (JSONObject) o;
            if (jsonObject.getBoolean("showLeagueTables") && !badCompetition.contains(jsonObject.getLong("dbid"))) {
                Competition competition = new Competition();
                competition.setDbId(jsonObject.getLong("dbid"));
                competition.setFullName(jsonObject.getString("fullName"));
                competition.setName(jsonObject.getString("name"));
                competition.setFlagUrl(jsonObject.getString("flagUrl"));
                competition.setRegion(jsonObject.getJSONObject("region").getString("name"));
                competitionList.add(competition);
            }
        });
        competitionRepository.deleteAll();
        competitionRepository.save(competitionList);
    }
}
