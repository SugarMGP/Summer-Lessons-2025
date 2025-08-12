package com.github.sugarmgp.demoproject.controller;

import com.github.sugarmgp.demoproject.dto.request.LoginRequest;
import com.github.sugarmgp.demoproject.dto.response.LoginResponse;
import com.github.sugarmgp.demoproject.result.AjaxResult;
import com.github.sugarmgp.demoproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

/**
 * @author SugarMGP
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public AjaxResult<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        Integer id = userService.login(request.getUsername(), request.getPassword());
        return AjaxResult.success(new LoginResponse(id));
    }
}
