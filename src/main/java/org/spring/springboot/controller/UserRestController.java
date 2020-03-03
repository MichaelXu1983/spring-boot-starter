package org.spring.springboot.controller;


import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User findOneCity(@RequestParam(value = "userName", required = true) String userName) {
        return userService.findUserByName(userName);
    }

}
