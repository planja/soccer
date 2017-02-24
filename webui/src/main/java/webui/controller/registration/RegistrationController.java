package webui.controller.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ShchykalauM on 24.02.2017.
 */

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return "registration/registration";
    }

}
