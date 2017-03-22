package webui.controller.user;

import domain.entity.user.User;
import infrastructure.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import webui.viewmodel.user.UserViewModel;

import java.security.Principal;

/**
 * Created by ShchykalauM on 16.03.2017.
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String user(Principal principal) {
        return principal != null ? "user/user" : "common/index";
    }

    @RequestMapping(value = "/loaduserprofile", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    UserViewModel loadUserProfile(Principal principal) {
        User user = userService.findByLogin(principal.getName());
        return new UserViewModel(user);
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> saveUser(@RequestBody UserViewModel userViewModel) {
        userService.updateUser(userViewModel.toUser());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
