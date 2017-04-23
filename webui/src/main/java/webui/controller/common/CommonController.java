package webui.controller.common;

import infrastructure.service.common.ICommonService;
import infrastructure.service.teams.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import webui.viewmodel.common.ApiDataRequestViewModel;

import java.io.IOException;

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

    @RequestMapping(value = "/getapidata", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    String getTeams(@RequestBody ApiDataRequestViewModel apiDataRequestViewModel) throws IOException {
        return commonService.getApiData(apiDataRequestViewModel.getUrl(), apiDataRequestViewModel.getKey());
    }

}