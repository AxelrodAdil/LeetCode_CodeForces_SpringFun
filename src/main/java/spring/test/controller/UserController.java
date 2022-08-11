package spring.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.test.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<?> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/functional")
    public List<?> getAllUsersByFunctionalInterface() {
        return userService.getAllUsersByFunctionalInterface();
    }
}
