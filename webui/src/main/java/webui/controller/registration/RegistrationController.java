package webui.controller.registration;

import domain.entity.user.User;
import infrastructure.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import webui.viewmodel.user.UserViewModel;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ShchykalauM on 24.02.2017.
 */

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    private final IUserService userService;

    @Autowired
    public RegistrationController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String registration(Principal principal) {
        return principal == null ? "registration/registration" : "common/index";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> saveUser(@RequestBody UserViewModel userViewModel) {
        userService.saveUser(userViewModel.toUser());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/isvalidtoduplicate/{login}", method = RequestMethod.GET)
    public
    @ResponseBody
    String isValidToSaveForDuplicate(@PathVariable String login, Principal principal) {
        List<User> loginList = userService.findUsers().stream().filter(o -> o.getLogin().equals(login))
                .collect(Collectors.toList());
        if (loginList.size() == 0)
            return String.valueOf(true);
        else {
            if (principal == null)
                return String.valueOf(false);
            else {
                User user = userService.findByLogin(principal.getName());
                if (user.getId().equals(loginList.get(0).getId()))
                    return String.valueOf(true);
                else return String.valueOf(false);
            }
        }
    }
}
