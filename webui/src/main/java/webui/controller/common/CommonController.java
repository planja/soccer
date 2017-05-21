package webui.controller.common;

import domain.entity.news.News;
import domain.entity.teams.MainCompetition;
import infrastructure.service.common.ICommonService;
import infrastructure.service.teams.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import webui.viewmodel.common.ApiDataRequestViewModel;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/")
public class CommonController {

    private final ICommonService commonService;

    @Autowired
    public CommonController(ICommonService commonService) {
        this.commonService = commonService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "common/index";
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String denied() {
        return "common/denied";
    }

    @RequestMapping(value = "/loginfailure", method = RequestMethod.GET)
    public String loginFailure() {
        return "common/loginfailure";
    }

    @RequestMapping(value = "/notfound", method = RequestMethod.GET)
    public String notFound() {
        return "common/notfound";
    }

    @RequestMapping(value = "/getapidata", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    String getTeams(@RequestBody ApiDataRequestViewModel apiDataRequestViewModel) throws IOException {
        return commonService.getApiData(apiDataRequestViewModel.getUrl(), apiDataRequestViewModel.getKey());
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView readNews(@PathVariable Integer id) {
        List<Integer> ids = Arrays.stream(MainCompetition.values()).map(MainCompetition::getValue).collect(Collectors.toList());
        if (ids.contains(id))
            return new ModelAndView("/common/country", "countryId", id);
        else return new ModelAndView("/common/notfound");
    }

}