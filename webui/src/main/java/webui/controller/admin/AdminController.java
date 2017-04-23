package webui.controller.admin;

import domain.entity.role.Role;
import domain.entity.role.RoleType;
import domain.entity.user.User;
import infrastructure.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import webui.viewmodel.admin.UserForAdminViewModel;
import webui.viewmodel.common.InfoViewModel;
import webui.viewmodel.user.UserViewModel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ShchykalauM on 17.02.2017.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final IUserService userService;

    @Autowired
    public AdminController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String admin() {
        return "admin/admin";
    }

    @RequestMapping(value = "/rolesinfo", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    List<InfoViewModel> getRolesInfo() {
        return Arrays.stream(RoleType.values()).map(o -> new InfoViewModel(o.getText(), o.getValue())).collect(Collectors.toList());
    }


    @RequestMapping(value = "/adminusers", method = RequestMethod.GET)
    public String adminUsers() {
        return "admin/admin-users";
    }

    @RequestMapping(value = "/findallusers", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    List<UserForAdminViewModel> findAllUsers() {
        return userService.findUsers().stream().map(UserForAdminViewModel::new).collect(Collectors.toList());
    }

    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/updateroles", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    UserForAdminViewModel updateUser(@RequestBody UserForAdminViewModel userForAdminViewModel) {
        User user = userForAdminViewModel.toUser();
        return new UserForAdminViewModel(userService.updateRoles(user));
    }

    @RequestMapping(value = "/admindata", method = RequestMethod.GET)
    public String adminData() {
        return "admin/admin-data";
    }


}
