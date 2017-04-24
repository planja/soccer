package webui.controller.teams;

import domain.entity.teams.Competition;
import infrastructure.service.common.ICommonService;
import infrastructure.service.teams.ITeamService;
import infrastructure.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.io.IOException;
import java.util.List;

/**
 * Created by Никита on 23.04.2017.
 */

@Controller
@RequestMapping(value = "/teams")
public class TeamsController {

    private final ITeamService teamService;

    @Autowired
    public TeamsController(ITeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String registration() {
        return "teams/teams";
    }

    @RequestMapping(value = "/updatecompetitions/{key}", method = RequestMethod.GET)
    public ResponseEntity<Void> updateCompetitions(@PathVariable String key) throws IOException {
        teamService.loadCompetition(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getcompetitions", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    List<Competition> getCompetitions() {
        return teamService.getCompetitions();
    }

    @RequestMapping(value = "/teaminfo/{dbId}", method = RequestMethod.GET)
    public ModelAndView refSchedule(@PathVariable Long dbId) {
        return new ModelAndView("/teams/team-info", "teamId", dbId);
    }

}
