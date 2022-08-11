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
        // ApiResponse --- later
        List<?> list = userService.getAllUsers();
        System.out.println(list);
        return list;
    }
}
