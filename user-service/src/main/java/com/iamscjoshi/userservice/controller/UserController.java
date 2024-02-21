package com.iamscjoshi.userservice.controller;

import com.iamscjoshi.userservice.VO.ResponseTemplateVO;
import com.iamscjoshi.userservice.entity.User;
import com.iamscjoshi.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user)
    {
        log.info("Inside saveUser of User Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId)
    {
        log.info("Inside getUserWithDepartment of User Controller");
        return userService.getUserWithDepartment(userId);
    }
}
